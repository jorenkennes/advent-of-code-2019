package day08;

import common.Day;
import util.Util;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Day08 extends Day {

    private Util util;
    private final int WIDTH = 25;
    private final int HEIGHT = 6;


    public static void main(String[] args) throws IOException {
        new Day08(new Util()).printResults();
    }

    public Day08(Util util) {
        this.util = util;
    }

    @Override
    public int executePart1() throws IOException {
        int[] pixels = util.readIntStream("day08.txt", "").toArray();
        int[][] layers = splitIntoLayers(pixels, WIDTH, HEIGHT);
        return findOnesAndTwos(layers);
    }

    public int findOnesAndTwos(int[][] layers) {
        int layer = getLayerFewest0Digits(layers);
        System.out.println(layer);
        int ones = getNumberOfDigitsInLayer(layers[layer], 1);
        int twos = getNumberOfDigitsInLayer(layers[layer], 2);
        return ones * twos;
    }

    public int getNumberOfDigitsInLayer(int[] layer, int digitToFind) {
        return (int) Arrays.stream(layer).filter(pixel -> pixel == digitToFind).count();
    }

    public int getLayerFewest0Digits(int[][] layers) {
        return IntStream.range(0, layers.length)
                .reduce((layerFewestZeros,i) -> {
                    int zeroCount =  getNumberOfDigitsInLayer(layers[i], 0);
                    int currentLowestZeros = getNumberOfDigitsInLayer(layers[layerFewestZeros], 0);
                    return zeroCount < currentLowestZeros ?  i : layerFewestZeros;
                })
                .getAsInt();
    }

    private int[][] splitIntoLayers(int[] pixelArray, int width, int height) {
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
        int[][] pixelGroups = splitIntoLayers(pixels, WIDTH, HEIGHT);
        int[] finalImage = decodeImage(pixelGroups);

        drawImage(finalImage);
        return 0;
    }

    private void drawImage(int[] finalImage) {
        for(int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                String printValue = finalImage[x + y * WIDTH] == 1? "#" : " ";
                System.out.print(printValue);
            }
            System.out.println();
        }
    }

    private int[] decodeImage(int[][] layers) {
        int[] finalLayer = layers[0]; // init final layer with first layer
        for (int[] pixelLayer : layers) {
            for (int pixel = 0; pixel < layers[0].length; pixel++) {
                // overwrite final layer on places with "2"
                if (finalLayer[pixel] == 2) {
                    finalLayer[pixel] = pixelLayer[pixel];
                }
            }
        }
        return finalLayer;
    }


}
