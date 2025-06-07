import java.util.*;

class Solution {
    static List<Integer> list;
    
    public int[] solution(int n, int[] numlist) {
        int count = 0;
        list = new ArrayList<>();
        for (int idx = 0; idx < numlist.length; idx++) {
            if(numlist[idx] % n == 0) {
                count++;
                list.add(numlist[idx]);
            }
        }
        
        int[] answer = new int[count];
        for(int idx = 0; idx < count; idx++) {
            answer[idx] = list.get(idx);
        }
        
        return answer;
    }
}