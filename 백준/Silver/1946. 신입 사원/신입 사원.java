import java.io.*;
import java.util.*;

/**
 * Main
 */
public class Main {
  static BufferedReader br;
  static StringTokenizer st;
  static StringBuilder sb;

  static int T; // 테스트 케이스의 개수
  static int N; // 지원자 수

  static class Score implements Comparable<Score> {
    int paper;
    int interview;

    public Score(int paper, int interview) {
      this.paper = paper;
      this.interview = interview;
    }

    @Override
    public int compareTo(Score o) {
      if (this.paper == o.paper) {
        return this.interview - o.interview;
      } else {
        return this.paper - o.paper;
      }
    }
  }

  static Score[] scores;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();
    T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      N = Integer.parseInt(br.readLine());
      scores = new Score[N];
      for (int idx = 0; idx < N; idx++) {
        st = new StringTokenizer(br.readLine().trim());
        int paper = Integer.parseInt(st.nextToken());
        int interview = Integer.parseInt(st.nextToken());
        scores[idx] = new Score(paper, interview);
      }

      Arrays.sort(scores); // 서류 성적을 기준으로 오름차순 정렬

      int cnt = 1;
      int minInterview = scores[0].interview;
      for (int idx = 1; idx < N; idx++) {
        if (scores[idx].interview < minInterview) { // 이전 지원자의 면접 성적보다 높은 경우
          cnt++; // 합격자 수 증가
          minInterview = scores[idx].interview; // 면접 성적 업데이트
        }
      }
      sb.append(cnt).append('\n');
    }

    System.out.println(sb);
  }
}