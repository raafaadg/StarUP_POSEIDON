package com.poseidon.poseidon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import okhttp3.OkHttpClient;


public class MainActivity extends AppCompatActivity {

    Button bt_log;

    OkHttpClient client = new OkHttpClient();
    CadastroActivity cadastro = new CadastroActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Carrega o layout que você vai usar nessa activity
        setContentView(R.layout.activity_login_poseidon);
        // Carregue todas as views do seu layout
        loadViews();

        bt_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LayoutmaqActivity.class));
            }
        });

    }

    private void loadViews() {

        bt_log = (Button) findViewById(R.id.bt_login);
    }

}
