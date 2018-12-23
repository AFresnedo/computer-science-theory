const lib = require('./stack.js');

const one = new lib.myStack();
console.log(one.pop());
one.push('happy');
one.push(3);
console.log(one.toString());
console.log(one.pop());
console.log(one.pop());
console.log(one.toString());
