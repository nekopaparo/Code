# PHP 環境設定 (Visual Studio Code & XAMPP)

## XAMPP
### PHP主目錄設定
#### 1. 用編輯器(e.g.筆記本)開啟 httpd.conf (位置: ./XAMPP/apache/conf)
#### 2. 修改PHP主目錄
###### 預設是在XAMPP/htdocs
```
↓改這2個
DocumentRoot "D:/Program/XAMPP/htdocs"
<Directory "D:/Program/XAMPP/htdocs">
```
![XAMPP_PHP_RunPath.png](https://lh3.googleusercontent.com/D8M39i0f6ZiAjaBrSkBDVt_xbFNVWtAK2YmpxC7tlO7eqq8tatbsCuKB11eKDVOqoZc5T8nh7GkGVIBhDRzLd7Yop1Dpy8XoGdqHBGYpGcJA00tiMmvqIDFqtIvA8CctQDUgwmvhaw=w2400)
###### 改成自己想要的PHP主目錄
![XAMPP_PHP_RunPath_AFTER.png](https://lh3.googleusercontent.com/Ay7xoDyLrZ_gFz0hlXEG49bSoshJggA127n8IBkP6Z0TuP_QBvQpZtHSXIO4zD34W1H3ahaS7QcwxhJ0Dcg-cDO4H5_HScMtnY2kTidVMhm8GN7JLrTSJ-sT33Fpc3XdOE1z2m3WUA=w2400)

## Visual Studio Code
### PHP
#### 1. PHP設定頁面
###### 左下角齒輪 -> Settings -> User -> Extensions -> PHP
![PHP_Setting_1.1.png](https://lh3.googleusercontent.com/pMYcue42HHp5oJ4s7U7Jrova33M-HN2sOkapPM8fCYCERJSHYu-UBxzh_7s9GBVy7xb95GmW1-vTGbNUH-PZuopq3BP6_oo7ZQiASl8I9ILyv_gpzN_T4RVIGD8gIVACqhSTo7qvxg=w2400)
![PHP_Setting_1.2.png](https://lh3.googleusercontent.com/vGIh-YB3D_EjiWRLmpW1KUasOB9sy8GZe2MzOWENitjt8SuJsP7IGHfoJw_81x8b5t6wtyNnHZu8lVufciCjh4zJlGLTHs5j8xEKtp5SLUnhEBtRVhpXAL6TbFP6R1NY6CHos9fscA=w2400)
#### 2. 點選Executable Path，並複製json格式
![PHP_Setting_2.png](https://lh3.googleusercontent.com/wuWUV-evPv8yxlPbTANgKd4-Vg2PuVwWYGAK4l5YVlM4bsE9NP2I1x0k-JYWyX4Up0AH_Ua0sc8Np8YKBZqQX5oxR5rxfnmAKdYQ_lYO2ARdOzGIUB9XfNFhboLk3KJum4i07vpMmg=w2400)
#### 3. 點選Edit in settings.json 並貼上剛剛複製的
![PHP_Setting_3.1.png](https://lh3.googleusercontent.com/cpOKCaZk6kUF90L80UYP7ncSMItWQjJMYDTN5edIRxs2Znp0QKPYAdOdtC62YXyhki1Iih8N5q_WFkbvJ8hM7hqPsrUD9Lk3Uuk7cumQBsLrcQ_U07LhP6sF9x_KrPGG2FFcfmZ4kQ=w2400)
![PHP_Setting_3.2.png](https://lh3.googleusercontent.com/_KrQvV4V-FC3-G3BU5vbuDSoCRmfwWMiZeCtrYfzrH2uluJPadXG4KYFg81ROMUJ-DGafwXNr05sr-Te0Wf1aR_iOE9tT1KekNc_cn4IkbC2ML2uJnORQamKDQtw6wr1Xorm2h9xPQ=w2400)
![PHP_Setting_3.3.png](https://lh3.googleusercontent.com/lgEwhPn6AtLPg8j1Lu0THfzi2HC--SBPP2wGqrqu2uGthO1zskYVSZHOKURA6CgjWLOgmPPxphHhmMvoYZA1uNtwbPH3Fw2gfmQ3TaJNU-w4KzaYk2VU32_JCa5oA999SNatJTpM-g=w2400)
#### 4. 填上php.exe的位置並儲存(Ctrl + S)
##### 本篇使用XAMPP所以位置在./XAMPP/php/php.exe
![PHP_Setting_4.png](https://lh3.googleusercontent.com/zmKu01uwk9vao8Db5Fk8w0dR1fTI7mNQ-lohU39pCvyofVCcqiaGRLydPpti8IaODGq7rm4JBMUpZ21LJyWzzLOv05eVTvVMyrZFOwMx0Ft3x0tJNFtR3mjr-yaGxeCmxzDcJKbqTA=w2400)
### Live Server
#### 1. 安裝
![Live_Server.png](https://lh3.googleusercontent.com/eA1ZuTrlSn3nDIzv4mPhQ9wQKHGxh_m0tojYFvAM4Tswk3Kt0TvdCAFF8FGrXO1AMuMqUbo1Ywx4O4uSsTliF3v-U1VyMfDMvRsmHS9CVMW4WwewJ_Y2bqopT5gihXPGoTqO8ntdkA=w2400)
#### 2. 設定
![Live_Server_Setting_1.png](https://lh3.googleusercontent.com/kIA20s0j7FJmT9kY2npQv844IMZR7qXpOviPHKRcTVUYmY_YjLZGvCXMKQ_MUvH46_bjTy7SPqWym2h1ZGI8vY_zyhzSNQsbMHJLuDyfuVprHsNyMHSHHZps1kNMSGM4kFRi-CDbQg=w2400)
##### 把Use Web Ext打勾
![Live_Server_Setting_2.png](https://lh3.googleusercontent.com/Xh6UQG78SAVx4xp4BqiUNQgnfYGsh79Luncx0_LRbVD-jqMU9hBCOmx05kt86F_w89QdK8St5f63G4d8dosTzb5UxSgZVGIDKH4vGMbYFXojYfqy71O0esH9uDlRthj6_WgUQpozGg=w2400)
##### 或者直接在settings.json裡面新增以下程式碼(等同於上面打勾)
```json
"liveServer.settings.useWebExt": true
```
#### 3. 在chrome中安裝Live Server Web Extension
![Live_Server_Setting_3.png](https://lh3.googleusercontent.com/zLLCaTbOXrpXEajiC3qvNNBg3RuGVCePi4CE9rFmJ7Hc9PqB12zU0v1NK-GadGDr5D7S9xKH2-GvCZIxifT23Ag_j4jOh00MMLYNbeW2qFcinocY4Cm5N54OQwgPsUMk6MPRXulu7Q=w2400)
#### 4. 設定Live Server Web Extension
##### 開啟.php並按Go Live
![Live_Server_Setting_4.1.png](https://lh3.googleusercontent.com/zWxOEitmtJcPvH4i1hN-NlVlBGzPGp9wi2v5TqsZgYE9AKuSVFZGxDqbpvqZ-es7hUlgcEiXlWSHRR3DjWuemxFcbf49OgIzTNjIjRxQBnejEwjFRXy2nLmgsRhpQGSmSttE9eaJLQ=w2400)
##### 複製上面網址貼到Live Server Address
![Live_Server_Setting_4.2.png](https://lh3.googleusercontent.com/U-D-uKXWWfnRFS4maTndiB9kD3Yld1IGtSzshjQ43A6kWzzhp-RGxGoY0zhCpqVrbaBxFXZkayEp7XaoRfAbNusXOiL89rvGW7yTtB2PzdnuTvaeWj2_jTiD-zx91fvPf3bcqXVgvQ=w2400)
##### Actual Server Address 打上`http://localhost/`，並按下Apply儲存
###### ps.使用時要把Live Reload打開
![Live_Server_Setting_4.3.png](https://lh3.googleusercontent.com/rUe6benIlrmOrKvTpERGST5Q7v1yUDgnVxssJGXxPx2U3pGiUH5ZFr7mnWCthN7q5RrYiiVcEH0QQtsE01PJBdJC8jv-G0oE_Ei_FfILxKc8K7Z6QywseeYhdjrgBCrZQ-TCqpcZAw=w2400)

## Run
#### 1. 開啟XAMPP並執行Apache
![Run_1.1.png](https://lh3.googleusercontent.com/DGnNDRtDQAhrEjMCbLxpKQvNUMA9StFET56u8cOTkeB3k7e51udskXy8zpVdr7hbJHs1jLsDDuxnSrGa41sHQyG6f_GypuaIue-uycGqEwEM4VooenUUeMMD9qQZL66pTcIJCO7ZCA=w2400)
![Run_1.2.png](https://lh3.googleusercontent.com/gIYVT4-zR6OriB6GDugRuLQ3snFZsBygPntoKCH6V4d4ansQhZJ9UNXi5hlWz6juEOqxOYiBgtu0MKhxoGFkkLDpwfqX4oJlLuE7KtmO1pGquOeNCG8BHIQAdXTZaDtp0CYzIPcXtw=w2400)
#### 2. 在網頁輸入localhost/XXX.php並送出
![Run_2.1.png](https://lh3.googleusercontent.com/uvZaItOyH_eXnXzFY5ixnCmeCKD9Vm9fkH1cSrumKpN-yJxfvWAfeQ2xOCwdnRW2UP8C-_TcPG7M2MfxTGuzrKLaibv6YcQ2nCsLJF9H3dJylMjRoA1xf_aUzP6E_y57-3zPtGAuBA=w2400)
##### 成功執行.php
![Run_2.2.png](https://lh3.googleusercontent.com/RfoiIOKk_0AycYT7Xmwls6r89s2C-hPtnUapw3INmEA39rc21_zpdBfnelo0aeEklXE2Up_4kiW9QsiYxqvOSegc25KT2M17qRhVcpS0355Kqd3IKzc7byP-mXhMCca5dClW9tUd3w=w2400)
#### 3. 會隨著php更新跟著一起變動就表示PHP&Live Server成功
![Run_3.png](https://lh3.googleusercontent.com/2QD3-k2wH-rmviVtI9QzwRf2ZPmTvpB441ncklgqsWlkdvowTe4fgzT8nTIcFS_X4x6Xvg2YC8ALysH7hfBX_D0phBEcfuYnVCl95ttJHFoscoLg8J_oqoFckIqsb0m0TSpITyJHSQ=w2400)