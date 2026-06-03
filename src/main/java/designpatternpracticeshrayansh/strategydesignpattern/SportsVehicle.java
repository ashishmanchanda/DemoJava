package designpattern.strategydesignpattern;

class SportsVehicle extends Vehicle {

    SportsVehicle() {super(new SportsDriveStrategy());}
}