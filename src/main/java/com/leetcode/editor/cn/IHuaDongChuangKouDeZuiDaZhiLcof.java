package com.leetcode.editor.cn;
//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 滑动窗口 单调队列 堆（优先队列） 👍 432 👎 0

import java.util.Deque;
import java.util.LinkedList;

public class IHuaDongChuangKouDeZuiDaZhiLcof {
    public static void main(String[] args) {
        Solution solution = new IHuaDongChuangKouDeZuiDaZhiLcof().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] res = new int[nums.length - k + 1];
            Deque<Integer> queue = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                // 队列不为空，并且队列中元素已经满了，就把队首元素出队。先出再加，相当于腾位置
                if (!queue.isEmpty() && i - queue.peekFirst() == k) {
                    queue.pollFirst();
                }
                // 队列元素：(尾巴）1 2 5（首）从队尾开始也就是1开始
                while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                    queue.pollLast();
                }
                queue.addLast(i);
                if (i >= k - 1) {
                    res[i - k + 1] = nums[queue.peekFirst()];
                }
            }
            return res;
        }
        //leetcode submit region end(Prohibit modification and deletion)
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> que = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!que.isEmpty() && i - que.peekFirst() + 1 > k) {
                que.pollFirst();
            }
            //（尾）1 4, 5（首）
            while (!que.isEmpty() && nums[i] >= nums[que.peekLast()]) {
                que.pollLast();
            }
            que.addFirst(i);
            if (i >= k - 1) {
                res[i - k + 1] = nums[que.peekFirst()];
            }
        }
        return res;
        //leetcode submit region end(Prohibit modification and deletion)
    }




}