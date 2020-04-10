package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getFavorites() {
        List<Neighbour> favNeighbour = new ArrayList<>();
        for (Neighbour n: neighbours)
        {
            if (n.getIsFavorite())
            {
                favNeighbour.add(n);
            }
        }
        return  favNeighbour;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void createNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

    @Override
    public void changeFavorite(long id, boolean isFav) {
        for (Neighbour n: neighbours)
        {
            if (n.getId() == id)
            {
                n.setIsFavorite(isFav);
            }
        }
    }
}
