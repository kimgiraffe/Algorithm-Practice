import java.util.*;

class Solution {
    static List<String> list1;
    static List<String> list2;
    
    static List<String> getList(String str) {
        List<String> result = new ArrayList<>();
        
        for(int idx = 0; idx < str.length() - 1; idx++) {
            String s = "" + str.charAt(idx) + str.charAt(idx + 1);
            if(s.matches("^[a-zA-Z]*$")) {
                result.add(s.toLowerCase());
            }
        }
        
        return result;
    }
    
    public int solution(String str1, String str2) {
        list1 = getList(str1);
        list2 = getList(str2);
        
        List<String> A = new ArrayList<>();
        List<String> B = new ArrayList<>();
        
        for(String s1 : list1) {
            if(list2.contains(s1)) {
                A.add(s1);
                list2.remove(s1);
            }
            B.add(s1);
        }
        
        for(String s2 : list2) {
            B.add(s2);
        }
        
        if(B.size() == 0) {
            return 65536;
        } else {
            return A.size() * 65536 / B.size();
        }
        
    }
}
