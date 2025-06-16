class Solution {
    public int solution(int a, int b, int c) {
        if(a != b && b != c && c != a) {    // 세 숫자가 모두 다른 경우...
            return a + b + c;
        } else if(a == b && b == c) { // 세 숫자가 모두 같은 경우...
            return (a + b + c) * (a * a + b * b + c * c) * (a * a * a + b * b * b + c * c * c);
        } else { // 세 숫자 중 어느 두 숫자는 같고 나머지 다른 숫자는 다른 경우...
            return (a + b + c) * (a * a + b * b + c * c);
        }
    }
}