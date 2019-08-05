var LRUCache = function(capacity) {
  this.capacity = capacity;
  this.size = 0;
  this.map = {};
  this.head = new Node();
  this.tail = new Node();
  this.head.next = this.tail;
  this.tail.prev = this.head;
};

LRUCache.prototype.get = function(key) {
  const newHeadNode = this.map[key];
  if (newHeadNode) {
    // move to top of list
    this.moveToHead(newHeadNode);
    return newHeadNode.value;
  } else {
    return -1;
  }
};

LRUCache.prototype.put = function(key, value) {
  // console.log(`PUT ${key}:${value} - size: ${this.size}`)
  const node = this.map[key];
  if (node) {
    // console.log('key is already in cache');
    node.value = value;
    this.moveToHead(node);
  } else {
    // create new node
    const newNode = new Node(key, value);
    if (this.size < this.capacity) {
      // add node
      this.addNode(newNode);
      this.size++;
    } else {
      // evict least recently used / this.tail and put new node at head
      const removedNode = this.popTail();
      delete this.map[removedNode.key];
      this.addNode(newNode);
    }
    this.map[key] = newNode;
  }
  // console.log(`PUT after ${key}:${value} - size: ${this.size}`)
};

LRUCache.prototype.addNode = function(newNode) {
  newNode.prev = this.head;
  newNode.next = this.head.next;
  this.head.next.prev = newNode;
  this.head.next = newNode;
};

LRUCache.prototype.removeNode = function(nodeToRemove) {
  const prev = nodeToRemove.prev;
  const next = nodeToRemove.next;
  prev.next = next;
  next.prev = prev;
};

LRUCache.prototype.popTail = function() {
  const toRemove = this.tail.prev;
  this.removeNode(this.tail.prev);
  return toRemove;
};

LRUCache.prototype.moveToHead = function(node) {
  this.removeNode(node);
  this.addNode(node);
};

LRUCache.prototype.toString = function() {
  console.log(`>>>>>>>>>>> toString start`);
  let node = this.head;
  let count = 0;
  console.log(
    `head: ${this.head.value} prev: ${this.head.prev} next: ${this.head.next}`
  );
  console.log(
    `tail: ${this.tail.value} prev: ${this.tail.prev} next: ${this.tail.next}`
  );

  while (node && count++ < 20) {
    console.log(`${node.value} prev: ${node.prev} next: ${node.next}`);
    node = node.next;
  }
  console.log(`>>>>>>>>>>> toString end`);
};

var Node = function(key, value, next, prev) {
  this.key = key;
  this.value = value;
  this.next = next;
  this.prev = prev;
};

let cache = new LRUCache(1);
cache.put(2, 1);
cache.get(2);
cache.put(3, 2);
cache.get(2);
cache.get(3);

// cache = new LRUCache(2);
// cache.put(1, 1);
// cache.put(2, 2);
// let res = cache.get(1);       // returns 1
// console.log(`>>>>>>>>>>> ${res} === 1`);
// cache.put(3, 3);    // evicts key 2
// res = cache.get(2);       // returns -1 (not found)
// console.log(`>>>>>>>>>>> ${res} === -1`);
// cache.put(4, 4);    // evicts key 1
// res = cache.get(1);       // returns -1 (not found)
// console.log(`>>>>>>>>>>> ${res} === -1`);
// cache.toString();
// res = cache.get(3);       // returns 3
// console.log(`>>>>>>>>>>> ${res} === 3`);
// cache.toString();

// res = cache.get(4);       // returns 4
// console.log(`>>>>>>>>>>> ${res} === 4`);
// cache.toString();

// res = cache.get(3);       // returns 3
// console.log(`>>>>>>>>>>> ${res} === 3`);
// cache.toString();
