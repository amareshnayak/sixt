package com.inducesmile.androidgsonparser;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.LruCache;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.PositionOfCar {

    private final String TAG = "MainActivity";

    private RecyclerView recyclerView;

    private LinearLayoutManager layoutManager;

    private RecyclerViewAdapter adapter;
    private ImageLoader mImageLoader;
    private RequestQueue mRequestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        mRequestQueue = Volley.newRequestQueue(MainActivity.this);
        mImageLoader = new ImageLoader(mRequestQueue, new ImageLoader.ImageCache() {
            private final LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>(10);
            public void putBitmap(String url, Bitmap bitmap) {
                mCache.put(url, bitmap);
            }
            public Bitmap getBitmap(String url) {
                return mCache.get(url);
            }
        });
        requestJsonObject();
    }

    private void requestJsonObject(){

        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://www.codetalk.de/cars.json";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, "Response " + response);
                        GsonBuilder builder = new GsonBuilder();
                        Gson mGson = builder.create();

                        List<ItemObject> posts = new ArrayList<ItemObject>();
                        posts = Arrays.asList(mGson.fromJson(response, ItemObject[].class));

                        adapter = new RecyclerViewAdapter(MainActivity.this, posts,mImageLoader);
                        recyclerView.setAdapter(adapter);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "Error " + error.getMessage());
            }
        });
        queue.add(stringRequest);
    }

    @Override
    public void sendPosition(int position) {
        Log.d("ppppppppppppppppp",""+position);
    }
}
