
/**
 * Brute Force solution
 */
var trapBruteForce = function(height) {
    var result = 0, maxleft = 0, maxright = 0, size = height.length;
    for(let i = 1; i < height.length - 1; i++) {
        maxleft = 0;
        maxright = 0;
        for(let j = i; j > 0; j--) {
            maxleft = Math.max(maxleft, height[j]);
        }
        for(let j = i; j < size - 1; j++) {
            maxright = Math.max(maxright, height[j])
        }
        result += Math.min(maxleft, maxright) - height[i];
    }
    return result;
};

var trapDP = function(height) {

}

class Stack {
    constructor() {
        this.data = [];
    }
    push(element) {
        this.data.push(element)
    }
    peek(){
        return this.data[this.data.length - 1];
    }
    pop() {
        return this.data.pop();
    }
    size() {
        return this.data.length;
    }
}

var trapStacks = function(height) {
    var ans = 0, current = 0;
    var stack = new Stack();
    while(current < height.length) {
        while(stack.size() !== 0 && height[current] > height[stack.peek()]) {
            let top = stack.pop();
            if (stack.size() === 0) {
                break;
            }
            let distance = current - stack.peek() - 1;
            let boundedHeight = Math.min(height[current], height[stack.peek()]) - height[top];
            ans += distance * boundedHeight;
        }
        stack.push(current++);
    }
    return ans;
}

console.log(trapStacks([0,1,0,2,1,0,1,3,2,1,2,1]));