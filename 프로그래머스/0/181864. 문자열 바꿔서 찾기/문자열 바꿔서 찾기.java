class Solution {
    public int solution(String myString, String pat) {
        myString = myString.replaceAll("A", "C"); // A를 C로 바꾸기        
        myString = myString.replaceAll("B", "A"); // B를 A로 바꾸기
        myString = myString.replaceAll("C", "B"); // C를 B로 바꾸기
        
        return myString.contains(pat) ? 1 : 0;
    }
}