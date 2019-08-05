/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    var currMax = nums[0];
    var globalMax = nums[0];

    for(let i = 1; i < nums.length; i++) {
        currMax = Math.max(nums[i], currMax + nums[i]);
        globalMax = Math.max(globalMax, currMax);
    }

    return globalMax;
};

console.log(maxSubArray([-2,1,-3,4,-1,2,1,-5,4]))


/**
 * Returns the actual max sub array
 * @param {*} nums 
 */
var maxSubArrayList = function(nums) {
    var currMax = nums[0];
    var globalMax = nums[0];
    var list = [nums[0]];
    var glist = [nums[0]];

    for(let i = 1; i < nums.length; i++) {
        if (nums[i] > currMax + nums[i]) {
            currMax = nums[i];
            list = [nums[i]];
        } else {
            currMax = currMax + nums[i];
            list.push(nums[i]);
        }
        // currMax = Math.max(nums[i], currMax + nums[i]);
        if (currMax > globalMax) {
            globalMax = currMax;
            glist = list.slice();
        }
        // globalMax = Math.max(globalMax, currMax);
    }

    return glist;
};

console.log(maxSubArrayList([-2,1,-3,4,-1,2,1,-5,4]))
