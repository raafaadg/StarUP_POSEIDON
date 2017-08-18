package com.poseidon.poseidon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.poseidon.poseidon.GetLeitura.GetLeitura;
import com.poseidon.poseidon.GetLeitura.GetLeituraResponse;
import okhttp3.OkHttpClient;

public class CadastroActivity extends AppCompatActivity{
    EditText et_emg_comando;
    EditText et_emg_nome;
    EditText et_emg_idade;
    EditText et_emg_peso;
    EditText et_emg_tipo;
    EditText et_emg_valor;
    Button bt_emg_buscar;
    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Carrega o layout que você vai usar nessa activity
        setContentView(R.layout.infos);
        // Carregue todas as views do seu layout
        loadViews();
        runThread();
        // Seta o que o botão vai fazer
        bt_emg_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                efetivarCadastro();
                Log.e("MyActivity","Teste Clique no botão");
            }
        });

    }

    public void executarLeitura(){
        Log.e("MyActivity", "Botão Pressionado");
    }
    private void loadViews() {
        //et_emg_comando = (EditText) findViewById(R.id.et_emg_comando);

    }
    public String getComando() {
        return et_emg_comando.getText().toString();
    }

    public void setInfo(GetLeituraResponse info) {
        //et_emg_comando.setText(info.comando);

    }

    private void efetivarCadastro(){
        new GetLeitura(CadastroActivity.this);
    }
    private void startThread() {

       runOnUiThread(new Runnable() {

            @Override
            public void run() {
                try {
                    while (true) {
                        Log.e("MyActivity", "Tempo");
                        //executa();
                        Log.e("MyActivity", "Rodando");
                        Thread.sleep(1000 * 10);
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private void runThread() {

        new Thread() {
            public void run() {
                while (true) {
                    try {
                        runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                new GetLeitura(CadastroActivity.this);
                            }
                        });
                        Thread.sleep(1000*10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
