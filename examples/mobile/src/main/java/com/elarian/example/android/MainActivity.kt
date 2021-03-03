package com.elarian.example.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elarian.hera.android.Elarian
import com.elarian.hera.proto.CommonModel.*
import com.elarian.hera.proto.MessagingModel.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var client: Elarian

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendSMS.setOnClickListener {
            response.text = "Sending SMS..."
            val customer = CustomerNumber.newBuilder()
            customer.number = number.text.toString()
            customer.provider = CustomerNumberProvider.CUSTOMER_NUMBER_PROVIDER_CELLULAR

            val channel = MessagingChannelNumber.newBuilder()
            channel.number = "787878"
            channel.channel = MessagingChannel.MESSAGING_CHANNEL_SMS

            val message = OutboundMessage.newBuilder()
            val body = OutboundMessageBody.newBuilder()
            body.text = "This is a test"
            message.body = body.build()

            client.sendMessage(customer.build(), channel.build(), message.build()).subscribe(
                    {
                        response.text = "${response.text}\n${it}"
                    },
                    { err ->
                        response.text = "${response.text}\n${err.message}"
                    },
                    {
                        response.text = "${response.text}\nDone!"
                    }
            )
        }

        fetchState.setOnClickListener {
            response.text = "Fetching customer state..."
        }

        connectToElarian()

    }

    private fun connectToElarian() {
        response.text = "Initializing SDK..."
        client = Elarian("el_tkn_741648465c35fa8916252c05333623dd7c1f9989f71d1cdb6b2ba3a95930e751", "og-uNX0Bf", "drelm_app")
        client.connect { err ->
            err.printStackTrace()
        }
        response.text = "Ready!"
    }
}