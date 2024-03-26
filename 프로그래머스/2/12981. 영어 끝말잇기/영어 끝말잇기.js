function solution(n, words) {
    let answer = [0, 0];
    const map = new Map();
    map.set(words[0], 1);

    for(let i = 1; i < words.length; i++) {
        let cur = words[i];
        let prev = words[i-1];
        
        let last = prev[prev.length - 1];
        let first = cur[0];
        
        if(map.get(cur) || last !== first) {
            answer[0] = (i % n) + 1;
            answer[1] = Math.floor((i / n)) + 1;
            
            return answer;
        }
        
        map.set(words[i], 1);
    }

    return answer;
}