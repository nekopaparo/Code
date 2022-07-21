// IIFE (Immediately Invoked Function Expression) 
(function (a, b) {
    console.log(a + b);
} (10, 20));

// UMD (Universal Module Definition)
(function (global, factory) {
    typeof exports === 'object' && typeof module !== 'undefined' ? module.exports = factory() :
    typeof define === 'function' && define.amd ? define(factory) :
    (global = global || self, (function () {
        var current = global.UMD_NAME;
        var exports = global.UMD_NAME = factory();
        exports.noConflict = function () { 
            global.UMD_NAME = current; 
            return exports; 
        };
    }()));
} (this, function () {
    'use strict';

    var a = 10,
        b = 20;

    function init (a, b)
    {
        function write ()
        {
            console.log("Hi UMD")
        }

        function detail ()
        {
            console.log(`a = ${a}, b = ${b}`);
        }

        return Object.create(
            {
                write : write,
                detail : detail
            }
        );
    }
    
    var api = init(a, b);

    return api;

}));

/* USE
<script src="./IIFE_sample.js"></script>
<script>
    UMD_NAME.write();
    UMD_NAME.detail();
</script>
*/