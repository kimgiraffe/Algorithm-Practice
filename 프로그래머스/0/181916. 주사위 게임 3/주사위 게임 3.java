class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        
        if (a == b && b == c & c == d) {
            answer = 1111 * a;
        } else if (a != b && b != c && c != d && d != a && a != c && b != d) {
            answer = Math.min(Math.min(a, b), Math.min(c, d));
        } else if (a == b && c == d && b != c) {
            answer = Math.abs(a - c) * (a + c);
        } else if (a == c && b == d && b != c) {
            answer = Math.abs(a - b) * (a + b);
        } else if (a == d && b == c && b != d) {
            answer = Math.abs(a - c) * (a + c);
        } else if (a == b && b != c && c != d && b != d) { // a == b
            answer = c * d;
        } else if (a == c && b != c && c != d && b != d) { // a == c
            answer = b * d;
        } else if (a == d && d != b && d != c && c != d) { // a == d
            answer = b * c;
        } else if (b == c && a != d && a != b && d != b) {
            answer = a * d;
        } else if (b == d && a != b && c != b && a != c) {
            answer = a * c;
        } else if (c == d && a != b && a != c && c != b) {
            answer = a * b;
        } else if (a == b && b == c && a != d) {
            answer = (10 * a + d) * (10 * a + d);
        } else if (a == b && b == d && c != d) {
            answer = (10 * a + c) * (10 * a + c);
        } else if (a == c && c == d && c != b) {
            answer = (10 * a + b) * (10 * a + b);
        } else if (b == c && c == d && a != d) {
            answer = (10 * b + a) * (10 * b + a);
        }
        
        return answer;
    }
}