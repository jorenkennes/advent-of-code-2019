package day08;

import common.Day;
import util.Util;

import java.io.IOException;
import java.util.Arrays;

public class Day08 extends Day {


    private Util util;

    public static void main(String[] args) throws IOException {
        new Day08(new Util()).printResults();
    }

    public Day08(Util util) {
        this.util = util;
    }

    @Override
    public int executePart1() throws IOException {
        return findOnesAndTwos(25, 6);
    }

    public int findOnesAndTwos(int width, int height) throws IOException {
        int[] pixels = util.readIntStream("day08.txt", "").toArray();
        int[][] pixelGroups = groupPixels(pixels, width, height);
        int layer = getLayerFewest0Digits(pixelGroups);
        int ones = getNumberOfDigitsInLayer(pixelGroups[layer], 1);
        int twos = getNumberOfDigitsInLayer(pixelGroups[layer], 2);
        return ones * twos;
    }

    public int getNumberOfDigitsInLayer(int[] layer, int digitToFind) {
        int digitCount = 0;
        for (int pixel = 0; pixel < layer.length; pixel++) {
            digitCount += layer[pixel] == digitToFind ? 1 : 0;
        }
        return digitCount;
    }

    public int getLayerFewest0Digits(int[][] pixelGroups) {
        int layerFewestZeros = 0;
        int lowestZerosInLayer = Integer.MAX_VALUE;
        for (int layer = 0; layer < pixelGroups.length; layer++) {
            int zeroCount = getNumberOfDigitsInLayer(pixelGroups[layer], 0);
            if (zeroCount < lowestZerosInLayer) {
                layerFewestZeros = layer;
                lowestZerosInLayer = zeroCount;
            }
        }
        return layerFewestZeros;
    }

    private int[][] groupPixels(int[] pixelArray, int width, int height) {
        int nrOfLayers = pixelArray.length / (width * height);
        int[][] result = new int[nrOfLayers][width * height];
        for (int layer = 0; layer < nrOfLayers; layer++) {
            for (int pixel = 0; pixel < result[0].length; pixel++) {
                result[layer][pixel] = pixelArray[(layer * width * height) + pixel];
            }
        }
        return result;
    }

    @Override
    public int executePart2() throws IOException {
        int[] pixels = util.readIntStream("day08.txt", "").toArray();
        int[][] pixelGroups = groupPixels(pixels, 25, 6);
        int[] finalImage = decodeImage(pixelGroups);

        for(int y = 0; y < 6; y++) {
            for (int x = 0; x < 25; x++) {
                String printvalue = finalImage[x + y * 25] == 1? "#" : " ";
                System.out.print(printvalue);
            }
            System.out.println();
        }
        System.out.println(Arrays.toString(finalImage));
        return 0;
    }

    private int[] decodeImage(int[][] pixelLayers) {
        int[] finalLayer = pixelLayers[0]; // init final layer with first layer

        for (int layer = 0; layer < pixelLayers.length; layer++) {
            for (int pixel = 0; pixel < pixelLayers[0].length; pixel++) {
                // overwrite final layer on places with "2"
                if (finalLayer[pixel] == 2) {
                    finalLayer[pixel] = pixelLayers[layer][pixel];
                }
            }
        }
        return finalLayer;
    }


}
