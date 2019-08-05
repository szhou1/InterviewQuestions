/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var threeSum = function(nums) {
    nums = nums.sort((a,b) => a - b);
    console.log(nums);
    //[ -4, -1, -1, 0, 1, 2 ]

    var res = [];

    for(let i = 0; i < nums.length; i++) {
        let target = 0 - nums[i];
        
    }

};

console.log(threeSum([-1, 0, 1, 2, -1, -4]));