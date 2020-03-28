package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.R;

public class DetailedProfile extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_profile);
        TextView firstname = findViewById(R.id.firstname);
        firstname.setText(getIntent().getStringExtra("neighbourName"));
    }
}
