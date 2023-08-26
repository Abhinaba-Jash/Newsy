package com.example.newsy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ListView listView;
    private static final String JSON_URL = "https://newsapi.org/v2/everything?q=tesla&from=2023-06-20&sortBy=publishedAt&apiKey=a2fca05e1a7048278eff6fe6cc877509";
    List<TutorialList> tutorial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        tutorial = new ArrayList<>();
        //this method will fetch and parse the data
        loadTutorialList();
    }
    public void loadTutorialList(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //creating a string request to send request to the url
        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //hiding the progressbar after completion
                        //progressBar.setVisibility(View.INVISIBLE);

                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
//                        try {
//                            //getting the whole json object from the response
//                            JSONObject obj = new JSONObject(response);
//
//                            //we have the array named tutorial inside the object
//                            //so here we are getting that json array
//                            JSONArray tutorialsArray = obj.getJSONArray("tutorial");
//
//                            //now looping through all the elements of the json array
//                            for (int i = 0; i < tutorialsArray.length(); i++) {
//                                //getting the json object of the particular index inside the array
//                                JSONObject tutorialsObject = tutorialsArray.getJSONObject(i);
//
//                                //creating a tutorial object and giving them the values from json object
//                                TutorialList tutorials = new TutorialList(tutorialsObject.getString("title"), tutorialsObject.getString("urlToImage"),tutorialsObject.getString("description"));
//
//                                //adding the tutorial to tutoriallist
//                                tutorial.add(tutorials);
//                            }
//
//                            //creating custom adapter object
//                            customAdapter adapter = new customAdapter(tutorial, getApplicationContext());
//
//                            //adding the adapter to listview
//                            listView.setAdapter(adapter);
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //displaying the error in toast if occur
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
        requestQueue.add(stringRequest);

    }

}