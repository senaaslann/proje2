package com.example.proje2.controllermvc;


import com.example.proje2.repository.entity.User;
import com.example.proje2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
@RequiredArgsConstructor

public class HomeMvcController {
    private final UserService userService;

    @GetMapping("/home")
    public ModelAndView home (String name){
        User user = userService.findByName(name);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("home");
        return modelAndView;
    }

}
