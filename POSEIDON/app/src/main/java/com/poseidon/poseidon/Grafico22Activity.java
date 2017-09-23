package com.poseidon.poseidon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by rafae on 06/09/2017.
 */

public class Grafico22Activity extends AppCompatActivity{

    Button bt_layout;
    Button bt_tabela;
    Button bt_grafico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gafico2x2);

        loadViwes();

        bt_grafico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Grafico22Activity.this,Grafico22Activity.class));
            }
        });
        bt_tabela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Grafico22Activity.this,TMaquinasActivity.class));
            }
        });
        bt_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Grafico22Activity.this,LayoutmaqActivity.class));
            }
        });

    }

    private void loadViwes(){

    }


}
