package id.ac.pnm.studentportalnewver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DataDiri extends AppCompatActivity {
    TextView npmdtdiri, namaDtdiri, alamatDtdiri, noHpDtdiri, genderDtdiri, NIKDtdiri, emailDtdiri;
    String npm;
    String url = "https://dekadragonslayer.000webhostapp.com/dtdiri/readdiribynpm.php";
    JSONObject jsonObject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_diri);
        npmdtdiri = (TextView) findViewById(R.id.NPMdatadiri);
        final Bundle extras = getIntent().getExtras();
        npm = extras.getString("npmDtDiri");
        npmdtdiri.setText(npm);

        namaDtdiri = (TextView) findViewById(R.id.namaDtDiri);
        alamatDtdiri = (TextView) findViewById(R.id.alamatdtDiri);
        noHpDtdiri = (TextView) findViewById(R.id.noHPDtdiri);
        genderDtdiri = (TextView) findViewById(R.id.genderDtdiri);
        NIKDtdiri = (TextView) findViewById(R.id.NIKDtdiri);
        emailDtdiri = (TextView) findViewById(R.id.emaildtDiri);

        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String s = response;
                try {
                    jsonObject = new JSONObject(s);
                    JSONArray a = jsonObject.getJSONArray("result");
                    for (int i = 0; i < a.length(); i++) {
                        JSONObject c = a.getJSONObject(i);
                        String nik = c.getString("nik");
                        String namaLengkap = c.getString("namaLengkap");
                        String jenisKelamin = c.getString("jenisKelamin");
                        String alamat = c.getString("alamat");
                        String noHp = c.getString("noHp");
                        String email = c.getString("email");

                        HashMap<String, String> resultx = new HashMap<>();
                        NIKDtdiri.setText(nik);
                        namaDtdiri.setText(namaLengkap);
                        genderDtdiri.setText(jenisKelamin);
                        alamatDtdiri.setText(alamat);
                        noHpDtdiri.setText(noHp);
                        emailDtdiri.setText(email);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                params.put("npm", npm);
                return params;

            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(DataDiri.this);
        requestQueue.add(request);
    }
}
