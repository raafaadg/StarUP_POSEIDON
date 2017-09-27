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

public class Grafico22Activity extends AppCompatActivity{

    Spinner sp_fabricas_graf2x2;
    ImageView ic_vistas_graf2x2;
    ImageView ic_config_graf2x2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gafico2x2);

        loadViwes();
        //getIntent().getExtras().getString("porcentagem", "");



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
        sp_fabricas_graf2x2 = (Spinner) findViewById(R.id.sp_fabricas_graf2x2);
        ic_vistas_graf2x2 = (ImageView) findViewById(R.id.ic_vistas_graf2x2);
        ic_config_graf2x2 = (ImageView) findViewById(R.id.ic_config_graf2x2);
        List<String> fabricas = new ArrayList<>();
        fabricas.add("Ícones Máquinas - SPBrasil");
        fabricas.add("Ícones Máquinas - PR");
        fabricas.add("Ícones Máquinas - MG");
        fabricas.add("Ícones Máquinas - RJ");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, fabricas);

        sp_fabricas_graf2x2.setAdapter(arrayAdapter);

        ic_config_graf2x2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(Grafico22Activity.this, ic_config_graf2x2);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.menu_opcoes_grafico, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.it_logout:
                                //onBackPressed();
                                startActivity(new Intent(Grafico22Activity.this,MainActivity.class));
                                break;
                            case R.id.it_idioma:
                                PopupMenu popupIdiomas = new PopupMenu(Grafico22Activity.this, ic_config_graf2x2);
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
                            case R.id.it_visualizar:
                                PopupMenu popupVisualizar = new PopupMenu(Grafico22Activity.this, ic_config_graf2x2);
                                popupVisualizar.getMenuInflater().inflate(R.menu.menu_visualizar, popupVisualizar.getMenu());
                                popupVisualizar.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                    @Override
                                    public boolean onMenuItemClick(MenuItem item) {
                                        switch (item.getItemId()){
                                            case R.id.it_1x1:
                                                startActivity(new Intent(Grafico22Activity.this,Grafico1Activity.class));
                                                break;
                                            case R.id.it_2x1:
                                                break;
                                            case R.id.it_2x2:
                                                startActivity(new Intent(Grafico22Activity.this,Grafico22Activity.class));
                                                break;

                                            default:
                                                break;
                                        }
                                        return true;
                                    }
                                });
                                popupVisualizar.show();

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

        ic_vistas_graf2x2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(Grafico22Activity.this, ic_vistas_graf2x2);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.menu_vistas, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.it_layout:
                                startActivity(new Intent(Grafico22Activity.this,LayoutmaqActivity.class));
                                break;
                            case R.id.it_tabela:
                                startActivity(new Intent(Grafico22Activity.this,TMaquinasActivity.class));
                                break;
                            case R.id.it_grafico:
                                startActivity(new Intent(Grafico22Activity.this,Grafico1Activity.class));
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
