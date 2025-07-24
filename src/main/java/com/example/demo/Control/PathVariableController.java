/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.demo.Control;

import com.example.demo.Domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@RestController
@RequestMapping("/hello")
public class PathVariableController {
   /*@GetMapping
    public String hello1(@RequestParam("username") String name,int age){
       return name+" "+age;
   }*/
    /*@PostMapping
    public User hello2(@RequestBody User u) {
        System.out.println(u);
        return u;
    }*/
        @GetMapping
    public String hello3(String [] s) {
        int n=s.length;
        StringBuilder ans=new StringBuilder();
        int i;
        for(i=0;i<n;i++)
            ans.append((s[i]));
        return ans.toString();
    }
}
