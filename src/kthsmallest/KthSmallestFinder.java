package kthsmallest;

public class KthSmallestFinder {


    public static int findKthSmallestElement(int[] numbers, int kthPosition) {
        mergeSort(numbers, 0, numbers.length - 1);
        return numbers[kthPosition - 1];
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        int[] leftPart = new int[leftSize];
        int[] rightPart = new int[rightSize];

        for (int i = 0; i < leftSize; i++) leftPart[i] = array[left + i];
        for (int j = 0; j < rightSize; j++) rightPart[j] = array[middle + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < leftSize && j < rightSize) {
            if (leftPart[i] <= rightPart[j]) array[k++] = leftPart[i++];
            else array[k++] = rightPart[j++];
        }

        while (i < leftSize) array[k++] = leftPart[i++];
        while (j < rightSize) array[k++] = rightPart[j++];
    }
}