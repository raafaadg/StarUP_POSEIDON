package com.poseidon.poseidon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import okhttp3.OkHttpClient;


public class MainActivity extends AppCompatActivity {

    Button bt_info;
    Button bt_log;
    OkHttpClient client = new OkHttpClient();
    CadastroActivity cadastro = new CadastroActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Carrega o layout que você vai usar nessa activity
        setContentView(R.layout.teste_tela);
        // Carregue todas as views do seu layout
        loadViews();

        bt_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersIntent = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(numbersIntent);
            }
        });
        bt_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent numbersIntent = new Intent(MainActivity.this, LoginPoseidon.class);
                startActivity(numbersIntent);
            }
        });

    }

    private void loadViews() {
        bt_info = (Button) findViewById(R.id.bt_info);
        bt_log = (Button) findViewById(R.id.bt_log);
      //  chart = (LineChart) findViewById(R.id.chart);
    }

}
