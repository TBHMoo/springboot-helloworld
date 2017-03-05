package org.spring.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Hello world!
 *
 */
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
