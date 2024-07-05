import java.util.*;

class Solution {
    static HashMap<String, Integer> parkings;
    static TreeMap<String, Integer> costs;
    public int[] solution(int[] fees, String[] records) {
        parkings = new HashMap<>();
        costs = new TreeMap<>();
        
        for(String record : records) {
            String[] input = record.split(" ");
            String car = input[1];
            String[] time = input[0].split(":");
            int min = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            if(input[2].equals("IN")) {
                parkings.put(car, min);
            } else if(input[2].equals("OUT")) {
                int in = parkings.get(car);
                if(costs.containsKey(car)) {
                    costs.put(car, costs.get(car) + min - parkings.get(car));
                } else {
                    costs.put(car, min - parkings.get(car));
                }
                parkings.remove(car);
            }
        }
        
        if(!parkings.isEmpty()) {
            for(String car : parkings.keySet()) {
                Integer cost = costs.get(car);
                cost = (cost == null) ? 0 : cost;
                costs.put(car, cost + (23 * 60 + 59) - parkings.get(car));
            }
        }
        
        List<Integer> result = new ArrayList<>(costs.size());
        
        for(Integer cost : costs.values()) {
            if(cost <= fees[0]) {
                result.add(fees[1]);
            } else {
                result.add((int) (fees[1] + Math.ceil((double) (cost - fees[0]) / fees[2]) * fees[3]));
            }
        }
        
        int[] answer = new int[result.size()];
        for(int idx = 0; idx < result.size(); idx++) {
            answer[idx] = result.get(idx);
        }
        
        return answer;
    }
}