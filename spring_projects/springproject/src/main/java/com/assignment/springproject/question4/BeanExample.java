package com.assignment.springproject.question4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

    @SpringBootApplication
    public class BeanExample {
        private static final Logger LOGGER = LoggerFactory.getLogger(BeanExample.class);
        public static void main(String[] args) {
            ApplicationContext applicationContext = SpringApplication.run(BeanExample.class);
            DemoBean demoBean = applicationContext.getBean(DemoBean.class);
            demoBean.setId(21);
            demoBean.setName("Samriddhi");
            LOGGER.info("Bean Name: {}",demoBean.getName());
            LOGGER.info("Bean id: {}",demoBean.getId());

        }
    }

