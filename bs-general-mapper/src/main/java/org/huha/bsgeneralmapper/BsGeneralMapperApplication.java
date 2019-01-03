package org.huha.bsgeneralmapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "org.huha.bsgeneralmapper")
public class BsGeneralMapperApplication {

    public static void main(String[] args) {
        SpringApplication.run(BsGeneralMapperApplication.class, args);
    }

}

