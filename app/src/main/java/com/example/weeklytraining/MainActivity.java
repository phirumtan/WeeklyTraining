package com.example.weeklytraining;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEdtSms;
    private AppCompatButton mBtnSend;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //update actionbar background
        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorAccent)));

        //update color of status bar
        //getWindow().setStatusBarColor(getResources().getColor(R.color.colorBlueDark));

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);
        //toolbar.setTitleTextColor();

        mEdtSms = findViewById(R.id.edt_sms);
        mBtnSend = findViewById(R.id.btn_send);

        if (getIntent().getExtras() != null) {
            String handleReplySms = getIntent().getExtras().getString("key_reply_sms");
            mEdtSms.setText(handleReplySms);
        }

        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(v.getContext(), DisplayMessageActivity.class);
                    intent.putExtra("key_sms", mEdtSms.getText().toString());
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }

    /**
     * need add menu item to activity
     * must implement this method
     *
     * @param menu can not null
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Use for handle callback on menu item click
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_open_browser:
                openWebsite("https://tarang.club/");
                break;
            case R.id.action_share_text:
                sharePlainText();
                break;
            case R.id.action_phone_call:
                callToOtherPhone("098637352");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void callToOtherPhone(String phoneNo) {
        Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNo));
        // Find an activity to hand the intent and start that activity.
        if (intentCall.resolveActivity(getPackageManager()) != null) {
            startActivity(intentCall);
        } else {
            Toast.makeText(this, "No activity can not handle this action", Toast.LENGTH_SHORT).show();
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }

    }

    public void openWebsite(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW,
                webpage);
        // Find an activity to hand the intent and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void sharePlainText() {
        ShareCompat.IntentBuilder
                .from(this)
                .setType("text/plain")
                .setChooserTitle("Share with: ")
                .setText(this.textShare)
                .startChooser();
    }

    private String textShare = "វើបុណ្យទាន់ខែភ្លឺ\n" +
            "\n" +
            "1). ម៉ាស និង សាប៊ូ កក់សក់ ២២ដុល្លា ។\n" +
            "2). ប្រេងបណ្តុះសក់ ២៥ដុល្លា ។\n" +
            "3). ស្រ្ពេយបំបាត់ស្កូវ ២៨ដុល្លា ។\n" +
            "https://www.youtube.com/watch?v=LCZuD5GUn5U&t=25s";
}
