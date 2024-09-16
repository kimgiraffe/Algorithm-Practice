class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] minutes = new int[timePoints.size()];

        for (int idx = 0; idx < timePoints.size(); idx++) {
            String time = timePoints.get(idx);
            int hour = Integer.parseInt(time.substring(0, 2));
            int min = Integer.parseInt(time.substring(3));
            minutes[idx] = hour * 60 + min;
        }

        Arrays.sort(minutes);

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < minutes.length; i++) {
            answer = Math.min(answer, minutes[i] - minutes[i - 1]);
        }

        return Math.min(answer, Math.abs(minutes[minutes.length - 1] - (minutes[0] + 1440)));
    }
}