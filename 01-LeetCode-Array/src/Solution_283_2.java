/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class Solution_283_2 {
    //时间 O(n)
    //空间 O(1)
    //双指针：原地操作，依照次序交换出非零元素
    public void moveZeroes(int[] nums) {
        int k = 0;//[0..k)依次为非零元素--[0,k-1] 是非零元素
        //遍历数组
        for(int cur=0; cur<nums.length; cur++) {
            int tmp = nums[cur];
            //找到非零元素
            if(tmp != 0) {
                //当前非零元素不是已经处理过的元素 --针对初始情况(k==0 cur==0)做的优化,也是对nums全部元素都不为0的情况的优化
                if(cur != k) {
                    //交换位置
                    nums[cur] = nums[k];
                    nums[k] = tmp;
                }
                //k后移
                k++;
            }
        }
    }
}
