package org.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Hello world!
 *
 */
@EnableAspectJAutoProxy //依赖spring aop 模块之后默认开启 java 动态代理
@SpringBootApplication
//@MapperScan("org.spring.springboot.dao")
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
