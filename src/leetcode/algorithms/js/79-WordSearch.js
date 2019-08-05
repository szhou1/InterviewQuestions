var board = [
    ['A','B','C','E'],
    ['S','F','C','S'],
    ['A','D','E','E']
  ];

var seen = JSON.parse(JSON.stringify(board));
var foundStarting = false;

var dfs = function(board, word, wordIndex, row, col) {
    // console.log(row, col, wordIndex)
    if(row < 0 || col < 0 || row === board.length || col === board[0].length) {
        return false;
    }
    if(wordIndex === word.length) {
        console.log('found word', row, col)
        return true;
    }
    if (board[row][col] !== word[wordIndex]) {
        return false;
    }
    board[row][col] = 'used';
    console.log(board);
    var right = dfs(board, word, wordIndex+1, row, col+1);
    var down = dfs(board, word, wordIndex+1, row+1, col);
    var left = dfs(board, word, wordIndex+1, row, col-1);
    var up = dfs(board, word, wordIndex+1, row-1, col);
    board[row][col] = word.charAt(wordIndex);
    return down || right || left || up;
}

var exist = function(board, word) {
    var _board = JSON.parse(JSON.stringify(board));
    for (let i = 0; i < _board.length; i++) {
        for (let j = 0; j < _board[0].length; j++) {
            if (dfs(_board, word, 0, i, j)) {
                return true;
            }
        }
    }
    return false;
};

// console.log(exist(board, 'ABCCED'));
// console.log(exist(board, 'SEE'));
console.log(exist(board, 'ABCB'));
