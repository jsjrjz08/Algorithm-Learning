
/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 梳理：
 *
 *
 */
public class Solution_215_2 {

    //时间 O(n)
    //空间 O(1)
    //根据快速排序思想，找到元素在最终排序后的位置
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if(len == 0) {
            throw new IllegalArgumentException("Array has no elemnts.");
        }
        int left = 0;
        int right = len - 1;
        int target = len - k;

        while(true) {
            int index = partition(nums,left,right);
            if(index < target) {
                left = index + 1;
            } else if(index > target) {
                right =index - 1;
            } else {
                return nums[index];
            }
        }
    }

    //返回nums[left]排序后的索引
    //nums(left...k] < pivot //索引k指向最后一个小于pivot的元素
    //nums(k...right] >=pivot
    private int partition(int[] nums,int left,int right) {
        int pivot = nums[left];
        int k = left;
        for(int i=left+1; i<=right; i++) {
            if(nums[i] < pivot) {
                k++;
                //交换元素位置 i<->k
                swap(nums,i,k);
            }
        }
        //将pivot放到排序后的位置k
        swap(nums,left,k);
        return k;
    }

    private void swap(int[] nums,int i,int j) {
        if(i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
