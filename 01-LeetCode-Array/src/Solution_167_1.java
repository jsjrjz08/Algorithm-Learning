import java.util.ArrayList;

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
public class Solution_167_1 {
    //时间 O(nlogn)
    //空间 O(1)
    //充分利用有序性+二分搜索是在有序序列上进行的
    public int[] twoSum(int[] numbers, int target) {
        for(int i=0; i<numbers.length; i++) {
            int newTargetIndex = binarySearch(numbers,i+1,numbers.length-1,target - numbers[i]);
            if(newTargetIndex != -1) {
                return new int[]{i+1,newTargetIndex+1};
            }
        }
        return new int[]{-1,-1};
    }

    //时间 O(logn)
    private int binarySearch(int[] arr, int start, int end, int target) {
        //在[l...r]区间查找target
        int l = start;
        int r = end;

        while(l <= r) {
            int mid = l + (r-l) / 2;
            if(target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                r = mid - 1;
            } else {//target > arr[mid]
                l = mid + 1;
            }
        }
        return -1;
    }
}
