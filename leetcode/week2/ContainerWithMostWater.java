package week2;

import static java.lang.Math.abs;

import java.util.Arrays;

public class ContainerWithMostWater {
    public static void main(String[] args) {
    }
    public static int maxArea(int[] height) {
        final int len = height.length;
        final int[] maxHeight = new int[len];

        for (int i = 0; i < len; i++) {
            final int pre = height[i];
            for (int j = 0; j < len; j++) {
                final int cur = height[j];
                final int sum = (cur > pre ? pre : cur) * abs(j - i);

                if (sum > maxHeight[i]) {
                    maxHeight[i] = sum;
                }
            }
        }

        return Arrays.stream(maxHeight).max().getAsInt();
    }
}
