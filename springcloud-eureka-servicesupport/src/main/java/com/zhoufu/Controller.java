package com.zhoufu;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhoufu
 * @Date: 2021/7/5 17:09
 * @description:
 */
@RestController
@RequestMapping("/Hello")
public class Controller {

    @RequestMapping("/World")
    public String helloWorld(String s){
        System.out.println("传入的值为： " + s);
        return "传入的值为： " + s;
    }
}
