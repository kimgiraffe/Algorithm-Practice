class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for (int i = 0; i < quiz.length; i++) {
            String[] tmp = quiz[i].split(" ");
            int x = Integer.parseInt(tmp[0]);
            String op = tmp[1];
            int y = Integer.parseInt(tmp[2]);
            int z = Integer.parseInt(tmp[4]);
            
            int calc = 0;
            switch(op) {
                case "+" : calc = x + y;
                    break;
                case "-" : calc = x - y;
                    break;
                default:
                    break;
            }
            
            answer[i] = (calc == z) ? "O" : "X";
        }
        
        return answer;
    }
}