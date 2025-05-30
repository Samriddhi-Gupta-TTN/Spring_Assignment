package com.assignment.restfulAPI.part2.Question1;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
    @RestController
    public class GreetingController {

        private MessageSource messageSource;

        public GreetingController(MessageSource messageSource) {
            this.messageSource = messageSource;
        }
        @GetMapping("/greet")
        public String greetUser(){
            Locale locale = LocaleContextHolder.getLocale();
            String message = messageSource.getMessage("good.morning.message",null,"Default message",locale);
            return message;
        }
    }

