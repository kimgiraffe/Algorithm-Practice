import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br;
    static StringBuilder sb;

    static int N; // 연산의 개수
    static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o2, o1);
        }
    });
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine().trim()); // 연산의 개수 입력

        for(int idx = 0; idx < N; idx++){
            int input = Integer.parseInt(br.readLine().trim());
            if(input != 0) { // 0인 경우
                pq.offer(input); // 최대 힙에 값 넣기
            } else { // 자연수인 경우
                if(pq.isEmpty()) { // 최대 힙이 비어 있는 경우
                    sb.append(0).append("\n"); // 0 출력
                }
                else { // 최대 힙이 비어 있지 않은 경우
                    sb.append(pq.poll()).append("\n"); // 최댓값 출력하고 최대 힙에서 제거
                }
            }
        }

        System.out.print(sb);
    }
}
