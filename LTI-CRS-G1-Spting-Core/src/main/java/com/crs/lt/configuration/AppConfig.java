package com.crs.lt.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({CourseConfig.class,ProfessorConfig.class,StudentConfig.class,UserConfig.class,AdminConfig.class})
public class AppConfig {

}
