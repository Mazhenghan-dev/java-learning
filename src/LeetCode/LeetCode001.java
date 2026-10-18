package LeetCode;

import java.util.Arrays;

public class LeetCode001 {
    public static int[] twoSum(int[] nums,int target){
        int n = nums.length;
        for (int i = 0;i < n;++i){
            for (int j = i+1;j < n;++j){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }
    public static void main(String[] args) {
        int[] r1 = twoSum(new int[]{2, 7, 11, 15}, 9);   // 期望 [0, 1]
        int[] r2 = twoSum(new int[]{3, 2, 4}, 6);        // 期望 [1, 2]
        int[] r3 = twoSum(new int[]{3, 3}, 6);           // 期望 [0, 1]

        System.out.println(Arrays.toString(r1));         // 打印数组要用 Arrays.toString
        System.out.println(Arrays.toString(r2));
        System.out.println(Arrays.toString(r3));
    }
}
