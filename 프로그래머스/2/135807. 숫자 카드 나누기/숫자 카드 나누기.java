class Solution {
    public boolean divide(int[] arr, int num) {
        for(int n : arr) {
            if(n % num != 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean notDivide(int[] arr, int num) {
        for(int n : arr) {
            if(n % num == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int num = Math.max(arrayA[0], arrayB[0]);
        for(int idx = 2; idx <= num; idx++) {
            if((divide(arrayA, idx) && notDivide(arrayB, idx)) || (divide(arrayB, idx) && notDivide(arrayA, idx))) {
                answer = idx;
            }
        }
        
        return answer;
    }
}