import java.util.*;
    
class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int coupon = chicken;
        
        while (true) {
            answer += coupon / 10;
            coupon = coupon / 10 + coupon % 10;
            if(coupon == 0 || coupon / 10 == 0) break;
        }
        
        return answer;
    }
}