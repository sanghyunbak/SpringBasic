package com.shbak;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by fingdori on 2017-01-22.
 */
@Configuration
@ComponentScan
public class Application {

    @Bean
    MessageService mockMessageService(){
        return new MessageService() {
            public String getMessage(){
                return "hello, world!";
            }
        };
    }

    public static void main(String[] args){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();
    }
}
