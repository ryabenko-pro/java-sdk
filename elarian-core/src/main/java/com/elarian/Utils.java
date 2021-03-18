package com.elarian;

import com.elarian.hera.proto.ActivityModel;
import com.elarian.hera.proto.AppSocket;
import com.elarian.hera.proto.CommonModel;
import com.elarian.hera.proto.MessagingModel;
import com.elarian.hera.proto.PaymentModel;
import com.elarian.model.ActivityChannel;
import com.elarian.model.CustomerNumber;
import com.elarian.model.Email;
import com.elarian.model.Location;
import com.elarian.model.Media;
import com.elarian.model.Message;
import com.elarian.model.MessageBody;
import com.elarian.model.MessagingChannel;
import com.elarian.model.Notification;
import com.elarian.model.PaymentChannel;
import com.elarian.model.PaymentChannelCounterParty;
import com.elarian.model.PaymentCounterParty;
import com.elarian.model.PaymentCustomerCounterParty;
import com.elarian.model.PaymentPurseCounterParty;
import com.elarian.model.PaymentWalletCounterParty;
import com.elarian.model.ReceivedMediaNotification;
import com.elarian.model.ReceivedMessageNotification;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.StringValue;

import java.util.List;
import java.util.stream.Collectors;

class Utils {

    public static <T extends Notification> T fillInCustomerNotification(AppSocket.ServerToAppCustomerNotification notif, T target) {
        target.orgId = notif.getOrgId();
        target.appId = notif.getAppId();
        target.customerId = notif.getCustomerId();
        target.createdAt = notif.getCreatedAt().getSeconds();
        return target;
    }

    public static ReceivedMediaNotification fillInMediaMessageNotification(AppSocket.ReceivedMessageNotification notif, ReceivedMediaNotification target, Customer targetCustomer) {
        target.messageId = notif.getMessageId();
        target.sessionId = notif.getSessionId().getValue();
        target.channelNumber = Utils.makeMessagingChannel(notif.getChannelNumber());
        target.customerNumber = Utils.makeCustomerNumber(notif.getCustomerNumber());

        targetCustomer.customerNumber = target.customerNumber;

        List<MessagingModel.InboundMessageBody> parts = notif.getPartsList();
        for (MessagingModel.InboundMessageBody part: parts) {
            target.text = part.getText();

            if (part.hasMedia()) {
                target.media = new Media(part.getMedia().getUrl(), Media.MediaType.valueOf(part.getMedia().getMediaValue()));
            }

            if (part.hasEmail()) {
                target.email = new Email();
                target.email.subject = part.getEmail().getSubject();
                target.email.plain = part.getEmail().getBodyPlain();
                target.email.html = part.getEmail().getBodyHtml();
                target.email.cc = part.getEmail().getCcListList();
                target.email.bcc = part.getEmail().getBccListList();
                target.email.attachments = part.getEmail().getAttachmentsList();
            }

            if (part.hasLocation()) {
                target.location = new Location();
                target.location.label = part.getLocation().getLabel().getValue();
                target.location.address = part.getLocation().getAddress().getValue();
                target.location.latitude = part.getLocation().getLatitude();
                target.location.longitude = part.getLocation().getLongitude();
            }
        }
        return target;
    }

    public static ActivityChannel makeActivityChannel(ActivityModel.ActivityChannelNumber num) {
        return new ActivityChannel(num.getNumber(), ActivityChannel.Channel.valueOf(num.getChannelValue()));
    }

    public static PaymentChannel makePaymentChannel(PaymentModel.PaymentChannelNumber num) {
        return new PaymentChannel(num.getNumber(), PaymentChannel.Channel.valueOf(num.getChannelValue()));
    }

    public static MessagingChannel makeMessagingChannel(MessagingModel.MessagingChannelNumber num) {
        return new MessagingChannel(num.getNumber(), MessagingChannel.Channel.valueOf(num.getChannelValue()));
    }

    public static CustomerNumber makeCustomerNumber(CommonModel.CustomerNumber num) {
        return new CustomerNumber(num.getNumber(), CustomerNumber.Provider.valueOf(num.getProviderValue()));
    }

    public static PaymentModel.PaymentCounterParty buildPaymentCounterParty(PaymentCounterParty counterParty) {

        PaymentModel.PaymentCounterParty.Builder result = PaymentModel.PaymentCounterParty.newBuilder();

        if (counterParty instanceof PaymentCustomerCounterParty) {
            PaymentCustomerCounterParty party = (PaymentCustomerCounterParty) counterParty;
            result.setCustomer(PaymentModel.PaymentCustomerCounterParty
                    .newBuilder()
                    .setCustomerNumber(CommonModel.CustomerNumber
                            .newBuilder()
                            .setNumber(party.customerNumber.number)
                            .setProviderValue(party.customerNumber.provider.getValue())
                            .build())
                    .setChannelNumber(PaymentModel.PaymentChannelNumber
                            .newBuilder()
                            .setNumber(party.channelNumber.number)
                            .setChannelValue(party.channelNumber.channel.getValue())
                            .build())
                    .build());
        } else if (counterParty instanceof PaymentPurseCounterParty) {
            PaymentPurseCounterParty party = (PaymentPurseCounterParty) counterParty;
            result.setPurse(PaymentModel.PaymentPurseCounterParty
                    .newBuilder()
                    .setPurseId(party.purseId)
                    .build());
        } else if (counterParty instanceof PaymentChannelCounterParty) {
            PaymentChannelCounterParty party = (PaymentChannelCounterParty) counterParty;
            result.setChannel(PaymentModel.PaymentChannelCounterParty
                    .newBuilder()
                    .setAccount(StringValue.of(party.account))
                    .setChannelCode(party.networkCode)
                    .setChannelNumber(PaymentModel.PaymentChannelNumber
                        .newBuilder()
                        .setNumber(party.channelNumber.number)
                        .setChannelValue(party.channelNumber.channel.getValue())
                        .build())
                    .build());
        } else if (counterParty instanceof PaymentWalletCounterParty) {
            PaymentWalletCounterParty party = (PaymentWalletCounterParty) counterParty;
            result.setWallet(PaymentModel.PaymentWalletCounterParty
                    .newBuilder()
                    .setCustomerId(party.customerId)
                    .setWalletId(party.walletId)
                    .build());
        }
        return result.build();
    }

    public static MessagingModel.OutboundMessage buildOutgoingMessage(Message message) {

        MessagingModel.OutboundMessage.Builder outgoing = MessagingModel.OutboundMessage.newBuilder();
        MessagingModel.OutboundMessageBody.Builder body = MessagingModel.OutboundMessageBody.newBuilder();

        outgoing.addAllLabels(message.labels);
        if (message.providerTag != null) {
            outgoing.setProviderTag(StringValue.of(message.providerTag));
        }

        if (message.replyPrompt != null) {
            outgoing.setReplyPrompt(MessagingModel.OutboundMessageReplyPrompt
                    .newBuilder()
                    .setActionValue(message.replyPrompt.action.getValue())
                    .addAllMenu(message.replyPrompt.menu.stream().map(menu -> {
                        MessagingModel.PromptMessageMenuItemBody.Builder item = MessagingModel.PromptMessageMenuItemBody.newBuilder();
                        if (menu.text != null) {
                            item.setText(menu.text);
                        } else if (menu.media != null) {
                            item.setMedia(
                                    MessagingModel.MediaMessageBody
                                            .newBuilder()
                                            .setUrl(menu.media.url)
                                            .setMediaValue(menu.media.type.getValue())
                                            .build()
                            );
                        }
                        return item.build();
                    }).collect(Collectors.toList()))
                    .build());
        }

        MessageBody incoming = new MessageBody();
        if (message.body != null) {
            incoming = message.body;
        }

        if (incoming.text != null) {
            body.setText(incoming.text);
        } else if (incoming.media != null) {
            body.setMedia(MessagingModel.MediaMessageBody
                    .newBuilder()
                    .setUrl(incoming.media.url)
                    .setMediaValue(incoming.media.type.getValue())
                    .build());
        } else if (incoming.location != null) {
            body.setLocation(MessagingModel.LocationMessageBody
                    .newBuilder()
                    .setAddress(StringValue.of(incoming.location.address))
                    .setLabel(StringValue.of(incoming.location.label))
                    .setLatitude(incoming.location.latitude)
                    .setLongitude(incoming.location.longitude)
                    .build());
        } else if (incoming.email != null) {
            body.setEmail(MessagingModel
                    .EmailMessageBody
                    .newBuilder()
                    .setSubject(incoming.email.subject)
                    .setBodyPlain(incoming.email.plain)
                    .setBodyHtml(incoming.email.html)
                    .addAllCcList(incoming.email.cc)
                    .addAllBccList(incoming.email.bcc)
                    .addAllAttachments(incoming.email.attachments)
                    .build());
        } else if (incoming.template != null) {
            MessagingModel.TemplateMessageBody.Builder template = MessagingModel.TemplateMessageBody.newBuilder();
            template.setId(incoming.template.id);
            template.putAllParams(incoming.template.params);
            body.setTemplate(template);
        } else if(incoming.url != null) {
            body.setUrl(incoming.url);
        } else if (incoming.voice != null && !incoming.voice.isEmpty()) {
            body.setVoice(MessagingModel.VoiceCallDialplanMessageBody
                    .newBuilder()
                    .addAllActions(
                            incoming.voice
                                    .stream()
                                    .map(action -> {
                                        // FIXME: Implement
                                        // TODO: build the correct action
                                        return MessagingModel.VoiceCallAction
                                                .newBuilder()
                                                .build();
                                    })
                                    .collect(Collectors.toList()))
                    .build());
        } else if (incoming.ussd != null) {
            body.setUssd(MessagingModel.UssdMenuMessageBody
                    .newBuilder()
                    .setText(incoming.ussd.text)
                    .setIsTerminal(incoming.ussd.isTerminal)
                    .build());
        }
        outgoing.setBody(body);

        return outgoing.build();
    }
}
