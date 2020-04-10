package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;


public class DetailedProfile extends AppCompatActivity
{
    //référencement et déclaration des back & star buttons
    private FloatingActionButton mBackButton;
    private FloatingActionButton mStarButton;
    private  NeighbourApiService mApiService;
    boolean isFavorite;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_profile);

        //id
        long idAvatar = getIntent().getLongExtra("id",0);

        //avatar
        ImageView avatar = findViewById(R.id.item_list_avatar);
        String avatarImage = getIntent().getStringExtra("avatar");
        Glide.with(this)
                .load(avatarImage)
                .into(avatar);

        //avatar neighbour name
        TextView avatarName = findViewById(R.id.avatar_name);
        avatarName.setText(getIntent().getStringExtra("avatarName"));

        //neighbour name
        TextView firstName = findViewById(R.id.firstname);
        String name = getIntent().getStringExtra("neighbourName");
        firstName.setText(name);

        //neighbour address
        TextView address = findViewById(R.id.address);
        address.setText(getIntent().getStringExtra("address"));

        //neighbour phone
        TextView phoneNumber = findViewById(R.id.phoneNumber);
        phoneNumber.setText(getIntent().getStringExtra("phoneNumber"));

        //neighbour facebook
        TextView facebook = findViewById(R.id.facebook);
        facebook.setText(getIntent().getStringExtra("facebook") + name);

        //about me title
        TextView about_title = findViewById(R.id.about_title);
        about_title.setText("À propos de moi");

        //about me text
        TextView about_text = findViewById(R.id.about_text);
        about_text.setText(getIntent().getStringExtra("aboutText"));

        //isFavorite
        isFavorite = getIntent().getBooleanExtra("favorite", false);

        //branchement du back button
        mBackButton = findViewById(R.id.back_arrow_button);

        mApiService = DI.getNeighbourApiService();


        //Création de l'évènement au clic
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backHomePage = new Intent(DetailedProfile.this, ListNeighbourActivity.class);
                startActivity(backHomePage);
            }
        });

        //branchement du favorite button
        mStarButton = findViewById(R.id.star_button);

        //étoile par défaut sans clic en fonction de l'état cad favori ou non
        if (!isFavorite)
        {
            mStarButton.setImageResource(R.drawable.ic_star_border_white_24dp);
        }
        else
        {
            mStarButton.setImageResource(R.drawable.ic_star_white_24dp);
        }

        //Création de l'évènement au clic
        mStarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //ajouter les favoris si booleen est false et passer le booleen à true
                if (!isFavorite)
                {
                    mStarButton.setImageResource(R.drawable.ic_star_white_24dp);
                    mApiService.changeFavorite(idAvatar, true);
                    isFavorite = true;
                }
                else
                {
                    mStarButton.setImageResource(R.drawable.ic_star_border_white_24dp);
                    mApiService.changeFavorite(idAvatar, false);
                    isFavorite = false;
                }
                //si nouveau clic passer l'étoile en blanc, retirer le neighbour des favoris et repasser le booleen à false
            }
        });


    }
}
