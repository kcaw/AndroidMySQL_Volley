package com.example.user_pc.tbcrudsql;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.user_pc.tbcrudsql.Util.AppController;
import com.example.user_pc.tbcrudsql.Util.ServerAPI;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class deleteOrtu extends AppCompatActivity {
    EditText deleteOrtuID;
    Button btnDeleteOrtu;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_ortu);

        deleteOrtuID = (EditText) findViewById(R.id.nik_param);
        btnDeleteOrtu = (Button) findViewById(R.id.btn_deleteOrtu);
        pd = new ProgressDialog(deleteOrtu.this);

        btnDeleteOrtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //delete hare action
                deleteData();
            }
        });
    }
    private void deleteData()
    {
        pd.setMessage("Delete Data...");
        pd.setCancelable(false);
        pd.show();

        StringRequest delReq = new StringRequest(Request.Method.POST, ServerAPI.URL_DELETE_ORTU,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pd.cancel();
                        Log.d("volley","response : " + response.toString());
                        try {
                            JSONObject res = new JSONObject(response);
                            Toast.makeText(deleteOrtu.this, "pesam : " +res.getString("message") , Toast.LENGTH_SHORT).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                        startActivity(new Intent(deleteOrtu.this,HalamanOrtu.class));

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pd.cancel();
                        Log.d("volley", "error : " + error.getMessage());
                        Toast.makeText(deleteOrtu.this, "pesan : gagal menghapus data", Toast.LENGTH_SHORT).show();

                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("nik",deleteOrtuID.getText().toString());
                return map;
            }
        };

        AppController.getInstance().addToRequestQueue(delReq);
    }
}
