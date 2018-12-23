/** Stacks are used to achieve First In Last Out functionality in constant
 * time.
 */

class myStack {
  constructor(initial = []) {
    if (typeof initial !== typeof []) {
      throw "myStack requires an array as an arguement";
    }
    let arr = initial;
  }

  pop() {
    console.log('popping');
  }
}

module.exports.myStack = myStack;
