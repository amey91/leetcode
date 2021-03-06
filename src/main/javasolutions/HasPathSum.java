package javasolutions;

import javasolutions.commons.TreeNode;

public class HasPathSum {

    // 112. Path Sum
// https://leetcode.com/problems/path-sum/

    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null) {
                return sum == root.val;
            }

            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}
