방치형 게임<br/><br/>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-게임 화면<br/>
<table align= "center">
  <th>메인화면</th><th>레이드</th><th>세이브</th>
  <tr>
    <td><img src="https://user-images.githubusercontent.com/106128885/212598693-d981a860-89e3-47c2-aede-b8e063dc7c5f.jpg" style="max-width : 100%;"></td>
    <td><img src="https://user-images.githubusercontent.com/106128885/212598727-aba5cafd-7fa2-44d2-b26d-086ad095f326.jpg" style="max-width : 100%;"></td>
    <td><img src="https://user-images.githubusercontent.com/106128885/212598734-12fd42ea-39cb-46a9-a24b-392143ac4cf7.jpg" style="max-width : 100%;"></td>
  </tr>
</table>

# 1. 초기 시작 페이지 : First_Layout

<pre>
  <code>
    화면을 누를 경우 intente를 통하여 First_Select로 이동
    데이터 저장 
      - sharedPreferences 를 통하여 Key : value 값으로 저장
    
  </code>
</pre>

# 2. 메인 화면 : First_Select
<pre>
  <code>
    새로시작
      - intente를 통해 slect_new 레이아웃 페이지로 이동
    불러오기 
      -intente를 통해 slect_load 레이아웃 페이지로 이동
    종료 
      -앱 자체를 종료 시킴
  </code>
</pre>
# 2-1. 새로 시작 : slect_new
<pre>
  <code>
    난이도 버튼을 누를 경우 난이도를 저장 후 캐릭터 선택 ( Select_characters로 이동)
  </code>
</pre>
