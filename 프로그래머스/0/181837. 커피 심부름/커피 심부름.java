class Solution {
    static final int AMERICANO = 4500;
    static final int LATTE = 5000;
    
    public int solution(String[] order) {
        int answer = 0;
        
        for (String s : order) {
            if (s.equals("iceamericano") || s.equals("americanoice") || s.equals("hotamericano") 
                || s.equals("americanohot") || s.equals("americano") || s.equals("anything")) {
                answer += AMERICANO;
            } else if (s.equals("icecafelatte") || s.equals("cafelatteice") || s.equals("hotcafelatte") 
                       || s.equals("cafelattehot") || s.equals("cafelatte")) {
                answer += LATTE;
            } else {
                answer += AMERICANO;
            }
        }
        
        return answer;
    }
}