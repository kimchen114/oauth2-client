/*
 * Copyright 2012-2015 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SocialApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(SocialApplication.class, args);
    }
    
    @RequestMapping("/user")
    public Map<String, String> user(Principal principal) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", principal.getName());
        return map;
    }
    
    @RequestMapping("/me")
    public Map<String, String> me() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "123");
        return map;
    }
    
    @RequestMapping("/index")
    public Map<String, String> user() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "index");
        return map;
    }
    
    @RequestMapping("/login")
    public Map<String, String> login() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "index");
        return map;
    }
    
}
