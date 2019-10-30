import java.util.Map;

public class Alex_11_ContainerWithMostWater {
    /*
    2019.10.19
    first try

    Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

    Note: You may not slant the container and n is at least 2.
    */

    public int maxArea1(int[] height) {
        int most_water = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int current_height = Math.min(height[i], height[j]);
                int current_area = current_height * (j - i);
                if (current_area > most_water) {
                    most_water = current_area;
                }
            }
        }
        return most_water;
    }
}
