class Solution {
    static final String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    
    public int solution(String s) {
        for(int idx = 0; idx < num.length; idx++) {
            if(s.contains(num[idx])) {
                s = s.replace(num[idx], Integer.toString(idx));
            }
        }
        
        return Integer.parseInt(s);
    }
}