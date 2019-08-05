/**
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var rotate = function(matrix) {
    matrix.reverse()
    for(let i = 0; i < matrix.length; i++) {
        for(let j = i + 1; j < matrix.length; j++) {
            let temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
    return matrix;
};

console.log(rotate([
    [1,2,3],
    [4,5,6],
    [7,8,9]
  ]));