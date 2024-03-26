function solution(nums) {
    var answer = 0;
    const map = new Map();
    const n = nums.length;
    
    for(let i = 0; i < n; i++) {
        if(map.get(nums[i])) {
            map.set(nums[i], map.get(nums[i]+1));   
        }
        map.set(nums[i], 1);
    }
    
    if(map.size < n / 2) {
        answer = map.size;
    } else {
        answer = n / 2;
    }
    
    return answer;
}