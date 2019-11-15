/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

 说明：你不能倾斜容器，且 n 的值至少为 2。

 示例:
 输入: [1,8,6,2,5,4,8,3,7]
 输出: 49

 */
public class Solution_11_1 {
    //时间 O(n^2)
    //空间 O(1)
    //暴力解法
    public int maxArea(int[] height) {
        int maxArea = -1;
        int len = height.length;
        for(int i=0; i<len-1; i++) {
            for(int j=i+1; j<len; j++) {
                maxArea = Math.max(maxArea, Math.abs(i-j)*Math.min(height[i], height[j]));
            }
        }
        return maxArea;
    }
}
