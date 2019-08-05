var subsets = function(nums) {
    var powerset = [[]];
    backtrack(nums, powerset, [], 0);
    return powerset;
};

// backtracking recursive function will take input nums, powerset result, current subset, start index
var backtrack = function(nums, powerset, subset, start) {
    if (start != nums.length) {
        for(let i = start; i < nums.length; i++) {
            subset.push(nums[i]);
            powerset.push(subset.slice());
            backtrack(nums, powerset, subset, i + 1);
            subset.pop();
        }
    }
}

console.log(subsets([1,2,3,4]));