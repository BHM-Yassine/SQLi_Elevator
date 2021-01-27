package com.yassine.state;
import com.yassine.entities.Elevator;

public class ElevatorStateUp implements ElevatorState {

	@Override
	public void goRest(Elevator elevator) {
		elevator.setState(new ElevatorStateRest());
		
        if (elevator.getCurrentFloor() != elevator.getNbFloors()) {
            elevator.setState(this);
        } else {
            elevator.setState(new ElevatorStateDown());
        }
	}

	@Override
	public void goUp(Elevator elevator, int floor) {
		
		if(elevator.getCurrentFloor() != floor) {
			elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
			goUp(elevator, floor);
		} else {
			goRest(elevator);
		}
	}

	@Override
	public void goDown(Elevator elevator, int floor) {
		throw new IllegalArgumentException("Elevator is moving Up");

	}

	@Override
	public void goStop(Elevator elevator) {
		elevator.setState(new ElevaatorStateStop());
		
	}
	
	@Override
	public int getDistance(Elevator elevator, int floor) {
		
		int distance = 0;
		int current = elevator.getCurrentFloor();
		int nbFloors = elevator.getNbFloors();
		
		if (current > floor) {
			distance = Math.abs(current - nbFloors);
			distance += Math.abs(floor - nbFloors);
        }
		else if (current < floor) {
        	distance = Math.abs(current - floor);
        }
        
        return distance;
	}

}
