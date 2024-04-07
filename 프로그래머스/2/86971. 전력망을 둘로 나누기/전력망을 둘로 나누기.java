class Solution {
    static int[] parents;
    
    static void make(int n) {
        parents = new int[n + 1];
        for(int idx = 0; idx <= n; idx++) {
            parents[idx] = idx;
        }    
    }
    
    static int find(int a) {
        if(parents[a] == a) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }
    
    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        
        if(aRoot == bRoot) {
            return;
        } else if(aRoot > bRoot) {
            parents[aRoot] = bRoot;
        } else {
            parents[bRoot] = aRoot;
        }
    }
    
    static int count(int n) {
        int cnt1 = 0, cnt2 = 0;
        for(int idx = 1; idx <= n; idx++) {
            if(find(parents[idx]) == 1) {
                cnt1++;
            }
        }
        cnt2 = n - cnt1;
        return Math.abs(cnt1 - cnt2);
    }
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        for(int i = 0; i < wires.length; i++) {
            make(n); // 초기화
            for(int j = 0; j < wires.length; j++) {
                if(i == j) continue; // 전선 하나 자르기
                union(wires[j][0], wires[j][1]); // 합치기
            }   
            answer = Math.min(answer, count(n)); // 송전탑 개수의 차이(절댓값) 갱신
        }
        
        return answer;
    }
}