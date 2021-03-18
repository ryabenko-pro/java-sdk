package com.elarian.example.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elarian.example.android.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var layout: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = ActivityMainBinding.inflate(layoutInflater)
        setContentView(layout.root)

        layout.sendSMS.setOnClickListener {
            layout.response.text = getString(R.string.sending_sms)
//            val customer = CustomerNumber.newBuilder()
//            customer.number = layout.number.text.toString()
//            customer.provider = CustomerNumberProvider.CUSTOMER_NUMBER_PROVIDER_CELLULAR
//
//            val channel = MessagingChannelNumber.newBuilder()
//            channel.number = "787878"
//            channel.channel = MessagingChannel.MESSAGING_CHANNEL_SMS
//
//            val message = OutboundMessage.newBuilder()
//            val body = OutboundMessageBody.newBuilder()
//            body.text = "This is a test"
//            message.body = body.build()
//
//            client.sendMessage(customer.build(), channel.build(), message.build()).subscribe(
//                    {
//                        layout.response.text = "${layout.response.text}\n${it}"
//                    },
//                    { err ->
//                        layout.response.text = "${layout.response.text}\n${err.message}"
//                    },
//                    {
//                        layout.response.text = "${layout.response.text}\nDone!"
//                    }
//            )
        }

        layout.fetchState.setOnClickListener {
            layout.response.text = getString(R.string.fetching_customer_state)
        }

        GlobalScope.launch(Dispatchers.IO) {
            connectToElarian()
        }
    }

    private suspend fun connectToElarian() {
        layout.response.text = getString(R.string.initializing_sdk)
//        client = Elarian("some-token", "some-org", "some-app")
//        client.connect({ layout.response.text = getString(R.string.ready) }, { layout.response.text = it.message })
    }
}