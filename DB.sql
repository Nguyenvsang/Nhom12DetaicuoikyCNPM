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
typeID int REFERENCES TypeOfTopic(typeID),
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
INSERT INTO subject (subjectName) VALUES("C??ng ngh??? ph???n m???m");
INSERT INTO subject (subjectName) VALUES("M???ng m??y t??nh");
INSERT INTO subject (subjectName) VALUES("H??? th???ng th??ng tin");
-- B??? c??ch ?????t t??n n??y 
-- INSERT INTO TypeOfTopic (typeName) VALUES("Ti???u lu???n chuy??n ng??nh | K14 (2014 - 2019) | H???c k??? 1 (2017-2018)");
-- INSERT INTO TypeOfTopic (typeName) VALUES("????? t??i t???t nghi???p | K14 (2014 - 2019) | H???c k??? 2 (2017-2018)");
-- INSERT INTO TypeOfTopic (typeName) VALUES("Ti???u lu???n chuy??n ng??nh | K17 (2017 - 2022) | H???c k??? 1 (2020-2021)");
-- INSERT INTO TypeOfTopic (typeName) VALUES("Ti???u lu???n chuy??n ng??nh | K19 (2019 - 2024) | H???c k??? 1 (2022-2023)");
-- L???y c??ch ?????t n??y 
INSERT INTO TypeOfTopic (typeName) VALUES("Ti???u lu???n chuy??n ng??nh");
INSERT INTO TypeOfTopic (typeName) VALUES("????? t??i t???t nghi???p");

-- Nguy???n V??n Song l?? tr?????ng b??? m??n C??ng ngh??? ph???n m???m
-- Nguy???n Th??? H???ng l?? tr?????ng b??? m??n M???ng m??y t??nh
-- Tr???n V??n Xu??n l?? tr?????ng b??? m??n H??? th???ng th??ng tin 
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Nguy???n V??n Song", "084779811199", "Nam", '1990-7-04', "nvsong@gmail.com", "0388177890", "Ti???n s???", 1, "nguyenvansong", "song@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Nguy???n Th??? H???ng", "079779822999", "N???", '1991-8-14', "nthong@gmail.com", "0399177890", "Ti???n s???", 2, "nguyenthihong", "hong@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Tr???n V??n Xu??n", "066779899199", "Nam", '1989-1-15', "tvxuan@gmail.com", "0988177888", "Ti???n s???", 3, "tranvanxuan", "xuan@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("L?? Th??? Nhung", "077779818999", "N???", '1990-12-04', "ltnhung@gmail.com", "0788168890", "Th???c s???", 1, "lethinhung", "nhung@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Nguy???n V??n Vi???t", "080777771199", "Nam", '1985-4-04', "nvviet@gmail.com", "0388678890", "Th???c s???", 1, "nguyenvanviet", "viet@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Nguy???n Th??? Th???m", "082779888999", "N???", '1985-8-18', "nttham@gmail.com", "0712377890", "Th???c s???", 2, "nguyenthitham", "tham@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Tr???n V??n T??ng", "083779897899", "Nam", '1987-1-15', "tvtung@gmail.com", "0888123888", "Th???c s???", 3, "tranvantung", "tung@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("L?? Th??? Thanh", "084779818789", "N???", '1988-12-04', "ltthanh@gmail.com", "0888168890", "Th???c s???", 1, "lethithanh", "thanh@111");
-- Th??m 8 gi??o vi??n l???n 2 
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Nguy???n V??n Linh", "084712311199", "Nam", '1985-6-04', "nvlinh@gmail.com", "0399177890", "Ti???n s???", 1, "nguyenvanlinh", "linh@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Nguy???n Th??? Linh", "0791232999", "N???", '1990-7-14', "ntlinh@gmail.com", "0799177123", "Ti???n s???", 2, "nguyenthilinh", "linh@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Tr???n V??n Vinh", "019779678199", "Nam", '1989-11-15', "tvvinh@gmail.com", "0781497888", "Ti???n s???", 3, "tranvanvinh", "vinh@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("L?? Th??? Mai", "0497779818999", "N???", '1991-11-04', "ltmai@gmail.com", "0333168890", "Th???c s???", 1, "lethimai", "mai@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Nguy???n V??n Ho??i", "006777771199", "Nam", '1986-4-04', "nvhoai@gmail.com", "0377678890", "Th???c s???", 1, "nguyenvanhoai", "hoai@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Nguy???n Th??? Uy??n", "019199888999", "N???", '1987-9-18', "ntuyen@gmail.com", "0312377111", "Th???c s???", 2, "nguyenthiuyen", "uyen@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("Tr???n V??n S??n", "049779897899", "Nam", '1988-1-15', "tvson@gmail.com", "0588123888", "Th???c s???", 3, "tranvanson", "son@111");
INSERT INTO Lecturer (lecturerName, citizenID, gender, dateOfBirth, email, phoneNumber, professionalQualification, deanID, username, password) 
VALUES("L?? Th??? Ph????ng", "020779818789", "N???", '1988-12-05', "ltphuong@gmail.com", "0788167770", "Th???c s???", 1, "lethiphuong", "phuong@111");

INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, typeID, periodID, subjectID, lecturerID) VALUES("M??y ph??t nh???c MP3 tr??n n???n kit nh??ng", "??t nh???t 1 sinh vi??n tham gia", "X??y d???ng xong ch????ng tr??nh", 2021, 2, null, 1, 2, 2, 2);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, typeID, periodID, subjectID, lecturerID) VALUES("H??? th???ng c???nh b??o b???ng ph??t hi???n chuy???n ?????ng tr??n kit nh??ng Raspberry Pi", "??t nh???t 1 sinh vi??n tham gia", "X??y d???ng xong ch????ng tr??nh", 2021, 2, null, 1, 2, 2, 2);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, typeID, periodID, subjectID, lecturerID) VALUES("T??m hi???u C??ng ngh??? PHP Laravel Framework v?? x??y d???ng Website kinh doanh th???i trang nam, n??? ki???u m???i", "??t nh???t 1 sinh vi??n tham gia", "X??y d???ng xong ch????ng tr??nh", 2021, 2, 9, 1, 2, 1, 1);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, typeID, periodID, subjectID, lecturerID) VALUES("T??m hi??u C??ng ngh??? SpringBoot, Thymeleaf v?? x??y d???ng Website h???c tr???c tuy???n", "??t nh???t 1 sinh vi??n tham gia", "X??y d???ng xong ch????ng tr??nh", 2021, 4, 9, 1, 2, 1, 1);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, typeID, periodID, subjectID, lecturerID) VALUES("T??m hi???u c?? ch??? chuy???n ?????i l??u tr??? d??? li???u t??? d???ng quan h??? sang d???ng NoSQL.", "??t nh???t 1 sinh vi??n tham gia", "X??y d???ng xong ch????ng tr??nh", 2022, 0, null, 1, 5, 3, 3);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, typeID, periodID, subjectID, lecturerID) VALUES("T??m hi???u C??ng ngh??? Spring boot, spring security, spring hibernate v?? x??y d???ng Website qu???n l?? ??i???u xe", "??t nh???t 1 sinh vi??n tham gia", "X??y d???ng xong ch????ng tr??nh", 2022, 0, null, 1, 5, 1, 4);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, typeID, periodID, subjectID, lecturerID) VALUES("H??? th???ng gi??m s??t c???a gara d??ng kit nh??ng Raspberry Pi", "??t nh???t 1 sinh vi??n tham gia", "X??y d???ng xong ch????ng tr??nh", 2022, 0, null, 1, 5, 2, 6);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, typeID, periodID, subjectID, lecturerID) VALUES("H??? th???ng gi??m s??t nh?? d??ng Raspberry Pi B+", "??t nh???t 1 sinh vi??n tham gia", "X??y d???ng xong ch????ng tr??nh", 2022, 0, null, 1, 5, 2, 6);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, typeID, periodID, subjectID, lecturerID) VALUES("X??y d???ng ???ng d???ng Web v???i MEAN Stack.", "??t nh???t 1 sinh vi??n tham gia", "X??y d???ng xong ch????ng tr??nh", 2022, 0, null, 1, 7, 3, 7);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, typeID, periodID, subjectID, lecturerID) VALUES("X??y d???ng ???ng d???ng IoT v???i NodeJS.", "??t nh???t 1 sinh vi??n tham gia", "X??y d???ng xong ch????ng tr??nh", 2022, 0, null, 1, 7, 3, 7);
-- 10 Topic ti???p theo typeOfTopic la 2 
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, typeID, periodID, subjectID, lecturerID) VALUES(" H??? th???ng gi??m s??t c???a Garage d??ng Raspberry Pi", "??t nh???t 1 sinh vi??n tham gia", "X??y d???ng xong ch????ng tr??nh", 2021, 2, null, 1, 2, 2, 2);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, typeID, periodID, subjectID, lecturerID) VALUES("H??? th???ng c???nh b??o ph??t hi???n chuy???n ?????ng d??ng Raspberry Pi", "??t nh???t 1 sinh vi??n tham gia", "X??y d???ng xong ch????ng tr??nh", 2022, 0, null, 1, 5, 2, 2);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, typeID, periodID, subjectID, lecturerID) VALUES("X??y d???ng h??? th???ng website ?????t v?? xe s??? d???ng Laravel v?? Angular 4", "??t nh???t 1 sinh vi??n tham gia", "X??y d???ng xong ch????ng tr??nh", 2021, 2, 9, 1, 1, 1, 4);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, typeID, periodID, subjectID, lecturerID) VALUES("T??m hi???u v?? ???ng d???ng Two - Factor Authentication v?? SignalR cho h??? th???ng web", "??t nh???t 1 sinh vi??n tham gia", "X??y d???ng xong ch????ng tr??nh", 2021, 1, 9, 1, 1, 1, 5);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, typeID, periodID, subjectID, lecturerID) VALUES("X??y d???ng h??? th???ng qu???n l?? chu???i c???a h??ng ti???n l???i v???i MEAN Stack", "??t nh???t 1 sinh vi??n tham gia", "X??y d???ng xong ch????ng tr??nh", 2021, 0, null, 2, 3, 3, 3);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, typeID, periodID, subjectID, lecturerID) VALUES("X??y d???ng ???ng d???ng t??m vi???c l??m tr??n di ?????ng b???ng React Native", "??t nh???t 1 sinh vi??n tham gia", "X??y d???ng xong ch????ng tr??nh", 2021, 0, null, 2, 3, 1, 8);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, typeID, periodID, subjectID, lecturerID) VALUES("T??m hi???u Two - Factor Authentication v?? ???ng d???ng b???o m???t website.", "??t nh???t 1 sinh vi??n tham gia", "X??y d???ng xong ch????ng tr??nh", 2022, 0, null, 1, 4, 2, 6);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, typeID, periodID, subjectID, lecturerID) VALUES("Ki???m so??t c??c truy c???p Web trong m???ng n???i b???", "??t nh???t 1 sinh vi??n tham gia", "X??y d???ng xong ch????ng tr??nh", 2022, 0, null, 1, 4, 2, 6);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, typeID, periodID, subjectID, lecturerID) VALUES("X??y d???ng h??? th???ng camera gi??m s??t v???i Android Things.", "??t nh???t 1 sinh vi??n tham gia", "X??y d???ng xong ch????ng tr??nh", 2021, 2, null, 1, 1, 3, 7);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, typeID, periodID, subjectID, lecturerID) VALUES("Khai ph?? lu???t k???t h???p song song", "??t nh???t 1 sinh vi??n tham gia", "X??y d???ng xong ch????ng tr??nh", 2021, 2, null, 1, 1, 3, 7);

INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Nguy???n Gia C??t", "001384738666", "Nam", '1997-8-17', "ngcat@student.edu.vn", "0399168678", "C??ng ngh??? th??ng tin", "nguyengiacat", "cat@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Tr???n B??ch H??", "002387778666", "N???", '1997-10-18', "tbha@student.edu.vn", "0799166678", "C??ng ngh??? th??ng tin", "tranbichha", "ha@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("L?? Minh Quang", "004384767866", "Nam", '1997-9-9', "lmquang@student.edu.vn", "0399789678", "C??ng ngh??? th??ng tin", "leminhquang", "quang@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("L?? M??? Duy??n", "010384799966", "N???", '1997-1-17', "lmduyen@student.edu.vn", "0377168678", "C??ng ngh??? th??ng tin", "lemyduyen", "duyen@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Phan Minh Lu??n", "011367938666", "Nam", '1997-2-12', "pmquan@student.edu.vn", "0799777678", "C??ng ngh??? th??ng tin", "phanminhluan", "luan@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Nguy???n C??t Ti??n", "095384738666", "N???", '1998-8-16', "nctien@student.edu.vn", "0399188878", "C??ng ngh??? th??ng tin", "nguyencattien", "tien@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Hu???nh Anh D??ng", "094384738666", "Nam", '1998-8-8', "hadung@student.edu.vn", "0199168999", "K??? thu???t d??? li???u", "huynhanhdung", "dung@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Tr???n Gia Linh", "079387778666", "N???", '1998-1-19', "tglinh@student.edu.vn", "0799168987", "K??? thu???t d??? li???u", "trangialinh", "linh@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Tr???n Qu???c B???o", "079384738679", "Nam", '1998-5-15', "tqbao@student.edu.vn", "0399987678", "K??? thu???t d??? li???u", "tranquocbao", "bao@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Nguy???n B??ch Th???y", "002384738886", "N???", '1998-1-12', "nbthuy@student.edu.vn", "0797778678", "K??? thu???t d??? li???u", "nguyenbichthuy", "thuy@123");
-- Them 10 sinh vien lan 2
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Nguy???n Gia Th??nh", "079384777666", "Nam", '1998-8-17', "ngthanh@student.edu.vn", "0388168678", "C??ng ngh??? th??ng tin", "nguyengiathanh", "thanh@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Tr???n B??ch Di???m", "002897778666", "N???", '1997-11-18', "tbdiem@student.edu.vn", "0789166678", "C??ng ngh??? th??ng tin", "tranbichdiem", "diem@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("L?? Minh Nh???t", "091914767866", "Nam", '1997-9-19', "lmnhat@student.edu.vn", "0399786788", "K??? thu???t d??? li???u", "leminhnhat", "nhat@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("L?? M??? Nhi", "040384099966", "N???", '1997-11-17', "lmnhi@student.edu.vn", "0377168899", "C??ng ngh??? th??ng tin", "lemynhi", "nhi@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Phan Minh Tr?????ng", "062369998666", "Nam", '1998-2-12', "pmtruong@student.edu.vn", "0799899678", "C??ng ngh??? th??ng tin", "phanminhtruong", "truong@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Nguy???n C??t Quy??n", "079384798666", "N???", '1998-8-17', "ncquyen@student.edu.vn", "0499199878", "C??ng ngh??? th??ng tin", "nguyencatquyen", "quyen@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Hu???nh Anh T?????ng", "019384731966", "Nam", '1998-9-8', "hatuong@student.edu.vn", "0399163999", "K??? thu???t d??? li???u", "huynhanhtuong", "tuong@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Tr???n Gia Chi", "049384978666", "N???", '1998-1-18', "tgchi@student.edu.vn", "0399168937", "K??? thu???t d??? li???u", "trangiachi", "chi@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Tr???n Qu???c T??n", "066384736679", "Nam", '1998-11-15', "tqtan@student.edu.vn", "0499944478", "K??? thu???t d??? li???u", "tranquoctan", "tan@123");
INSERT INTO Student (studentName, citizenID, gender, dateOfBirth, email, phoneNumber, department, username, password) 
VALUES("Nguy???n Thanh Tr??c", "091384738886", "N???", '1998-1-13', "nttruc@student.edu.vn", "0397789678", "K??? thu???t d??? li???u", "nguyenthanhtruc", "truc@123");

INSERT INTO Admin (username, password) VALUES("trannhatphong", "123456");

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
INSERT INTO Period (beginning, `end`, periodName, createFor, typeID, mainPeriod) VALUES("2021-08-15", "2021-08-22", "Ti???u lu???n chuy??n ng??nh | K18 (2018 - 2022) | H???c k??? 1 (2021-2022)", 0, 1, 0);
INSERT INTO Period (beginning, `end`, periodName, createFor, typeID, mainPeriod) VALUES("2021-09-01", "2021-09-07", "Ti???u lu???n chuy??n ng??nh | K18 (2018 - 2022) | H???c k??? 1 (2021-2022)", 1, 1, 1);
INSERT INTO Period (beginning, `end`, periodName, createFor, typeID, mainPeriod) VALUES("2021-09-20", "2021-09-27", "????? t??i t???t nghi???p | K18 (2018 - 2022) | H???c k??? 1 (2022-2023)", 0, 2, 0);
INSERT INTO Period (beginning, `end`, periodName, createFor, typeID, mainPeriod) VALUES("2022-08-15", "2022-08-22", "Ti???u lu???n chuy??n ng??nh | K19 (2019 - 2023) | H???c k??? 1 (2021-2022)", 0, 1, 0);
INSERT INTO Period (beginning, `end`, periodName, createFor, typeID, mainPeriod) VALUES("2022-09-05", "2022-09-12", "Ti???u lu???n chuy??n ng??nh | K19 (2019 - 2023) | H???c k??? 1 (2021-2022)", 1, 1, 4);
INSERT INTO Period (beginning, `end`, periodName, createFor, typeID, mainPeriod) VALUES("2022-08-15", "2022-08-22", "Ti???u lu???n chuy??n ng??nh | K19 (2019 - 2023) | H???c k??? 2 (2021-2022)", 0, 1, 0);
INSERT INTO Period (beginning, `end`, periodName, createFor, typeID, mainPeriod) VALUES("2022-09-05", "2022-09-12", "Ti???u lu???n chuy??n ng??nh | K19 (2019 - 2023) | H???c k??? 2 (2021-2022)", 1, 1, 6);
-- Nh???p li???u cho Team v?? TopicRegistration 
INSERT INTO Team(leaderID, topicID, quantity) VALUES(1, 1, 2);
INSERT INTO TopicRegistration(studentID, teamID) VALUES(1,1);
INSERT INTO TopicRegistration(studentID, teamID) VALUES(2,1);
INSERT INTO Team(leaderID, topicID, quantity) VALUES(3, 2, 2);
INSERT INTO TopicRegistration(studentID, teamID) VALUES(3,2);
INSERT INTO TopicRegistration(studentID, teamID) VALUES(4,2);
INSERT INTO Team(leaderID, topicID, quantity) VALUES(5, 11, 2);
INSERT INTO TopicRegistration(studentID, teamID) VALUES(5,3);
INSERT INTO TopicRegistration(studentID, teamID) VALUES(6,3);
INSERT INTO Team(leaderID, topicID, quantity) VALUES(7, 3, 2);
INSERT INTO TopicRegistration(studentID, teamID) VALUES(7,4);
INSERT INTO TopicRegistration(studentID, teamID) VALUES(8,4);
INSERT INTO Team(leaderID, topicID, quantity) VALUES(9, 4, 2);
INSERT INTO TopicRegistration(studentID, teamID) VALUES(9,5);
INSERT INTO TopicRegistration(studentID, teamID) VALUES(10,5);
INSERT INTO Team(leaderID, topicID, quantity) VALUES(11, 13, 2);
INSERT INTO TopicRegistration(studentID, teamID) VALUES(11,6);
INSERT INTO TopicRegistration(studentID, teamID) VALUES(12,6);
INSERT INTO Team(leaderID, topicID, quantity) VALUES(13, 19, 2);
INSERT INTO TopicRegistration(studentID, teamID) VALUES(13,7);
INSERT INTO TopicRegistration(studentID, teamID) VALUES(14,7);
INSERT INTO Team(leaderID, topicID, quantity) VALUES(15, 20, 2);
INSERT INTO TopicRegistration(studentID, teamID) VALUES(15,8);
INSERT INTO TopicRegistration(studentID, teamID) VALUES(16,8);


INSERT INTO Council(leaderID, topicID, quantity) VALUES (2, 1, 3);
INSERT INTO TopicEvaluation(councilID, lecturerID, evaluation, point, dateEvaluate) VALUES (1, 2, "R???t t???t, c?? tri???n v???ng khai th??c", 9.2, "2022-10-08");
INSERT INTO TopicEvaluation(councilID, lecturerID, evaluation, point, dateEvaluate) VALUES (1, 6, "Ngi??n c???u r???t ?????y ?????, r???t ????ng khen", 9, "2022-10-08");
INSERT INTO TopicEvaluation(councilID, lecturerID, evaluation, point, dateEvaluate) VALUES (1, 10, "Kh?? t???t, c?? tri???n v???ng khai th??c", 8.8, "2022-10-08");
INSERT INTO Council(leaderID, topicID, quantity) VALUES (6, 2, 3);
INSERT INTO TopicEvaluation(councilID, lecturerID, evaluation, point, dateEvaluate) VALUES (2, 6, "Kh?? t???t, c???n ph??n t??ch s??u h??n", 8, "2022-09-08");
INSERT INTO TopicEvaluation(councilID, lecturerID, evaluation, point, dateEvaluate) VALUES (2, 10, "Kh?? ???n, m???t v??i ch??? c???n gi???i quy???t h???p l?? h??n", 8, "2022-09-08");
INSERT INTO TopicEvaluation(councilID, lecturerID, evaluation, point, dateEvaluate) VALUES (2, 14, "Kh?? t???t, c?? tri???n v???ng khai th??c", 8.8, "2022-09-08");
INSERT INTO Council(leaderID, topicID, quantity) VALUES (2, 11, 3);
INSERT INTO TopicEvaluation(councilID, lecturerID, evaluation, point, dateEvaluate) VALUES (3, 2, "Kh?? t???t, c?? tri???n v???ng khai th??c", 9, "2022-09-07");
INSERT INTO TopicEvaluation(councilID, lecturerID, evaluation, point, dateEvaluate) VALUES (3, 6, "Kh?? ???n, m???t v??i ch??? c???n gi???i quy???t h???p l?? h??n", 8.8, "2022-09-07");
INSERT INTO TopicEvaluation(councilID, lecturerID, evaluation, point, dateEvaluate) VALUES (3, 14, "Kh?? t???t, c?? tri???n v???ng khai th??c", 9, "2022-09-07");
INSERT INTO Council(leaderID, topicID, quantity) VALUES (1, 3, 3);
INSERT INTO TopicEvaluation(councilID, lecturerID, evaluation, point, dateEvaluate) VALUES (4, 1, "R???t t???t, c?? tri???n v???ng khai th??c", 9.2, "2022-10-07");
INSERT INTO TopicEvaluation(councilID, lecturerID, evaluation, point, dateEvaluate) VALUES (4, 4, "Kh?? ???n, m???t v??i ch??? c???n gi???i quy???t h???p l?? h??n", 8.8, "2022-10-07");
INSERT INTO TopicEvaluation(councilID, lecturerID, evaluation, point, dateEvaluate) VALUES (4, 5, "Kh?? t???t, c?? tri???n v???ng khai th??c", 9.1, "2022-10-07");
INSERT INTO Council(leaderID, topicID, quantity) VALUES (8, 4, 3);
INSERT INTO TopicEvaluation(councilID, lecturerID, evaluation, point, dateEvaluate) VALUES (5, 8, "Kh?? t???t, c?? tri???n v???ng khai th??c", 9, "2022-09-09");
INSERT INTO TopicEvaluation(councilID, lecturerID, evaluation, point, dateEvaluate) VALUES (5, 9, "Kh?? ???n, m???t v??i ch??? c???n gi???i quy???t h???p l?? h??n", 8, "2022-09-09");
INSERT INTO TopicEvaluation(councilID, lecturerID, evaluation, point, dateEvaluate) VALUES (5, 12, "Kh?? t???t, c?? tri???n v???ng khai th??c", 8, "2022-09-09");
INSERT INTO Council(leaderID, topicID, quantity) VALUES (12, 13, 4);
INSERT INTO TopicEvaluation(councilID, lecturerID, evaluation, point, dateEvaluate) VALUES (6, 12, "R???t t???t, c?? tri???n v???ng khai th??c", 9.3, "2022-08-22");
INSERT INTO TopicEvaluation(councilID, lecturerID, evaluation, point, dateEvaluate) VALUES (6, 13, "Ngi??n c???u r???t ?????y ?????, r???t ????ng khen", 9.2, "2022-08-22");
INSERT INTO TopicEvaluation(councilID, lecturerID, evaluation, point, dateEvaluate) VALUES (6, 16, "Kh?? t???t, c?? tri???n v???ng khai th??c", 8.8, "2022-08-22");
INSERT INTO TopicEvaluation(councilID, lecturerID, evaluation, point, dateEvaluate) VALUES (6, 1, "R???t t???t, c?? tri???n v???ng khai th??c", 9.2, "2022-08-22");
INSERT INTO Council(leaderID, topicID, quantity) VALUES (3, 19, 3);
INSERT INTO TopicEvaluation(councilID, lecturerID, evaluation, point, dateEvaluate) VALUES (7, 3, "R???t t???t, c?? tri???n v???ng khai th??c", 9, "2022-08-25");
INSERT INTO TopicEvaluation(councilID, lecturerID, evaluation, point, dateEvaluate) VALUES (7, 7, "Ngi??n c???u r???t ?????y ?????, r???t ????ng khen", 9, "2022-08-25");
INSERT INTO TopicEvaluation(councilID, lecturerID, evaluation, point, dateEvaluate) VALUES (7, 11, "Kh?? t???t, c?? tri???n v???ng khai th??c", 8, "2022-08-25");
INSERT INTO Council(leaderID, topicID, quantity) VALUES (15, 20, 3);
INSERT INTO TopicEvaluation(councilID, lecturerID, evaluation, point, dateEvaluate) VALUES (8, 15, "Kh?? t???t, c?? tri???n v???ng khai th??c", 9, "2022-08-22");
INSERT INTO TopicEvaluation(councilID, lecturerID, evaluation, point, dateEvaluate) VALUES (8, 11, "Kh?? ???n, m???t v??i ch??? c???n gi???i quy???t h???p l?? h??n", 8, "2022-08-22");
INSERT INTO TopicEvaluation(councilID, lecturerID, evaluation, point, dateEvaluate) VALUES (8, 7, "Kh?? t???t, c?? tri???n v???ng khai th??c", 9, "2022-08-22");



SELECT * 
FROM Topic t 
INNER JOIN Council c ON t.topicID = c.topicID 
LEFT JOIN TopicEvaluation e ON c.councilID = e.councilID
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
WHERE t.topicID = 1;

INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, periodID, subjectID, lecturerID) VALUES("Ki???m so??t c??c truy c???p Web trong m???ng n???i b???", "??t nh???t 1 sinh vi??n tham gia", "X??y d???ng xong ch????ng tr??nh", 2022, 0, null, 7, 1, 7);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, periodID, subjectID, lecturerID) VALUES("X??y d???ng h??? th???ng camera gi??m s??t v???i Android Things.", "??t nh???t 1 sinh vi??n tham gia", "X??y d???ng xong ch????ng tr??nh", 2021, 0, null, 7, 1, 7);
INSERT INTO Topic (topicName, topicRequire, topicGoal, schoolYear, quantity, point, periodID, subjectID, lecturerID) VALUES("Khai ph?? lu???t k???t h???p song song", "??t nh???t 1 sinh vi??n tham gia", "X??y d???ng xong ch????ng tr??nh", 2021, 0, null, 7, 1, 7);

INSERT INTO Period (beginning, `end`, periodName, createFor, typeID, mainPeriod) VALUES("2022-12-08", "2022-12-15", "Ti???u lu???n chuy??n ng??nh | K19 (2019 - 2023) | H???c k??? 2 (2021-2022)", 1, 1, 7);

INSERT INTO Period (beginning, `end`, periodName, createFor, typeID, mainPeriod) VALUES("2022-12-08", "2022-12-15", "Ti???u lu???n chuy??n ng??nh | K19 (2019 - 2023) | H???c k??? 2 (2021-2022)", 1, 1, 8);

SELECT * FROM Topic t
INNER JOIN Period p ON t.periodID = p.periodID 
WHERE p.periodID = 7;

SELECT *  FROM Period;

SELECT * FROM Topic Where periodID