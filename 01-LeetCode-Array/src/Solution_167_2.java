/**
 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

 说明:
 返回的下标值（index1 和 index2）不是从零开始的。
 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。

 示例:
     输入: numbers = [2, 7, 11, 15], target = 9
     输出: [1,2]
     解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class Solution_167_2 {
    //时间 O(n)
    //空间 O(1)
    //充分利用有序性+对撞指针
    public int[] twoSum(int[] numbers, int target) {

        //在[l...r]闭区间内查找
        int l = 0;
        int r = numbers.length - 1;

        while(l < r) {//l==r违反规则：不可以重复使用相同的元素
            int sum = numbers[l] + numbers[r];
            if(sum == target) {
                return new int[]{l+1, r+1};
            } else if(sum < target) {
                l++;
            } else {//sum > target
                r--;
            }
        }
        return new int[]{-1,-1};
    }

}
