import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class Solution_1_2 {
    /**
     * 给定 nums = [2, 7, 11, 15], target = 9
         因为 nums[0] + nums[1] = 2 + 7 = 9
         所以返回 [0, 1]

     * @param nums
     * @param target
     * @return
     */
    //时间复杂度 O(n)
    //空间复杂度 O(1)
    //使用一次哈希 hash查找时间复杂度为O(1)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>(nums.length);

        //O(n)
        for (int i = 0; i < nums.length; i++) {
            int completeTarget = target - nums[i];
            //O(1)
            if(map.containsKey(completeTarget)) {
                return new int[] {i,map.get(completeTarget)};
            }
            //key:数据，value:索引
            map.put(nums[i],i);
        }

        throw new IllegalArgumentException("There is no two sum solution.");
    }
}
