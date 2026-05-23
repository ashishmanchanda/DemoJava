package designpattern.strategydesignpattern;

class OffRoadVehicle extends Vehicle{
    OffRoadVehicle() {super(new NormalDriveStrategy());}
    @Override
    public void drive() {
        System.out.println("sports drivi capability");
    }
}