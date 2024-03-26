function solution(s) {
    let answer = ''
    const arr = s.split(" ")
    
    answer = Math.min(...arr) + ' ' + Math.max(...arr)
    
    return answer
}