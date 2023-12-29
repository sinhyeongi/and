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
# 2-2. 캐릭터 선택 : slect_characters
<pre>
  <code>
    캐릭터 선택 버튼에 따라 sharedPreferences 에 해당 캐릭터 이미지 아이디 값을 저장 후 게임의 메인 화면으로 이동    
  </code>
</pre>

# 2-3. 불러오기 : select_Load
<pre>
  <code>
    sharedPreferences에 Save1_level...Save3_level 이 0보다 크면 로드 화면에 정보를 출력  
    정보가 있는 경우에만 버튼을 클릭할 수 있음
    해당 정보 로드시 데이터를 sharedPreferences에 Save?_를 땐 형태로 저장 후 게임 매인 화면 으로 이동
  </code>
</pre>
# 3. 게임 메인 화면 : MainActivity
<pre>
  <code>
    state,save플래그먼트를 소유하고있으며
    money쓰레드를 메인과 같이 실행하여 1초 마다 1의 money를 획득 하며 runOnIUThread를 통해 UI를 업데이틑 시켜 준다
    
    boottomNavigationView.OnNavigationItemSelectedListener를 상속 받은 ItemSelectedListener의 onNavigationItemSelected를 통해 해당 이벤트를 실행
    해당 버튼 클릭시 메인 화면의 뷰를 안보이게 설정 후 버튼에 해당 하는 플레그먼트를 띄워줌
    if_transaction은 state , save 메뉴를 띄워둔 상태에서 다시 해당 버튼 클릭 시 메뉴를 안보이게 설정 후 게임메인 화면으로 전환
    else_transaction 은 메인화면에서 state, save메뉴 선택 시 해당 화면을 띄우며 메인 메뉴를 안보이게 바꾼다
    
    정보는 현재 캐릭터의 스탯 (체력, 방어력 등)을 보여준다
    스탯은 게임의 money를 사용 하여 스탯을 증가 시키며 보유 돈 보다 버튼의 text가 높을 경우 스탯이 증가 하지 않는다
    저장은 1~3번 슬롯이 있으며 난이도 슬롯 번호 레벨 ,돈 을 보여 주며 현재 가지고 있는 플레이어 정보를 Save(슬롯번호)_(스탯이름)으로 저장한다
    
    
    휴대폰의 뒤로가기를 누를 경우 다시 종료할 것인지 확인 하며 홈으로 와 종료 버튼을 선택하게 한다
    홈으로 선택시 저장 하지않고 바로 First_layout(첫 시작 화면)페이지로 이동한다
    종료 선택 시 앱을 바로 종료 한다
    
    레이드 버튼 클릭시 Cutom_Dialog를 띄우며 sharedPreferences에 보스 클리어 값 (기본 값 : 0) 에 따라 선택 할 수 있는 보스 스테이지가 결정
      0 -> raid1만 선택 가능
    
    Cutom_Dialog의 버튼은 onclic이며
    onclick -> 레이드 1 ~ 3 중 버튼에 해당하는 페이지 ex raid1 으로 이동하여 레이드를 진행
      레이드 정보는 sharedPreferences에 저장되어있으며 1단계를 클리어 후 2단계가 열리며 2단계 클리어 후 3단계가 열린다
    미니게임 버튼
      버튼 클릭시 현재 3개의 게임 중 한개로 이동 하게 되며
      1번 게임 15초가 터치한 만큼의 money를 얻게 된다
      2번 게임 가운데 버튼이 있으며 버튼 클릭시 0~100 + 캐릭터 행운 * 0.2 의 돈을 획득 한다 -> 현재 오류로 사용 불가 상태
      3번 게임 가운데 카드가 뒷면 상태로 있으며 0~6번 버튼을 클릭 할 수있다 
        랜덤 한 카드 값을 맞추게 되며 틀릴경우 Toast를 통해 틀렸습니다 를 띄어준다
        정답시 정답입니다 를 출력
        버튼 클릭을 모두 불가능 하게 만든 후 3초후 메인 페이지로 이동하게 된다
    
      
    
  </code>
</pre>
