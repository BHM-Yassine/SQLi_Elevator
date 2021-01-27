package com.yassine.state;
import com.yassine.entities.Elevator;

public class ElevatorStateDown implements ElevatorState {

	@Override
	public void goRest(Elevator elevator) {
		elevator.setState(new ElevatorStateRest());
		
		 if (elevator.getCurrentFloor() != 1) {
			 elevator.setState(this);
		 } else {
			 elevator.setState(new ElevatorStateUp());
		 }
	}

	@Override
	public void goUp(Elevator elevator, int floor) {
		throw new IllegalArgumentException("Elevator is moving Down");

	}

	@Override
	public void goDown(Elevator elevator, int floor) {
		if(elevator.getCurrentFloor() != floor) {
			elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
			goDown(elevator, floor);
		} else {
			goRest(elevator);
		}
	}

	@Override
	public void goStop(Elevator elevator) {
		elevator.setState(new ElevaatorStateStop());
	}
	
	@Override
	public int getDistance(Elevator elevator, int floor) {
		
		int distance = 0;
		int current = elevator.getCurrentFloor();
		
		if (current > floor) {
        	distance = Math.abs(current - floor);
        }
		else if (current < floor) {
        	distance = Math.abs(current - 1) + floor;
        }
        
        return distance;
	}

}
