/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成
 *
 * 例子：
 * 给定 nums = [1,1,1,2,2,3],函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 *
 * 梳理：
 *
 */
public class Solution_80_2 {

    //时间 O(n)
    //空间 O(1)
    //双指针 ----充分利用【每个元素最多出现两次】条件
    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        if(size <= 2) {
            return size;
        }

        //每个元素最多出现两次[0...availableMaxIdx]区间的元素为满足条件的元素
        int availableMaxIdx = 1;
        //O(n)
        for(int i=2; i<size; i++) {
            int current = nums[i];
            //nums[availableMaxIdx-1]、nums[availableMaxIdx]、nums[i]三个元素比较，
            //如果三者都不相等，那么，nums[i]是满足条件的元素
            //O(1) 此处比较时间复杂度为O(1),比上一个实现的优化之处在于,不是全部元素参与比较，而是与最近的两个元素比较即可
            if( !(current == nums[availableMaxIdx-1] && current == nums[availableMaxIdx]) ) {
                //current覆盖nums[availableMaxIdx+1]
                nums[++availableMaxIdx] = current;
            }
        }
        return availableMaxIdx + 1;
    }

}
