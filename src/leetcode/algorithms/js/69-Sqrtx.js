var mySqrt = function(x) {
    if (x < 1) return 0;
    var high = x;
    var mid = 0;
    var low = 1;

    while(low + 1 < high) {
        mid = Math.floor((high+low)/2);
        if(mid * mid > x) {
            high = mid;
        }else if(mid * mid < x) {
            low = mid;
        }else {
            return mid;
        }
    }
    return low;
};


console.log(mySqrt(4)) // 2
console.log(mySqrt(2)) // 1.41 -> 1
console.log(mySqrt(9)) // 3
console.log(mySqrt(1)) // 1
