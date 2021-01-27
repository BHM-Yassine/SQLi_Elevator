package com.yassine.state;

import com.yassine.entities.Elevator;

public interface ElevatorState {
    void goRest(Elevator elevator);
    void goUp(Elevator elevator, int floor);
    void goDown(Elevator elevator, int floor );
    void goStop(Elevator elevator);
    
    int getDistance(Elevator elevator, int floor);

}
