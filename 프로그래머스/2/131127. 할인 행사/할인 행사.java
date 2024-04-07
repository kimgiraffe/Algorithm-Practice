import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    // static boolean check(String[] want) {
    //     for(int idx = 0; idx < want.length; idx++) {
    //         if(map.get(want[idx]) == 0) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        boolean register = false;
        
        for(int idx = 0; idx < want.length; idx++) {
            map.put(want[idx], number[idx]);
        }
        
        int day = 0;
        while(day + 10 <= discount.length) {
            Map<String, Integer> disc = new HashMap<>();
            for(int idx = day; idx < day + 10; idx++) {
                disc.put(discount[idx], disc.getOrDefault(discount[idx], 0) + 1);
            }
            
            for(int idx = 0; idx < want.length; idx++) {
                if(disc.get(want[idx]) == null) {
                    register = false;
                    break;
                } else if(map.get(want[idx]) <= disc.get(want[idx])) {
                    register = true;
                } else {
                    register = false;
                    break;
                }
            }
            if(register) {
                answer++;
            }
            
            register = false;
            day++;
        }
        
        return answer;
    }
}

