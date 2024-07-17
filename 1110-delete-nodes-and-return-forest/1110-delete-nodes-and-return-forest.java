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
    List<TreeNode> answer;
    boolean[] delete;

    public TreeNode DFS(TreeNode root, boolean flag) {
        if (root == null) {
            return root;
        }
        root.left = DFS(root.left, delete[root.val]);
        root.right = DFS(root.right, delete[root.val]);
        if (!delete[root.val] && flag) {
            answer.add(root);
        }

        return delete[root.val] ? null : root;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        answer = new ArrayList<>();
        delete = new boolean[1001];

        for (int i : to_delete) {
            delete[i] = true;
        }

        DFS(root, true);

        return answer;
    }
}