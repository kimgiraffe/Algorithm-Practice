class Solution {
    public String solution(String polynomial) {
        int xSum = 0;   // x 계수 합
        int numSum = 0; // 상수 합
        
        String[] terms = polynomial.split(" \\+ ");
        for (int idx = 0; idx < terms.length; idx++) {
            System.out.println(terms[idx]+ " ");
        }
        
        for (String term : terms) {
            if (term.contains("x")) {
                if (term.equals("x")) {
                    xSum += 1;
                } else {
                    xSum += Integer.parseInt(term.replace("x", ""));
                }
            } else {
                // 상수항 처리
                numSum += Integer.parseInt(term);
            }
        }
        
         // 결과 만들기
        StringBuilder sb = new StringBuilder();
        
        // x항
        if (xSum > 0) {
            if (xSum == 1) {
                sb.append("x");
            } else {
                sb.append(xSum).append("x");
            }
        }
        
        // 상수항
        if (numSum > 0) {
            if (sb.length() > 0) {
                sb.append(" + ");
            }
            sb.append(numSum);
        }
        
        return sb.toString();
    }
}