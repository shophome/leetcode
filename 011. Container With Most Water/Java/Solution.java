/*
11. 盛最多水的容器
给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。画 n 条垂直线，使得垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

注意：你不能倾斜容器，n 至少是2。
*/
public class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int low = 0;
        int high = height.length - 1;
        while (low < high) {
            int tall = Math.min(height[low], height[high]);
            maxWater = Math.max(maxWater, tall * (high - low));
            while (low < high && height[low] <= tall) {
                low++;
            }
            while (low < high && height[high] <= tall) {
                high--;
            }
        }
        return maxWater;
    }
}