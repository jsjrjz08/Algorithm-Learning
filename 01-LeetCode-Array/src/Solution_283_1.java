/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class Solution_283_1 {
    //时间O(n)
    //空间O(n)
    //暴力解法：借助另外一个数组，依照次序筛选出非零元素，剩余位置补充0
    public void moveZeroes(int[] nums) {
        int size = nums.length;
        int[] nonZeroElements = new int[size];
        int k = 0;
        for(int i=0;i<size;i++) {
            if(nums[i] != 0) {
                nonZeroElements[k] = nums[i];
                k ++;
            }
        }

        //覆盖原数组nums
        for(int j=0;j<size;j++) {
            if(j<=k-1) {
                nums[j] = nonZeroElements[j];
            } else {
                nums[j] = 0;
            }
        }

    }
}
