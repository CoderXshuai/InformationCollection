
# InformationCollectionSystem
- [InformationCollectionSystem](#informationcollectionsystem)
  - [1.项目描述](#1项目描述)
  - [2.环境配置(所有相关的jar包都在Information/lib文件夹中)](#2环境配置所有相关的jar包都在informationlib文件夹中)
  - [3.文件夹介绍](#3文件夹介绍)
    - [3.1 lib](#31-lib)
    - [3.2 out](#32-out)
    - [3.3 src](#33-src)
      - [3.3.1 action](#331-action)
        - [3.3.1.1 DocAction](#3311-docaction)
        - [3.3.1.1 DownloadAction](#3311-downloadaction)
        - [3.3.1.1 InboxAction](#3311-inboxaction)
        - [3.3.1.1 UserAction](#3311-useraction)
      - [3.3.2 conf](#332-conf)
        - [3.3.2.1 applicationContext.xml](#3321-applicationcontextxml)
        - [3.3.2.2 applicationContext-beans.xml](#3322-applicationcontext-beansxml)
        - [3.3.2.3 db.properties](#3323-dbproperties)
        - [3.3.2.4 hibernate.cfg.xml](#3324-hibernatecfgxml)
        - [3.3.2.4 struts2.xml](#3324-struts2xml)
        - [3.3.2.5 mail.properties](#3325-mailproperties)
      - [3.3.3 dao](#333-dao)
        - [3.3.3.1 imp](#3331-imp)
        - [3.3.3.2 BaseDao](#3332-basedao)
        - [3.3.3.3 DocDao](#3333-docdao)
        - [3.3.3.4 FileHashDao](#3334-filehashdao)
        - [3.3.3.5 InboxDao](#3335-inboxdao)
        - [3.3.3.5 UserDao](#3335-userdao)
      - [3.3.4 filter](#334-filter)
      - [3.3.4.1 LoginFilter](#3341-loginfilter)
      - [3.3.5 listener](#335-listener)
      - [3.3.6 model](#336-model)
      - [3.3.7 service](#337-service)
        - [3.3.7.1 imp](#3371-imp)
      - [3.3.8 util](#338-util)
        - [3.3.8.1 Config](#3381-config)
        - [3.3.8.2 MailUtil](#3382-mailutil)
        - [3.3.8.3 MyUtils](#3383-myutils)
        - [3.3.8.4 SmsUtils](#3384-smsutils)
        - [3.3.8.4 Static](#3384-static)
    - [3.4 web](#34-web)
      - [3.4.1 css](#341-css)
      - [3.4.2 img](#342-img)
      - [3.4.3 js](#343-js)
      - [3.4.4 upFile](#344-upfile)
        - [3.4.4.1 src](#3441-src)
      - [3.4.5 layui](#345-layui)
      - [3.4.5 WEB-INF](#345-web-inf)
    - [3.5 README.md](#35-readmemd)
  - [4.项目进度](#4项目进度)
## 1.项目描述
一个能实现提交收集信息的web系统
## 2.环境配置(所有相关的jar包都在Information/lib文件夹中)
- JDK:1.8
- Tomcat:9.0.27
- IDE:IntelliJ IDEA 2020.1
- spring:5.2.3.RELEASE
- struts:2.5.22
- MySQL:8.0.15
- 数据库连接池:dbcp2.2.1
- 前端模板:layUI
## 3.文件夹介绍
### 3.1 lib
项目所需jar包必须全部复制到在lib中
### 3.2 out
项目运行时生成的war包和.class文件
### 3.3 src
主文件目录
#### 3.3.1 action
控制层,主要是struts2的控制类
##### 3.3.1.1 DocAction
文件上传
##### 3.3.1.1 DownloadAction
文件下载(管理员权限)
##### 3.3.1.1 InboxAction
收件箱(管理员权限)
##### 3.3.1.1 UserAction
用户
#### 3.3.2 conf
配置层,全是配置文件(这里面的配置文件有的应该放在src目录下,如果调用的时候注意位置)
##### 3.3.2.1 applicationContext.xml
spring整合hibernate的配置文件
##### 3.3.2.2 applicationContext-beans.xml
spring管理的各种bean
##### 3.3.2.3 db.properties
数据库的配置文件,根据个人情况用,建议使用默认的
##### 3.3.2.4 hibernate.cfg.xml
hibernate属性配置(hibernate连接已经在applicationContext.xml配置完成)
##### 3.3.2.4 struts2.xml
struts2的配置文件
##### 3.3.2.5 mail.properties
邮箱配置,主要是默认的发件邮箱等信息
#### 3.3.3 dao
数据访问控制层
##### 3.3.3.1 imp
各个dao层文件的实现类
##### 3.3.3.2 BaseDao
基本的数据访问接口(增删改查等)
##### 3.3.3.3 DocDao
文件上传
##### 3.3.3.4 FileHashDao
识别相同类型的文件,后期根据进度调整(实现不实现意义不大)
##### 3.3.3.5 InboxDao
收集箱
##### 3.3.3.5 UserDao
用户管理
#### 3.3.4 filter
拦截器
#### 3.3.4.1 LoginFilter
登录拦截,防止未登录用户登录(后期可以整合到struts2框架中),目前这个功能在web.xml注释掉了,不然总是报错

#### 3.3.5 listener
监听器,暂时没有相对于的实现,有需要再添加
#### 3.3.6 model
实体层,和上文的对应方式类似,*.hbm.xml文件为每个实体类的配置文件
#### 3.3.7 service
业务层,对应方式和上文类似,每个接口分别对应其功能
##### 3.3.7.1 imp
每个业务的具体实现方法
#### 3.3.8 util
常用工具的封装,其中有一些测试项的文件,最后会删除
##### 3.3.8.1 Config
获取用户上传文件之后的存储位置(暂定web/upFile文件夹)
##### 3.3.8.2 MailUtil
发送提醒邮件的工具类
##### 3.3.8.3 MyUtils
常用工具的封装,底层实现都简单,注释写的比较清楚
##### 3.3.8.4 SmsUtils
通过阿里云服务器发送手机短信验证,网上找的代码,因为需要收费,不准备使用,可能会使用邮箱验证
##### 3.3.8.4 Static
常用的静态属性获取
### 3.4 web
web资源
其中页面会出现乱码的情况,暂时尚未能解决
#### 3.4.1 css
样式文件
#### 3.4.2 img
界面所有图片文件
#### 3.4.3 js
JavaScript脚本
#### 3.4.4 upFile
暂定的用户上传文件的存储位置
##### 3.4.4.1 src
#### 3.4.5 layui
laiUI的包
为了提高扩展性,目前先把文件上传到src中
#### 3.4.5 WEB-INF
web.xml的配置文件(其中拦截器没有配置好,总是报错,先注释掉了)
### 3.5 README.md
文件的说明,有相关的更新需要在这个文档里写出,方便协作
## 4.项目进度
- 5.15 
项目立项,IDE以及编程环境统一,为了方便协作统一使用[远端仓库](https://gitee.com/xushuai1999/InformationCollection)
明确分工,许帅和徐新杰先把环境配置好,王永辛去学学layUI,魏兆兴和王璟晖先把上课没好好学的补一补
- 5.18
正式确定项目做的功能,编程环境以及引入的jar包正式确定,不适应maven仓库,jar包统一放在lib文件夹下
- 5.22
项目结构基本搭建完成,具体每个文件夹的功能在上文都有相对于的说明,具体每个文件夹的内容待定,约定好有变动在README中写入,为了前后端方便交互,学一下ajax.
-5.23 
开了一个会议,了解了每个人任务的进度,有快有慢,根据每个人任务的进度重新分配了工作.
许帅把负责主要功能模块的定义(dao层和service层接口定义),

王璟晖辅助并确定所需要的工具类(暂时需要邮件收发工具类),

徐新杰负责数据库表结构的设计(暂定为user,doc和inbox三个表)和model层

魏兆兴负责准备构思上交的文档和PPT

王永辛把layUI的常见模板学一下,并学会用ajax和后端交互
- 5.26
徐新杰已基本完成数据库表结构的设计,但冗余有点大,有些地方不合理,后期有需要再改动
王璟晖找到了spring邮箱验证的jar包和相关操作,在spring的配置文件中配置完成之后测试可用
- 5.27
许帅已完成spring和struts2的整合,并进行了基本的调试,下一步准备把ajax学了然后尝试前后端交互一下
- 5.30
魏兆兴参与项目功能模块的定义
- 5.31
王永辛对layUI基本熟悉了,可参照模板做出一些基本的空间,ajax用的不熟练,参与项目的model层设计
- 6.2
开会商讨了一下后续流程,项目结构还差hibernate框架的整合,中间bug太多,需要一定时间处理,许帅把hibernate整合好,
其余人先学习ssh的相关知识,整合好就开始分功能写service层和dao层.
- 6.4
许帅基本完成hibernate的整合,在配置事务切入点的时候出了一点问题,
暂时无法进行写入操作,可完成查询操作,本周应该能解决.
- 6.6
许帅完成service层的主要代码,但问题较多,需要解决,dao层正在根据业务逻辑写
主界面的外观正在优化,根据时间的进度决定优化的程度
- 6.7
ajax交互的问题较多,需要重点解决
-6.9
项目全部的代码基本完成,目前正在整合,登录注册个人信息管理整合完毕
-6.10
创建收件夹的功能整合完毕
-6.10晚上
还差表单提交的功能,布局外观做了一定的优化,明天再把最新的截图替换掉PPT和文档中之前的截图
并录屏整个过程即完成.
6.11
表单提交完成,新增了把提交的表单信息转化成json文件的形式保存,下一步把收件夹和表单关联即可
6.13
项目基本完工,可根据时间优化一些部分