function solution(n, lost, reserve) {
    var answer = n- lost.length;
    
    lost.sort((a, b) => a - b);
    reserve.sort((a, b) => a- b);
    
    for(let i = 0; i < lost.length; i++) {
        for(let j = 0; j < reserve.length; j++) {
            if(lost[i] === reserve[j]) {
                answer++;
                lost[i] = -1;
                reserve[j] = -1;
                break;
            }
        }
    }
    
    for(let i = 0; i < lost.length; i++) {
        for(let j = 0; j < reserve.length; j++) {
            if(Math.abs(lost[i]-reserve[j]) === 1) {
                answer++;
                reserve[j] = -1;
                break;
            }
        }
    }
    
    return answer;
}