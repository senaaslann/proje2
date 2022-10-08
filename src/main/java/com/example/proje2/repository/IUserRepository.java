package com.example.proje2.repository;

import com.example.proje2.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long>{

        // optional ne ise yariyor methot bos donerse null atiyor sadece <User> yazsak calisir ama bos oldugunda hata doner
@Query ("select COUNT(m)>0 from User m where UPPER(m.name)=UPPER(?1) and m.password=?2")
    Boolean isExistUser(String name, String password);
    // entitydeki user a gider name ve password ile baglanti kurar
    @Query("select m from User m where UPPER(m.name)=UPPER(?1)")
    User findByName (String name);
}  // Jpa dan bir kalitim yap ve cocuk olustur IUserRepository onun cocugu ONEMLI :Interfaceden Interface
// extends Clastan olursa
