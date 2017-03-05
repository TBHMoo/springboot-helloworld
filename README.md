
目标：参照 泥瓦匠的博客 http://www.bysocket.com/?p=1610
在 hello-world 项目的基础上，通过前台请求到后台数据库数据。

步骤。
 一. 数据库准备 mysql  

建数据库
create database springbootdb;

建表语句。
create table city(
id int(10) unsigned not null auto_increment comment '城市编号',
province_id int(10) unsigned not null comment '省份编码',
city_name  varchar(25) default null comment '城市名称',
description  varchar(25) default null comment '描述',
primary key (id)
) engine=InnoDB auto_increment =1；

insert city(2,'郴州','故乡已成他乡');

 二. 项目依赖进来 mybatis ,和驱动。

 在主POM.xml 下加入依赖

 <properties>
   <mybatis-spring-boot>1.2.0</mybatis-spring-boot>
     <mysql-connector>5.1.39</mysql-connector>
     </properties>

     <dependency>
       <groupId>org.mybatis.spring.boot</groupId>
         <artifactId>mybatis-spring-boot-starter</artifactId>
	   <version>${mybatis-spring-boot}</version>
	   </dependency>

	   <dependency>
	     <groupId>mysql</groupId>
	       <artifactId>mysql-connector-java</artifactId>
	         <version>${mysql-connector}</version>
		 </dependency>

		 这里学会了自定义标签的使用 
		 <properties>
		      <mytagname>xxxxxxx</mytagname>
		 </properties>
		 ${mytagname}


		 在项目目录下  mvn clean install . 刷新依赖

		 项目目录结构



		 三。 解决maven 下载太慢的问题
		 下载太慢，所以找了个maven 国内的镜像。 
		 1. 找到maven settings.xml 文件
		 。D:\日常\DEVTOOLS\apache-maven-3.3.9\conf\settings.xml
		 找到 <mirros></mirros>标签，中间加入阿里的镜像配置。

		 <mirror>
		       <id>alimaven</id>
		       <name>aliyun maven</name>
		       <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
		       <mirrorOf>central</mirrorOf> 
		 </mirror>

		 然后再刷依赖 mvn clean install . 起飞

		 四，使用mybatis建立对象和表之间的关系。

		 1、新建实体类，和数据表对应。
		 org.spring.springboot.domain.City
		 这个时候需要把数据表和实体类建立连接关系。

		 2、然后新建表和City实体类字段之间的对于关系。
		 springboot-helloworld\src\main\resources\mapper\CityMapper.xml
		 这里注意，resources文件目录和java目录平级。

		 3、注册实体类，和mapper配置文件
		 D:\demos\springboot-helloworld\src\main\resources\application.properties
		 中添加

		 ## 数据源配置
		 spring.datasource.url=jdbc:mysql://localhost:3306/springbootdb?useUnicode=true&characterEncoding=utf8
		 spring.datasource.username=root
		 spring.datasource.password=root
		 spring.datasource.driver-class-name=com.mysql.jdbc.Driver

		 ## Mybatis 配置
		 mybatis.typeAliasesPackage=org.spring.springboot.domain
		 mybatis.mapperLocations=classpath:mapper/*.xml

		 这里把domain下的所有bean和 mapper下的所有xml文件都注册了。 

		 五，然后把Application应用类添加注解MapperScan
		 @SpringBootApplication
		 @MapperScan("org.spring.springboot.dao")
		 public class App  extends SpringBootServletInitializer
		 {
		 //    @Override
		 //    protected SpringApplicationBuilder configure(SpringApplicationBuilder app){
		 //        return app.sources(App.class);
		 //    }

		     public static void main( String[] args )
		         {
			         SpringApplication.run(App.class,args);
				         System.out.println( "Hello World!" );
					     }
					     }

					     MapperScan 注解会自动注册 mapper接口。 这样就和mysql 数据库连接起来了
					     最后添加controller  service ,serviceImpl ,dao,然后这里的DAO接口是在serviceImpl 实现的。







