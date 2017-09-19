package world;

import dengfx.OutputHelper;
import hello.MessageService;
import org.joda.time.LocalTime;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Observable;

@Configuration
@Component
public class Application {

    @Bean
    MessageService mockMessageService(){
        return () -> "Hello World!";
    }

    public static void main(String[] args){
//        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
//        MessagePrinter messagePrinter = context.getBean(MessagePrinter.class);
//        messagePrinter.printMessage();

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
        helloWorld.printHello();

        OutputHelper outputHelper = (OutputHelper) context.getBean("outputHelper");
        outputHelper.generateOutput();

        LocalTime currentTime = new LocalTime();
        System.out.println("The current local time is: " + currentTime);
    }
}
