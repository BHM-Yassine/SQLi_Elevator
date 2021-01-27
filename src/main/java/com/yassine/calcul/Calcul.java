package com.yassine.calcul;

import java.util.ArrayList;
import java.util.List;

import com.yassine.entities.Elevator;
import com.yassine.state.ElevatorStateDown;
import com.yassine.state.ElevatorStateRest;
import com.yassine.state.ElevatorStateUp;

public class Calcul implements ICalcul{
	
	// private List<Elevator> elevators = new ArrayList<Elevator>();
	
	public static Calcul singleton = null;
	
	private Calcul(){}
	
	public static Calcul getInstance(){
		if(singleton == null)
			return new Calcul();
		return singleton;
	}
		

	@Override
	public Elevator getClosestElevator(List<Elevator> elevators, int floor) {
		int minimum = 10;
		int distance = 0;
		
		Elevator tempElevator = null;
		
		for(Elevator e : elevators) {

			distance = e.goDistance(floor);

            if(distance >= 0 && distance < minimum) {
            	minimum = distance;
            	tempElevator = e;
            }
			
		}
		
		return tempElevator;
	}

}
