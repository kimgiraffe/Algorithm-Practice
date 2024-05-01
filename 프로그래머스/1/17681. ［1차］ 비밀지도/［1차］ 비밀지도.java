class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int idx = 0; idx < n; idx++) {
            String tmp = String.format("%16s", Integer.toBinaryString(arr1[idx] | arr2[idx]));
            tmp = tmp.substring(tmp.length() - n);
            tmp = tmp.replaceAll("1", "#");
            tmp = tmp.replaceAll("0", " ");
            answer[idx] = tmp;
        }
        
        return answer;
    }
}