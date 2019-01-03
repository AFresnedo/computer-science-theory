/** Stacks are used to achieve First In Last Out functionality in constant
 * time. This class serves as a building block for a custom stack with
 * additional methods. Since the JavaScript array is more versatile than this
 * class as is, it is not intended to be used in this basic form (augment it
 * based on the situation).
 */

class myStack {
/* uses "private" fields as referenced in:
 * https://crockford.com/javascript/private.html */
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

  toString() {
    // TODO clear empty array output
    return this.arr.join(', ');
  }
}

module.exports.myStack = myStack;
