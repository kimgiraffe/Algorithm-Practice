class Solution {
    public boolean checkIfExist(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                if (arr[i] == 2 * arr[j]) {
                    return true;
                }
            }
        }

        return false;
    }
}