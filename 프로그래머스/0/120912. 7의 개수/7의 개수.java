class Solution {
    
    public int count(int num) {
        int result = 0;
        
        while (num > 0) {
            int d = num % 10;
            if(d == 7) {
                result++;
            }
            num /= 10;
        }
        
        return result;
    }
    
    public int solution(int[] array) {
        int answer = 0;
        
        for (int i = 0; i < array.length; i++) {
            answer += count(array[i]);
        }
        
        return answer;
    }
}