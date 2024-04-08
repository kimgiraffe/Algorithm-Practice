import java.util.*;

class Solution {
    static class Room implements Comparable<Room> {
        int start;
        int end;
        
        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Room o) {
            return this.end - o.end;
        }
    }
    
    static Room[] rooms;
    static int time;
    static PriorityQueue<Room> pq;
    
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, (x, y) -> x[0].compareTo(y[0]));
        rooms = new Room[book_time.length];
        pq = new PriorityQueue<>();
        
        for(int idx = 0; idx < book_time.length; idx++) {
            String[] s = book_time[idx][0].split(":");
            String[] e = book_time[idx][1].split(":");
            
            int start = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
            int end = Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1]) + 10;
            
            rooms[idx] = new Room(start, end);
        }
        
        for(int idx = 0; idx < rooms.length; idx++) {
            if(pq.isEmpty()) {
                answer++;
                pq.offer(rooms[idx]);
                continue;
            }
            Room prev = pq.poll();
            if (rooms[idx].start >= prev.end) {
                pq.offer(rooms[idx]);
            } else {
                answer++;
                pq.offer(rooms[idx]);
                pq.offer(prev);
            }
        }
        
        return answer;
    }
}