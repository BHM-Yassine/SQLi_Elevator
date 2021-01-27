package com.yassine.state;
import com.yassine.entities.Elevator;

public class ElevatorStateRest implements ElevatorState {

	@Override
	public void goRest(Elevator elevator) {
		throw new IllegalArgumentException("Already Resting");
	}

	@Override
	public void goUp(Elevator elevator, int floor) {
		elevator.setState(new ElevatorStateUp());
		elevator.getState().goUp(elevator, floor);
	}

	@Override
	public void goDown(Elevator elevator, int floor) {
		elevator.setState(new ElevatorStateDown());
		elevator.goDown(floor);
		// elevator.getState().goDown(elevator, floor);

	}

	@Override
	public void goStop(Elevator elevator) {
		elevator.setState(new ElevaatorStateStop());
	}
	
	@Override
	public int getDistance(Elevator elevator, int floor) {
		       
        return Math.abs(elevator.getCurrentFloor() - floor);
	}


}
