package com.elarian.example.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elarian.ConnectionListener
import com.elarian.Customer
import com.elarian.Elarian
import com.elarian.example.android.databinding.ActivityMainBinding
import com.elarian.model.Message
import com.elarian.model.MessageBody
import com.elarian.model.MessagingChannel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var layout: ActivityMainBinding
    private lateinit var client: Elarian

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = ActivityMainBinding.inflate(layoutInflater)
        setContentView(layout.root)

        layout.sendSMS.setOnClickListener {
            layout.response.text = getString(R.string.sending_sms)
            val customer = Customer(client, layout.number.text.toString())
            val channel = MessagingChannel("787878", MessagingChannel.Channel.SMS)

            val body = MessageBody()
            body.text = "This is a test from Android"
            val message = Message(body)

            customer.sendMessage(channel, message).subscribe(
                    {
                        layout.response.text = "${layout.response.text}\n${it}"
                    },
                    { err ->
                        layout.response.text = "${layout.response.text}\n${err.message}"
                    },
                    {
                        layout.response.text = "${layout.response.text}\nDone!"
                    }
            )
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
        // TODO: fetch token, orgId, appId from server
        val token = "some-auth-token"
        val orgId = "some-org-id"
        val appId = "some-app-id"
        client = Elarian(token, orgId, appId)
        client.connect(object: ConnectionListener {
            override fun onPending() {
                layout.response.text = "Connection pending..."
            }

            override fun onConnecting() {
                layout.response.text = "Connecting..."
            }

            override fun onClosed() {
                layout.response.text = "Connection closed!"
            }

            override fun onConnected() {
                layout.response.text = "Connected!"
            }

            override fun onError(throwable: Throwable?) {
                throwable?.printStackTrace()
                layout.response.text = throwable?.message
            }
        })
    }
}