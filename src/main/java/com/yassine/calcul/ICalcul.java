package com.yassine.calcul;

import java.util.List;

import com.yassine.entities.Elevator;

public interface ICalcul {
	
    /**
     * recuperer l'elevator le plus proche du floor demandé
     *
     * @param floor
     * @param listElevator
     * @return Elevator
     */
	public Elevator getClosestElevator(List<Elevator> listElevator, int floor);
}

