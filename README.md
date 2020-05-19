## sword项目介绍

sword是一个前后端分离的权限管理系统，项目采用 SpringBoot+mybatis||SpringBoot+JPA 开发，计划采用react作为前端框架。

### 项目技术栈

#### 后端技术栈

1. Spring Boot

2. Spring Security

3. MyBatis and JPA

4. MySQL

5. Swagger

   

## 快速部署

1.clone 项目到本地
2.提前在本地 MySQL 中创建一个空的数据库 sword，导入数据data.sql，并修改项目中关于数据的配置（resources 目录下的 application.yml文件中）
3.运行SwordAdminApplication  访问URL http://localhost:8001/swagger-ui.html
4.点开sys-login-controller，输出账号密码  admin admin（账号密码都是admin）
5.获取到的token 点击右上角的Authorize，在输入框输入刚刚的token然后点击Authorize。就可以获得获取其他API 的权限

6.喜欢JPA的同学切换到jpa分支



## TODO

事件发布、监听(一般是环境监听？初始化监听？)