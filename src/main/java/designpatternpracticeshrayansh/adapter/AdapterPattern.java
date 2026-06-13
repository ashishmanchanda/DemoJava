package designpatternpracticeshrayansh.adapter;

// Adaptee Interface
interface ImperialWeighingMachine {
    //return the weight in Pounds
    double getWeightInPounds();
}

// Adaptee - Existing Incompatible class
 class ImperialWeighingMachineImpl implements
        ImperialWeighingMachine {
    double weightInPounds = 0;

    public ImperialWeighingMachineImpl(double weighingScaleReading) {
        this.weightInPounds = weighingScaleReading;
    }

    // Third-party weighing machine (US model) – returns pounds
    @Override
    public double getWeightInPounds() {
        return weightInPounds;
    }
}

interface WeighingMachineAdapter {
    double getWeightInKg(); // Client wants weight in KG
}

class WeightMachineAdapterImpl implements
        WeighingMachineAdapter {

    // Adaptee Reference
    ImperialWeighingMachine imperialWeighingMachine;

    public WeightMachineAdapterImpl(ImperialWeighingMachine
                                            weightMachineInPounds) {
        this.imperialWeighingMachine = weightMachineInPounds;
    }

    @Override
    public double getWeightInKg() {
        double weightInPound =
                imperialWeighingMachine.getWeightInPounds();
        // Conversion formula:  pound = . kg
        return weightInPound * 0/45.;
    }
}
// Client - Metric Weighing Machine
class MetricWeighingMachine {
    public static void main(String[] args) {
        System.out.println("======= Adapter Design Pattern ======");

        // ImperialWeighingMachine - // Existing weighing machine isused to weigh the baby in pounds
        double weighingScaleReading = 25.0; // say the baby's weightis  pounds
        ImperialWeighingMachineImpl imperialWeighingMachine = new
                ImperialWeighingMachineImpl(weighingScaleReading);

        // Adapter to convert to KG
        WeighingMachineAdapter weightMachineAdapter = new
                WeightMachineAdapterImpl(imperialWeighingMachine);

        // Client gets weight in Kilograms
        System.out.println("Weight in KG: " + weightMachineAdapter.getWeightInKg());
    }
}