package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

/**
 * Event show neighbours informations
 */
public class DetailedNeighbourEvent {

    /**
     * Neighbours informations
     */
    public Neighbour neighbour;

    /**
     * Constructor.
     * @param neighbour
     */
    public DetailedNeighbourEvent(Neighbour neighbour) {
        this.neighbour = neighbour;
    }
}
