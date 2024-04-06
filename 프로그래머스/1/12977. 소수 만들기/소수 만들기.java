class Solution {
    static int answer;
    static int[] selected;
    static boolean isPrime(int num) {
        for(int idx = 2; idx <= Math.sqrt(num); idx++) {
            if(num % idx == 0) {
                return false;
            }
        }
        return true;
    }
    
    static void combination(int selectIdx, int curIdx, int[] nums) {
        if(selectIdx == 3) {
            int sum = 0;
            for(int idx = 0; idx < 3; idx++) {
                sum += selected[idx];
            }
            if(isPrime(sum)) {
                answer++;
            }
            return;
        }
        
        if(curIdx == nums.length) {
            return;
        }
        
        selected[selectIdx] = nums[curIdx];
        combination(selectIdx + 1, curIdx + 1, nums);
        
        combination(selectIdx, curIdx + 1, nums);
    }
    
    public int solution(int[] nums) {
        selected = new int[3];

        combination(0, 0, nums);
        
        return answer;
    }
}