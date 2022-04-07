package ru.job4j.accident;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {
    public static void main(String[] args) {
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        String st = bc.encode("encode");
        System.out.println(st);
    }
}
