package org.vaadin.springbootexample;

import com.vaadin.ui.UI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class SpringBootVaadin extends SpringBootServletInitializer {
    
    @Bean 
    @Scope("prototype")
    public UI ui() {
        return new MyVaadinUI();
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        final ServletRegistrationBean servletRegistrationBean
                = new ServletRegistrationBean(
                        new ru.xpoft.vaadin.SpringVaadinServlet(),
                        "/*", "/VAADIN/*");
        return servletRegistrationBean;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootVaadin.class, args);
    }

}
