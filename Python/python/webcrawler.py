"""爬蟲"""
import urllib.request as request
import fake_useragent
import bs4
# 目標網址
URL = "http://www.ptt.cc/bbs/movie/index.html"
# 偽裝使用者資訊
user = fake_useragent.UserAgent() # 建立使用者
Request = request.Request(URL, headers={
    "User-Agent" : user.random # 隨機套用使用者資訊
})
# 取得網頁原始碼
with request.urlopen(Request) as response:
    data = response.read().decode("utf-8")
# 解析原始碼，取得指定標籤
root = bs4.BeautifulSoup(data, "html.parser")
titles = root.find_all("div", class_="title")
for title in titles:
    tmp = title.a.string
    if tmp is not None:
        print(tmp)
