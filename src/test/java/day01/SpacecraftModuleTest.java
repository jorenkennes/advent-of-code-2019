package day01;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpacecraftModuleTest {

    @Test
    public void calculateFuel_given_12_expects_2() {
        SpacecraftModule spacecraftModule = new SpacecraftModule(12);
        assertThat(spacecraftModule.calculateFuel()).isEqualTo(2);
    }

    @Test
    public void calculateFuel_given_14_expects_3() {
        SpacecraftModule spacecraftModule = new SpacecraftModule(14);
        assertThat(spacecraftModule.calculateFuel()).isEqualTo(2);
    }

    @Test
    public void calculateFuel_given_1969_expects_654() {
        SpacecraftModule spacecraftModule = new SpacecraftModule(1969);
        assertThat(spacecraftModule.calculateFuel()).isEqualTo(654);
    }

    @Test
    public void calculateFuel_given_100756_expects_33583() {
        SpacecraftModule spacecraftModule = new SpacecraftModule(100756);
        assertThat(spacecraftModule.calculateFuel()).isEqualTo(33583);
    }

    @Test
    public void calculateTotalFuel_given__expects_2() {
        SpacecraftModule spacecraftModule = new SpacecraftModule(14);
        assertThat(spacecraftModule.calculateTotalFuel(14)).isEqualTo(2);
    }

    @Test
    public void calculateTotalFuel_given_1969_expects_966() {
        SpacecraftModule spacecraftModule = new SpacecraftModule(1969);
        assertThat(spacecraftModule.calculateTotalFuel(1969)).isEqualTo(966);
    }

    @Test
    public void calculateTotalFuel_given_100756_expects_50346() {
        SpacecraftModule spacecraftModule = new SpacecraftModule(100756);
        assertThat(spacecraftModule.calculateTotalFuel(100756)).isEqualTo(50346);
    }

}
