/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 举例:
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */
public class Solution_75_1 {

    //时间 O(n)
    //空间 O(1)
    //暴力解法：两次遍历,由于颜色有限(颜色数量比较少)，可以使用计数排序
    public void sortColors(int[] nums) {
        int size = nums.length;
        //记录三种颜色的数量
        int[] colors = new int[3];

        for(int i=0;i<size;i++) {
            int val = nums[i];
            //val即将作为colors的下标使用，要注意数组越界问题!!
            if(val >=0 && val <=2) {
                colors[val]++;
            }
        }

        //覆盖原数组nums,颜色要排序
        for(int j=0;j<size;j++) {
            if(j<colors[0]) {
                nums[j] = 0;
            } else if(j<colors[0]+colors[1]) {
                nums[j] = 1;
            } else if(j<colors[0]+colors[1]+colors[2]) {
                nums[j] = 2;
            }
        }
    }
}
