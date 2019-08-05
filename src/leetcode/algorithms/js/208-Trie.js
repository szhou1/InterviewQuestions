var Node = function(key) {
    this.key = key;
    this.parent = null;
    this.children = {};
    this.end = false;
}

/**
 * Initialize your data structure here.
 */
var Trie = function() {
    this.root = new Node();
};

/**
 * Inserts a word into the trie. 
 * @param {string} word
 * @return {void}
 */
Trie.prototype.insert = function(word) {
    var node = this.root;
    for (let i = 0; i < word.length; i++) {
        var c = word[i];
        if (node.children[c]) {
            node = node.children[c];
        } else {
            // create new node
            var newNode = new Node(c);
            newNode.parent = node;
            if (i === word.length-1){
                // end of word
                newNode.end = true;
            }
            node.children[c] = newNode;

            // move pointer to next node
            node = node.children[c];
        }
    }
};

/**
 * Returns if the word is in the trie. 
 * @param {string} word
 * @return {boolean}
 */
Trie.prototype.search = function(word) {
    var node = this.root;
    for (let i = 0; i < word.length; i++) {
        var c = word[i];
        if (node.children[c]) {
            node = node.children[c];
            if(i === word.length-1 && node.end){
                return true;
            }
        }
    }
    return false;
};

/**
 * Returns if there is any word in the trie that starts with the given prefix. 
 * @param {string} prefix
 * @return {boolean}
 */
Trie.prototype.startsWith = function(prefix) {
    var node = this.root;
    for (let i = 0; i < prefix.length; i++) {
        var c = prefix[i];
        if (node.children[c]) {
            if(i === prefix.length-1){
                return true;
            }
            node = node.children[c];
        }
    }
    return false;
};

 
// Your Trie object will be instantiated and called as such:
var obj = new Trie()
obj.insert('steve')
obj.insert('star')
obj.insert('steven')
var param_2 = obj.search('steve')
console.log(param_2)
param_2 = obj.search('stevee')
console.log(param_2)
param_2 = obj.search('stev')
console.log(param_2)
param_2 = obj.search('steven')
console.log(param_2)
var param_3 = obj.startsWith('s')
console.log(param_3)
var param_3 = obj.startsWith('')
console.log(param_3)
// var trie = new Trie();
// trie.insert("apple");
// trie.search("apple");   // returns true
// trie.search("app");     // returns false
// trie.startsWith("app"); // returns true
// trie.insert("app");   
// trie.search("app");     // returns true