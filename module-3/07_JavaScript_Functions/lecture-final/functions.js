const thisVariableIsInGlobalScope = 0;

function someFunction() {
    const thisVariableIsInFunctionScope = 0;

    if (1 === 1) {
        const thisVariableIsInBlockScope = 0;
    }
}

// Named function
function sayHelloWorld() {
    console.log("Hello World");
}
sayHelloWorld();
function unknownParams() {
    console.log(arguments.length);
    console.table(arguments);
    const paramsAsArray = Array.from(arguments);

    for (let i = 0; i < paramsAsArray.length; i++) {
        console.log(paramsAsArray[i]);
    }
}


function addWithSpread(x, y, z) {
    return x + y + z;
}

const args = [1,2,3];

addWithSpread(...args);
addWithSpread(...'JavaScript');


/*
    Anonymous Functions
*/

function doubleSum(x, y) {
    return (x + y) * 2;
}

/*
Create an anonymous function and assign to a variable
*/
const doubleSumFunc = function (x, y) {
    return (x + y) * 2;
}
// use that variable to call the function using ()
doubleSumFunc(2, 3);

/*
Create an anonymous function using the fat arrow =>
*/
const doubleSumFuncAgain =  (x, y) => {
    return (x + y) * 2;
}

// Reassign the function that was assigned to a variable to a new variable
const q = doubleSumFuncAgain;

// Write a function that takes another function as a parameter and uses it
function addValues(x, y, func) {
    return func(x, y);
}

/*
Chang the way a function works by passing it an anonymous function to do part of its work.
Can do this either passing it a function stored in a variable, or by writing an anonymous function
in the method call.
*/
console.log(addValues(1,2,q));

console.log( 
    addValues(1, 2, (x, y) => { return (x + y) * 3;})
);

/*
    Array forEach()
*/
const nums = [1,2,3,4,5,6,7,8,9,10];

// A simple Array forEach() example that just prints out each value in the array
nums.forEach( 
    (element) => {
        console.log(element);
    }
);


// The traditional way of finding the sum of all the numbers in an array
let sum = 0;
for (let i = 0; i < nums.length; i++) {
    sum += nums[i];
}
console.log(sum);

// Finding the sum with forEach()
let sum2 = 0;
nums.forEach( (value) => {
    sum2 += value;
});

/*
    reduce() - aggregates all the values in an array into a single accumulated value
*/
const sum3 = nums.reduce( (sum, value) => {
    // for each item in the array, calculate the new accumulated value and return it
        return sum + value;
}, 0);

const stringArr = ['John', 'Matt', 'Rachelle', 'Steve', 'Kevin'];
let singleStringFromTheArray = stringArr.reduce( (newStr, name) => {
    return newStr + ", " + name;
});
console.log(singleStringFromTheArray);


/*
    Filter - creates a new array using only the values from the original array that match 
             a boolean condition.  When the condition is true the value is included in the
            new array, and when it is false it is excluded.
*/

const evenNumbersOnly = nums.filter( (value) => {
    // return true if we want the value in the new array and false if we don't
    return value % 2 == 0;
});
console.table(evenNumbersOnly);

/*
    Map - create a new array by transforming each value in the original array using
          the anonymous function and placing the new value in the same index in the new array
*/
const allValuesDoubled = nums.map( (value)=> {
    return value * 2;
});
console.table(allValuesDoubled);

const fizzArr = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15];
let fizzbuzzed = fizzArr.map( (num) => {
    if (!(num % 3) && !(num % 5)) {
        return 'FizzBuzz';
    }
    if (!(num % 3)) {
        return 'Fizz';
    }
    if (!(num % 5)) {
        return 'Buzz';
    }
    return num;
});
console.table(fizzbuzzed);

/*
 Chaining array functions

    Requirement (using fizzArr): Find the sum of all the numbers in the array where all of the 
         number that are not a multiple of 3 have been multiplied by 10 and those that 
         are have been removed.
 */
const newArr = fizzArr.filter( (num) => {  // filter out all the multiples of 3
    return num % 3;
    // equivalent to:  return num % 3 != 0;
}).map( (num) => { // multiple all the remaining values by 10 in the array returned by filter
    return num * 10;
}).reduce( (collector, num)=> { // find the sum of the numbers in the array returned by map
    return collector + num;
});



console.table(newArr);
