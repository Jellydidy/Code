/**
 * @author Jelly
 * @version 1.0.0
 * @ClassName L003_RepeatNum.java
 * @Description TODO
 * @createTime 2020年04月21日 23:18:00
 */
public class L003_RepeatNum {
    class Solution {
        public int findRepeatNumber(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                while (i != nums[i]) {
                    if (nums[i] == nums[nums[i]]) {
                        return nums[i];
                    }
                    swap(nums, i, nums[i]);
                }
            }
            return -1;
        }

        private void swap (int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }

    class Solution2 {
        public int findRepeatNumber(int[] nums) {
            int temp;
            for(int i=0;i<nums.length;i++){
                while (nums[i]!=i){
                    if(nums[i]==nums[nums[i]]){
                        return nums[i];
                    }
                    temp=nums[i];
                    nums[i]=nums[temp];
                    nums[temp]=temp;
                }
            }
            return -1;
        }
    }
}
