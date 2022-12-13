package com.arely.incenterapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
 EditText edtUsuario,edtPassword;
 Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtPassword=findViewById(R.id.edtPassword);
        edtUsuario=findViewById(R.id.edtUsuario);
        btnLogin=findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validarUsuario("http://yessichat.estudiasistemas.com/validar_usuario.php");
            }
        });


    }
    private  void validarUsuario(String URL){
        String usuario = edtUsuario.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if(!response.isEmpty()){
                    Intent intent=new Intent(getApplicationContext(), ProductosActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "Usuario 0 contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros= new HashMap<String, String>();
                parametros.put("usuario",edtUsuario.getText().toString());
                parametros.put("password",edtPassword.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}