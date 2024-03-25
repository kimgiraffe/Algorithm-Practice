function solution(answers) {
    var answer = [];
    let result = [0, 0 ,0];
    let first = [1, 2, 3, 4, 5];
    let second = [2, 1, 2, 3, 2, 4, 2, 5];
    let third = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
    
    for(i = 0; i < answers.length; i++) {
        if(answers[i] === first[i % 5]) {
            result[0]++;
        }
        if(answers[i] === second[i % 8]) {
            result[1]++;
        }
        if(answers[i] === third[i % 10]) {
            result[2]++;
        }
    }
    
    console.log(result);
    
    let max = Math.max(...result);
    let index = 0;
    
    for(let i = 0; i < 3; i++) {
        if(max === result[i]) {
            answer[index++] = i + 1;
            
        }
    }
    
    return answer;
}