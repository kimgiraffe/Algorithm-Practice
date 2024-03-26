function solution(strings, n) {
    var answer = [];
    answer = strings.sort((a, b) => {
        if(a[n] > b[n]) {
            return 1;
        } else if(a[n] === b[n]) {
            if(a > b) {
                return 1;
            } else if(a < b) {
                return -1;
            } else {
                return 0;
            }
        } else {
            return -1;
        }
    })
    return answer;
}