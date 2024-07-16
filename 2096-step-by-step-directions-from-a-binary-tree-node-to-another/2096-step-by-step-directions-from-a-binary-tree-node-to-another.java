/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    boolean find(TreeNode node, int value, StringBuilder sb) {
        if (node.val == value) {
            return true;
        }

        if (node.left != null && find(node.left, value, sb)) {
            sb.append("L");
        } else if (node.right != null && find(node.right, value, sb)) {
            sb.append("R");
        }

        return sb.length() > 0;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder s = new StringBuilder();
        StringBuilder d = new StringBuilder();
        find(root, startValue, s); // 시작 노드에서부터 찾기
        find(root, destValue, d); // 도착 노드에서부터 찾기

        int idx = 0, maxIdx = Math.min(s.length(), d.length());

        // 공통 부분 찾기
        while (idx < maxIdx && s.charAt(s.length() - idx - 1) == d.charAt(d.length() - idx - 1)) {
            idx++;
        }

        return "U".repeat(s.length() - idx) + d.reverse().toString().substring(idx);
    }
}