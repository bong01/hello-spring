package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController  {

    /**
     * 1. 템플릿 엔진 방식
     */
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!"); //hello HMTL문서에 데이터 넣기
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    /**
     * 2. API 방식
     */
    //HTML없이 데이터 그대로 내려줌
    @GetMapping("hello-string")
    @ResponseBody //디폴트로 json 형태로 반환
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; //"hello spring"
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //객체 반환 시 json 형태로 반환
    }

    //반환할 객체 클래스
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
