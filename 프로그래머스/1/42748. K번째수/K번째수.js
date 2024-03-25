function solution(array, commands) {
    var answer = [];
    
    for(let i = 0; i < commands.length; i++) {
        
        let result = [];
        for(let j = commands[i][0] - 1; j < commands[i][1]; j++) {
            result.push(array[j]);
        }
        result.sort((a, b) => (a-b));
        console.log(result);
        answer.push(result[commands[i][2] - 1]);
    }
    return answer;
}