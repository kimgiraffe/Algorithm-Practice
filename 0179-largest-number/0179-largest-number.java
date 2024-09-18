class Solution {
    public String largestNumber(int[] nums) {
        String[] numbers = new String[nums.length];

        for (int idx = 0; idx < nums.length; idx++) {
            numbers[idx] = String.valueOf(nums[idx]);
        }

        Arrays.sort(numbers, (a, b) -> (b + a).compareTo(a + b));
        if (numbers[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int idx = 0; idx < numbers.length; idx++) {
            sb.append(numbers[idx]);
        }

        return sb.toString();
    }
}