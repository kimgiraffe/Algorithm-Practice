class Solution {
    public class Pair implements Comparable<Pair> {
        int idx;
        int num;

        public Pair(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.num == o.num) { // mapped value가 동일한 경우...
                return this.idx - o.idx; // 상대 위치 기준 정렬
            } else {
                return this.num - o.num;
            }
        }
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[] sorted = new int[nums.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int arrIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            String str = nums[i] + "";
            String value = "";
            // mapped value로 변환
            for (int j = 0; j < str.length(); j++) {
                value += mapping[str.charAt(j) - '0'];
            }

            pq.offer(new Pair(i, Integer.parseInt(value)));
        }

        while (!pq.isEmpty()) {
            sorted[arrIdx++] = nums[pq.poll().idx];
        }

        return sorted;
    }
}