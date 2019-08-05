/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
function merge(intervals) {
    if (!intervals.length) return intervals
    intervals.sort((a, b) => a[0] - b[0])
    var prev = intervals[0]
    var res = [prev]
    for (var curr of intervals) {
        console.log(curr[0], prev[1]);
      if (curr[0] <= prev[1]) {
        prev[1] = Math.max(prev[1], curr[1])
      } else {
        res.push(curr)
        prev = curr
      }
    }
    return res
  }

var intervals = [[1,3],[2,6],[8,10],[15,18]];
console.log(merge(intervals));
console.log(merge([[1,4],[4,5]])); // [[1,5]]
console.log(merge([[1,4]])); // [[1,4]]
console.log(merge([[1,4],[1,5]])); // [[1,5]]
console.log(merge([[1,4],[0,5]])); // [[0,5]]
console.log(merge([[1,4],[0,4]])); // [[0,4]]

console.log([3,4,1,2].sort((a,b)=>a-b))
console.log([3,4,1,2].sort((a,b)=>b-a))