package com.yassine.entities;

import com.yassine.state.ElevatorState;
import com.yassine.state.ElevatorStateDown;
import com.yassine.state.ElevatorStateRest;
import com.yassine.state.ElevatorStateUp;

public class Elevator {
	
	private String id;
	private int currentFloor;
	private ElevatorState state; // up down rest
	private int nbFloors = 0;
		
	public Elevator(String id, int currentFloor, int nbFloors) {
		super();
		
		this.id = id;
		this.currentFloor = currentFloor;
		this.state = new ElevatorStateRest();
		this.nbFloors = nbFloors;
	}
	
	
	public int getNbFloors() {
		return nbFloors;
	}


	public void setNbFloors(int nbFloors) {
		this.nbFloors = nbFloors;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCurrentFloor() {
		return currentFloor;
	}
	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	public ElevatorState getState() {
		return state;
	}
	public void setState(ElevatorState state) {
		this.state = state;
	}

	public void goUp(int floor) {
		this.state.goUp(this, floor);
	}
	public void goDown(int floor) {
		this.state.goDown(this, floor);
	}
	
	public void goRest() {
		this.state.goRest(this);
	}
	
	public void goStop() {
		this.state.goStop(this);
	}
	
	public int goDistance(int floor) {
		return this.state.getDistance(this, floor);
	}
	
}
