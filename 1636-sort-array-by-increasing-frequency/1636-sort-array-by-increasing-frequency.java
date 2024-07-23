class Solution {
    class Number implements Comparable<Number> {
        int frequency; // 빈도 수
        int value; // 값

        public Number(int frequency, int value) {
            this.frequency = frequency;
            this.value = value;
        }

        public String toString() {
            return this.frequency + " " + this.value;
        }

        @Override
        public int compareTo(Number o) {
            if (this.frequency == o.frequency) { // 빈도 수 동일한 경우
                return Integer.compare(this.value, o.value); // 오름차순 정렬
            } else { // 값 기준 내림차순 정렬
                return Integer.compare(o.frequency, this.frequency);
            }
        }
    }

    public int[] frequencySort(int[] nums) {
        Number[] frequencies = new Number[201];
        int[] answer = new int[nums.length];

        for (int idx = 0; idx < 201; idx++) {
            frequencies[idx] = new Number(0, idx - 100); // -100 ~ 100
        }

        // 빈도 수 계산
        for (int num : nums) {
            frequencies[num + 100].frequency++;
        }

        // 정렬
        Arrays.sort(frequencies);

        int answerIdx = nums.length - 1;
        for (int idx = 0; idx < nums.length; idx++) {
            while (frequencies[idx].frequency-- > 0) {
                answer[answerIdx--] = frequencies[idx].value;
            }
        }

        return answer;
    }
}