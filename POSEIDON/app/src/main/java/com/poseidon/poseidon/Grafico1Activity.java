package com.poseidon.poseidon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;

/**
 * Created by rafae on 06/09/2017.
 */

public class Grafico1Activity extends AppCompatActivity {

    Button bt_layout;
    Button bt_tabela;
    Button bt_grafico;
    private LineChart mChart;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafico);
        loadViwes();

        bt_grafico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Grafico1Activity.this,Grafico1Activity.class));
            }
        });
        bt_tabela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Grafico1Activity.this,TMaquinasActivity.class));
            }
        });
        bt_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Grafico1Activity.this,LayoutmaqActivity.class));
            }
        });

    }


    private void loadViwes(){
        bt_layout = (Button) findViewById(R.id.bt_layout_grafico1);
        bt_grafico = (Button) findViewById(R.id.bt_grafico_grafico1);
        bt_tabela = (Button) findViewById(R.id.bt_tabela_grafico1);
    }
}
