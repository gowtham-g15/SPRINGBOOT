package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("resources.xml");
        // Student s = (Student) context.getBean("st");
        SpringBoot s = (SpringBoot) context.getBean("sp");
       // s.print();
        s.program();

        trainers t = (trainers) context.getBean("t");
        staffs stf =  (staffs) context.getBean("stf");
        hostel h =  (hostel) context.getBean("h");
        t.train("saruban");
        stf.staf();
        h.host();


        System.out.println( "Hello World! from app" );
        //Student s1 = new Student();
        //s1.print();
    }
}
