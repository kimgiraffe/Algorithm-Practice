class Solution {
    public int solution(int[] num_list) {
        int oddSum = 0, evenSum = 0;
        
        for (int idx = 0; idx < num_list.length; idx++) {
            if (idx % 2 == 0) {
                oddSum += num_list[idx];
            } else {
                evenSum += num_list[idx];
            }
        }
        
        return oddSum >= evenSum ? oddSum : evenSum;
    }
}