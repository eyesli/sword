## sword项目介绍

sword是一个前后端分离的权限管理系统，项目采用 SpringBoot+mybatis||SpringBoot+JPA 开发，计划采用react作为前端框架。项目地址：https://github.com/eyesli/sword-react

### 项目技术栈

#### 后端技术栈

1. Spring Boot

2. Spring Security

3. MyBatis and JPA

4. MySQL

5. Swagger

6. JWT
   

#### 项目结构

项目采用按功能分模块开发方式，将通用的配置放在公共模块，`admin`模块为系统核心模块也是项目入口模块.

- sword-common 公共模块
  - utils 工具类
  - entity mybatis的实体（ JPA分支没有这个文件夹）


- sword-admin系统核心模块（系统启动入口）

  - annotation 为系统自定义注解
  - aop 切面
  - config 自定义权限实现、swagger配置、跨域、代码审计配置
  - controller 项目的API
  - model 实体类和 请求参数DTO
  - Spring Security 的相关配置和登录认证
  - utils 系统通用工具类
- sword-core

  -	exception 项目统一异常的处理
  - http 项目统一API返回
- sword-pom 工程父模块，没有任何代码

  

## 快速部署

1.clone 项目到本地

2.提前在本地 MySQL 中创建一个空的数据库 sword，导入数据data.sql，并修改项目中关于数据的配置（resources 目录下的 application.yml文件中）

3.运行SwordAdminApplication  访问URL http://localhost:8001/swagger-ui.html

4.点开sys-login-controller，输出账号密码  admin admin（账号密码都是admin）

5.获取到的token 点击右上角的Authorize，在输入框输入刚刚的token然后点击Authorize。就可以获得获取其他API 的权限

6.喜欢JPA的同学切换到jpa分支



## TODO

redis，消息队列，事件发布、监听、定时任务
