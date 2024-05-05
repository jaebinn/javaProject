create database kh;
drop database kh;

use kh;

create table Manager(
	managerid varchar(300) primary key,
    managerpw varchar(300) not null
);

insert into Manager values ("manager", "1234");
delete from manager;


create table teacher(
	teacherid varchar(300) primary key,
    tea_pw varchar(300) not null,
    tea_name varchar(300) not null,
    tea_age int not null,
    tea_gender varchar(300) not null,
    tea_phone varchar(300) not null
);
insert into teacher values ("teacher", "1234", "강사", 23, "남", "010");

create table student(
	studentid varchar(300) primary key,
    stu_pw varchar(300) not null,
    stu_name varchar(300) not null,
    stu_age int not null,
    stu_gender varchar(300) not null,
    stu_addr varchar(300) not null,
    stu_major varchar(300),
    stu_phone varchar(300) not null
);

create table classroom(
	classroomid varchar(300)primary key,
    cr_location varchar(1000) not null,
    cr_student int not null
);
insert into classroom values("U", "U", "30");

create table lecture(
	lectureid int primary key auto_increment,
    lec_name varchar(300) not null,
    lec_beginday varchar(300),
    teacherid varchar(300),
    classroomid varchar(300),
	constraint l_t_fk foreign key (teacherid) references teacher(teacherid),
	constraint l_c_fk foreign key (classroomid) references classroom(classroomid)
);


create table course_list (
	cl_id int primary key auto_increment,
    lectureid int,
    studentid varchar(300),
	constraint cl_l_fk foreign key (lectureid) references lecture(lectureid),
    constraint cl_s_fk foreign key (studentid) references student(studentid)
);

create table announcement(
	announcenum int primary key auto_increment,
    am_title varchar(300) not null,
    teacherid varchar(300),
    constraint a_t_fk foreign key (teacherid) references teacher(teacherid),
    am_detail text(30000) not null,
    am_view int default 0,
    regdate datetime default now()
);



create table comment(
	commentnum int primary key auto_increment,
    announcenum int,
    studentid varchar(300),
	constraint cm_a_fk foreign key (announcenum) references announcement(announcenum),
	constraint cm_s_fk foreign key (studentid) references student(studentid),
    comment_detail varchar(3000) not null
);

create table messenger(
	msg_num int primary key auto_increment,
    msg_title varchar(1000) not null,
    cl_id int,
	constraint m_cl_fk foreign key(cl_id) references course_list(cl_id),
    sendtime datetime default now(),
    msg_detail varchar(1000) not null
);



create table quiz(
	quiznum int primary key auto_increment,
    quiz_type varchar(300),
    quiz_title varchar(300),
    quiz_detail text(30000),
    quizans text(30000)
);

create table answer(
	answerid int primary key auto_increment,
    cl_id int,
    quiznum int,
	constraint a_cl_fk foreign key(cl_id) references course_list(cl_id),
    constraint a_q_fk foreign key(quiznum) references quiz(quiznum),
    stu_answer text(30000),
    regdate datetime default now()
);

create table grading(
	 quiznum int,
     answerid int,
	 constraint s_q_fk foreign key(quiznum) references quiz(quiznum),
	 constraint s_a_fk foreign key(answerid) references answer(answerid),
     score int
);




