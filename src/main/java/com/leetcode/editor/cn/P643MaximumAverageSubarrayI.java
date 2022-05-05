package com.leetcode.editor.cn;
//给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。 
//
// 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。 
//
// 任何误差小于 10⁻⁵ 的答案都将被视为正确答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,12,-5,-6,50,3], k = 4
//输出：12.75
//解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
// 
//
// 示例 2： 
//
// 
//输入：nums = [5], k = 1
//输出：5.00000
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= k <= n <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 滑动窗口 👍 240 👎 0

public class P643MaximumAverageSubarrayI {
    public static void main(String[] args) {
        System.out.println(Math.max(0, Double.MIN_VALUE));
        Solution solution = new P643MaximumAverageSubarrayI().new Solution();
        int[] a = {7, 4, 5, 8, 8, 3, 9, 8, 7, 6};
        System.out.println(solution.findMaxAverage(a, 7));
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMaxAverage(int[] nums, int k) {
            double res = -Double.MAX_VALUE;
            if (nums.length < k || k < 1) {
                return res;
            }
            double sum = 0;
            for (int i = 0; i < k; i++) {
                sum += nums[i];
            }
            res = sum;
            for (int i = k, j = 1; i < nums.length; i++, j++) {
                // 注意这里sum要更新的，因为下一次要用，不能写为： res = Math.max(sum, sum - nums[j - 1] + nums[i])
                sum = sum - nums[j - 1] + nums[i];
                res = Math.max(res,sum);
            }
            return res / k;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}