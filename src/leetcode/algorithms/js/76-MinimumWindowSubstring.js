var assert = require('assert')

var minWindow = function(s, t) {
    var target = {};
    for(let char of t) {
        target[char] = ++target[char] || 1;
    }
    var begin = 0, end = 0, counter = t.length;
    var min = Number.MAX_SAFE_INTEGER;
    var head = 0;

    while(end < s.length) {
        if(target[s[end++]]-- > 0) {
            counter--;
        }
        while(counter === 0) {
            // found match
            if(end - begin < min) { // current window size less than global min?
                head = begin;
                min = end - begin;
            }
            if(target[s[begin++]]++ === 0) {
                counter++;
            }
        }
    }

    return min === Number.MAX_SAFE_INTEGER ? '' : s.substring(head, head + min + 1);
};

assert.deepEqual(minWindow('ADOBECODEBANC', 'AABC'), 'BANC')