class Solution {
    static int[] left;
    static int[] right;
    static int leftMin;
    static int rightMin;
    
    public int solution(int[] a) {
        if(a.length == 1) {
            return 1;
        }
        
        int answer = 2;
        left = new int[a.length];
        right = new int[a.length];
        leftMin = a[0];
        rightMin = a[a.length - 1];
        
        for(int idx = 1; idx < a.length - 1; idx++) {
            if(leftMin > a[idx]) leftMin = a[idx];
            left[idx] = leftMin;
        }
        
        for(int idx = a.length - 2; idx > 0; idx--) {
            if(rightMin > a[idx]) rightMin = a[idx];
            right[idx] = rightMin;
        }
        
        for(int idx = 1; idx < a.length - 1; idx++) {
            if(a[idx] > left[idx] && a[idx] > right[idx]) continue;
            answer++;
        }
        
        return answer;
    }
}