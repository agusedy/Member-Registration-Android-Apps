package com.greentech.agusedyc.itc;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class ViewMember extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextId;
    private EditText editTextNama;
    private EditText editTextAlamat;
    private EditText editTextNohp;

    private Button buttonUpdate;
    private Button buttonDelete;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_member);

        Intent intent = getIntent();

        id = intent.getStringExtra(Config.MBR_ID);

        editTextId = (EditText) findViewById(R.id.editTextId);
        editTextNama = (EditText) findViewById(R.id.editTextNama);
        editTextAlamat = (EditText) findViewById(R.id.editTextAlamat);
        editTextNohp = (EditText) findViewById(R.id.editTextNohp);

        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        buttonDelete = (Button) findViewById(R.id.buttonDelete);

        buttonUpdate.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);

        editTextId.setText(id);

        getEmployee();
    }

    private void getEmployee(){
        class GetEmployee extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ViewMember.this,"Fetching...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(Config.URL_GET_MBR,id);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }

    private void showEmployee(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(Config.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String nama = c.getString(Config.TAG_NAMA);
            String alamat = c.getString(Config.TAG_ALAMAT);
            String nohp = c.getString(Config.TAG_NOHP);

            editTextNama.setText(nama);
            editTextAlamat.setText(alamat);
            editTextNohp.setText(nohp);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void updateMember(){
        final String nama = editTextNama.getText().toString().trim();
        final String alamat = editTextAlamat.getText().toString().trim();
        final String nohp = editTextNohp.getText().toString().trim();

        class UpdateMember extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ViewMember.this,"Updating...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(ViewMember.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put(Config.KEY_MBR_ID,id);
                hashMap.put(Config.KEY_MBR_NAMA,nama);
                hashMap.put(Config.KEY_MBR_ALAMAT,alamat);
                hashMap.put(Config.KEY_MBR_NOHP,nohp);

                RequestHandler rh = new RequestHandler();

                String s = rh.sendPostRequest(Config.URL_UPDATE_MBR,hashMap);

                return s;
            }
        }

        UpdateMember ue = new UpdateMember();
        ue.execute();
    }

    private void deleteMember(){
        class DeleteMember extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ViewMember.this, "Updating...", "Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(ViewMember.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(Config.URL_DELETE_MBR, id);
                return s;
            }
        }

        DeleteMember de = new DeleteMember();
        de.execute();
    }

    private void confirmDeleteMember(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure you want to delete this member?");

        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        deleteMember();
                        startActivity(new Intent(ViewMember.this,ViewAllMember.class));
                    }
                });

        alertDialogBuilder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void onClick(View v) {
        if(v == buttonUpdate){
            updateMember();
        }

        if(v == buttonDelete){
            confirmDeleteMember();
        }
    }
}
