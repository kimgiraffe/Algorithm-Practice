class Solution {
    static final String[] days = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
    static int cnt;
    static void solve(int a) {
        if(a == 2) {
            cnt += 31;
        } else if(a == 3) {
            cnt += 31 + 29;
        } else if(a == 4) {
            cnt += 31 + 29 + 31;
        } else if(a == 5) {
            cnt += 31 + 29 + 31 + 30;
        } else if(a == 6) {
            cnt += 31 + 29 + 31 + 30 + 31;
        } else if(a == 7) {
            cnt += 31 + 29 + 31 + 30 + 31 + 30;
        } else if(a == 8) {
            cnt += 31 + 29 + 31 + 30 + 31 + 30 + 31;
        } else if(a == 9) {
            cnt += 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31;
        } else if(a == 10) {
            cnt += 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
        } else if(a == 11) {
            cnt += 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
        } else if(a == 12) {
            cnt += 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;
        }
    }
    
    public String solution(int a, int b) {
        cnt += b;
        solve(a);
        return days[cnt % 7];
    }
}