# Elarian SDK for the JVM

[ ![Download](https://api.bintray.com/packages/elarian/java/com.elarian/images/download.svg) ](https://bintray.com/elarian/java/com.elarian/_latestVersion)

>
> The SDK provides convenient access to the Elarian APIs from applications written in Kotlin, Java, and Scala.
>

## Documentation
Take a look at the [API docs here](https://docs.elarian.com).

## Install

You can depend on the [.jar](http://dl.bintray.com/elarian/java/com/elarian/java) through Maven (from `http://dl.bintray.com/elarian/java`):
```xml
<repositories>
   <repository>
      <id>elarian</id>
      <name>Elarian</name>
      <url>http://dl.bintray.com/elarian/java</url>
   </repository>
</repositories>
...
<dependency>
  <groupId>com.elarian</groupId>
  <artifactId>jvm</artifactId>
  <version>0.0.4</version>
</dependency>
```
or sbt:

```
resolvers += "elarian maven repository" at "http://dl.bintray.com/elarian/java"
// Get all services
libraryDependencies += "com.elarian" % "jvm" % "0.0.4"
```

or Gradle:
```groovy
repositories {
  maven {
    url  "http://dl.bintray.com/elarian/java"
  }
}

dependencies{
  implementation 'com.elarian:jvm:0.0.4'
  // Or if you're building for android
  // implementation 'com.elarian:android:0.0.4'
}
```

## Usage

The SDK needs to be initialized with your API key, which you get from the [dashboard](https://account.elarian.com).

```kotlin
// Kotlin/Scala
val elarian = Elarian.newInstance("test_api_key")
val req = GetCustomerStateRequest
        .newBuilder()
        .setOrgId("test_org")
        .setCustomerId("fake")
        .build()
val res = elarian.getCustomerState(req)
```

```java
// Java
GrpcWebServiceBlockingStub elarian = Elarian.newInstance("test_api_key");
GetCustomerStateRequest req = GetCustomerStateRequest
        .newBuilder()
        .setOrgId("test_org")
        .setCustomerId("fake")
        .build();
GetCustomerStateReply res = elarian.getCustomerState(req);
```

See [examples](examples/) for more usage examples.

## Methods

```
authToken(AuthTokenRequest) -> AuthTokenReply

getCustomerState(GetCustomerStateRequest) -> GetCustomerStateReply
adoptCustomerState(AdoptCustomerStateRequest) -> UpdateCustomerStateReply

addCustomerReminder(AddCustomerReminderRequest) -> UpdateCustomerStateReply
addCustomerReminderByTag(AddCustomerReminderTagRequest) -> TagCommandReply
cancelCustomerReminder(CancelCustomerReminderRequest) -> UpdateCustomerStateReply
cancelCustomerReminderByTag(CancelCustomerReminderTagRequest) -> TagCommandReply

updateCustomerTag(UpdateCustomerTagRequest) -> UpdateCustomerStateReply
deleteCustomerTag(DeleteCustomerTagRequest) -> UpdateCustomerStateReply

updateCustomerSecondaryId(UpdateCustomerSecondaryIdRequest) -> UpdateCustomerStateReply
deleteCustomerSecondaryId(DeleteCustomerSecondaryIdRequest) -> UpdateCustomerStateReply

leaseCustomerMetadata(LeaseCustomerMetadataRequest) -> LeaseCustomerMetadataReply
updateCustomerMetadata(UpdateCustomerMetadataRequest) -> UpdateCustomerStateReply
deleteCustomerMetadata(DeleteCustomerMetadataRequest) -> UpdateCustomerStateReply

sendMessage(SendMessageRequest) -> SendMessageReply
sendMessageByTag(SendMessageTagRequest) -> TagCommandReply
replyToMessage(ReplyToMessageRequest) -> SendMessageReply
messagingConsent(MessagingConsentRequest) -> MessagingConsentReply

sendPayment(SendPaymentRequest) -> InitiatePaymentReply
checkoutPayment(CheckoutPaymentRequest) -> InitiatePaymentReply
customerWalletPayment(CustomerWalletPaymentRequest) -> InitiatePaymentReply

makeVoiceCall(MakeVoiceCallRequest) -> MakeVoiceCallReply

streamNotifications(StreamNotificationRequest) -> WebhookRequest
sendWebhookResponse(WebhookResponse) -> WebhookResponseReply
```

## Issues

If you find a bug, please file an issue on [our issue tracker on GitHub](https://github.com/ElarianLtd/kotlin-sdk/issues).