package designpatternpracticeshrayansh.strategydesignpattern;

class SportsDriveStrategy implements DriveStrategy {
    @Override
    public void drive()
    {
        System.out.println("sports drive capability");
    }
}