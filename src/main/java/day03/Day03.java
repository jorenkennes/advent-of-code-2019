package day03;

import util.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day03 {

    public static void main(String[] args) throws IOException {
        List<String> input = new Util().readFile("day03.txt");

        Day03 day03 = new Day03();
        int distance = day03.findWires(input);
        System.out.println(distance);
    }
    
    // read input of wire 1
    // find all coordinates of wire 1, 2
    // add visualization each wire start, corner
    // find double coordinates --> crossings
    // change visualization for double coordinates

    public int findWires(List<String> input) {
        ArrayList<Position> positionsWire1 = findPositions(input.get(0)); //wire 1
        ArrayList<Position> positionsWire2 = findPositions(input.get(1)); //wire 2
        return findResult(positionsWire1, positionsWire2);
    }

    private int findResult(ArrayList<Position> positionsWire1, ArrayList<Position> positionsWire2) {
        ArrayList<Integer> distances = new ArrayList<>();
        ArrayList<Integer> steps = new ArrayList<>();

        positionsWire1.forEach(position -> {
            for (Position position2 : positionsWire2) {
                if (position.equals(position2)) {
                    System.out.print(position.getX() + "," + position.getY() + " ," + position.getStep() + " | ");
                    System.out.println(position2.getX() + "," + position2.getY() + " ," + position2.getStep());
                    distances.add(calculateDistance(position));
                    steps.add(position.getStep() + position2.getStep());
                }
            }
        });
        System.out.println(steps.stream().min(Integer::compare).get());
        return distances.stream().min(Integer::compare).get();
    }

    private ArrayList<Position> recalculateSteps(ArrayList<Position> originalWire) {
        ArrayList<Position> newWire = new ArrayList<>();
        int newStep = 0;
        for (Position position : originalWire) {
            if (newWire.contains(position)) {
                System.out.println(position.getX() + "," + position.getY() + ", step:" + position.getStep());
                //new step calculation
                newStep = newWire.get(newWire.indexOf(position)).getStep();
            } else {
                //get previous step
                if (newWire.size() > 0) {
                    newStep = newWire.get(newWire.size() - 1).getStep() + 1;
                } else {
                    newStep++;

                }
            }
            position.setStep(newStep);
            newWire.add(position);
        }

        return newWire;
    }

    private int calculateDistance(Position position) {
        return Math.abs(position.getX()) + Math.abs(position.getY());
    }


    public ArrayList<Position> findPositions(String input) {

        ArrayList<Position> wire = new ArrayList<>();
        String[] moves = input.split(",");
        Position prevPosition = new Position(0, 0, 'O', 0);

        for (String move : moves) {
            List<Position> nextPositions = findNextPositions(prevPosition, move, wire);
            wire.addAll(nextPositions);
            prevPosition = nextPositions.get(nextPositions.size() - 1);
        }
        return wire;
    }

    private List<Position> findNextPositions(Position prevPosition, String nextMove, ArrayList<Position> wire) {

        ArrayList<Position> nextPositions = new ArrayList<>();
        Direction direction = Direction.valueOf(nextMove.substring(0, 1));
        int moveValue = Integer.parseInt(nextMove.substring(1));
        int x = prevPosition.getX();
        int y = prevPosition.getY();
        int step = prevPosition.getStep();
        char visual;

        for (int i = 0; i < moveValue; i++) {
            if (direction.equals(Direction.R) || direction.equals(Direction.L)) {
                // moved horizontally
                x += direction.getOperation();
                visual = '-';
                step++;
            } else {
                // moved vertically
                y += direction.getOperation();
                visual = '|';
                step++;
            }
            nextPositions.add(new Position(x, y, visual, step));
        }

        return nextPositions;
    }


    public enum Direction {
        R(1), L(-1), U(1), D(-1);

        private int operation;

        Direction(int operation) {
            this.operation = operation;
        }

        public int getOperation() {
            return operation;
        }
    }
}
