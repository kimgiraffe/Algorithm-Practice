import java.util.List;
import java.util.ArrayList;

class Solution {
    static List<Integer> list;
    public int[] solution(String[] intStrs, int k, int s, int l) {
        list = new ArrayList<>();
        
        for (String str : intStrs) {
            int num = Integer.parseInt(str.substring(s, s + l));
            if (num > k) {
                list.add(num);
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}