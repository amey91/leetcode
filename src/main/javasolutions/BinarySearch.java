package javasolutions;

public class BinarySearch {

    // https://leetcode.com/problems/binary-search/
//  704. Binary Search
    class Solution {
        public int search(int[] nums, int target) {
            if (nums == null) {
                return -1;
            }

            int l = 0; int r = nums.length-1;
            int p;

            // since we are not guaranteed for the target to be present, we need to let the pointers cross each other to know when to stop
            // This can be done by always setting left and right to +/-1 of middle so that pointers cross. If we set the pointers to
            // exactly middle then the pointers we never cross and loop to never end.
            while (l <= r) {
                p = (l+r)/2;
                if (nums[p] == target) {
                    return p;
                }
                if (nums[p] < target) {
                    l = p+1;
                } else {
                    r = p-1;
                }
            }
            return -1;
        }
    }
}
