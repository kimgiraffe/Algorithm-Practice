import java.util.*;

class Solution {
    static List<String> list;
    public String[] solution(String[] strArr) {
        list = new ArrayList<>();
        
        for (int i = 0; i < strArr.length; i++) {
            if (!strArr[i].contains("ad")) {
                list.add(strArr[i]);
            }
        }
        
        
        return list.toArray(new String[0]);
    }
}