package com.example.pies;

//test comitta

//import android.support.v7.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    public int Lx=0;
    public int Ly=0;

    private TextView mTextViewResult;
    //private RequestQueue mQueue;
    Point point=new Point(0,0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_points);
        new FireBaseDatabaseHelper().readPoints(new FireBaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Point> points, List<String> keys) {
                new RecyclerView_Config().setConfig(mRecyclerView,MainActivity.this,points,keys);
                Toast.makeText(MainActivity.this,"X= "+Lx +"\n"+"Y= "+Ly,Toast.LENGTH_LONG).show();
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });


        //Toast.makeText(MainActivity.this,"Firebase Giiit",Toast.LENGTH_LONG).show();

    }






}