package com.example.projectfinal1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherStation extends AppCompatActivity {
    EditText CITYOUTPUT;
    Button button;
    TextView country, city, temp, humidity, windspeed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_station);


        CITYOUTPUT = (EditText) findViewById(R.id.entCity);
        button = (Button) findViewById(R.id.ChangeCIT);
        country = (TextView) findViewById(R.id.country);
        city = (TextView) findViewById(R.id.City);
        temp = (TextView) findViewById(R.id.Tempout);
        humidity = (TextView) findViewById(R.id.Humidout);
        windspeed = (TextView) findViewById(R.id.Windout);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findWeather();
            }
        });


    }

public void findWeather(){
    String City = CITYOUTPUT.getText().toString();
    String URL = "https://api.openweathermap.org/data/2.5/weather?q=" + City + "&appid=984f554800d65945625aa60ef17b8ef2";
    StringRequest stringRequest = new StringRequest(Request.Method.GET, URL ,new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {

            try {
                //Geography
                JSONObject jsonObject = new JSONObject(response);
                JSONObject object1=jsonObject.getJSONObject("sys");
                String Country_find= object1.getString("country");
                country.setText(Country_find);


                String City_find=object1.getString("name");
                city.setText(City_find);

                //Weather EVENTS

                JSONObject object2=jsonObject.getJSONObject("main");
                String temp1=object2.getString("temp");
                temp.setText(temp1);
                String windy=object2.getString("speed");
                windspeed.setText(windy);
                String humy=object2.getString("humidity");
                humidity.setText(humy);





            }
            catch (JSONException e){
                e.printStackTrace();
            }
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    });
    RequestQueue requestQueue= Volley.newRequestQueue(WeatherStation.this);
    requestQueue.add(stringRequest);

}

}

