package com.poseidon.poseidon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by rafae on 06/09/2017.
 */

public class LayoutmaqActivity extends AppCompatActivity {

    Button bt_layout;
    Button bt_tabela;
    Button bt_grafico;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        loadViwes();

        bt_grafico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LayoutmaqActivity.this,Grafico1Activity.class));
            }
        });
        bt_tabela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LayoutmaqActivity.this,TMaquinasActivity.class));
            }
        });
        bt_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LayoutmaqActivity.this,LayoutmaqActivity.class));
            }
        });

    }

    private void loadViwes(){
        bt_layout = (Button) findViewById(R.id.bt_layout_layout);
        bt_grafico = (Button) findViewById(R.id.bt_grafico_layout);
        bt_tabela = (Button) findViewById(R.id.bt_tabela_layout);
    }
}
