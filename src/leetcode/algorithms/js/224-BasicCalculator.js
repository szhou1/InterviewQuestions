const assert = require('assert')
/**
 * @param {string} s
 * @return {number}
 * (1 + 2) - 3 + (-4)
 * (1+(4+5+2)-3)+(6+8)
 */
var calculate = function(s) {

    let sign = 1;
    let result = 0;
    let number = 0;
    let stack = [];

    for(let c of s) {
        // console.log(c, c === '-', result, number)

        if (!isNaN(parseInt(c))) {
            number = 10 * number + parseInt(c);
        } else if (c === '+') {
            result += sign * number;
            number = 0;
            sign = 1;
        } else if (c === '-') {
            result += sign * number;
            number = 0;
            sign = -1;
        } else if (c === '(') {
            stack.push(result);
            stack.push(sign);
            sign = 1;
            result = 0;
        } else if (c === ')') {
            result += sign * number;
            number = 0;
            result *= stack.pop();
            result += stack.pop();
        }
    }

    if (number !== 0) {
        result += sign * number;
    }
    return result;
};

// var calculate = function(s) {
//     console.log('===== calc: ', s)
//     let sign = 1;
//     let result = 0;
//     let number = 0;

//     for(let i = 0; i < s.length; i++) {
//         let c = s[i];
//         // console.log(c, c === '-', result, number)

//         if (!isNaN(parseInt(c))) {
//             number = 10 * number + parseInt(c);
//         } else if (c === '+') {
//             result += sign * number;
//             number = 0;
//             sign = 1;
//         } else if (c === '-') {
//             result += sign * number;
//             number = 0;
//             sign = -1;
//         } else if (c === '(') {
//             result += sign * calculate(s.substring(i + 1, s.lastIndexOf(')')))
//             console.log('here', result, number)
//             sign = 1;
//             i = s.lastIndexOf(')');
//         }
//     }

//     if (number !== 0) {
//         result += sign * number;
//     }
//     console.log('===== returning: ', result)
//     return result;
// };

// var calculate = function(s) {
//     s = s.replace(/\(\)/g, '');
//     let sign = 1;
//     let result = 0;
//     let number = 0;

//     for(let i = 0; i < s.length; i++) {
//         let c = s[i];

//         if (!isNaN(parseInt(c))) {
//             number = 10 * number + parseInt(c);
//         } else if (c === '+') {
//             result += sign * number;
//             number = 0;
//             sign = 1;
//         } else if (c === '-') {
//             result += sign * number;
//             number = 0;
//             sign = -1 * sign;
//         }
//     }

//     if (number !== 0) {
//         result += sign * number;
//     }
//     return result;
// };

assert.equal(calculate('2-1 + 2'), 3);
assert.equal(calculate('(2-1) + 2'), 3);
assert.equal(calculate('(1+(4+5+2)-3)+(6+8)'), 23);
assert.equal(calculate('(((1)))'), 1);
assert.equal(calculate('(-(-1))'), 1);
assert.equal(calculate('(-(2)+2)+(-(-1))'), 1);
assert.equal(calculate('(5-(1+(5)))'), -1);
