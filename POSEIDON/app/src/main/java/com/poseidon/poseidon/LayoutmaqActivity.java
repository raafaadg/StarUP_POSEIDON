package com.poseidon.poseidon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rafae on 06/09/2017.
 */

public class LayoutmaqActivity extends AppCompatActivity {


    Spinner sp_fabricas;
    ImageView ic_vistas_layout;
    ImageView ic_config_layout;

    ImageView iv_maquinas_config;
    ImageView iv_maquinas_legenda;
    GridView gv_maquinas;
    PopupWindow legenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layoutmaq);
        loadViwes();

        iv_maquinas_legenda.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    legenda = new PopupWindow(LayoutmaqActivity.this);
                    View layout = getLayoutInflater().inflate(R.layout.popup_legenda, null);
                    legenda.setContentView(layout);
                    // Set content width and height
                    legenda.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
                    legenda.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
                    // Closes the popup window when touch outside of it - when looses focus
                    legenda.setOutsideTouchable(true);
                    legenda.setFocusable(true);
                    legenda.showAsDropDown(v);
                } else if(event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    if(legenda!=null && legenda.isShowing())
                        legenda.dismiss();
                }
                return true;
            }
        });

        iv_maquinas_config.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(LayoutmaqActivity.this, ic_config_layout);
                popup.getMenuInflater().inflate(R.menu.menu_visualizacao, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.it_layout:
                                break;
                            case R.id.it_icone:
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

    private void loadHeader(){
        sp_fabricas = (Spinner) findViewById(R.id.sp_fabricas);
        ic_vistas_layout = (ImageView) findViewById(R.id.ic_vistas_layout);
        ic_config_layout = (ImageView) findViewById(R.id.ic_config_layout);
        List<String> fabricas = new ArrayList<>();
        fabricas.add("Ícones Máquinas - SPBrasil");
        fabricas.add("Ícones Máquinas - PR");
        fabricas.add("Ícones Máquinas - MG");
        fabricas.add("Ícones Máquinas - RJ");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, fabricas);

        sp_fabricas.setAdapter(arrayAdapter);

        ic_config_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(LayoutmaqActivity.this, ic_config_layout);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.menu_opcoes, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.it_logout:
                                startActivity(new Intent(LayoutmaqActivity.this,MainActivity.class));
                                break;
                            case R.id.it_idioma:
                                PopupMenu popupIdiomas = new PopupMenu(LayoutmaqActivity.this, ic_config_layout);
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

        ic_vistas_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(LayoutmaqActivity.this, ic_vistas_layout);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.menu_vistas, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.it_layout:
                                startActivity(new Intent(LayoutmaqActivity.this,LayoutmaqActivity.class));
                                break;
                            case R.id.it_tabela:
                                startActivity(new Intent(LayoutmaqActivity.this,TMaquinasActivity.class));
                                break;
                            case R.id.it_grafico:
                                startActivity(new Intent(LayoutmaqActivity.this,Grafico1Activity.class));
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


    private void loadViwes() {
        loadHeader();
        iv_maquinas_config = (ImageView) findViewById(R.id.iv_maquinas_config);
        iv_maquinas_legenda = (ImageView) findViewById(R.id.iv_maquinas_legenda);
        gv_maquinas = (GridView) findViewById(R.id.gv_maquinas);
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

        ListViewAdapter adapter = new ListViewAdapter(imagens, nome, porcentagem, this);
        gv_maquinas.setAdapter(adapter);

    }
}
