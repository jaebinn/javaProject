#자바 프로젝트
콘솔창으로만 이뤄진 프로젝트입니다.

팀 이름
GGUKBBI

View(화면)

> KH 소개			**크롤링
> 오시는 길		**크롤링

1. 회원가입
   - 강사용
   - 학생용

2. 로그인
   - 관리자
	1. 강의관리
	 ① 강의조회
	  > 조회 (리스트 lectorid) (이름: lec_name / 반: classroomid / 시작: lec_beginday / 강사: teacherid)
	  A. 수정/삭제하기
		a. 강의수정
			가. 이름
			나. 반
			다. 시작
			라. 강사
	  	b. 강의삭제
			- 삭제 (이름, 반, 시작, 강사 ")
	  B. 뒤로가기

	 ② 강의개설
	   A. #추가 (이름: lec_name / 반: classroomid / 시작: lec_beginday / 강사: teacherid)
	   B. 뒤로가기

	 ③ 뒤로가기
	  
	2. 수강생관리
	 > 강의 (리스트 lectureid) (lec_name)
	 ① 강의 선택
	  > 수강생 (리스트 순서) (studentid / stu_name)
	  A. 수강생 선택
	   > 인적사항 (studentid, stu_name, stu_age, stu_gender, stu_addr, stu_major, stu_phone)
	   	a. 뒤로가기
	   	b. 삭제 (해당 학생 studentid 삭제 후, 수강신청 course_list 삭제)
	 ② 뒤로가기(-1)

	3. 시험관리
	 ① 조회(quiznum) (제목: quiz_title)
	  A. 번호 선택하기
		> 상세히 보기 (quiz_title, 내용: quiz_detail, 답안: quizans)
		a. 삭제
		b. 뒤로가기(-1)
	  B. 뒤로가기(-1)
	 ② 등록
	  - #추가(quiz_title, quiz_detail, quizans)
	 ③ 뒤로가기

	4. 로그아웃


   - 강사용
	1. 학생 (리스트 순서) (studentid, stu_name)
	 > 인적사항(studentid, stu_name, stu_age, stu_gender, stu_major, stu_phone)
	2. 공지사항
	 ① 공지사항(리스트 announcenum) (제목: am_title)
	  A. 공지사항 선택
	   	> 상세히보기 (announcenum, am_title, 내용: am_detail, 조회수: am_view, 시간: regdate)
	   	> 댓글 (stu_name, studentid, comment_detail)
			a. 공지사항 수정
			 가. 제목
			 나. 내용
			b. 공지사항 삭제 (해당 댓글 comment 삭제 후, announce 삭제)
	  		c. 뒤로가기(-1)
	  B. 뒤로가기(-1)
 	 ② 등록
	  - #추가 (am_title, am_detail)
	 ③ 뒤로가기

	3. 시험관리
	 > 시험 분류(quiz_type)
	 ① 분류 선택
	   > 해당 분류 시험 조회 (리스트 quiznum) (quiz_title)
	   A. 시험 선택 (quiz_title, quiz_detail, quizans)
	     > 푼 학생 (리스트 순서) (studentid, stu_name)
	     a. 학생선택
	       > 자세히보기 (학생 답: stu_answer, 입력시간: regdate)
	       가. 채점하기 (score)
	       나. 뒤로가기
	     b. 뒤로가기
	   B. 뒤로가기
	 ② 뒤로가기

	4. 메신저
	 ① 메신저 조회
	  > 조회(리스트 msg_num) (제목: msg_title, 보낸사람: studentid, 보낸시간: sendtime)
	  A. 번호선택
		> 상세히 보기 (msg_title, stu_name, studentid, sendtime, msg_detail)
		a. 답장하기 (제목: msg_title, 내용: msg_detail / 받는사람 = 보낸사람)
		b. 삭제
		c. 뒤로가기
	  B. 메신저 삭제
		a. 전체삭제
		b. 일괄삭제
		 - 삭제 첫번째 번호, 마지막 번호 입력받기
		c. 단일삭제
		 - 삭제 번호 선택
		d. 뒤로가기
	  C. 뒤로가기
	 ② 메신저 보내기
	  A. #입력 (받는사람: studentid, 제목: msg_title, 내용: msg_detail)
	  B. 뒤로가기(String으로 -1 받기)
	 ③ 뒤로가기

	5. 내 정보
	 > 조회 (teacherid, tea_pw, tea_name, tea_age, tea_gender, tea_phone, lec_name, cr_location)
	 ① 개인정보 수정
	  A. 비밀번호
	  B. 전화번호
	 ② 뒤로가기
	6. 로그아웃

   - 학생용
	1. 공지사항 보기
	 > 조회 (리스트 announcenum) (제목: am_title)
	 A. 선택
	  > 상세히 보기 (announcenum, am_title, 내용: am_detail, 조회수: am_view, 시간: regdate)
	  > 해당 댓글 (stu_name, studentid, comment_detail)
	  > 내 댓글 리스트(commentnum) (stu_name, studentid, comment_detail)
	  	a. 내 댓글 삭제
		b. 뒤로가기(-1)
	 B. 뒤로가기(-1)

	2. 메신저
	 ① 메신저 조회
	  > 조회(리스트 msg_num) (제목: msg_title, 보낸사람: teacherid, 보낸시간: sendtime)
	  A. 번호선택
		> 상세히 보기 (msg_title, teachername, sendtime, msg_detail)
		a. 답장하기 (제목: msg_title, 내용: msg_detail / 받는사람 = 보낸사람)
		b. 삭제
		c. 뒤로가기
	  B. 메신저 삭제
		a. 전체삭제
		b. 일괄삭제
		 - 삭제 첫번째 번호, 마지막 번호 입력받기
		c. 단일삭제
		 - 삭제 번호 선택
		d. 뒤로가기
	  C. 뒤로가기
	 ② 메신저 보내기
	  A. #입력 (제목: msg_title, 내용: msg_detail / 받는사람 = 내가 듣는 강의의 강사님)
	  B. 뒤로가기(String으로 -1 받기)
	 ③ 뒤로가기

	3. 시험
	 > 시험 분류(quiz_type)
	 ① 분류 선택
	   > 해당 분류 미제출 시험 조회 (리스트 quiznum) (quiz_title)
	   > 해당 분류 제출 시험 조회(리스트 quiznum) (quiz_title, score)
	   A. 미제출 시험 번호 선택시
	    > 상세히보기(quiz_title, quiz_detail, quizans)
	    - 답 입력하기
	    - 뒤로가기
	   B. 제출 시험 번호 선택시
	    > 점수 (quiz_title, quiz_detail, quizans, score)
	    - 뒤로가기
	   C. 뒤로가기
	 ② 뒤로가기
	4. 내 정보
	 > 조회 (studentid, stu_pw, stu_name, stu_age, stu_gender, stu_addr, stu_major, stu_phone, lec_name, cr_location)
	 - 개인정보 수정
		a. 전화번호
		b. 주소
	5. 로그아웃

3. 나가기
