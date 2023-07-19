package bg.proxiad.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"bg.proxiad.demo.controller", "bg.proxiad.demo.service"})
@EnableWebMvc
public class Config {}
