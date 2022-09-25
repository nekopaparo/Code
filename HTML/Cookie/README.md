# USE MyCookie
## script
```html
<script src="./MyCookie.js"></script>
<script>
    MyCookies.set('key', 'value');
    console.log(MyCookies.get('key'));
    MyCookies.remove('key');
</script>
```
## import
```html
<script type="module">
    import Cookies from './MyCookie.mjs';
    Cookies.set('key', 'value');
    console.log(Cookies.get('key'));
    Cookies.remove('key');
</script>
```