class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        
        char[] chars = Integer.toString(num).toCharArray();
        
        for (int idx = 0; idx < chars.length; idx++) {
            if(chars[idx] - '0' == k) {
                return idx + 1;
            }
        }
        
        return -1;
    }
}