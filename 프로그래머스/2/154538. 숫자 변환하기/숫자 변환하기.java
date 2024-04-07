import java.util.*;

class Solution {
    static int answer;
    static boolean[] visited;
    
    static class Pair {
        int num;
        int count;
        
        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
    
    static Queue<Pair> queue = new ArrayDeque<>();
    
    static void solve(int x, int y, int n) {
        queue.offer(new Pair(y, 0));
        while(!queue.isEmpty()) {
            Pair p = queue.poll();
            visited[p.num] = true;
            
            if(p.num == x) {
                answer = p.count;
                return;
            }
            
            if(p.num - n > 0 && !visited[p.num - n]) {
                queue.offer(new Pair(p.num - n, p.count + 1));
            }
            
            if(p.num % 2 == 0 && !visited[p.num / 2]) {
                queue.offer(new Pair(p.num / 2, p.count + 1));
            }
            
            if(p.num % 3 == 0 && !visited[p.num / 3]) {
                queue.offer(new Pair(p.num / 3, p.count + 1));
            }
        }
    }
    
    public int solution(int x, int y, int n) {
        visited = new boolean[y + 1];
        solve(x, y, n);
        if(x == y) {
            return 0;
        }
        else if(answer == 0) {
            return -1;
        } else {
            return answer;
        }
    }
}