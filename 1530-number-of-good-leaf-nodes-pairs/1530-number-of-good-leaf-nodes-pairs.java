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
    int answer;

    List<Integer> dfs(TreeNode root, int distance) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        if (root.left == null && root.right == null) { // leaf node
            List<Integer> subList = new ArrayList<Integer>();
            subList.add(1);
            return subList;
        }

        // 부모 노드로부터 거리 구하기
        List<Integer> list1 = dfs(root.left, distance); // 왼쪽 subtree 순회
        List<Integer> list2 = dfs(root.right, distance); // 오른쪽 subtree 순회

        // 부모 노드로부터의 거리 합이 두 leaf 노드 사이의 최단거리
        for (int d1 : list1) {
            for (int d2 : list2) {
                if (d1 + d2 <= distance) { // 조건을 만족하는 경우...
                    answer++;
                }
            }
        }

        // 다음 부모 노드를 위해 거리 1 증가
        List<Integer> list = new ArrayList<>();

        for (int d : list1) {
            list.add(d + 1);
        }

        for (int d : list2) {
            list.add(d + 1);
        }

        return list;
    }

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);

        return answer;
    }
}