package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.R;

import org.greenrobot.eventbus.Subscribe;

public class DetailedProfile extends AppCompatActivity
{
    //référencement et déclaration du back button
    private FloatingActionButton mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_profile);

        //avatar
        ImageView avatar = findViewById(R.id.item_list_avatar);


        //avatar neighbour name
        TextView avatarName = findViewById(R.id.avatar_name);
        avatarName.setText(getIntent().getStringExtra("avatarName"));

        //neighbour name
        TextView firstname = findViewById(R.id.firstname);
        firstname.setText(getIntent().getStringExtra("neighbourName"));

        //neighbour address
        TextView address = findViewById(R.id.address);
        address.setText(getIntent().getStringExtra("address"));

        //neighbour phone
        TextView phoneNumber = findViewById(R.id.phoneNumber);
        phoneNumber.setText(getIntent().getStringExtra("phoneNumber"));

        //neighbour facebook
        //TextView facebook = findViewById(R.id.facebook);
        //facebook.setText(getIntent().getStringExtra("facebook"));

        //about me title
        TextView about_title = findViewById(R.id.about_title);
        about_title.setText("À propos de moi");

        //about me text
        TextView about_text = findViewById(R.id.about_text);
        about_text.setText(getIntent().getStringExtra("aboutText"));


        //branchement du back button
        mBackButton = findViewById(R.id.back_arrow_button);

        //Création de l'évènement au clic
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backHomePage = new Intent(DetailedProfile.this, ListNeighbourActivity.class);
                startActivity(backHomePage);
            }
        });

    }
}
