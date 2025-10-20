class Solution {
    static int len1, len2, sum1, sum2;
    
    public int solution(int[] arr1, int[] arr2) {
        len1 = arr1.length;
        len2 = arr2.length;
        
        if (len1 > len2) {
            return 1;
        } else if (len1 < len2) {
            return -1;
        } else {
            for (int num : arr1) {
                sum1 += num;
            }
            for (int num : arr2) {
                sum2 += num;
            }
            if (sum1 > sum2) {
                return 1;
            } else if (sum1 < sum2) {
                return -1;
            } else {
                return 0;
            }
        }              
    }
}