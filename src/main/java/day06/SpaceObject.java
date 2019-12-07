package day06;

import java.util.Objects;

public class SpaceObject {

    private String name;
    private SpaceObject orbitsAround;
    private String orbits;
    private int orbitCount = 0;

    public SpaceObject(String name, String orbits) {
        this.name = name;
        this.orbits = orbits;
    }

    public String getName() {
        return name;
    }

    public SpaceObject getOrbitsAround() {
        return orbitsAround;
    }

    public void setOrbitsAround(SpaceObject orbitsAround) {
        this.orbitsAround = orbitsAround;
    }

    public int getOrbitCount() {
        return orbitCount;
    }

    public void setOrbitCount(int orbitCount) {
        this.orbitCount = orbitCount;
    }

    public String getOrbits() {
        return orbits;
    }

    public void setOrbits(String orbits) {
        this.orbits = orbits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpaceObject that = (SpaceObject) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, orbitsAround, orbits, orbitCount);
    }
}
