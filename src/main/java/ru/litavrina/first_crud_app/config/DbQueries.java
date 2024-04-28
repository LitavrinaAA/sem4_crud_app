package ru.litavrina.first_crud_app.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "db")
@Getter
@Setter
public class DbQueries {
    private String findAll;
    private String save;
    private String delete;
    private String get;
    private String update;


}
