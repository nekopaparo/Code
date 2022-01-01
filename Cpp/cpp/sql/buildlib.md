# build .lib
## 1. 開啟 Developer Command Prompt for VS 2019
![執行檔](https://lh3.googleusercontent.com/geIsFRO7O3eGp-VJ35OzpckP82ahOGxnlQStAj3t1A5UW1HbY7Z0W7FPL8xiwiHSAN6ISx_-OWfnExva6GTLxrH9NUfip2uyO2Q1SLcnwesYt07gB2Qj-s2vI8scLvFlxHil_6JUoQ=w2400)

## 2.位置轉到sqlite-dll-win64-x64-xxxxxx資料夾內

## 3.執行
```cmd
lib /DEF:sqlite3.def /OUT:sqlite3.lib /MACHINE:x64
```
![使用](https://lh3.googleusercontent.com/KaSqTW25KWK4Tg652Kc3jiOPefJ7Lga7iTyyKE3fTIVI4OhyQLya1g2U4RAhFpj4aZLEAVJb23qP89tCaMFRJMTu_jRF8HziMWuawIRtSyVM9cUx-ArlJqdhPmmnC3ubY6wC-2Ishw=w2400)

## 資料參考
[How to build SQLite3 .lib file on Windows 10](https://gist.github.com/zeljic/d8b542788b225b1bcb5fce169ee28c55)