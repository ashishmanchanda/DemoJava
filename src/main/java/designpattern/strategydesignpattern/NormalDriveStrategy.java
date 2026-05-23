package designpattern.strategydesignpattern;

class NormalDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("normal drive capability");
    }
}
