import java.util.Arrays;

class Solution {
    public int solution(String my_string) {
        return Arrays.stream(my_string.split("[^0-9]+"))
                     .filter(s -> !s.isEmpty())
                     .mapToInt(Integer::parseInt)
                     .sum();
    }
}