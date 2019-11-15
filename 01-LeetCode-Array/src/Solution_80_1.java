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
public class Solution_80_1 {

    //时间 O(n^2)
    //空间 O(1)
    //双指针 ----没有充分利用【每个元素最多出现两次】条件
    public int removeDuplicates(int[] nums) {
        //由于结尾有 +1 操作，所以，此处要判断空数据的情况
        if(nums.length == 0) {
            return 0;
        }
        // 下标在[0...availableMaxIdx]区间的元素是保留下来的元素
        int availableMaxIdx = 0;

        //O(n)
        for(int i=1;i<nums.length; i ++) {
            int tmp = nums[availableMaxIdx];
            //如果当前元素在之前的序列中出现的次数不足2次，则加入  --O(n)
            if(lessTwice(nums,0,availableMaxIdx,nums[i])) {
                availableMaxIdx ++;
                if(i != availableMaxIdx) {
                    nums[availableMaxIdx] = nums[i];
                    nums[i] = tmp;
                }
            }
        }

        return availableMaxIdx + 1;//
    }

    //判断在nums数组中的[start,end]区间内，value出现次数是否不足2次
    private boolean lessTwice(int[] nums,int start,int end,int value) {
        int time = 0;
        for(int i=start;i<=end;i++) {
            if(nums[i] == value) {
                time ++;
            }
        }
        return time < 2;
    }
}
