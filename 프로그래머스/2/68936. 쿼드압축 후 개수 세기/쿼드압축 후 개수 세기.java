class Solution {
  static int[] answer;

  static boolean canCompress(int[][] arr, int r, int c, int size, int value) {
    for (int row = r; row < r + size; row++) {
      for (int col = c; col < c + size; col++) {
        if (arr[row][col] != value) {
          return false;
        }
      }
    }

    return true;
  }

  static void compress(int[][] arr, int r, int c, int size) {
    if (canCompress(arr, r, c, size, arr[r][c])) {
      answer[arr[r][c]]++;
      return;
    }

    compress(arr, r, c, size / 2);
    compress(arr, r, c + size / 2, size / 2);
    compress(arr, r + size / 2, c, size / 2);
    compress(arr, r + size / 2, c + size / 2, size / 2);
  }

  public int[] solution(int[][] arr) {
    answer = new int[2];
    compress(arr, 0, 0, arr.length);

    return answer;
  }
}