CREATE DATABASE TopicMana;

USE TopicMana;
CREATE TABLE Subject
(
subjectID varchar(10) primary key,
subjectName VARCHAR(200) not null
);
CREATE TABLE TypeOfTopic
(
typeID varchar(10) primary key,
typeName VARCHAR(200) not null
);
CREATE TABLE Topic
(
topicID varchar(10) primary key,
topicName VARCHAR(200) not null,
topicRequire VARCHAR(200),
topicGoal VARCHAR(200),
schoolYear int,
typeID char(10) REFERENCES TypeOfTopic(typeID),
subjectID char(10) REFERENCES Subject(subjectID)
);
USE topicmana;
INSERT INTO subject VALUES("SU001","Công nghệ phần mềm");
INSERT INTO subject VALUES("SU002","Mạng máy tính");
INSERT INTO subject VALUES("SU003","Hệ thống thông tin");

INSERT INTO TypeOfTopic VALUES("TO001","Tiểu luận chuyên ngành | K14 (2014 - 2019) | Học kỳ 1 (2017-2018)");
INSERT INTO TypeOfTopic VALUES("TO002","Đề tài tốt nghiệp | K14 (2014 - 2019) | Học kỳ 2 (2017-2018)");
INSERT INTO TypeOfTopic VALUES("TO003","Tiểu luận chuyên ngành | K17 (2017 - 2022) | Học kỳ 1 (2020-2021)");
INSERT INTO TypeOfTopic VALUES("TO004","Tiểu luận chuyên ngành | K19 (2019 - 2024) | Học kỳ 1 (2022-2023)");

INSERT INTO Topic VALUES("TP001","Máy phát nhạc MP3 trên nền kit nhúng", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2014, "TO001", "SU002");
INSERT INTO Topic VALUES("TP002","Hệ thống cảnh báo bằng phát hiện chuyển động trên kit nhúng Raspberry Pi", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2014, "TO001", "SU002");
INSERT INTO Topic VALUES("TP003","Tìm hiểu Công nghệ PHP Laravel Framework và xây dựng Website kinh doanh thời trang nam, nữ kiểu mới", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2014, "TO001", "SU001");
INSERT INTO Topic VALUES("TP004","Tìm hiêu Công nghệ SpringBoot, Thymeleaf và xây dựng Website học trực tuyến", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2014, "TO001", "SU001");
INSERT INTO Topic VALUES("TP005","Tìm hiểu cơ chế chuyển đổi lưu trữ dữ liệu từ dạng quan hệ sang dạng NoSQL.", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2014, "TO001", "SU003");
