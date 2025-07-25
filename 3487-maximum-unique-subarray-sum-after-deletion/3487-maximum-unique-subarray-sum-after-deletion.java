class Solution {
    static Set<Integer> set;
    public int maxSum(int[] nums) {
        set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }

        if (set.isEmpty()) {
            return Arrays.stream(nums).max().getAsInt();
        }

        return set.stream().mapToInt(Integer::intValue).sum();
    }
}