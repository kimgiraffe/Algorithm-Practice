class Solution {
    public int minimumPushes(String word) {
        int min = 0;
        int[] freq = new int[26];

        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        Arrays.sort(freq);

        for (int idx = 0; idx < 26; idx++) {
            min += (idx / 8 + 1) * freq[26 - idx - 1];
        }

        return min;
    }
}