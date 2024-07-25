class Solution {
    static int[] frequency;
    
    public int solution(int[] a) {
        int answer = -1;
        
        frequency = new int[a.length];
        
        for(int num : a) {
            frequency[num]++;
        }
        
        for(int i = 0; i < a.length; i++) {
            if(frequency[i] <= answer) {
                continue;
            }
            
            int result = 0;
            
            for(int j = 0; j < a.length - 1; j++) {
                if((a[j] == i || a[j + 1] == i) && a[j] != a[j + 1]) {
                    result++;
                    j++;
                }
            }
            
            answer = Math.max(answer, result);
        }
        
        return answer * 2;
    }
}