import java.util.*;

class Solution {
    static int n; // plans의 길이
    
    static class Plan implements Comparable<Plan> {
        String name;
        int start;
        int playtime;
        
        public Plan(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
        
        public Plan(String name, int playtime) {
            this.name = name;
            this.playtime = playtime;
        }
        
        @Override
        public int compareTo(Plan o) {
            return this.start - o.start;
        }
        
        @Override
        public String toString() {
            return "[" + this.name + " " + this.start + " " + this.playtime + "]";
        }
    }
    
    static PriorityQueue<Plan> pq;
    static Stack<Plan> stack; // 진행 중인 과제를 저장할 스택
    
    public String[] solution(String[][] plans) {
        n = plans.length;
        String[] answer = new String[n];
        pq = new PriorityQueue<>();
        stack = new Stack<>();
        
        for(String[] plan : plans) {
            String name = plan[0];
            String[] time = plan[1].split(":"); // ":" 기준 시, 분 구분
            int start = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            int playtime = Integer.parseInt(plan[2]);
            pq.offer(new Plan(name, start, playtime));
        }
        
        int idx = 0; // answerIdx
        
        while(!pq.isEmpty()) {
            Plan cur = pq.poll();
            
            int curTime = cur.start; // 현재 시각
            
            if(!pq.isEmpty()) {
                Plan next = pq.peek(); // 다음 과제
                
                if(curTime + cur.playtime < next.start) { // 현재 과제를 끝냈을 때, 다음 과제전까지 시간이 있는 경우...
                    answer[idx++] = cur.name; // 현재 과제 이름 배열에 담기
                    curTime += cur.playtime; // 현재 시각 갱신
                    
                    while(!stack.isEmpty()) { // 진행 중이던 과제 확인
                        Plan plan = stack.pop();
                        
                        if(curTime + plan.playtime <= next.start) { // 다음 과제 전까지 끝낼 수 있는 경우...
                            curTime += plan.playtime; // 현재 시각 갱신
                            answer[idx++] = plan.name; // 과제 이름 배열에 담기
                            continue;
                        } else { // 다음 과저 전까지 못 끝내는 경우...
                            // 진행중인 과제 스택에 추가
                            stack.push(new Plan(plan.name, plan.playtime - (next.start - curTime)));
                            break;
                        }
                    }
                } else if(cur.start + cur.playtime == next.start) { // 과제가 끝나는 시각과 새로운 과제를 시작해야하는 시각이 같은 경우...
                    answer[idx++] = cur.name; // 과제 이름 배열에 담기
                    continue;
                } else { // 새로운 과제 시작 전까지 과제를 끝내지 못하는 경우...
                    // 스택에 과제 담기
                    stack.push(new Plan(cur.name, cur.playtime - next.start + curTime));
                }
            } else { // 더 이상 새로운 과제가 없는 경우...
                if(stack.isEmpty()) { // 진행중이던 과제가 없는 경우...
                    curTime += cur.playtime; // 현재 시각 갱신
                    answer[idx++] = cur.name; // 과제 이름 배열에 담기
                } else { // 진행중이던 과제가 있는 경우...
                    answer[idx++] = cur.name;
                    
                    while(!stack.isEmpty()) { // 남은 과제를 순서대로 담기
                        answer[idx++] = stack.pop().name;
                    }
                }
            }
        }        
        
        return answer;
    }
}