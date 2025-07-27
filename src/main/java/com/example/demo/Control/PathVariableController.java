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
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping
public class PathVariableController {
    @Autowired
    sever sever;
    @Autowired
    deptSever deptSever;
   @GetMapping("/Emps")
    public Result list(){
       List<Emp>s=sever.getAll();
       log.info("getEmps");
       return new Result(1,"OK",s);
   }
   @DeleteMapping("/Emp/{id}")
   public Result deleteid(@PathVariable int id){
       int n=sever.deleteId(id);
       return  new Result(1,"delete"+id,"delete"+n);
   }
    @PostMapping("/Emp")
    public Result hello2(@RequestBody Emp u) {
       u.setCreateTime(LocalDateTime.now());
       u.setUpdateTime(LocalDateTime.now());
        sever.posts(u);
        return  new Result(1,"post",u);
    }
}
