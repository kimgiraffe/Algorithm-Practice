import java.util.*;

class Solution {
    public int solution(String s) {
        List<String> list = new ArrayList<>();
        int count = 0;
        int start = 0;
        int cnt1 = 1, cnt2 = 0;
        
        for(int idx = 1; idx < s.length(); idx++) {
            if(s.charAt(idx) == s.charAt(start)) {
                cnt1++;
            } else {
                cnt2++;
            }
            if(cnt1 == cnt2) {
                count++;
                if(count == 1) {
                    list.add(s.substring(start, idx + 1));
                    start = idx + 1;
                    count = 0;
                    cnt1 = 0;
                    cnt2 = 0;
                }
            }
        }
        
        if(start < s.length() && cnt1 != cnt2) {
            list.add(s.substring(start));
        }
        
        return list.size();
    }
}