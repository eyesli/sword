package com.lideng.sword.admin.aop;

import com.lideng.sword.core.exception.SwordException;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class SwordControllerAdvice {
 
    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {}
 
    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "lideng");
    }
 
    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map<String,Object> errorHandler(Exception ex) {
        Map<String,Object> map  = new HashMap<>(2);
        map.put("code", 100);
        map.put("msg", ex.getMessage());
        return map;
    }
    @ResponseBody
    @ExceptionHandler(value = SwordException.class)
    public Map<String,Object> swordErrorHandler(SwordException ex) {
        Map<String,Object> map  = new HashMap<>(2);
        map.put("code", ex.getCode());
        map.put("msg", ex.getMsg());
        return map;
    }
 
}