package com.yassine.state;

import com.yassine.entities.Elevator;

public class ElevaatorStateStop implements ElevatorState {

	@Override
	public void goRest(Elevator elevator) {
		elevator.setState(new ElevatorStateRest());

	}

	@Override
	public void goUp(Elevator elevator, int floor) {
		elevator.setState(new ElevatorStateUp());
		elevator.getState().goUp(elevator, floor);
	}

	@Override
	public void goDown(Elevator elevator, int floor) {
		elevator.setState(new ElevatorStateDown());
		elevator.getState().goDown(elevator, floor);
	}

	@Override
	public void goStop(Elevator elevator) {
		throw new IllegalArgumentException("Elevator already stopped");
	}

	@Override
	public int getDistance(Elevator elevator, int floor) {
		return -1;
	}
	
	

}
