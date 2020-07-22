package com.elarian.example.android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.elarian.hera.proto.GrpcWebServiceGrpc.*;
import com.elarian.hera.Elarian;
import com.elarian.hera.proto.Web;

import io.grpc.stub.StreamObserver;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView output = findViewById(R.id.response);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output.setText("Initializing SDK...");

                String authToken = "test_auth_token"; // Fetch auth token from your server...
                GrpcWebServiceStub asyncInstance = Elarian.newAsyncInstance(authToken, true);

                output.setText("Fetching customer state...");
                Web.GetCustomerStateRequest req =  Web.GetCustomerStateRequest
                        .newBuilder()
                        .setCustomerId("fake_id")
                        .setAppId("test_app")
                        .build();
                asyncInstance.getCustomerState(req, new StreamObserver<Web.GetCustomerStateReply>() {
                    @Override
                    public void onNext(Web.GetCustomerStateReply value) {
                        output.setText(value.toString());
                    }

                    @Override
                    public void onError(Throwable t) {
                        t.printStackTrace();
                        output.setText(t.getMessage());
                    }

                    @Override
                    public void onCompleted() {

                    }
                });
            }
        });

    }
}
