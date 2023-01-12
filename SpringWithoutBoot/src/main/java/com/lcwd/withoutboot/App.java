package com.lcwd.withoutboot;

import another.world.Repo;
import another.world.RepoConfig;
import com.lcwd.withoutboot.beans.CartService;
import com.lcwd.withoutboot.beans.OrderService;
import com.lcwd.withoutboot.beans.UserService;
import com.lcwd.withoutboot.config.AppConfig;
import com.lcwd.withoutboot.config.WebConfig;
import com.lcwd.withoutboot.web.AuthController;
import com.lcwd.withoutboot.web.HomeController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ContextAnnotationAutowireCandidateResolver;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Application started");
        //we have to create object of application context
//this is for annotation configuration

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class, RepoConfig.class, WebConfig.class);
        System.out.println(context);
        CartService cartService1 = context.getBean("cartService1", CartService.class);
        cartService1.createCart();

        UserService bean = context.getBean(UserService.class);
        bean.saveUser();

        OrderService bean1 = context.getBean(OrderService.class);
        bean1.createOrder();

        HomeController ho = context.getBean(HomeController.class);
        ho.homePage();
//this is for xml based configuration
//ApplicationContext context=new ClassPathXmlApplicationContext();

        AuthController au = context.getBean(AuthController.class);
        au.login();

        Repo re = context.getBean(Repo.class);
        re.getUser();

    }
}
