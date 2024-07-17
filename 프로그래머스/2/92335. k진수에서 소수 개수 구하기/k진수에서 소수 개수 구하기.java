import java.util.*;

class Solution {
    static String converted;
    static int answer;
    
    static boolean isPrime(long x) {
        if(x < 2) { // 2보다 작은 경우 소수가 아님
            return false;
        }
        
        for(int i = 2; i <= Math.sqrt(x); i++) {
            if(x % i == 0) { // 나누어 떨어지는 경우... -> 약수 존재
                return false; // 소수가 아님
            }
        }
        
        return true;
    }
    
    public int solution(int n, int k) {
        converted = Integer.toString(n, k); // k 진법으로 변환
        
        String[] splited = converted.split("0"); // "0" 기준 문자열 자르기
        
        for(int i = 0; i < splited.length; i++) {
            if(splited[i].equals("")) { // 빈 문자열인 경우... 무시
                continue;
            }
            Long x = Long.parseLong(splited[i]); // 문자열을 long 으로 변환
            if(isPrime(x)) { // 소수인 경우...
                answer++; // 소수의 개수 1 증가
            }
        }        
        
        return answer;
    }
}