let student = {

name: "Ak",
age:  20
};

let ans = JSON.stringify(student); // converts javascript object to json object iin string //https://onecompiler.com/javascript/3yz9rw9ra
console.log(ans);

let obj = JSON.parse(ans); // JSON - Javascript
console.log(obj);