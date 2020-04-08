package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class ListNeighbourPagerAdapter extends FragmentPagerAdapter {

    public ListNeighbourPagerAdapter(FragmentManager fm) {
        super(fm);
        //possible modification pour ajouter les favoris
    }

    /**
     * getItem is called to instantiate the fragment for the given page.
     * @param position
     * @return
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0)
        {
            return NeighbourFragment.newInstance();
        }
        else
        {
            return FavoriteFragment.newInstance();
        }
    }

    /*Les 2 pages retournent la liste de Neighbours voir comment retourner les favoris dans l'onglet favorites

    /**
     * get the number of pages
     * @return
     */
    @Override
    public int getCount() {
        return 2;
    } //changer return 1 en return 2 (page my neighbours & favorites)
}