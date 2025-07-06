class Solution {
    static int gcd(int x, int y) {
        while(y > 0) {
            int tmp = x % y;
            x = y;
            y = tmp;
        }
        
        return x;
    }
    
    static boolean isTerminatingDecimal(int a, int b) {
        int gcd = gcd(a, b);
        
        b /= gcd;
        
        while (b % 2 == 0) {
            b /= 2;
        }
        
        while (b % 5 == 0) {
            b /= 5;
        }
        
        return b == 1;
    }
    
    public int solution(int a, int b) {        
        return isTerminatingDecimal(a, b) ? 1 : 2;
    }
}