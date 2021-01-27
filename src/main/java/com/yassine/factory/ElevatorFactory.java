package com.yassine.factory;

import com.yassine.entities.Elevator;

public class ElevatorFactory implements IElevatorFactory {
	
	public static ElevatorFactory singleton = null;
	
	private ElevatorFactory() {}
	
	public static ElevatorFactory getInstance(){
		if(singleton == null)
			return new ElevatorFactory();
		
		return singleton;
	}
	
	@Override
	public Elevator createElevator(String elevatorString, int nbFloors) {
		int pos = elevatorString.indexOf(":");
    	String id = elevatorString.substring(0, pos);
    	String currentFloor = elevatorString.substring(pos + 1, elevatorString.length());
    	
    	return new Elevator(id, Integer.valueOf(currentFloor), nbFloors);
	}

}
