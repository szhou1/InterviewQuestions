const assert = require('assert');

var calculate = function(s) {
    s = s.replace(/\s/g, '');

    let num = 0;
    let result = 0;
    let stack = [];
    let sign = '+';

    for(let i = 0; i < s.length; i++) {
        var c = s[i];
        // integer
        if(/\d/g.test(c)) {
            num = num * 10 + parseInt(c);
        }

        // not integer or end of string
        if(/\D/g.test(c) || i === s.length - 1) {
            if(sign === '+') {
                stack.push(parseInt(num));
            } else if (sign === '-') {
                stack.push(parseInt(-num));
            } else if (sign === '*') {
                stack.push(stack.pop() * num);
            } else if (sign === '/') {
                let popped = stack.pop();
                stack.push(parseInt(popped / num));
            }
            sign = c;
            num = 0;
        }
    }

    result = stack.reduce((acc, n) => acc + n, 0);
    return result;
};


assert.equal(calculate('3+2*2'), 7);
assert.equal(calculate(' 3/2 '), 1);
assert.equal(calculate(' 3+5 / 2 '), 5);
// assert.equal(calculate('1/0'), 5);
assert.equal(calculate("14-3/2"), 13);
