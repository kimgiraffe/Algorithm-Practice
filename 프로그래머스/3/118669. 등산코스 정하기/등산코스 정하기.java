import java.util.*;

class Solution {
    static final int INF = 10000001;
    
    static class Node {
        int vertex;
        int weight;
        
        public Node (int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
    
    static List<List<Node>> adjList;
    static int[] intensity;
    static int vertexCount;
    
    static int[] dijkstra(int[] gates, int[] summits) {
        intensity = new int[vertexCount + 1];
        Arrays.fill(intensity, INF);
        
        Queue<Node> queue = new ArrayDeque<>();
        
        // 출입구를 큐에 넣기
        for(int gate : gates) {
            queue.offer(new Node(gate, 0));
            intensity[gate] = 0; // 시작 지점의 intensity는 0
        }
        
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            
            // 현재 지점의 소요시간이 기존 가중치보다 큰 경우... 건너뜀
            if(cur.weight > intensity[cur.vertex]) continue;
            
            for(int i = 0; i < adjList.get(cur.vertex).size(); i++) {
                Node tmp = adjList.get(cur.vertex).get(i);
                
                int distance = Math.max(intensity[cur.vertex], tmp.weight);
                if(intensity[tmp.vertex] > distance) { // intensity 갱신
                    intensity[tmp.vertex] = distance;
                    queue.offer(new Node(tmp.vertex, distance));
                }
            }
        }
        
        int summitIdx = Integer.MAX_VALUE; // 산봉우리 번호
        int minIntensity = Integer.MAX_VALUE; // intensity의 최솟값
        
        Arrays.sort(summits); // 산봉우리 번호 오름차순 정렬
        
        for(int summit : summits) {
            if(intensity[summit] < minIntensity) {
                summitIdx = summit; // 산봉우리 번호 갱신
                minIntensity = intensity[summit]; // intensity 최솟값 갱신
            }
        }
        
        return new int[]{summitIdx, minIntensity};
    }
    
    static boolean isGate(int vertex, int[] gates) {
        for(int gate : gates) {
            if(vertex == gate) {
                return true;
            }
        }
        
        return false;
    }
    
    static boolean isSummit(int vertex, int[] summits) {
        for(int summit : summits) {
            if(vertex == summit) {
                return true;
            }
        }
        
        return false;
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        vertexCount = n + 1;
        adjList = new ArrayList<>();
        for(int i = 0; i < vertexCount; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int[] path : paths) {
            int start = path[0];
            int end = path[1];
            int weight = path[2];
            
            // 출입구에 연결된 양방향 등산로 -> 출입구에서 다른 지점으로만 이동 가능한 단방향 등산로
            // 산봉우리에 연결된 양방향 등산로 -> 다른 지점에서 산봉우리로만 이동 가능한 단방향 등산로
            
            if(isGate(start, gates) || isSummit(end, summits)) {
                adjList.get(start).add(new Node(end, weight));
            } else if(isGate(end, gates) || isSummit(start, summits)) {
                adjList.get(end).add(new Node(start, weight));
            } else {
                adjList.get(start).add(new Node(end, weight));
                adjList.get(end).add(new Node(start, weight));
            }
        }
        
        return dijkstra(gates, summits);
    }
}