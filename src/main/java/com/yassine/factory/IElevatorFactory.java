package com.yassine.factory;

import com.yassine.entities.Elevator;

public interface IElevatorFactory {

	/**
	 * creation d'un elevator
	 *
	 * @param elevatorString
	 * @param nbFloors
	 * @return Elevator
	 */
	
	public Elevator createElevator(String elevatorString, int nbFloors);
}
