class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;

        for(int idx = 0; idx < nums.length; idx++) {
            int prevSum = sum;
            sum = (sum + nums[idx]) % k;
            if(set.contains(sum)) {
                return true;
            }
            set.add(prevSum);
        }

        return false;
    }
}