package com.example.proje2.controllermvc;

import com.example.proje2.repository.entity.Cinsiyet;
import com.example.proje2.repository.entity.User;
import com.example.proje2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // register.html de formun icerisindekinin direk burayi kontrol etmesini saglar ayni zamanda
@RequestMapping("/login")
@RequiredArgsConstructor // Gerek oldugunda Constructor
public class LoginMvcController {

    private final UserService userService;
    private final HomeMvcController homeMvcController;


    @GetMapping("/loginpage")
    public ModelAndView login(){

        String ka="Kullanici Adi";
        String sfr="Sifre";
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login");
        modelAndView.addObject("kullanicilbl",ka);
        modelAndView.addObject("sifrelbl",sfr);
        return modelAndView;
    }

    @PostMapping("/dologin")
        public ModelAndView doLogin(String name,String password){
        if (userService.isExistUser(name, password)){
//            return new ModelAndView("redirect:/home");
            return homeMvcController.home(name);
            //new ModelAndView("redirect:/personalpage"); // hoca boyle yapmis yonlendirerek
        }else{
            return new ModelAndView("redirect:/error");
        }


    }




    @GetMapping("/registerpage")
        public ModelAndView register(){                      // bu bir class html ile bir kopru diyebiliriz
            ModelAndView modelAndView=new ModelAndView();    // Bir nesne olusturduk
                                                            // olusturulan nesnenin icine parantez ici
                                                            // bossa bos Cons ozelligi doluysa dolu cons

            modelAndView.setViewName("register");           // html de sayfanin goruntulenmesi icin olusturulur
            return modelAndView;
    }
    @PostMapping("/doregister")  // Html ile baglanti kurulur register form ile baglantili front backend baglantisi diyebiliriz
    public ModelAndView doRegister (String name, String password, String email, Cinsiyet cinsiyet){
      userService.save(
              User.builder()
                      .name(name)
                      .password(password)
                      .email(email)
                      .cinsiyet(cinsiyet)
                      .build()

      );
      return new ModelAndView("redirect:loginpage");
    }



}
