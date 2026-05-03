package shipping;

public class ShippingCapacityCalculator {

    public static int calculateMinimumCapacity(int[] weights, int days) {
        int left = findMax(weights);
        int right = findSum(weights);

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canShip(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean canShip(int[] weights, int days, int capacity) {
        int usedDays = 1;
        int currentLoad = 0;

        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                usedDays++;
                currentLoad = 0;
            }
            currentLoad += weight;
        }
        return usedDays <= days;
    }

    private static int findMax(int[] weights) {
        int max = weights[0];
        for (int w : weights) if (w > max) max = w;
        return max;
    }

    private static int findSum(int[] weights) {
        int sum = 0;
        for (int w : weights) sum += w;
        return sum;
    }
}