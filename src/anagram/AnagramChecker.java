package anagram;

public class AnagramChecker {


    public static String checkAnagramUsingSorting(String firstText, String secondText) {
        if (firstText.length() != secondText.length()) {
            return "NO";
        }

        char[] firstArray = firstText.toCharArray();
        char[] secondArray = secondText.toCharArray();

        mergeSortCharacters(firstArray, 0, firstArray.length - 1);
        mergeSortCharacters(secondArray, 0, secondArray.length - 1);

        for (int index = 0; index < firstArray.length; index++) {
            if (firstArray[index] != secondArray[index]) {
                return "NO";
            }
        }
        return "YES";
    }

    private static void mergeSortCharacters(char[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSortCharacters(array, left, middle);
            mergeSortCharacters(array, middle + 1, right);
            mergeCharacters(array, left, middle, right);
        }
    }

    private static void mergeCharacters(char[] array, int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        char[] leftPart = new char[leftSize];
        char[] rightPart = new char[rightSize];

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