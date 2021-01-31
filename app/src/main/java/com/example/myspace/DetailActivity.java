package com.example.myspace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import model.Planet;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_PLANET = "planet";
    public static final String EXTRA_INDEX = "planetIndex";


    //int mPlanetindex = -1;

    Toolbar mToolbar;
    ImageView mPlanetimage;
    TextView mPlanetdescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mToolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        mPlanetimage = (ImageView) findViewById(R.id.detail_planet_img);
        mPlanetdescription = (TextView) findViewById(R.id.detail_description);

        Planet mPlanet = (Planet) getIntent().getParcelableExtra(EXTRA_PLANET);
        //int mPlanetindex = intent.getIntExtra(EXTRA_INDEX, -1);

        setSupportActionBar(mToolbar);
        mToolbar.setTitle(mPlanet.getmName());
        mToolbar.setBackgroundColor(Color.parseColor(mPlanet.getmColor()));

        Picasso.get().load(mPlanet.getmImageurl()).into(mPlanetimage);
        mPlanetdescription.setText(mPlanet.getmDescription());
    }
}