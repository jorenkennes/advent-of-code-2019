package day01;

public class SpacecraftModule {

    private double mass;
    private int totalFuel = 0;

    public SpacecraftModule(double mass) {
        this.mass = mass;
    }

    public double getMass() {
        return mass;
    }

    int calculateFuel() {
        return (int) Math.floor(mass / 3) - 2;
    }

    // total fuel considering the mass of the fuel in calculation
    int calculateTotalFuel(double mass) {
        int fuel = (int) Math.floor(mass / 3) - 2;
        if (fuel >= 0) {
            //totalFuel += fuel;
            return calculateTotalFuel(fuel) + fuel;
        }
        return 0;
    }
}
