# Mesosphere Elevator Challenge

Design and implement an elevator control system. What data structures, interfaces and algorithms will you need? Your elevator control system should be able to handle a few elevators — up to 16.

=========================================

## Build Information
	java Simulation (number of elevators) (test file - optional)

## Problem with FCFS
The problem with FCFS is that it is clearly not the most efficient in servicing most of the user. Also, if a person getting on the 8th floor and was trying to travel down to the 1st floor, FCFS would cause an issue here. If the next few requests were never the 1st floor, the user would be stuck in the elevator forever until a 1st floor was finally requested!

## Implementation method
The elevator all starts at an idle state. Using the SCAN method, when a pickup request is sent, the algorithm will look to idle elevators to act first. This helps spread out the load. Afterwards, the initial request will dictate how the elevator will travel (whether up or down). Then, if none of the elevators are idle, a request sent will be picked up by elevators going in the same direction that haven't already passed the floor (whether up or down). This ensures that the elevator will pick up the passengers on the way. Also, requests are stored in a priority queue so that the next nearest floor will be at the head and polled off. This allows elevators to pick up the nearest floor as it travels. After the requests for the elevator is empty, the elevator will return to an idle state.

## Assumption
I assumed that the elevators moved only immediately after the pickup request. I also assumed that the printing out the state would not update the elevators location.

## Limitations
Due to time constraint, the algorithm I was hoping to implement would be to allow elevators to calculate the distant to the floor and pick up the nearest floors in the same direction. Therefore, I just chose the design to have idle elevators move first. Also I was hoping to use threads for the simulation. I also attempted to tackle the issue of when the user enters the elevator and enters a floor, however, I couldn't end up with a design that only allowed user to enter input when they enter the elevator. I used a placeholder 10 to assume all users entering the elevator wish to go to floor 10.

## Commands
The commands are
step
state
pickup (floor) (direction)
exit 


