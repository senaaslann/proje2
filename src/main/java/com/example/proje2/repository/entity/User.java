package com.example.proje2.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "tblusers")        // Tablo isimlendirilmesi
@Entity                         // Tablo olusturulmasi
@AllArgsConstructor             // Dolu Constructor
@NoArgsConstructor              //Bos Constructor
@Data                           // Getter Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY ) // Bu strateji ile Sirala
    private Long id;
    private String name;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private Cinsiyet cinsiyet;
}


