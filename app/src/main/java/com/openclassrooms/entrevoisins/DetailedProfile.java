package com.openclassrooms.entrevoisins;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

public class DetailedProfile extends AppCompatActivity
{
    //référencement et déclaration de l'Api & star button
    private FloatingActionButton mStarButton;
    private NeighbourApiService mApiService;
    boolean isFavorite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_profile);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //id
        long idAvatar = getIntent().getLongExtra("id",0);

        //avatar
        ImageView avatar = findViewById(R.id.item_list_avatar);
        String avatarImage = getIntent().getStringExtra("avatar");
        Glide.with(this)
                .load(avatarImage)
                .into(avatar);

        //neighbour name
        TextView firstName = findViewById(R.id.firstName);
        String name = getIntent().getStringExtra("neighbourName");
        firstName.setText(name);

        getSupportActionBar().setTitle(name);

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

        mApiService = DI.getNeighbourApiService();

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
                    Snackbar.make(view, name + " a éte ajouté(e) aux favoris", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else
                {
                    mStarButton.setImageResource(R.drawable.ic_star_border_white_24dp);
                    mApiService.changeFavorite(idAvatar, false);
                    isFavorite = false;
                    Snackbar.make(view, name + " a éte supprimé(e) des favoris", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
    }
}
