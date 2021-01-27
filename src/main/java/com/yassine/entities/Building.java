package com.yassine.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import com.yassine.factory.IElevatorFactory;
import com.yassine.calcul.Calcul;
import com.yassine.factory.ElevatorFactory;

public class Building {

	private IElevatorFactory elevatorFactory = ElevatorFactory.getInstance();
	private Calcul calcul = Calcul.getInstance();

	private int numberOfFloors;
	private List<Elevator> elevators = new ArrayList<Elevator>();

	/**
	 * creation du building
	 *
	 * @param number
	 * @param stringElevators
	 * @return Building
	 */

	public Building(int number, String... stringElevators) {
		this.numberOfFloors = number;
		createElevators(number, stringElevators);
	}

	public void addElevator(Elevator e) {
		elevators.add(e);
	}

	/**
	 * creation des elevators
	 *
	 * @param nbFloors
	 * @param stringElevators
	 */

	private void createElevators(int nbFloors, String... stringElevators) {

		Arrays.stream(stringElevators).map(elevatorString -> elevatorFactory.createElevator(elevatorString, nbFloors))
				.forEach(elevator -> {
					addElevator(elevator);
				});
	}

	/**
	 * recupere id de l'elevator le plus proche
	 *
	 * @param elevators
	 * @param numberOfFloors
	 * @param String
	 */
	public String requestElevator() {
		Elevator elevator = calcul.getClosestElevator(elevators, numberOfFloors);
		return elevator.getId();
	}

	/**
	 * recupere elevator par son Id
	 *
	 * @param id
	 * @param Elevator
	 */
	public Elevator findById(String id) {
		return elevators.stream().filter(elevator -> elevator.getId().equals(id)).findAny().orElse(null);
	}

	/**
	 * faire bouger l elevator vers le haut ou vers le bas
	 *
	 * @param idElevator
	 * @param state
	 */

	public void move(String idElevator, String state) {
		Elevator elevator = findById(idElevator);
		if (elevator == null)
			throw new IllegalArgumentException();

		switch (state) {
		case "UP":
			elevator.goUp(elevator.getCurrentFloor() + 1);
			break;
		case "DOWN":
			elevator.goDown(elevator.getCurrentFloor() - 1);
			break;
		default:
			throw new IllegalArgumentException("State indefined");
		}

	}

	/**
	 * faire stoper l elevator dans un floor donné
	 *
	 * @param elevatorId
	 * @param floor
	 */

	public void stopAt(String elevatorId, int floor) {
		Elevator elevator = findById(elevatorId);
		if (elevator == null)
			throw new IllegalArgumentException();

		elevator.setCurrentFloor(floor);
		elevator.goStop();
	}

	public String requestElevator(int i) {
		Elevator elevator = calcul.getClosestElevator(elevators, i);
		return elevator.getId();
	}
}
