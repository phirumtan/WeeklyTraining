package com.example.weeklytraining;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    private TextView mTextHandleSms;
    private EditText mEdtReply;
    private Button mBtnReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        mTextHandleSms = findViewById(R.id.text_handle_sms);
        mEdtReply = findViewById(R.id.edt_reply);
        mBtnReply = findViewById(R.id.btn_reply);

        String handleSms = getIntent().getExtras().getString("key_sms");


        mTextHandleSms.setText(handleSms);

        mBtnReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    intent.putExtra("key_reply_sms", mEdtReply.getText().toString());
                    startActivity(intent);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
