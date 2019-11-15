/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 梳理：逻辑删除即可；剩余的元素顺序可变；
 *
 * 举例:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 */
public class Solution_27_1 {
    //时间O(n)
    //空间O(1)
    //双指针
    public int removeElement(int[] nums, int val) {
        // 下标在[0...availableLength)区间的元素是保留下来的元素
        int availableLength = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] != val) {
                //指向同一个位置，不需要交换元素
                if(i != availableLength) {
                    nums[availableLength] = nums[i];
                }
                availableLength++;
            }
        }
        return availableLength;
    }
}
