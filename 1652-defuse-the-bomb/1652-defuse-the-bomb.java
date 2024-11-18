class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] decrypted = new int[n];

        int l = 0, r = 0;
        if (k == 0) {
            return decrypted;
        }

        if (k > 0) {
            l = 1;
            r = k;
        } else {
            l = n - Math.abs(k);
            r = n - 1;
        }

        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += code[i];
        }

        for (int i = 0; i < n; i++) {
            decrypted[i] = sum;
            sum -= code[(l) % n];
            sum += code[(r + 1) % n];
            l++;
            r++;
        }

        return decrypted;
    }
}