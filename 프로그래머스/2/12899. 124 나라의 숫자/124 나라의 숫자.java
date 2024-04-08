import java.util.*;
class Solution {
    static final String[] nums = {"4", "1", "2"};
    static StringBuilder sb;
    public String solution(int n) {
        sb = new StringBuilder();
        String answer = "";
        while(n > 0) {
            int index = n % 3;
            n /= 3;
            if(index == 0) {
                n--;
            }
            sb.append(nums[index]);
        }
        
        return sb.reverse().toString();
    }
}