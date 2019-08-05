var myPow = function(x, n) {
    if(n < 0) {
        x = 1 / x;
        n = -n;
    }

    var ans = 1;
    var current = x;
    for(let i = n; i > 0; i = Math.floor(i/2)) {
        if (i % 2 === 1) {
            ans = ans * current;
        }
        current = current * current;
    }
    return ans;
};

console.log(myPow(2, -10));