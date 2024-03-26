function solution(bridge_length, weight, truck_weights) {
    var answer = 0;
    
    const queue = [];
    let weight_sum = 0; // 다리 위 트럭 무게 합
    
    for(let i = 0; i < truck_weights.length; i++) {
        while(true) {
            if(queue.length === 0) {
                queue.push(truck_weights[i]);
                weight_sum += truck_weights[i];
                answer++;
                break;
            } else if(queue.length === bridge_length) {
                weight_sum -= queue.shift();
            } else {
                if(weight_sum + truck_weights[i] <= weight) {
                    queue.push(truck_weights[i]);
                    weight_sum += truck_weights[i];
                    answer++;
                    break;
                } else {
                    queue.push(0);
                    answer++;
                }
            }
        }
    }
    
    return answer + bridge_length;
}