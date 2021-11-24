package ir.mreonline.session06;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import cz.msebera.android.httpclient.Header;
import ir.mreonline.session06.models.VehicleModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url ="https://pouyaheydari.com/vehicles.json";
        AsyncHttpClient client =new AsyncHttpClient();
        client.get(url,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Gson gson =new Gson();
                VehicleModel vehicle = gson.fromJson(response.toString(),VehicleModel.class);
                int strTest = vehicle.getVehicles().size();
                Log.d("Testt", "onSuccess: "+strTest);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });

    }
}