package com.example.takshak;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class payment extends AppCompatActivity implements PaymentResultListener {
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        b=findViewById(R.id.btnPay);

        String sAmount="100";

        int amount = Math.round(Float.parseFloat(sAmount)*100);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Checkout checkout = new Checkout();
                checkout.setKeyID("rzp_test_QKr3y6JUIsXB1x");
                checkout.setImage(R.drawable.rzp);
                JSONObject object = new JSONObject();

                try {
                    object.put("name","Takshak");
                    object.put("description","Payment");
                    object.put("theme.color","#0093DD");
                    object.put("currency","INR");
                    object.put("amount",amount);
                    object.put("prefill.contact","9549196879");
                    object.put("prefill.email","saloniag1299@gmail.com");

                    checkout.open(payment.this,object);

                } catch (JSONException e) {
                    e.printStackTrace();
                }




            }
        });
    }

    @Override
    public void onPaymentSuccess(String s) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Payment ID");
        builder.setMessage(s);
        builder.show();
        Intent i = new Intent(payment.this, Success.class);
        startActivity(i);
    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(getApplicationContext()
                ,s,Toast.LENGTH_SHORT).show();

    }
}