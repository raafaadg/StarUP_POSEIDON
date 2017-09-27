package com.poseidon.poseidon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafae on 06/09/2017.
 */

public class TMaquinasActivity extends AppCompatActivity {

    Spinner sp_fabricas_tabelaM;
    ImageView ic_vistas_tabelaM;
    ImageView ic_config_tabelaM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabela);

        loadViwes();


    }

    private void loadViwes(){
        loadHeader();
        List<Integer> imagens = new ArrayList<>();
        List<String> nome = new ArrayList<>();
        List<String> porcentagem = new ArrayList<>();
        imagens.add(R.color.fora_da_meta);
        imagens.add(R.color.dentro_da_meta);
        imagens.add(R.color.dentro_da_meta);
        imagens.add(R.color.dentro_da_meta);
        imagens.add(R.color.fora_da_meta);
        imagens.add(R.color.fora_da_meta);
        imagens.add(R.color.sem_molde);

        nome.add("0440/04");
        nome.add("1000/05");
        nome.add("1500/01");
        nome.add("1500/02");
        nome.add("0440/04");
        nome.add("0500/07");
        nome.add("0440/03");

        porcentagem.add("87.80%");
        porcentagem.add("0.00%");
        porcentagem.add("0.00%");
        porcentagem.add("97.97%");
        porcentagem.add("87.80%");
        porcentagem.add("90.22%");
        porcentagem.add("80.97%");
    }

    private void loadHeader(){
        sp_fabricas_tabelaM = (Spinner) findViewById(R.id.sp_fabricas_tabelaM);
        ic_vistas_tabelaM = (ImageView) findViewById(R.id.ic_vistas_tabelaM);
        ic_config_tabelaM = (ImageView) findViewById(R.id.ic_config_tabelaM);
        List<String> fabricas = new ArrayList<>();
        fabricas.add("Ícones Máquinas - SPBrasil");
        fabricas.add("Ícones Máquinas - PR");
        fabricas.add("Ícones Máquinas - MG");
        fabricas.add("Ícones Máquinas - RJ");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, fabricas);

        sp_fabricas_tabelaM.setAdapter(arrayAdapter);

        ic_config_tabelaM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(TMaquinasActivity.this, ic_config_tabelaM);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.menu_opcoes, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.it_logout:
                                onBackPressed();
                                break;
                            case R.id.it_idioma:
                                PopupMenu popupIdiomas = new PopupMenu(TMaquinasActivity.this, ic_config_tabelaM);
                                popupIdiomas.getMenuInflater().inflate(R.menu.menu_idiomas, popupIdiomas.getMenu());
                                popupIdiomas.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem item) {
                                        switch (item.getItemId()){
                                            case R.id.it_portbr:
                                                break;
                                            default:
                                                break;
                                        }
                                        return true;
                                    }
                                });
                                popupIdiomas.show();
                                break;
                            default:
                                break;
                        }
                        return true;
                    }
                });
                popup.show();
                //startActivity(new Intent(LayoutmaqActivity.this,Grafico22Activity.class));
            }
        });

        ic_vistas_tabelaM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(TMaquinasActivity.this, ic_vistas_tabelaM);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.menu_vistas, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.it_layout:
                                startActivity(new Intent(TMaquinasActivity.this,LayoutmaqActivity.class));
                                break;
                            case R.id.it_tabela:
                                startActivity(new Intent(TMaquinasActivity.this,TMaquinasActivity.class));
                                break;
                            case R.id.it_grafico:
                                startActivity(new Intent(TMaquinasActivity.this,Grafico1Activity.class));
                                break;
                            default:
                                break;
                        }
                        return true;
                    }
                });
                popup.show();
            }
        });
    }
}
