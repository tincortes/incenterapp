package com.arely.incenterapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProductosActivity extends AppCompatActivity {
    private static String url="https://yessichat.estudiasistemas.com/productos.php";
    List<Productos> productosList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        Log.v("Verbose","Está entrando.");
        cargargarImagen();

        recyclerView= findViewById(R.id.recy);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productosList=new ArrayList<>();

    }

    private void cargargarImagen() {
        StringRequest stringRequest =new StringRequest(Request.Method.POST,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);

                            for (int i = 0; i < array.length(); i++) {
                                JSONObject Productos = array.getJSONObject(i);

                                productosList.add(new Productos(
                                        Productos.getInt("codigo"),
                                        Productos.getString("nombreProducto"),
                                        Productos.getString("descripcion"),
                                        Productos.getString("precioCompra"),
                                        Productos.getString("precioVenta"),
                                        Productos.getString("existencia")
                                ));
                            }
                            Adapter adapter = new Adapter(ProductosActivity.this, productosList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(stringRequest);
    }


}