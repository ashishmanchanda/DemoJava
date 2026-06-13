package designpatternpracticeshrayansh.strategydesignpattern;

class PassengerVehicle extends Vehicle {
    PassengerVehicle() {super(new NormalDriveStrategy());}
}
