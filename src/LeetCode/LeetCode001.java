package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    public static int[] twoSumHash(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int need = target - nums[i];
            if(map.containsKey(need)){
                return new int[]{map.get(need),i};
            }
            map.put(nums[i],i);
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
        System.out.println(" ");
        int[] a = twoSum(new int[]{2, 7, 11, 15}, 9);
        int[] b = twoSumHash(new int[]{2, 7, 11, 15}, 9);
        System.out.println("暴力版: " + Arrays.toString(a));
        System.out.println("哈希版: " + Arrays.toString(b));
        System.out.println("结果一致吗? " + Arrays.equals(a, b));
    }
}
