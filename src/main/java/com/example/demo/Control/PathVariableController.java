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

import com.example.demo.Domain.Emp;
import com.example.demo.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Sever.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@RestController
@RequestMapping("/hello")
public class PathVariableController {
    @Autowired
    sever sever;
   /*@GetMapping
    public String hello1(@RequestParam("username") String name,int age){
       return name+" "+age;
   }*/
    /*@PostMapping
    public User hello2(@RequestBody User u) {
        System.out.println(u);
        return u;
    }*/
       /* @GetMapping
    public Result hello3(String [] s) {
        int n=s.length;
        StringBuilder ans=new StringBuilder();
        int i;
        for(i=0;i<n;i++)
            ans.append((s[i]));
        return new Result(1,"OK","hello");
    }*/
   /* @GetMapping("/Time")
    public String time(@DateTimeFormat(pattern="yyyy-mm-dd hh:mm:ss") LocalDateTime time) {
        System.out.println(time);
        return time.toString();
    }*/
    @GetMapping("/{id}")
    public Result id(@PathVariable int id) {
        List<Emp>ans=sever.select(id);
        System.out.println(id);
        return new Result(1,"find",ans);
    }
}
