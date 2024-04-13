class Solution {
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    public String solution(String s) {
        String answer = "";
        String[] nums = s.split(" ");
        for(int idx = 0; idx < nums.length; idx++) {
            int num = Integer.parseInt(nums[idx]);
            if(num > max) {
                max = num;
            }
            if(num < min) {
                min = num;
            }
        }
        answer = min + " " + max;
        return answer;
    }
}