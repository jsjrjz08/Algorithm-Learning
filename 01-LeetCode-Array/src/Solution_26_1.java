/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 举例：
 * 给定数组 nums = [1,1,2],函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 梳理：充分利用数组有序性这一条件
 */
public class Solution_26_1 {

    //时间O(n)
    //空间O(1)
    //双指针
    public int removeDuplicates(int[] nums) {
        //由于结尾有 +1 操作，所以，此处要判断空数据的情况
        if(nums.length == 0) {
            return 0;
        }
        // 下标在[0...availableMaxIdx]区间的元素是保留下来的元素
        int availableMaxIdx = 0;

        for(int i=1;i<nums.length; i ++) {
            int tmp = nums[availableMaxIdx];
            if(nums[i] != tmp) {
                availableMaxIdx ++;
                if(i != availableMaxIdx) {
                    nums[availableMaxIdx] = nums[i];
                    nums[i] = tmp;
                }
            }
        }

        return availableMaxIdx + 1;
    }

}
