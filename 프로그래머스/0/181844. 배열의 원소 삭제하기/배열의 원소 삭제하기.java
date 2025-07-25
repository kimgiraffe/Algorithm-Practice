import java.util.*;

class Solution {
    static List<Integer> list;
    public int[] solution(int[] arr, int[] delete_list) {
        list = new ArrayList<>();
        
        for (int idx = 0; idx < arr.length; idx++) {
            list.add(arr[idx]);
        }
        
        for (int idx = 0; idx < delete_list.length; idx++) {
            int p = list.indexOf(delete_list[idx]);
            if(p != -1) {
                list.remove(list.get(p));
            }
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}