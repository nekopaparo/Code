/*
import test, {hi as zako} from './export.js';
test.b();
zako();
*/

class dog {
    constructor (name, age){
        this.name = name;
        this.age = age;
    }
    getname() {
        return this.name;
    }
    getage() {
        return this.age;
    }
}

var dog1 = new dog('apple', 5);
console.log(dog1.getname());

var dog2 = new dog('sum', 1);
console.log(dog1.getage());