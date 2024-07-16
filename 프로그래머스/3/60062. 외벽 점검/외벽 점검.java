import java.util.*;

class Solution {
    static boolean[] visited;
    static int[] checked;
    static int[] selected;
    static int distLength;
    static int answer = Integer.MAX_VALUE;
    
    static void permutation(int start, int curIdx, int[] dist) {
        if(curIdx == distLength) {
            // for(int idx = 0; idx < distLength; idx++) {
            //     System.out.print(selected[idx]+" ");
            // }
            // System.out.println();
            answer = Math.min(answer, check(start, start + checked.length / 2));
            return;
        }
        
        for(int idx = 0; idx < distLength; idx++) {
            if(visited[idx]) {
                continue;
            }
            visited[idx] = true;
            selected[curIdx] = dist[idx];
            permutation(start, curIdx + 1, dist);
            visited[idx] = false;
        }
    }
    
    static int check(int start, int end) {
        int friend = 1;
        int pos = selected[friend - 1] + checked[start];
        for(int idx = start; idx < end; idx++) {
            if(pos < checked[idx]) {
                friend++;
                if(friend > selected.length) {
                    return Integer.MAX_VALUE;
                }
                pos = selected[friend - 1] + checked[idx];
            }
        }
        return friend;
    }
    
    public int solution(int n, int[] weak, int[] dist) {
        distLength = dist.length;
        checked = new int[weak.length * 2];
        visited = new boolean[distLength];
        selected = new int[distLength];
        
        int i = 0;
        while(i < weak.length) {
            checked[i] = weak[i];
            checked[i + weak.length] = weak[i] + n;
            i++;
        }
        
        System.out.println(Arrays.toString(checked));
        
        for(int k = 0; k < weak.length; k++) {
            permutation(k, 0, dist);
        }
        
        return answer == Integer.MAX_VALUE ? - 1 : answer;
    }
}