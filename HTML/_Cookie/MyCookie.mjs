// 參考
// https://github.com/js-cookie/js-cookie
// https://developer.mozilla.org/zh-TW/docs/Web/HTTP/Cookies
// https://tech-blog.cymetrics.io/posts/jo/zerobased-secure-samesite-httponly/
// http://www.tsnien.idv.tw/MySQL_WebBook/chap4/4-5%20Cookie%20%E8%88%87%20Session.html

'use strict';
// 可在這邊加密
var defaultConverter = {
    read: function (value) {
      return value;
    },
    write: function (value) {
      return value;
    }
};
// 預設cookie設定
var defaultAttributes = { 
    // path 參數用來指定哪些路徑可以存取這個 cookie。
    path : '/',
    // 有效期限
//    expires : 'Tue, 19 Jan 2038 03:14:07 GMT',  // new Date().toUTCString()
//    'max-age' : 10, // 從設定開始算之後幾秒之內 cookie 是有效的
    // 共用網域.預設值是當前網域
//    domain : 'github.com',
    // cookie 只能透過 https 傳遞
//    Secure : false,
    // 禁止 JavaScript 存取 cookie
//    HttpOnly : false,
    // Samesite 的作用是防止 cookie 以跨站方式傳送
//    SameSite : 'lax', // strict > lax >>>>>> none(允許第三方)
}
// 串接
function assign () {
    var target = {};
    for (var i = 0; i < arguments.length; ++i) {
        var source = arguments[i];
        for (var key in source) {
            target[key] = source[key];
        }
    }
    return target;
}
// main
function init (converter, defaultAttributes)
{
    function get (key)
    {
        if (typeof document === 'undefined' || (arguments.length && !key)) {
            return
        }

        var cookies = document.cookie ? document.cookie.split(';') : [];
        var jar = {};

        cookies.forEach(function (cookie) {
            var parts = cookie.split('=');
            try {
                jar[parts[0]] = converter.read(parts[1]);
            } catch (e) {}
        });
    
        return key ? jar[key] : jar;
    }

    function set (key, value, attributes)
    {
        if (typeof document === 'undefined') {
            return
        }

        const ifiedAttributes = assign(defaultAttributes, attributes);
        var stringifiedAttributes = '';
        for (var attributeName in ifiedAttributes)
        {
            stringifiedAttributes += `${attributeName}=${ifiedAttributes[attributeName]};`;
        }
        return (document.cookie =
            `${key}=${converter.write(value)};${stringifiedAttributes}`);
    }

    return Object.create(
    {
        set : set,
        get : get,
        remove : function (key, attributes) {
            set(
                key,
                '',
                assign(attributes, {
                    expires : (new Date(Date.now() - 1)).toGMTString()
                })
            );
        },
        withAttributes: function (attributes) {
            return init(this.converter, assign(this.attributes, attributes))
        },
        withConverter: function (converter) {
            return init(assign(this.converter, converter), this.attributes)
        }
    },
    {
        attributes : { value: Object.freeze(defaultAttributes) },
        converter : { value: Object.freeze(converter) }
    })
}

var api = init(defaultConverter, defaultAttributes);

export default api;