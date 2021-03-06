package javasolutions.arrayprocessing;

import java.util.ArrayList;
import java.util.List;

// #448. Find All Numbers Disappeared in an Array
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

public class FindAllNumbersDisappearedInArray {

    class Solution {

        // for constant space solution we mark individual numbers as negative. So if nums[i] is < 0 then i was seen
        public List<Integer> findDisappearedNumbers(int[] nums) {

            List<Integer> missing = new ArrayList<>();

            // for each value, mark its index as seen
            for (int num : nums) {
                // handle negative indexes
                int index = num < 0? -num -1 : num - 1;

                // mark index as seen
                if (nums[index] > 0) {
                    nums[index] = -nums[index];
                }
            }

            // if seen, add to result
            for (int i = 0; i< nums.length; i++) {
                if (nums[i] > 0) {
                    missing.add(i+1);
                }
            }
            return missing;
        }

//     this solution has faster run times but uses extra space
//     public List<Integer> findDisappearedNumbers(int[] nums) {
//         // I can do this since all inputs are in this range
//         boolean[] arr= new boolean[nums.length + 1];

//         List<Integer> missing = new ArrayList<>();
//         for (int num : nums) {
//             arr[num] = true;
//         }
//         for (int i = 1; i< arr.length; i++) {
//             if (!arr[i]) {
//                 missing.add(i);
//             }
//         }
//         return missing;
//     }
    }
}
