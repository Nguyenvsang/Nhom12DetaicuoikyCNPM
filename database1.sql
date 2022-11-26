CREATE DATABASE TopicMana;

USE TopicMana;
CREATE TABLE Subject
(
subjectID INT AUTO_INCREMENT primary key,
subjectName VARCHAR(200) not null
);
CREATE TABLE TypeOfTopic
(
typeID INT AUTO_INCREMENT primary key,
typeName VARCHAR(200) not null
);
CREATE TABLE Topic
(
topicID INT AUTO_INCREMENT primary key,
topicName VARCHAR(200) not null,
topicRequire VARCHAR(200),
topicGoal VARCHAR(200),
schoolYear int,
typeID varchar(10) REFERENCES TypeOfTopic(typeID),
subjectID varchar(10) REFERENCES Subject(subjectID)
);
CREATE TABLE Lecturer
(
username VARCHAR(200),
password VARCHAR(20) not null,
lecturerID INT AUTO_INCREMENT primary key,
lecturerName VARCHAR(200) not null,
citizenID VARCHAR(20) not null,
gender VARCHAR(3) not null,
dateOfBirth Date not null,
email VARCHAR(200),
phoneNumber VARCHAR(20),
professionalQualification VARCHAR(200)
);
USE topicmana;
INSERT INTO subject (subjectName) VALUES("Công nghệ phần mềm");
INSERT INTO subject (subjectName) VALUES("Mạng máy tính");
INSERT INTO subject (subjectName) VALUES("Hệ thống thông tin");

INSERT INTO TypeOfTopic (typeName) VALUES("Tiểu luận chuyên ngành | K14 (2014 - 2019) | Học kỳ 1 (2017-2018)");
INSERT INTO TypeOfTopic (typeName) VALUES("Đề tài tốt nghiệp | K14 (2014 - 2019) | Học kỳ 2 (2017-2018)");
INSERT INTO TypeOfTopic (typeName) VALUES("Tiểu luận chuyên ngành | K17 (2017 - 2022) | Học kỳ 1 (2020-2021)");
INSERT INTO TypeOfTopic (typeName) VALUES("Tiểu luận chuyên ngành | K19 (2019 - 2024) | Học kỳ 1 (2022-2023)");

INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, typeID, subjectID) VALUES("Máy phát nhạc MP3 trên nền kit nhúng", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2014, 1, 2);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, typeID, subjectID) VALUES("Hệ thống cảnh báo bằng phát hiện chuyển động trên kit nhúng Raspberry Pi", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2014, 1, 2);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, typeID, subjectID) VALUES("Tìm hiểu Công nghệ PHP Laravel Framework và xây dựng Website kinh doanh thời trang nam, nữ kiểu mới", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2014, 1, 1);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, typeID, subjectID) VALUES("Tìm hiêu Công nghệ SpringBoot, Thymeleaf và xây dựng Website học trực tuyến", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2014, 1, 1);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, typeID, subjectID) VALUES("Tìm hiểu cơ chế chuyển đổi lưu trữ dữ liệu từ dạng quan hệ sang dạng NoSQL.", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2014, 1, 3);

INSERT INTO Lecturer (username, password, lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification) 
VALUES("nguyenvansong", "song@111", "Nguyễn Văn Song", "084779811199", "nam", '1990-7-04', "nvsong@gmail.com", "0388177890", "Thạc sỹ");
INSERT INTO Lecturer (username, password, lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification) 
VALUES("nguyenthihong", "hong@111", "Nguyễn Thị Hồng", "079779822999", "nữ", '1991-8-14', "nthong@gmail.com", "0399177890", "Tiến sỹ");
INSERT INTO Lecturer (username, password, lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification) 
VALUES("tranvanxuan", "xuan@111", "Trần Văn Xuân", "066779899199", "nam", '1989-1-15', "tvxuan@gmail.com", "0988177888", "Tiến sỹ");
INSERT INTO Lecturer (username, password, lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification) 
VALUES("lethinhung", "nhung@111", "Lê Thị Nhung", "077779818999", "nữ", '1990-12-04', "ltnhung@gmail.com", "0788168890", "Thạc sỹ");
