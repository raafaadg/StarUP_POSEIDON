package com.poseidon.poseidon;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.Toast;

public class CustomRequest {
    private Fragment fragment;
    private Context context;
    private ProgressDialog progressDialog;


    public CustomRequest(Fragment fragment, ProgressDialog progressDialog) {

        this.context = fragment.getContext();
        this.fragment = fragment;
        this.progressDialog = progressDialog;

        try {
            startProgressDialog();
            if (!ConnectionUtil.isConnected(context)) {
                Toast.makeText(context, "Sem conexão", Toast.LENGTH_SHORT).show();
                dismissProgressDialog();

            } else {
                request_call();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public CustomRequest(Fragment fragment) {
        this(fragment, null);
    }

    public CustomRequest(Context context, ProgressDialog progressDialog) {

        this.context = context;
        this.fragment = null;
        this.progressDialog = progressDialog;

        try {
            startProgressDialog();
            if (!ConnectionUtil.isConnected(context)) {
                Toast.makeText(context, "Sem conexão", Toast.LENGTH_SHORT).show();
                dismissProgressDialog();
            } else {
                request_call();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public CustomRequest(Context context) {
        this(context, null);
    }

    public void request_call() throws Exception {
    }

    public void startProgressDialog() throws Exception {
        if(progressDialog == null){
            progressDialog = new ProgressDialog(context, R.style.AppTheme);
            progressDialog.setMessage("Aguarde");
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(false);
        }
        if(progressDialog != null)
            progressDialog.show();
    }

    public void dismissProgressDialog(){
        progressDialog.dismiss();
    }

    public void createMessageDialog(String message){

        new AlertDialog.Builder(context).setMessage(message).setTitle("Alerta").show();
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public ProgressDialog getProgressDialog() {
        return progressDialog;
    }

    public void setProgressDialog(ProgressDialog progressDialog) {
        this.progressDialog = progressDialog;
    }
}
