class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c - 'a' + 1);
        }

        while (k > 0) {
            int tmp = 0;
            for (char c : sb.toString().toCharArray()) {
                tmp += c - '0';
            }
            sb = new StringBuilder(String.valueOf(tmp));
            k--;
        }

        return Integer.parseInt(sb.toString());
    }
}