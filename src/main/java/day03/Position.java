package day03;

import java.util.Objects;

public class Position {

    private int x;
    private int y;
    private char visual;
    private int step;


    public Position(int x, int y, char visual, int step) {
        this.x = x;
        this.y = y;
        this.visual = visual;
        this.step = step;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public void setVisual(char visual) {
        this.visual = visual;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

