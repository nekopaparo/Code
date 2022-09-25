window.onload = function ()
{
    console.log("First");
}
// 舊的也加入
window.onload = function (current) {
    if (current)
    {
        current();
    }
    console.log("Second");
} (window.onload);