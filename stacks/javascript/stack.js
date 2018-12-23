/** Stacks are used to achieve First In Last Out functionality in constant
 * time.
 */

class myStack {
  constructor(initial = []) {
    if (typeof initial !== typeof []) {
      throw "myStack requires an array as an arguement";
    }
    this.arr = initial;
  }

  pop() {
    return this.arr.length === 0 ? null : this.arr.pop();
  }

  push(item) {
    this.arr.push(item);
  }
}

module.exports.myStack = myStack;
