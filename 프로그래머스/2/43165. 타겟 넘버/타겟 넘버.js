function solution(numbers, target) {
    var answer = 0;
    
    function dfs(count, result) {
        if(count === numbers.length) {
            if(target === result) {
                answer++;
            }
            return;
        }
        
        dfs(count + 1, result + numbers[count]);
        
        dfs(count + 1, result - numbers[count]);
    }
    
    dfs(0, 0);
    
    return answer;
}