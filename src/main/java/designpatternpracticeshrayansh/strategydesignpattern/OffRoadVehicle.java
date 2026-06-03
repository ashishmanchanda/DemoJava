package designpattern.strategydesignpattern;

class PassengerVehicle extends Vehicle {
    PassengerVehicle() {super(new NormalDriveStrategy());}
}
