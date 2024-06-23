class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int answer = 0;
        int left = 0;

        LinkedList<Integer> increase = new LinkedList<>();
        LinkedList<Integer> decrease = new LinkedList<>();

        for (int idx = 0; idx < nums.length; idx++) {
            while (increase.size() > 0 && nums[idx] < increase.getLast()) {
                increase.removeLast();
            }
            increase.add(nums[idx]);

            while (decrease.size() > 0 && nums[idx] > decrease.getLast()) {
                decrease.removeLast();
            }
            decrease.add(nums[idx]);

            while (decrease.getFirst() - increase.getFirst() > limit) {
                if (nums[left] == decrease.getFirst()) {
                    decrease.removeFirst();
                }
                if (nums[left] == increase.getFirst()) {
                    increase.removeFirst();
                }
                left++;
            }

            answer = Math.max(answer, idx - left + 1);
        }

        return answer;
    }
}