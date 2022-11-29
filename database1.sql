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
CREATE TABLE Lecturer
(
lecturerID INT AUTO_INCREMENT primary key,
lecturerName VARCHAR(200) not null,
citizenID VARCHAR(20) not null,
gender VARCHAR(3) not null,
dateOfBirth Date not null,
email VARCHAR(200),
phoneNumber VARCHAR(20),
professionalQualification VARCHAR(200),
deanID INT references Lecturer(lecturerID),
username VARCHAR(200),
password VARCHAR(20) not null
);
CREATE TABLE Topic
(
topicID INT AUTO_INCREMENT primary key,
topicName VARCHAR(200) not null,
topicRequire VARCHAR(200),
topicGoal VARCHAR(200),
schoolYear int,
typeID int REFERENCES TypeOfTopic(typeID),
subjectID int REFERENCES Subject(subjectID),
lecturerID int references Lecturer(lecturerID),
quantity int 
);
CREATE TABLE Student 
(
studentID INT AUTO_INCREMENT primary key,
studentName VARCHAR(200) not null,
citizenID VARCHAR(20) not null,
gender VARCHAR(3) not null,
dateOfBirth Date not null,
email VARCHAR(200),
phoneNumber VARCHAR(20),
department VARCHAR(200),
username VARCHAR(200),
password VARCHAR(20) not null
);
CREATE TABLE TopicRegistration(
id int primary key auto_increment,
studentID int references Student(studentID),
teamID int references Team(teamID)
);

CREATE TABLE Team(
teamID int primary key auto_increment,
leaderID int references Student(studentID),
topicID int references Topic(topicID),
quantity int
);

CREATE TABLE Admin
(
username VARCHAR(200),
password VARCHAR(20) not null
);

USE topicmana;
INSERT INTO subject (subjectName) VALUES("Công nghệ phần mềm");
INSERT INTO subject (subjectName) VALUES("Mạng máy tính");
INSERT INTO subject (subjectName) VALUES("Hệ thống thông tin");

INSERT INTO TypeOfTopic (typeName) VALUES("Tiểu luận chuyên ngành | K14 (2014 - 2019) | Học kỳ 1 (2017-2018)");
INSERT INTO TypeOfTopic (typeName) VALUES("Đề tài tốt nghiệp | K14 (2014 - 2019) | Học kỳ 2 (2017-2018)");
INSERT INTO TypeOfTopic (typeName) VALUES("Tiểu luận chuyên ngành | K17 (2017 - 2022) | Học kỳ 1 (2020-2021)");
INSERT INTO TypeOfTopic (typeName) VALUES("Tiểu luận chuyên ngành | K19 (2019 - 2024) | Học kỳ 1 (2022-2023)");

INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Nguyễn Văn Song", "084779811199", "nam", '1990-7-04', "nvsong@gmail.com", "0388177890", "Tiến sỹ", 1, "nguyenvansong", "song@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Nguyễn Thị Hồng", "079779822999", "nữ", '1991-8-14', "nthong@gmail.com", "0399177890", "Tiến sỹ", 2, "nguyenthihong", "hong@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Trần Văn Xuân", "066779899199", "nam", '1989-1-15', "tvxuan@gmail.com", "0988177888", "Tiến sỹ", 3, "tranvanxuan", "xuan@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Lê Thị Nhung", "077779818999", "nữ", '1990-12-04', "ltnhung@gmail.com", "0788168890", "Thạc sỹ", 1, "lethinhung", "nhung@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Nguyễn Văn Việt", "080777771199", "nam", '1985-4-04', "nvviet@gmail.com", "0388678890", "Thạc sỹ", 1, "nguyenvanviet", "viet@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Nguyễn Thị Thắm", "082779888999", "nữ", '1985-8-18', "nttham@gmail.com", "0712377890", "Thạc sỹ", 2, "nguyenthitham", "tham@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Trần Văn Tùng", "083779897899", "nam", '1987-1-15', "tvtung@gmail.com", "0888123888", "Thạc sỹ", 3, "tranvantung", "tung@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Lê Thị Thanh", "084779818789", "nữ", '1988-12-04', "ltthanh@gmail.com", "0888168890", "Thạc sỹ", 1, "lethithanh", "thanh@111");

INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, typeID, subjectID, lecturerID, quantity) VALUES("Máy phát nhạc MP3 trên nền kit nhúng", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2014, 1, 2, 2, 0);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, typeID, subjectID, lecturerID, quantity) VALUES("Hệ thống cảnh báo bằng phát hiện chuyển động trên kit nhúng Raspberry Pi", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2014, 1, 2, 2, 0);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, typeID, subjectID, lecturerID, quantity) VALUES("Tìm hiểu Công nghệ PHP Laravel Framework và xây dựng Website kinh doanh thời trang nam, nữ kiểu mới", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2014, 1, 1, 1, 1);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, typeID, subjectID, lecturerID, quantity) VALUES("Tìm hiêu Công nghệ SpringBoot, Thymeleaf và xây dựng Website học trực tuyến", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2014, 1, 1, 1, 1);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, typeID, subjectID, lecturerID, quantity) VALUES("Tìm hiểu cơ chế chuyển đổi lưu trữ dữ liệu từ dạng quan hệ sang dạng NoSQL.", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2014, 1, 3, 3, 0);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, typeID, subjectID, lecturerID, quantity) VALUES("Tìm hiểu Công nghệ Spring boot, spring security, spring hibernate và xây dựng Website quản lý điều xe", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2014, 1, 1, 4, 0);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, typeID, subjectID, lecturerID, quantity) VALUES("Hệ thống giám sát cửa gara dùng kit nhúng Raspberry Pi", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2014, 1, 2, 6, 0);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, typeID, subjectID, lecturerID, quantity) VALUES("Hệ thống giám sát nhà dùng Raspberry Pi B+", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2014, 1, 2, 6, 0);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, typeID, subjectID, lecturerID, quantity) VALUES("Xây dựng ứng dụng Web với MEAN Stack.", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2014, 1, 3, 7, 0);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, typeID, subjectID, lecturerID, quantity) VALUES("Xây dựng ứng dụng IoT với NodeJS.", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2014, 1, 3, 7, 0);

INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Nguyễn Gia Cát", "001384738666", "nam", '1997-8-17', "ngcat@student.edu.vn", "0399168678", "Công nghệ thông tin", "nguyengiacat", "cat@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Trần Bích Hà", "002387778666", "nữ", '1997-10-18', "tbha@student.edu.vn", "0799166678", "Công nghệ thông tin", "tranbichha", "ha@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Lê Minh Quang", "004384767866", "nam", '1997-9-9', "lmquang@student.edu.vn", "0399789678", "Công nghệ thông tin", "leminhquang", "quang@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Lê Mỹ Duyên", "010384799966", "nữ", '1997-1-17', "lmduyen@student.edu.vn", "0377168678", "Công nghệ thông tin", "lemyduyen", "duyen@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Phan Minh Luân", "011367938666", "nam", '1997-2-12', "pmquan@student.edu.vn", "0799777678", "Công nghệ thông tin", "phanminhluan", "luan@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Nguyễn Cát Tiên", "095384738666", "nữ", '1998-8-16', "nctien@student.edu.vn", "0399188878", "Công nghệ thông tin", "nguyencattien", "tien@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Huỳnh Anh Dũng", "094384738666", "nam", '1998-8-8', "hadung@student.edu.vn", "0199168999", "Kỹ thuật dữ liệu", "huynhanhdung", "dung@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Trần Gia Linh", "079387778666", "nữ", '1998-1-19', "tglinh@student.edu.vn", "0799168987", "Kỹ thuật dữ liệu", "trangialinh", "linh@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Trần Quốc Bảo", "079384738679", "nam", '1998-5-15', "tqbao@student.edu.vn", "0399987678", "Kỹ thuật dữ liệu", "tranquocbao", "bao@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Nguyễn Bích Thủy", "002384738886", "nữ", '1998-1-12', "nbthuy@student.edu.vn", "0797778678", "Kỹ thuật dữ liệu", "nguyenbichthuy", "thuy@123");

<<<<<<< Updated upstream
INSERT INTO Admin (username, password) VALUES("trannhatphong", "123456");


SELECT * FROM Team
SELECT * FROM Topic
SELECT * FROM TopicRegistration
=======
>>>>>>> Stashed changes
INSERT INTO Team(leaderID, topicID, quantity) VALUES(1, 1, 0)
