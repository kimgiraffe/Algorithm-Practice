class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        
        if (direction.equals("right")) {
            int last = numbers[numbers.length - 1];
            for (int idx = 1; idx < numbers.length; idx++) {
                answer[idx] = numbers[idx - 1];
            }
            answer[0] = last;
        } else {
            int first = numbers[0];
            for (int idx = 0; idx < numbers.length - 1; idx++) {
                answer[idx] = numbers[idx + 1];
            }
            answer[numbers.length - 1] = first;
        }
        
        return answer;
    }
}