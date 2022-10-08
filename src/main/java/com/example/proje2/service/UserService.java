package com.example.proje2.service;

import com.example.proje2.repository.IUserRepository;
import com.example.proje2.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService  {

    private final IUserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    } // ilk User donus tipi ikinci User Disardan alinan

    public Boolean isExistUser(String name, String password){
        return userRepository.isExistUser(name, password);
        //db den Userrepostoryden bir isim sifre aliyoruz
        // o isim sifre bizim db mizde var mi yok mu diye kontrol eder


        // bu asamadan sonra kontroller logine baglayacagiz

    }

    public User findByName(String name) {
        return userRepository.findByName(name);
    }
}
