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
    int answer = 0;
    final int MAX_DISTANCE = 10;
    public int[] postOrder(TreeNode node, int distance) {
        if (node == null) {
            return new int[MAX_DISTANCE + 1]; // 빈 배열 반환
        }

        if (node.left == null && node.right == null) { // 리프 노드인 경우...
            int[] result = new int[MAX_DISTANCE + 1];
            result[1] = 1; // 부모 노드로부터의 거리는 1
            return result;
        }

        int[] leftDistance = postOrder(node.left, distance);
        int[] rightDistance = postOrder(node.right, distance);

        for (int i = 1; i <= distance; i++) {
            for (int j = 1; j <= distance - i; j++) {
                answer += leftDistance[i] * rightDistance[j];
            }
        }

        int[] result = new int[MAX_DISTANCE + 1];
        // left와 right에 대해 합치기
        for (int i = 1; i < MAX_DISTANCE; i++) {
            result[i + 1] = leftDistance[i] + rightDistance[i];
        }

        return result;
    }

    public int countPairs(TreeNode root, int distance) {
        postOrder(root, distance);

        return answer;
    }
}