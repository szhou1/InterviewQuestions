var assert = require('assert')

/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var spiralOrder = function(matrix) {
    if(matrix.length < 1) return [];
    var res = [];
    var R = matrix.length-1;
    var C = matrix[0].length-1;
    var r = 0;
    var c = 0;
    while(r <= R && c <= C) {
        for(let i = c; i <= C; i++) res.push(matrix[r][i]);
        for(let i = r+1; i <= R; i++) res.push(matrix[i][C]);
        if (r < R && c < C) {
            // need if to handle input with only 1 row or 1 col
            for(let i = C-1; i > c; i--) res.push(matrix[R][i]);
            for(let i = R; i > r; i--) res.push(matrix[i][c]);
        }
        r++;
        R--;
        c++;
        C--;
    }
    return res;
};

assert.deepEqual(spiralOrder([
    [ 1, 2, 3 ],
    [ 4, 5, 6 ],
    [ 7, 8, 9 ]
   ]), [ 1, 2, 3, 6, 9, 8, 7, 4, 5 ]);

assert.deepEqual(spiralOrder([
    [1, 2, 3, 4],
    [5, 6, 7, 8],
    [9,10,11,12]
  ]), [1,2,3,4,8,12,11,10,9,5,6,7]);


assert.deepEqual(spiralOrder([[3],[2]]), [3,2]);
assert.deepEqual(spiralOrder([[3,2,1]]), [3,2,1]);
assert.deepEqual(spiralOrder([]), []);
