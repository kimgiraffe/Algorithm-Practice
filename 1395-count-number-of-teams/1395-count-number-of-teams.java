class Solution {
    public int numTeams(int[] rating) {
        int length = rating.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if ((rating[i] > rating[j] && rating[j] > rating[k])
                            || (rating[i] < rating[j] && rating[j] < rating[k])) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}