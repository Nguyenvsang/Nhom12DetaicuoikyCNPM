CREATE DATABASE TopicMana;
-- DROP DATABASE TopicMana;
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
quantity int,
point double,
periodID int REFERENCES Period(periodID),
subjectID int REFERENCES Subject(subjectID),
lecturerID int references Lecturer(lecturerID)
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

CREATE TABLE Council
(
councilID int primary key auto_increment,
leaderID int references Lecturer(lecturerID),
topicID int references Topic(topicID),
quantity int
);

CREATE TABLE TopicEvaluation
(
id int primary key auto_increment,
councilID int references councilID(Council),
lecturerID int references Lecturer(lecturerID),
evaluation VARCHAR(200),
point double,
dateEvaluate timestamp
);

CREATE TABLE Admin
(
username VARCHAR(200) primary key,
password VARCHAR(20) not null
);

USE topicmana;
INSERT INTO subject (subjectName) VALUES("Công nghệ phần mềm");
INSERT INTO subject (subjectName) VALUES("Mạng máy tính");
INSERT INTO subject (subjectName) VALUES("Hệ thống thông tin");
-- Bỏ cách đặt tên này 
-- INSERT INTO TypeOfTopic (typeName) VALUES("Tiểu luận chuyên ngành | K14 (2014 - 2019) | Học kỳ 1 (2017-2018)");
-- INSERT INTO TypeOfTopic (typeName) VALUES("Đề tài tốt nghiệp | K14 (2014 - 2019) | Học kỳ 2 (2017-2018)");
-- INSERT INTO TypeOfTopic (typeName) VALUES("Tiểu luận chuyên ngành | K17 (2017 - 2022) | Học kỳ 1 (2020-2021)");
-- INSERT INTO TypeOfTopic (typeName) VALUES("Tiểu luận chuyên ngành | K19 (2019 - 2024) | Học kỳ 1 (2022-2023)");
-- Lấy cách đặt này 
INSERT INTO TypeOfTopic (typeName) VALUES("Tiểu luận chuyên ngành");
INSERT INTO TypeOfTopic (typeName) VALUES("Đề tài tốt nghiệp");

INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Nguyễn Văn Song", "084779811199", "Nam", '1990-7-04', "nvsong@gmail.com", "0388177890", "Tiến sỹ", 1, "nguyenvansong", "song@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Nguyễn Thị Hồng", "079779822999", "Nữ", '1991-8-14', "nthong@gmail.com", "0399177890", "Tiến sỹ", 2, "nguyenthihong", "hong@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Trần Văn Xuân", "066779899199", "Nam", '1989-1-15', "tvxuan@gmail.com", "0988177888", "Tiến sỹ", 3, "tranvanxuan", "xuan@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Lê Thị Nhung", "077779818999", "Nữ", '1990-12-04', "ltnhung@gmail.com", "0788168890", "Thạc sỹ", 1, "lethinhung", "nhung@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Nguyễn Văn Việt", "080777771199", "Nam", '1985-4-04', "nvviet@gmail.com", "0388678890", "Thạc sỹ", 1, "nguyenvanviet", "viet@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Nguyễn Thị Thắm", "082779888999", "Nữ", '1985-8-18', "nttham@gmail.com", "0712377890", "Thạc sỹ", 2, "nguyenthitham", "tham@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Trần Văn Tùng", "083779897899", "Nam", '1987-1-15', "tvtung@gmail.com", "0888123888", "Thạc sỹ", 3, "tranvantung", "tung@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Lê Thị Thanh", "084779818789", "Nữ", '1988-12-04', "ltthanh@gmail.com", "0888168890", "Thạc sỹ", 1, "lethithanh", "thanh@111");
-- Thêm 8 giáo viên lần 2 
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Nguyễn Văn Linh", "084712311199", "Nam", '1985-6-04', "nvlinh@gmail.com", "0399177890", "Tiến sỹ", 1, "nguyenvanlinh", "linh@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Nguyễn Thị Linh", "0791232999", "Nữ", '1990-7-14', "ntlinh@gmail.com", "0799177123", "Tiến sỹ", 2, "nguyenthilinh", "linh@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Trần Văn Vinh", "019779678199", "Nam", '1989-11-15', "tvvinh@gmail.com", "0781497888", "Tiến sỹ", 3, "tranvanvinh", "vinh@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Lê Thị Mai", "0497779818999", "Nữ", '1991-11-04', "ltmai@gmail.com", "0333168890", "Thạc sỹ", 1, "lethimai", "mai@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Nguyễn Văn Hoài", "006777771199", "Nam", '1986-4-04', "nvhoai@gmail.com", "0377678890", "Thạc sỹ", 1, "nguyenvanhoai", "hoai@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Nguyễn Thị Uyên", "019199888999", "Nữ", '1987-9-18', "ntuyen@gmail.com", "0312377111", "Thạc sỹ", 2, "nguyenthiuyen", "uyen@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Trần Văn Sơn", "049779897899", "Nam", '1988-1-15', "tvson@gmail.com", "0588123888", "Thạc sỹ", 3, "tranvanson", "son@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Lê Thị Phương", "020779818789", "Nữ", '1988-12-05', "ltphuong@gmail.com", "0788167770", "Thạc sỹ", 1, "lethiphuong", "phuong@111");

INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, periodID, subjectID, lecturerID) VALUES("Máy phát nhạc MP3 trên nền kit nhúng", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2021, 0, null, 2, 2, 2);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, periodID, subjectID, lecturerID) VALUES("Hệ thống cảnh báo bằng phát hiện chuyển động trên kit nhúng Raspberry Pi", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2021, 0, null, 2, 2, 2);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, periodID, subjectID, lecturerID) VALUES("Tìm hiểu Công nghệ PHP Laravel Framework và xây dựng Website kinh doanh thời trang nam, nữ kiểu mới", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2021, 1, 9, 2, 1, 1);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, periodID, subjectID, lecturerID) VALUES("Tìm hiêu Công nghệ SpringBoot, Thymeleaf và xây dựng Website học trực tuyến", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2021, 1, 9, 2, 1, 1);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, periodID, subjectID, lecturerID) VALUES("Tìm hiểu cơ chế chuyển đổi lưu trữ dữ liệu từ dạng quan hệ sang dạng NoSQL.", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2022, 0, null, 5, 3, 3);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, periodID, subjectID, lecturerID) VALUES("Tìm hiểu Công nghệ Spring boot, spring security, spring hibernate và xây dựng Website quản lý điều xe", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2022, 0, null, 5, 1, 4);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, periodID, subjectID, lecturerID) VALUES("Hệ thống giám sát cửa gara dùng kit nhúng Raspberry Pi", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2022, 0, null, 5, 2, 6);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, periodID, subjectID, lecturerID) VALUES("Hệ thống giám sát nhà dùng Raspberry Pi B+", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2022, 0, null, 5, 2, 6);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, periodID, subjectID, lecturerID) VALUES("Xây dựng ứng dụng Web với MEAN Stack.", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2022, 0, null, 7, 3, 7);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, periodID, subjectID, lecturerID) VALUES("Xây dựng ứng dụng IoT với NodeJS.", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2022, 0, null, 7, 3, 7);
-- 10 Topic tiếp theo typeOfTopic la 2 
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, periodID, subjectID, lecturerID) VALUES(" Hệ thống giám sát cửa Garage dùng Raspberry Pi", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2021, 0, null, 2, 2, 2);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, periodID, subjectID, lecturerID) VALUES("Hệ thống cảnh báo phát hiện chuyển động dùng Raspberry Pi", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2022, 0, null, 5, 2, 2);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, periodID, subjectID, lecturerID) VALUES("Xây dựng hệ thống website đặt vé xe sử dụng Laravel và Angular 4", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2021, 1, 9, 1, 1, 4);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, periodID, subjectID, lecturerID) VALUES("Tìm hiểu và ứng dụng Two - Factor Authentication và SignalR cho hệ thống web", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2021, 1, 9, 1, 1, 5);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, periodID, subjectID, lecturerID) VALUES("Xây dựng hệ thống quản lý chuỗi cửa hàng tiện lợi với MEAN Stack", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2021, 0, null, 3, 3, 3);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, periodID, subjectID, lecturerID) VALUES("Xây dựng Ứng dụng tìm việc làm trên di động bằng React Native", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2021, 0, null, 3, 1, 8);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, periodID, subjectID, lecturerID) VALUES("Tìm hiểu Two - Factor Authentication và ứng dụng bảo mật website.", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2022, 0, null, 4, 2, 6);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, periodID, subjectID, lecturerID) VALUES("Kiểm soát các truy cập Web trong mạng nội bộ", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2022, 0, null, 4, 2, 6);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, periodID, subjectID, lecturerID) VALUES("Xây dựng hệ thống camera giám sát với Android Things.", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2021, 0, null, 1, 3, 7);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, periodID, subjectID, lecturerID) VALUES("Khai phá luật kết hợp song song", "Ít nhất 1 sinh viên tham gia", "Xây dựng xong chương trình", 2021, 0, null, 1, 3, 7);

INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Nguyễn Gia Cát", "001384738666", "Nam", '1997-8-17', "ngcat@student.edu.vn", "0399168678", "Công nghệ thông tin", "nguyengiacat", "cat@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Trần Bích Hà", "002387778666", "Nữ", '1997-10-18', "tbha@student.edu.vn", "0799166678", "Công nghệ thông tin", "tranbichha", "ha@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Lê Minh Quang", "004384767866", "Nam", '1997-9-9', "lmquang@student.edu.vn", "0399789678", "Công nghệ thông tin", "leminhquang", "quang@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Lê Mỹ Duyên", "010384799966", "Nữ", '1997-1-17', "lmduyen@student.edu.vn", "0377168678", "Công nghệ thông tin", "lemyduyen", "duyen@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Phan Minh Luân", "011367938666", "Nam", '1997-2-12', "pmquan@student.edu.vn", "0799777678", "Công nghệ thông tin", "phanminhluan", "luan@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Nguyễn Cát Tiên", "095384738666", "Nữ", '1998-8-16', "nctien@student.edu.vn", "0399188878", "Công nghệ thông tin", "nguyencattien", "tien@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Huỳnh Anh Dũng", "094384738666", "Nam", '1998-8-8', "hadung@student.edu.vn", "0199168999", "Kỹ thuật dữ liệu", "huynhanhdung", "dung@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Trần Gia Linh", "079387778666", "Nữ", '1998-1-19', "tglinh@student.edu.vn", "0799168987", "Kỹ thuật dữ liệu", "trangialinh", "linh@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Trần Quốc Bảo", "079384738679", "Nam", '1998-5-15', "tqbao@student.edu.vn", "0399987678", "Kỹ thuật dữ liệu", "tranquocbao", "bao@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Nguyễn Bích Thủy", "002384738886", "Nữ", '1998-1-12', "nbthuy@student.edu.vn", "0797778678", "Kỹ thuật dữ liệu", "nguyenbichthuy", "thuy@123");
-- Them 10 sinh vien lan 2
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Nguyễn Gia Thành", "079384777666", "Nam", '1998-8-17', "ngthanh@student.edu.vn", "0388168678", "Công nghệ thông tin", "nguyengiathanh", "thanh@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Trần Bích Diễm", "002897778666", "Nữ", '1997-11-18', "tbdiem@student.edu.vn", "0789166678", "Công nghệ thông tin", "tranbichdiem", "diem@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Lê Minh Nhật", "091914767866", "Nam", '1997-9-19', "lmnhat@student.edu.vn", "0399786788", "Kỹ thuật dữ liệu", "leminhnhat", "nhat@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Lê Mỹ Nhi", "040384099966", "Nữ", '1997-11-17', "lmnhi@student.edu.vn", "0377168899", "Công nghệ thông tin", "lemynhi", "nhi@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Phan Minh Trường", "062369998666", "Nam", '1998-2-12', "pmtruong@student.edu.vn", "0799899678", "Công nghệ thông tin", "phanminhtruong", "truong@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Nguyễn Cát Quyên", "079384798666", "Nữ", '1998-8-17', "ncquyen@student.edu.vn", "0499199878", "Công nghệ thông tin", "nguyencatquyen", "quyen@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Huỳnh Anh Tường", "019384731966", "Nam", '1998-9-8', "hatuong@student.edu.vn", "0399163999", "Kỹ thuật dữ liệu", "huynhanhtuong", "tuong@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Trần Gia Chi", "049384978666", "Nữ", '1998-1-18', "tgchi@student.edu.vn", "0399168937", "Kỹ thuật dữ liệu", "trangiachi", "chi@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Trần Quốc Tân", "066384736679", "Nam", '1998-11-15', "tqtan@student.edu.vn", "0499944478", "Kỹ thuật dữ liệu", "tranquoctan", "tan@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Nguyễn Thanh Trúc", "091384738886", "Nữ", '1998-1-13', "nttruc@student.edu.vn", "0397789678", "Kỹ thuật dữ liệu", "nguyenthanhtruc", "truc@123");

INSERT INTO Admin (username, password) VALUES("trannhatphong", "123456");

INSERT INTO Team(leaderID, topicID, quantity) VALUES(1, 1, 0);

SELECT * FROM Student;
SELECT * FROM Topic;
SELECT * FROM Lecturer WHERE username = "nguyenvansong" AND password = "song@111";

-- DROP TABLE Period;
CREATE TABLE Period(
	periodID INT PRIMARY KEY auto_increment,
    beginning DATE,
    `end` DATE,
    periodName CHAR(100),
    createFor int CHECK (createFor = 0 OR createFor = 1), 
    typeID int references TopicType(typeID),
    mainPeriod int -- -- Giang vien so 0, sinh vien lay cua giang vien 
    );
    
select * from period;
INSERT INTO Period (beginning, `end`, periodName, createFor, typeID, mainPeriod) VALUES("2021-08-15", "2021-08-22", "Tiểu luận chuyên ngành | K18 (2018 - 2022) | Học kỳ 1 (2021-2022)", 0, 1, 0);
INSERT INTO Period (beginning, `end`, periodName, createFor, typeID, mainPeriod) VALUES("2021-09-01", "2021-09-07", "Tiểu luận chuyên ngành | K18 (2018 - 2022) | Học kỳ 1 (2021-2022)", 1, 1, 1);
INSERT INTO Period (beginning, `end`, periodName, createFor, typeID, mainPeriod) VALUES("2021-09-20", "2021-09-27", "Đề tài tốt nghiệp | K18 (2018 - 2022) | Học kỳ 1 (2022-2023)", 0, 2, 0);
INSERT INTO Period (beginning, `end`, periodName, createFor, typeID, mainPeriod) VALUES("2022-08-15", "2022-08-22", "Tiểu luận chuyên ngành | K19 (2019 - 2023) | Học kỳ 1 (2021-2022)", 0, 1, 0);
INSERT INTO Period (beginning, `end`, periodName, createFor, typeID, mainPeriod) VALUES("2022-09-05", "2022-09-12", "Tiểu luận chuyên ngành | K19 (2019 - 2023) | Học kỳ 1 (2021-2022)", 1, 1, 4);
INSERT INTO Period (beginning, `end`, periodName, createFor, typeID, mainPeriod) VALUES("2022-08-15", "2022-08-22", "Tiểu luận chuyên ngành | K19 (2019 - 2023) | Học kỳ 2 (2021-2022)", 0, 1, 0);
INSERT INTO Period (beginning, `end`, periodName, createFor, typeID, mainPeriod) VALUES("2022-09-05", "2022-09-12", "Tiểu luận chuyên ngành | K19 (2019 - 2023) | Học kỳ 2 (2021-2022)", 1, 1, 6);

INSERT INTO Council(leaderID, topicID, quantity) VALUES (1, 1, 3);

INSERT INTO TopicEvaluation(councilID, lecturerID, evaluation, point, dateEvaluate) VALUES (1, 1, "Rất tốt, có triển vọng khai thác", 9.2, "2022-10-08");
INSERT INTO TopicEvaluation(councilID, lecturerID) VALUES (1, 2);

SELECT * 
FROM Topic t 
INNER JOIN Council c ON t.topicID = c.topicID 
INNER JOIN TopicEvaluation e ON c.councilID = e.councilID
WHERE e.lecturerID = 2;

SELECT * FROM TopicEvaluation e 
INNER JOIN Council c ON c.councilID = e.councilID
WHERE c.topicID = 1 AND e.lecturerID = 2;

SELECT * FROM TopicEvaluation e
LEFT JOIN Council c ON c.councilID = e.councilID
WHERE c.topicID = 1 AND e.lecturerID = 1;

SELECT * FROM TopicEvaluation;

SELECT * FROM TopicEvaluation e 
INNER JOIN Council c ON e.councilID = c.councilID
INNER JOIN Topic t ON t.topicID = c.topicID
WHERE t.topicID = 1