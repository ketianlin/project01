package top.ke1205.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import top.ke1205.springmvc.pojo.User;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("hello")
public class ShowController {
    @RequestMapping("show1")
    public ModelAndView show1(){
        System.out.println("前置连接器启动了……");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg", "这个是注解方式的controller");
        return mv;
    }

    @RequestMapping("aa?/show2")
    public ModelAndView show2(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg", "这个是ant风格的映射：？aaaaaaa");
        return mv;
    }

    @RequestMapping("bb*/show3")
    public ModelAndView show3(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg", "这个是ant风格的映射：*bbbccc");
        return mv;
    }

    @RequestMapping("**/show4")
    public ModelAndView show4(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg", "这个是ant风格的映射：**show4");
        return mv;
    }

    @RequestMapping("/user/{name}/{userid}")
    public ModelAndView show5(@PathVariable("userid") Integer id, @PathVariable("name") String uname){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg", "rest风格的映射：name="+uname+",id="+id);
        return mv;
    }

    @RequestMapping(value = "show6", method = RequestMethod.POST)
    public ModelAndView show6(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg", "限定请求方法的映射：POST");
        return mv;
    }

    @RequestMapping(value = "show7", params = "!id")
    public ModelAndView show7(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg", "springmvc的映射之限定请求参数，!id");
        return mv;
    }

    @RequestMapping("show8")
    public ModelAndView show8(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:show10.do?id=123&key=show08&type=redirect");
        return mv;
    }

    @RequestMapping("show9")
    public ModelAndView show9(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("forward:show10.do?id=456&key=show09&type=forward");
        return mv;
    }

    @RequestMapping("show10")
    public String show10(@RequestParam("id") Long id, @RequestParam("key") String key,
                        @RequestParam("type") String type, Model model){
        String msg = "id=" + id + ",key=" + key + ",type=" + type;
        model.addAttribute("msg", msg);
        return "hello";
    }

    @RequestMapping("show11")
    public String show11(){
        return "forward:show10.do?id=789&key=show11&type=forward_string";
    }

    @RequestMapping("show12")
    @ResponseBody
    public List<User> show12(){
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            User user = new User("张三"+i,"123"+i,18+i,(2600d + 1),false, new String[]{"台球"+i,"ktv"+i},"fuck"+i,i+1l,new Date());
            users.add(user);
        }
        return users;
    }

    @RequestMapping("show13")
    public String show13(@RequestBody User user, Model model){
        model.addAttribute("msg", user.toString());
        return "hello";
    }

    @RequestMapping("show14")
    public String show14(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        System.out.println(file);
        String msg = file.getName() + "," + file.getOriginalFilename();

        file.transferTo(new File("C:\\Java\\java_demos\\project01\\springmvc\\web\\uploads\\" + file.getOriginalFilename()));
        model.addAttribute("msg", msg);
        return "redirect:/success.html";
    }

    @RequestMapping("show15")
    public ModelAndView show15() throws RuntimeException{
        if (true){
            throw new RuntimeException();
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg", "这个是注解方式的controller");
        return mv;
    }
}
