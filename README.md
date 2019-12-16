# 深入淺出 - Android 開發

1.官方網址隨書附贈<br>
http://dogriffiths.github.io/HeadFirstAndroid<br>

2.官方 github 隨書附贈<br>
https://github.com/dogriffiths/HeadFirstAndroid<br>

# 第一章 - 第一章開始探索 Android
1.簡單介紹 android<br>
2.建立一個空白專案<br>
3.建立 AVD 模擬器<br>
4.介紹 layout<br>
5.介紹 strings.xml<br>
6.參考網址<br>
https://tinyurl.com/HeadFirstAndroid<br>
https://github.com/dogriffiths/HeadFirstAndroid<br>

# 第二章 - 建立互動式 APP
1.使用 layout 元件<br>
2.拉介面<br>
3.使用字串資源<br>
4.簡易使用 TextView<br>
5.簡易使用 Spinner 參照 String-array<br>
6.為按鈕設定事件，在 xml 使用 onclick 呼叫方法<br>
7.在 activity 寫入 onclick 方法<br>
8.封裝<br>
9.自訂義類別<br>
10.自訂義方法<br>

# 第三章 - 多個 Activity 與 Intent 陳述你的意圖
1.多個 Activity 透過 Intent 溝通<br>
2.建立多個 Activity ，替多個 Activity 和 layout 做設定<br>
3.描述 manifests 與 Activity 和 layout 的關係<br>
4.描述 Intent 功能<br>
5.透過 Intent 溝通同一隻 APP 的 Activity<br>
6.透過 Intent 溝通不同隻 APP 的 Activity<br>
7.Intent action 活動動作詳細參考網站如下<br>
8.使用實機測試<br>
9.開啟實機 USB 偵錯<br>

# 第四章 - Activity 的生命週期
1.activity 執行的過程<br>
2.撰寫計時器 APP<br>
3.handle 的使用方式以及介紹<br>
4.post()<br>
5.postDelayed()<br>
6.螢幕反轉，APP 重製的原因與解決辦法<br>
7.生命週期<br>

# 第五章 - 使用者介面
1.RelativeLayout 相對布局<br>
2.LinearLayout 線性布局<br>
3.GridLayout 網格布局<br>
4.內邊距 (padding)<br>
5.資源檔設定距離供直接使用<br>
6.外邊距 (margin)<br>
7.gravity 屬性<br>
8.layout_gravity 屬性<br>
9.GUI 的好處<br>
10.TextView<br>
11.EditText<br>
12.Button<br>
13.Toggle Button<br>
14.Switch<br>
15.CheckBox<br>
16.核取方塊<br>
17.Radio Button<br>
18.Spinner<br>
19.ImageView<br>
20.ImageButton<br>
21.ScrollView<br>
22.Toast<br>

# 第六章 - 列表視圖與適配器
1.分層概念 <br>
2.圖像資源 <br>
3.ListView <br>
4.ListActivity <br>
5.布置練習專案 starbuzz <br>

# 第七章 - 模組化 Fragment
1.各種裝置適應性<br>
2.使用 java 程式碼設計 layout<br>
3.fragment 生命週期<br>
4.Fragment 基本規則<br>
5.使用系統的 ListFragment<br>
6.使用 ArrayAdapter 設定 ListView<br>
7.介面 (ubterface)<br>
8.返回堆疊(back stack)<br>
9.使用 fragment 交易<br>
10.fragment 旋轉裝置毀壞的解決辦法<br>
11.根據裝置設定不一樣的 java 和 layout<br>
12.利用布局差異辨識裝置<br>

# 第八章 - 嵌套式 Fragment
1.actiity 與 fragment 差異<br>
2.fragment 可以包含其他 fragment<br>
3.子父 fragment 的關係，必須透過程式化增加<br>
4.fragment 嵌套式交易 (getChildFragmentManager() )<br>
5.onclick 無法再嵌套式使用的原因與解決辦法<br>
6.在 fragment 實作 OnclickListener<br>
7.將 OnclickListner 附加到按鈕<br>
8.旋轉螢幕 Fragment 會錯誤的原因與解決辦法<br>


# 第九章 - ActionBar 走捷徑
1.清楚的結構<br>
2.介紹 action bar<br>
3.theme 主題<br>
4.android 支援程式庫<br>
5.定義主題與在 AndroidManifestt.xml 使用主題<br>
6.不同 API Leverl 使用不同的 styles<br>
7.增加 action item 到 action bar<br>
8.menu 資源檔<br>
9.icon pack icon 支援包網址 https://developer.android.com/design/downloads/index.html<br>
10.action bar 分享<br>
11.up 導覽<br>
★ActionBar 不更新請更改使用 Toolbar<br>

# 第十章 - NavigationDrawer
1.navigation drawer 解構<br>
2.實作 BitsAndPizzas<br>
3.介紹 Navigation Drawer<br>
4.使用 ActionBarDrawerToggle<br>
5.讓 Navigation Drawer 開啟予關閉<br>
6.標題與 fragment 不同步<br>

# 第十一章 - SQLite 資料庫
1.介紹 SQLite<br>
2.建立資料庫<br>
3.使用結構化查詢語法建立資料表<br>
4.insert() 插入<br>
5.update() 更新<br>
6.delete() 刪除<br>
7.SQLite 執行過程<br>
8.更新與變更資料庫<br>
9.onUpgrade() 升級資料庫<br>
10.onDowngrade() 降級資料庫<br>
11.升級既有資料庫<br>
12.新增資料欄位<br>
13.變更資料欄位<br>
14.更名與刪除資料表<br>
★Android 官方推薦資料庫新技術 「Room」替代 「SQLite」

# 第十二章 - Cursor 與 AsyncTask
1.使用 Cursor 從資料庫讀寫資料<br>
2.資料庫查詢 SQLiteDatabase 的 query()<br>
3.資料庫查詢相關網站 http://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html<br>
4.指定資料表與欄位查詢<br>
5.多條件查詢<br>
6.查詢資料並排序<br>
7.查詢中使用 SQL 語法<br>
8.Group by (分組)與 having (函數判斷) 語法<br>
9.getReadableDatabase() 與 getWritableDatabase()<br>
10.操作 cursor<br>
11.關於 cursor 操作可參考 http://developer.android.com/reference/android/database/Cursor.html<br>
12.CursorAdapter <br>
13.SimpleCursorAdapter<br>
14.Cursor 不會自動更新，使用 ChangeCursor() 更新<br>
15.資料庫搭配執行緒優化 APP<br>
16.執行緒使用時機<br>
17.介紹 AsyncTask 非同步執行緒<br>
18.OnPreExecute()<br>
19.doInBackgroud()<br>
20.OnProgressUpdate()<br>
21.OnPostExecute()<br>
22.執行 AsyncTask <br>
23.AsyncTask 步驟摘要<br>

# 第十三章 - Service 聽候差遣
1.介紹 Service<br>
2.介紹 Started service<br>
3.IntentService 建立與概觀<br>
4.實作 Joke<br>
5.紀錄日誌訊息<br>
6.在 AndroidManifest.xml 註冊 Service 服務<br>
7.使用 startService() 啟動 service 服務<br>
8.Service 使用 Toast 顯示訊息<br>
9.Service 使用 notification 顯示訊息<br>
10.使用 notification service<br>
11.關於 notification 細節可參考網站 https://developer.android.com/reference/android/app/Notification.Builder.html <br>
12.透過 notification 啟動 App<br>
13.介紹 Bound Service<br>
14.實作 Odmeter<br>
15.介紹 APP 如何和 Service 聯繫運作<br>
16.Service 類別有四個關鍵方法<br>
17.註冊 LocationListener<br>

# 第十四章 - Material Design 活在真實世界裡
1.介紹 Material Design<br>
2.介紹 CardView 與 RecyclerView<br>
3.實作 BitsAndrPizza_MaterialDesign<br>
4.使用 CardView<br>
5.使用 RecycleView<br>
6.使用基本適配器<br>
7.定義適配器的 ViewHolder<br>
8.RecyclerView 使用佈局管理器安排視圖元件<br>
9.指定佈局管理器<br>
10.讓 RecyclerView 回應<br>

# 附錄
1.android Runtime(ART)<br>
2.Android Debug Bridrge<br>
3.模擬器<br>
4.沒有介紹的技術<br>
A.發布 APP<br>
B.Content provide<br>
C.WebView<br>
D.動畫<br>
E.地圖<br>
F.Cursor Loader<br>
G.Broadcast Receiver<br>
H.APP Widget<br>
I.NinePatch 繪圖<br>
J.測試 <br>
關於測試可以參考 http://d.android.com/tool/testing/testing_android.html<br>
進階測試可以參考 https://code.google.com/p/robotium/<br>
