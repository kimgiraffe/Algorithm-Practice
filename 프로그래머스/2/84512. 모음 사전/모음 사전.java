import java.util.ArrayList;
import java.util.List;

class Solution {
  static int answer = 1;
  static char[] vowels = { 'A', 'E', 'I', 'O', 'U' };
  static List<String> list = new ArrayList<>();

  public void dfs(String str, String word, int depth) {
    list.add(str);

    if (depth == 5) {
      return;
    }

    for (int idx = 0; idx < 5; idx++) {
      dfs(str + vowels[idx], word, depth + 1);
    }
  }

  public int solution(String word) {
    dfs("", word, 0);

    for (int idx = 0; idx < list.size(); idx++) {
      if (list.get(idx).equals(word)) {
        answer = idx;
        break;
      }
    }
    return answer;
  }
}