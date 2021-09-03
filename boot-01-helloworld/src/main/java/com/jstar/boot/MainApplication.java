package com.jstar.boot;

import com.jstar.boot.beans.Pet;
import com.jstar.boot.beans.User;
import com.jstar.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.plaf.basic.BasicViewportUI;

/**
 * @author Jstar
 * @version 1.0
 *
 * 主程序类
 * @date 2021/9/2 9:55 下午
 */

@SpringBootApplication   //this is a Springboot Application
public class MainApplication {

    public static void main(String[] args) {

        // return IOC container
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //  return Module in container
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }

        // get Module from container, and it returns the same instance
        Pet pet = run.getBean("Tom", Pet.class);
        Pet pet2 = run.getBean("Tom", Pet.class);
        System.out.println(pet + "equal " + (pet==pet2));


        // ConfigClass is also a Module in Ioc
        MyConfig bean = run.getBean(MyConfig.class);
        User user = bean.user01();
        User user1 = bean.user01();
        System.out.println(bean);
        System.out.println((user==user1));

        Pet pet1 = user.getPet();

        System.out.println("user pet || Tom    " + (pet1 == pet));

        System.out.println("++++++++++++++++");
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }

    }
}
