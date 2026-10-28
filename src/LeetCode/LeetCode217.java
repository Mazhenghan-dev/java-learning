package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode217 {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<nums.length;i++){
            int n = nums[i];
            if(set.contains(n)){
                return true;
            }
            set.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));            // true
        System.out.println(containsDuplicate(new int[]{1,2,3,4}));            // false
        System.out.println(containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2})); // true
    }
}
