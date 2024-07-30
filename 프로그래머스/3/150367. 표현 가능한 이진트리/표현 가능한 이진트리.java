class Solution {
    public String makeBinary(long number) {
        String binary = Long.toBinaryString(number);
        
        int height = (int) Math.ceil(Math.log10(binary.length() + 1) / Math.log10(2));
        int size = (int) Math.pow(2, height) - 1;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < size - binary.length(); i++) {
            sb.append("0");
        }
        sb.append(binary);
        return sb.toString();
    }
    
    public boolean check(String binaryTree) {
        if(binaryTree.length() <= 1) {
            return true;
        }
        
        String leftTree = binaryTree.substring(0, binaryTree.length() / 2);
        String rightTree = binaryTree.substring(binaryTree.length() / 2 + 1);
        
        char root = binaryTree.charAt(binaryTree.length() / 2);
        char left = leftTree.charAt(leftTree.length() / 2);
        char right = rightTree.charAt(rightTree.length() / 2);
        
        if(root == '0' && (left == '1' || right == '1')) {
            return false;
        } else {
            return check(leftTree) && check(rightTree);
        }
    }
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int idx = 0; idx < numbers.length; idx++) {
            if(check(makeBinary(numbers[idx]))) {
                answer[idx] = 1;
            } else {
                answer[idx] = 0;
            }
        }
        
        return answer;
    }
}