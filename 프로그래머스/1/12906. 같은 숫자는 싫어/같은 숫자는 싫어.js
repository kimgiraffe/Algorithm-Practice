function solution(arr)
{
    class Stack {
        constructor() {
            this.arr = [];
        }
        
        push(item) {
            this.arr.push(item);
        }
        
        pop() {
            return this.arr.pop();
        }
        
        peek() {
            return this.arr[this.arr.length - 1];
        }
        
        size() {
            return this.arr.length;
        }
        
        isEmpty() {
            return this.arr.length === 0;
        }
    }
    var answer = [];
    
    const stack = new Stack();
    
    for(i = 0; i < arr.length; i++) {
        
        if(stack.peek() !== arr[i]) {
            stack.push(arr[i]);
        }
    }
    
    while(!stack.isEmpty()) {
        answer.push(stack.pop());
    }
    
    return answer.reverse();
}