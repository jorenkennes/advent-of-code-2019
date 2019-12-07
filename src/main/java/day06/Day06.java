package day06;

import common.Day;
import util.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Day06 extends Day {

    private Util util;

    public static void main(String[] args) throws IOException {
        new Day06(new Util()).printResults();
    }

    public Day06(Util util) {
        this.util = util;
    }

    public List<SpaceObject> createSpaceObjects(List<String> orbitMap) {
        List<SpaceObject> spaceObjects = orbitMap.stream()
                .map(orbitRelation -> new SpaceObject(orbitRelation.split("\\)")[1], orbitRelation.split("\\)")[0]))
                .collect(Collectors.toList());

        for (SpaceObject spaceObject : spaceObjects) {
            Optional<SpaceObject> first = spaceObjects.stream()
                    .filter(object -> object.getName().equals(spaceObject.getOrbits()))
                    .findFirst();
            first.ifPresent(spaceObject::setOrbitsAround);
        }

        for (int i = 0; i < spaceObjects.size(); i++) {
            SpaceObject current = spaceObjects.get(i);
            int counter = getDistanceBetween(current, null);
            spaceObjects.get(i).setOrbitCount(counter);
        }
        return spaceObjects;
    }

    private int getDistanceBetween(SpaceObject start, SpaceObject end) {
        int counter = 1;
        SpaceObject current = start;
        while (current.getOrbitsAround() != null && !current.getOrbitsAround().equals(end)) {
            current = current.getOrbitsAround();
            counter++;
        }
        return counter;
    }

    @Override
    public int executePart1() throws IOException {
        List<String> orbitMap = util.readFile("day06.txt");
        List<SpaceObject> spaceObjects = createSpaceObjects(orbitMap);
        return spaceObjects.stream().map(SpaceObject::getOrbitCount).mapToInt(Integer::intValue).sum();
    }

    @Override
    public int executePart2() throws IOException {
        List<String> orbitMap = util.readFile("day06.txt");
        List<SpaceObject> spaceObjects = createSpaceObjects(orbitMap);
        SpaceObject you = spaceObjects.stream()
                .filter(spaceObject -> spaceObject.getName().equals("YOU"))
                .findFirst().get();
        SpaceObject santa = spaceObjects.stream()
                .filter(spaceObject -> spaceObject.getName().equals("SAN"))
                .findFirst().get();
        SpaceObject commonSpaceObject = findCommon(spaceObjects, you, santa);
        return getDistanceBetween(you, commonSpaceObject) + getDistanceBetween(santa, commonSpaceObject) - 2;
    }

    private SpaceObject findCommon(List<SpaceObject> spaceObjects, SpaceObject you, SpaceObject santa) {
        ArrayList<SpaceObject> orbitListYou = getOrbitPathToCOM(you);
        ArrayList<SpaceObject> orbitListSanta = getOrbitPathToCOM(santa);
        return orbitListYou.stream().filter(orbitListSanta::contains).findFirst().get();
    }

    private ArrayList<SpaceObject> getOrbitPathToCOM(SpaceObject spaceObject) {
        ArrayList<SpaceObject> orbitList = new ArrayList<>();
        while(spaceObject.getOrbitsAround() != null) {
            spaceObject = spaceObject.getOrbitsAround();
            orbitList.add(spaceObject.getOrbitsAround());
        }
        return orbitList;
    }
}

