# 1. 屬性
![屬性](https://lh3.googleusercontent.com/vOs1FMD0c3eHEmVpGyoEfCCeJGRiw5GUVsbq819k0pgT9WTDkxRSZAhk8JGllwEiwqXcvoOEmvX5Dp0jLdVCJ_xaxqvO388hL9K9ByEZRuStk5MSuPP4ZSgG9cvjV40h7GqkJVNu8w=w2400)
***
# 2. 選擇x64
![平台](https://lh3.googleusercontent.com/6xG4PdqciEm5qOenxsYLFi3yqHjGV5k4ctMwltbXMIO1NmyO_F-mQuG2aDwkKJVPWtKTixJFtBTIBQjkggoADCdvF5yUjIa3AZ_pk4kKV3Q6luJhYSlYrwAq5xmPboXq9MN0SVH4zw=w2400)
***
# 3. 設定include來源
![include](https://lh3.googleusercontent.com/74roac1GaHFgX4I5Y5grfAQi7KFlUq5jdWZTncBy3n5KDJ_vrCBz7jjrHdZ4v6xYERZhjIK-Mn07FVeP1Y2LvuF8orTxHRRQrrwvFl6Vy-5PIKqBus-oXvfDb5o6mrgY2OQ8YerrQw=w2400)
![include](https://lh3.googleusercontent.com/TO60TQpxM_kqHTiOQ7o9ZliQLNYzPzl_jSLq703_H4HnrpL29FrMIp5FYOIeMdAGle5x2RwPUpjpUijt7e1-xecC4LwCKg4liWiijO5xnHfesKGT5lCtNSM_bSnlz8PO8FPIV0CI6A=w2400)
![include](https://lh3.googleusercontent.com/1MXxha4gmDctXovX_I-tlClVf531BZJbZeH6MSn88jM1cRl13vMYhTI_o2aIVJSFK2dudsyBOo2jLFXNv-Yt1k5O82dbXHYZ02O6t7XWYQLEynG9urNSHzyJlHhD3Hdyh5l1_LQH5A=w2400)
***
# 4. 設定lib來源
![lib](https://lh3.googleusercontent.com/quH6JIlJNf-V0eOUIFFkFuiKKxFX6hYU9IssdOLRsq1tcZhTNuRvWTTJrodpDszkkauQ1mQFZ6Z9-9AQ6SEa1lADFp6LBPxdvMhvkc6Cx6lmcOWAAwJ4-6B7G8FTuWP_5v9d4LgPgg=w2400)
![lib](https://lh3.googleusercontent.com/GK8zSfxpa04GLDIYb2I7VnCmrs3PUfhijtGl3cNPDTbtscQnlFT1JghsONOzAC3pvYrFH5_cabV4aSgmLO6Bbh4SgUMrvhm04TSMSEpBqYQslzlFpwoH0sI3vtrLY0-bIcR89cAQzA=w2400)
![lib](https://lh3.googleusercontent.com/2PwaSbSB_p1bk_gBY2HBKB1IVXfJI6BoLawmNUDrMtySAaeTSA1tgjacPUptikF23ss2tKhGT7ohUcP7vw7z7Ym1rGslwd_VtCvo3o_aC18PqWcQCIXBxoPCYvly8TSQJ498AY3kOw=w2400)
![lib](https://lh3.googleusercontent.com/dE6gi6KYyZ_Ivh-TX2Edv8MZ3qhojI8PNViZAZYJ-B_c30Y9ynVK62U7jm9eOY_ZxFVEyP_GwIJsHdOu5JgTh1EsU91CVUsxf__GQ8ScHzdxEwaQHVv0nHPbD9iK2WnVex_YHA-chQ=w2400)
![lib](https://lh3.googleusercontent.com/Jwkrve2QYeQtxs49LvRLazNhLI45l6tF_gXSaNTWB-P3TbrIKTyZ4tKm10RQWVi1LGelEETFpaA2AvgNIGWTvmG42iPu0QhtzBugVx5qLc2jR8hTeggL0eu-AM1kCSa5NSZEjNkPMA=w2400)
***
# 5. 將dll和執行檔放在一起
### 5-1. 手動複製
![dll](https://lh3.googleusercontent.com/DU5IWFZgcJsrQZkAzbJ-R1FihzVhe5FhJpVORmZW7d_3DZ1ZoRrK6lAXuJMCkS-QtG6lS2nuW46Er5NE_eOcAggaoEpf_yj3AECS-qe_SRDrFSZVRpQ-8yDm96cMyObmNiiImamIVg=w2400)
### 5-2. 建置時命令複製
```cmd
xcopy /y /d "C:\Program Files\MySQL\MySQL Server 8.0\lib\libmysql.dll" "$(OutDir)"
```
![dll](https://lh3.googleusercontent.com/Z0wD1voJzY56j6nabT9Jb9fJQuUZBc5ard9PTLXNYxzj54cMPlDsIZ_-E_I6j4bvfqYqhLWBKhgqJHyDmuxftbj6GJ1qvHPdrdTvUdGOiq4PNmI7egEDu9e_RrfDvGdpKj-vuewXmQ=w2400)