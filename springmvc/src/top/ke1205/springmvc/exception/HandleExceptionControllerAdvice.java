package top.ke1205.springmvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class HandleExceptionControllerAdvice {
    @ExceptionHandler({Exception.class})
    public ModelAndView handleException(Exception ex){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg", "出异常了-全局");
        return mv;
    }

    @ExceptionHandler({RuntimeException.class})
    public ModelAndView handleException2(RuntimeException ex){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg", "运行时异常-全局");
        return mv;
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ModelAndView handleException3(MaxUploadSizeExceededException ex){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello");
        mv.addObject("msg", "上传图片太大了");
        return mv;
    }
}
