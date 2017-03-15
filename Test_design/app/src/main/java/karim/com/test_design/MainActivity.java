package karim.com.test_design;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button)findViewById(R.id.button);
        textview=(TextView)findViewById(R.id.text);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //http://star-wallet.com/api/cities
        // src=app
        // province_id=1
        // publicKey=ASDqw3e213ASDasda
        // hashOutput=5b03f5705f841efe54546b253891abf8d56ca4e8
        String url="http://star-wallet.com/api/cities";
        Map<String,String> params=new HashMap<>();
        params.put("src","app");
        params.put("province_id","1");
        params.put("publicKey","ASDqw3e213ASDasda");
        params.put("hashOutput","5b03f5705f841efe54546b253891abf8d56ca4e8");
        JSONObject parameter=new JSONObject(params);

        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url,parameter, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                textview.setText(response.toString());
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(request);
    }
}
