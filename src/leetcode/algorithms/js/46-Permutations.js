function swap (arr, i, j) {
    var temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

function backtrack (n, nums, output, first) {
    
    for(let i = first; i < n; i++) {
        swap(nums, first, i);
        backtrack(n, nums, output, first + 1);
        swap(nums, first, i);
    }
    if (first === n) output.push(nums.slice());
}

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
    var firsts = nums.slice();
    var maxlen = nums.length;
    var output = [];

    backtrack(maxlen, firsts, output, 0);
    return output;
};

var three = permute([1,2,3]);
console.log(three.length, three);

// var four = permute([1,2,3,4]);
// console.log(four.length, four);