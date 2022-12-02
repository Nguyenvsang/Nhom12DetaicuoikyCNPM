# Nhóm 12 - Công nghệ phần mềm - Đề tài

## Tổng quan

Tên đề tài: Thiết kế website quản lý đề tài khoa công nghệ thông tin

Ngôn ngữ backend: Java JSP/Servlet

Cơ sở dữ liệu: MySQL

Sever : Apache Tomcat® - Apache Tomcat 8.5.59

Ngày bắt đầu code: 21/11/2022

Công bố sprint 1: 2/12/2020 (Hoàn thành tương đối các chức năng đăng nhập, đăng kí đề tài, quản lý thông tin cá nhân theo sơ đồ use_case)

## Lược đồ use-case
![Picture1](https://user-images.githubusercontent.com/94773081/205356032-8daf6d26-1237-4bb0-8849-236ea36ade22.png)

## Các chức năng đã thực hiện:
- Đăng nhập cho admin, sinh viên, giảng viên, trưởng bộ môn:

![Picture2](https://user-images.githubusercontent.com/94773081/205356057-02f828c6-2dd6-426d-a6ab-ffee89ee4f7e.png)

- Xem danh sách đề tài:

![Picture2](https://user-images.githubusercontent.com/94773081/205356105-eec9f724-1a8c-43aa-b9e3-c4241310b711.png)

- Xem chi tiết đề tài:

![Picture3](https://user-images.githubusercontent.com/94773081/205356120-951d4031-af7b-4f1b-8509-38d9c29cfedf.png)

- Giảng viên đăng ký đề tài:

![Picture4](https://user-images.githubusercontent.com/94773081/205356132-c38d1d8c-0a36-46b6-bcc9-8e474f3a530a.png)

- Giảng viên chỉnh sửa đề tài:

![Picture5](https://user-images.githubusercontent.com/94773081/205356139-619400f1-c15d-43a6-b9f5-af99f76348df.png)

- Giảng viên xem danh sách đề tài đã đăng ký:

![Picture6](https://user-images.githubusercontent.com/94773081/205356148-4faede91-2615-461b-bb88-a4e1c5858d94.png)

- Sinh viên đăng ký đề tài:

![Picture7](https://user-images.githubusercontent.com/94773081/205356155-3faf98db-3034-47cc-b064-b51030d683a6.png)

- Quản lý thông tin cá nhân: giảng viên, sinh viên:

![Picture8](https://user-images.githubusercontent.com/94773081/205356167-9aaf27ff-b4f3-4113-bd1e-c60181933782.png)

## Tổ chức dự án: mô hình MVC

```
├── Source code
   	├── Model ├── Entity (database model)
        |         └── DAO (business model)
        |
        └── View  ├── Webapp
        |
        └── Controller
```

