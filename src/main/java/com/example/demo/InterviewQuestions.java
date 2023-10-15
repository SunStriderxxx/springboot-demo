package com.example.demo;

import java.util.*;

/**
 * @author Fcb
 * @date 2021/10/10
 * @description
 */
public class InterviewQuestions {

    public static void AlternateOutput() {

    }

    public static void main(String[] args) {
        InterviewQuestions questions = new InterviewQuestions();
        int[][] matrix = new int[][]{{1,6},{3,7},{9,12},{4,13}};
        int[] persons = {2,3,7,11};
//        questions.fullBloomFlowers(matrix, persons);
//        questions.getMaxLen(new int[]{1,-2,-3,4});
//        questions.lengthOfLongestSubstring("abba");
//        List<String> wordDict = new ArrayList<>();
//        wordDict.add("leet");
//        wordDict.add("code");
//        questions.wordBreak("leetcode", wordDict);
//        questions.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
//        questions.nthUglyNumber(10);
//        questions.minFallingPathSum(new int[][]{{17,82},{1,-44}});
//        Queue<Integer> que = new LinkedList<>();
//        questions.longestPalindrome("babad");
//        String[] split = "".split(";");
//        String s1 = split[0];
//        System.out.println(s1);

        questions.search(new int[]{4,5,6,7,0,1,2}, 3);

    }

    private class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(node -> node.val));
        for (ListNode node : lists) {
            queue.offer(node);
        }
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            cur.next = poll;
            cur = cur.next;
            if (poll.next != null) {
                queue.offer(poll.next);
            }
        }
        return dummy.next;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != match(c)) {
                    return  false;
                }
            }
        }
        return stack.isEmpty();
    }

    private char match(char c) {
        if (c == ']') {
            return '[';
        }
        if (c == '}') {
            return '{';
        }
        if (c == ')') {
            return '(';
        }
        return '(';
    }


    public int search(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 假如左边有序
            if (nums[mid] == target) {
                return mid;
            } else if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        return -1;
    }

     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        que.offer(root);
        while (que.size() != 0) {
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < que.size(); i++) {
                TreeNode node = que.poll();
                cur.add(node.val);
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            result.add(cur);
        }
        return result;
    }

    // 中心扩散
    public String longestPalindrome(String s) {
        int start = 0, len = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            int len1 = longestPalindrome(s, i, i);
            int len2 = longestPalindrome(s, i, i + 1);
            int max = Math.max(len1, len2);
            if (max > len) {
                start = i - (max - 1) / 2;
                len = max;
            }
        }
        return s.substring(start, start + len);
    }

    private int longestPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            i--;
            j++;
        }
        return j - i - 1;
    }

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] preSum = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                preSum[i + 1][j + 1] = preSum[i][j + 1] + preSum[i + 1][j] - preSum[i][j] + mat[i][j];
            }
        }
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x1 = i - k, x2 = i + k;
                if (x1 < 0) {
                    x1 = 0;
                }
                if (x2 > m - 1) {
                    x2 = m - 1;
                }
                int y1 = j - k, y2 = j + k;
                if (y1 < 0) {
                    y1 = 0;
                }
                if (y2 > m - 1) {
                    y2 = m - 1;
                }
                res[i][j] = preSum[x2 + 1][y2 + 1] - preSum[x1][y2 + 1] - preSum[x2 + 1][y1] + preSum[x1][y1];
            }
        }
        return res;
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix[0].length;
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = matrix[0][i];
        }
        for (int i = 1; i < matrix.length; i++) {
            int[] cur = new int[n];
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    cur[j] = Math.min(pre[j], pre[j + 1]) + matrix[i][j];
                } else if (j == n - 1) {
                    cur[j] = Math.min(pre[j], pre[j - 1]) + matrix[i][j];
                } else {
                    cur[j] = Math.min(Math.min(pre[j], pre[j - 1]), pre[j + 1]) + matrix[i][j];
                }
            }
            pre = cur;
        }
        int min = pre[0];
        for (int i : pre) {
            Math.min(min, i);
        }
        return min;
    }

    public int nthUglyNumber(int n) {
        int p2 = 1, p3 = 1, p5 = 1, res = 1;
        for (int i = 2; i <= n; i++) {
            res = Math.min(Math.min(p2 * 2, p3 * 3), p5 * 5);
            if (res == p2 * 2) {
                p2 = res;
            }
            if (res == p3 * 3) {
                p3 = res;
            }
            if (res == p5 * 5) {
                p5 = res;
            }
        }
        return res;
    }

    public int trap(int[] height) {
        int left = 0, right = height.length - 1, res = 0;
        int leftMax = height[0], rightMax = height[height.length - 1];
        while (left < right) {
            if (height[left] < height[right]) {
                if (leftMax > height[left]) {
                    res +=  leftMax - height[left];
                } else {
                    leftMax = height[right];
                }
                left++;
            } else {
                if (rightMax > height[right]) {
                    res += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }
        return res;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Set<Integer> lengthSet = new HashSet<>();
        for (String word : wordDict) {
            lengthSet.add(word.length());
        }
        boolean[] res = new boolean[wordDict.size() + 1];
        res[0] = true;
        for (int i = 1; i < res.length; i++) {
            for (int j = 0; j < i; j++) {
                if (lengthSet.contains(i - j)) {
                    if (res[j] && wordSet.contains(s.substring(j, i))) {
                        res[i] = true;
                        break;
                    }
                }
            }
        }
        return res[res.length - 1];
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, res = 0;
        // 记录当前子串每个字符的索引，如果出现了重复，左下标要跳到索引的最后一处
        Map<Character, Integer> count = new HashMap<>();
        while (right < s.length()) {
            Character c = s.charAt(right);
            while (count.containsKey(c)) {
                // 跳跃滑动
                left = count.get(c) + 1;
                count.remove(c);
            }
            count.put(c, right);
            right++;
            res = Math.max(res, right - left);
        }
        return res;
    }

    public int getMaxLen(int[] nums) {
        int res = 0, p = 0, q = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                p = 0;
                q = 0;
            } else if (nums[i] > 0) {
                p = p + 1;
                q = q == 0 ? 0 : q + 1;
            } else {
                // bug:p q互相依赖了 这里要用旧值计算
//                p = q == 0 ? 0 : q + 1;
//                q = p + 1;
            }
            res = Math.max(res, p);
        }
        return res;
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        // 差分数组
        int maxEnd = 0, minStart = 1000000001;
        for (int i = 0; i < flowers.length; i++) {
            int start = flowers[i][0];
            int end = flowers[i][1];
            maxEnd = Math.max(maxEnd, end);
            minStart = Math.min(minStart, start);
        }
        int[] diff = new int[maxEnd - minStart + 1];
        for (int i = 0; i < flowers.length; i++) {
            int start = flowers[i][0] - minStart;
            int end = flowers[i][1] - minStart;
            diff[start] += 1;
            if (end < diff.length - 1) {
                diff[end + 1] -= 1;
            }
        }
        int[] total = new int[diff.length];
        total[0] = diff[0];
        for(int i = 1; i < total.length; i++) {
            total[i] = total[i - 1] + diff[i];
        }

        int[] res = new int[persons.length];
        for (int i = 0; i < persons.length; i++) {
            int index = persons[i] - minStart;
            if (index < 0 || index >= res.length) {
                continue;
            }
            res[i] = total[index];
        }
        return res;
    }
}
