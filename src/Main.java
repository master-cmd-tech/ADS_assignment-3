import java.util.Scanner;

import anagram.AnagramChecker;
import kthsmallest.KthSmallestFinder;
import median.MedianCalculator;
import shipping.ShippingCapacityCalculator;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String first = input.nextLine();
        String second = input.nextLine();
        System.out.println(AnagramChecker.checkAnagramUsingSorting(first, second));

        int size = input.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) array[i] = input.nextInt();
        int k = input.nextInt();
        System.out.println(KthSmallestFinder.findKthSmallestElement(array, k));

        int medianSize = input.nextInt();
        int[] medianArray = new int[medianSize];
        for (int i = 0; i < medianSize; i++) medianArray[i] = input.nextInt();
        System.out.println(MedianCalculator.findMedianValue(medianArray));

        int weightCount = input.nextInt();
        int[] weights = new int[weightCount];
        for (int i = 0; i < weightCount; i++) weights[i] = input.nextInt();
        int days = input.nextInt();
        System.out.println(ShippingCapacityCalculator.calculateMinimumCapacity(weights, days));
    }
}