const assert = require('assert');

const ONES_TEENS_CONST = ['','One','Two','Three','Four','Five','Six','Seven','Eight','Nine','Ten','Eleven','Twelve','Thirteen','Fourteen','Fifteen','Sixteen','Seventeen','Eighteen','Nineteen'];
const TENS_CONST = ['','','Twenty','Thirty','Forty','Fifty','Sixty','Seventy','Eighty','Ninety'];
const THOUSANDS_CONST = [[], 'Thousand','Million','Billion'];

var numberToWords = function(num) {
    var s = String(num).split('');
    let res = [];
    var i = 0;
    if (num === 0) return 'Zero'; 
    while(num > 0) {
        if (num % 1000) {
            res = getHundredsString(num % 1000)
                .concat(THOUSANDS_CONST[i])
                .concat(res);
        }
        num = Math.floor(num / 1000);
        i++;
    }
    return res.join(' ').trim();
};

function getHundredsString(num) {
    var res = [];
    if (num === 0) {
        return [];
    } else if (num < 20) {
        res.push(ONES_TEENS_CONST[num]);
    } else if (num < 100) {
        res.push(TENS_CONST[Math.floor(num / 10)]);
        res = res.concat(getHundredsString(num % 10));
    } else {
        res.push(ONES_TEENS_CONST[Math.floor(num / 100)]);
        res.push('Hundred');
        res = res.concat(getHundredsString(num % 100));
    }
    return res;
}

assert.equal(numberToWords(0), 'Zero');
assert.equal(numberToWords(1), 'One');
assert.equal(numberToWords(5), 'Five');
assert.equal(numberToWords(10), 'Ten');
assert.equal(numberToWords(12), 'Twelve');
assert.equal(numberToWords(19), 'Nineteen');
assert.equal(numberToWords(20), 'Twenty');
assert.equal(numberToWords(29), 'Twenty Nine');
assert.equal(numberToWords(99), 'Ninety Nine');
assert.equal(numberToWords(100), 'One Hundred');
assert.equal(numberToWords(101), 'One Hundred One');
assert.equal(numberToWords(110), 'One Hundred Ten');
assert.equal(numberToWords(111), 'One Hundred Eleven');
assert.equal(numberToWords(120), 'One Hundred Twenty');
assert.equal(numberToWords(123), 'One Hundred Twenty Three');
assert.equal(numberToWords(200), 'Two Hundred');
assert.equal(numberToWords(999), 'Nine Hundred Ninety Nine');
assert.equal(numberToWords(1000), 'One Thousand');
assert.equal(numberToWords(1001), 'One Thousand One');
assert.equal(numberToWords(1010), 'One Thousand Ten');
assert.equal(numberToWords(1011), 'One Thousand Eleven');
assert.equal(numberToWords(1020), 'One Thousand Twenty');
assert.equal(numberToWords(1099), 'One Thousand Ninety Nine');
assert.equal(numberToWords(12345), 'Twelve Thousand Three Hundred Forty Five');
assert.equal(numberToWords(123456), 'One Hundred Twenty Three Thousand Four Hundred Fifty Six');
assert.equal(numberToWords(1234567), 'One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven');
assert.equal(numberToWords(1234567891), 'One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One');
