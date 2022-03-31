package com.example.viiko10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView web;
    EditText haku;
    String url = "www.google.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = findViewById(R.id.webView);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
        haku = (EditText) findViewById(R.id.searchBar);
        web.loadUrl("http://" + url);
    }



    public void button(View v) {
        url = String.valueOf(haku.getText());
        if(url.equals("index.html")){
            web.loadUrl("file:///android_asset/index.html");
        }else{
            web.loadUrl("http://"+url);
        }
    }

    public void runShoutOut(View v){
        web.evaluateJavascript("javascript:shoutOut()", null);
    }

    public void runInitialize(View v){
        web.evaluateJavascript("javascript:initialize()", null);
    }

    public void refreshPage(View v) {
        web.reload();
    }
}