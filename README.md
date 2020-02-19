# bs

## ✨ 特性
- 基于maven的多模块项目
- 基于mybatis plus的快速CRUD开发
- 基于注解AuthorityActuator来对权限进行的控制
- 多数据库支持，通过注解来对数据库进行切换

### 热更新配置说明

## 🎉 模块说明

- 🔢 entity 实体模块

里面保存了项目内的所有的实体文件

- 💡 mapper 数据库映射模块

- 📜 passport 系统鉴权模块

- 💎 plugins 插件模块，包括：过滤器，拦截器，aop注解等

- 📐 service 业务模块，实现具体的业务

- 🚀 web 主模块，包含启动类，系统配置

## 	🤖 多数据库配置说明

项目通过在配置文件`application-dev.yml`里面对多个数据库进行配置

配置示例：

```
db1:
   driver-class-name: com.mysql.cj.jdbc.Driver
   url: jdbc:mysql://192.168.1.19:3306/xyjg-pgy?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Hongkong
   username: node
   password: 123456
db2:
   driver-class-name: com.mysql.cj.jdbc.Driver
   url: jdbc:mysql://192.168.1.19:3306/ent-info?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Hongkong
   username: node
   password: 123456
```

之后，需要写配置类`MybatisPlusConfig`

>关于为什么aop监听要监听mapper层，我是这么想的，mapper是最底层，也就是和数据库打交道的地方
>在开发的时候，可能会出现这样的情况，比如，在一个server中，同时对两个数据库进行操作，
>所以应该放在server层🤝

## 📢 项目依赖目录

- [MyBatis-Plus](https://mp.baomidou.com/)

> MyBatis-Plus（简称 MP）是一个 MyBatis 的增强工具，在 MyBatis 的基础上只做增强不做改变，为简化开发、提高效率而生。

```
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>mybatis-plus</artifactId>
    <version>3.1.2</version>
</dependency>
```

- [alibaba/druid](https://github.com/alibaba/druid)

> Druid是Java语言中最好的数据库连接池。Druid能够提供强大的监控和扩展功能。

```
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid-spring-boot-starter</artifactId>
    <version>1.1.18</version>
</dependency>
```

- [Apache Log4j Core](http://logging.apache.org/log4j/2.x/index.html)

> Apache Log4j 2是对Log4j的升级，它比其前身Log4j 1.x提供了重大改进，并提供了Logback中可用的许多改进，同时修复了Logback架构中的一些固有问题

```
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-api</artifactId>
    <version>2.12.0</version>
</dependency>
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.12.0</version>
</dependency>
```

- [org.apache.commons.lang3](http://commons.apache.org/proper/commons-lang/)

> Lang为java.lang API提供了许多辅助工具，特别是字符串操作方法，基本数值方法，对象反射，并发，创建和序列化以及系统属性。

```xml
<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-lang3 -->
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-lang3</artifactId>
    <version>3.9</version>
</dependency>

```

## 📦 安装

在运行本项目前，请先clone工具项目[theling-base-utils](http://39.104.104.207/summary/theling-base-utils.git)
并按照项目的提示，更新依赖到maven中去

## 🔨 打包

项目使用idea进行开发，首先在IDE打开Maven插件，然后在聚合父工程bs中Lifecycle下点击 clean ，然后点击 package 进行打包

打包效果如下：
```shell
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary for bs 0.0.1-SNAPSHOT:
[INFO] 
[INFO] bs ............................................ SUCCESS [  0.005 s]
[INFO] bs-entity ..................................... SUCCESS [  2.165 s]
[INFO] bs-mapper ..................................... SUCCESS [  0.290 s]
[INFO] bs-service .................................... SUCCESS [  0.289 s]
[INFO] bs-config ..................................... SUCCESS [  0.235 s]
[INFO] bs-web ........................................ SUCCESS [  1.054 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.463 s
[INFO] Finished at: 2019-07-30T17:54:11+08:00
[INFO] ------------------------------------------------------------------------
```

打包后的jar会在`bs-service/target`中，直接运行即可


外部接口服务 bs-api

系统管理接口 bs-sys

跨域服务 bs-cors