create table test_sys_user(
	user_id bigint PRIMARY key auto_increment,
	login_no varchar(50) not null unique,
	user_name varchar(255) not null,
	user_amount DECIMAL(10,2) not null DEFAULT 0.00,
	create_time TIMESTAMP not null DEFAULT current_timestamp
)