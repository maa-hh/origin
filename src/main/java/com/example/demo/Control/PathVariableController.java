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
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Sever.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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
   @GetMapping("/Emp/{page}/{size}")
   public  Result listLimit(@PathVariable int page,@PathVariable int size){
       PageInfo<Emp> s = sever.getAllLimit(page, size);
       log.info("检查第 " + page + " 页，本页 " + size + " 行数据");
       return new Result(1, "selectLimit", s);
   }
   @GetMapping("/Emp")
   public Result selectListId(@RequestBody List<Emp> l){
       List<Emp> m=sever.selectListId(l);
       return new Result(1,"OK",m);
   }
   @DeleteMapping("/Emp/{id}")
   public Result deleteid(@PathVariable int id){
       int n=sever.deleteId(id);
       return  new Result(1,"delete"+id,"delete"+n);
   }
    @PostMapping("/Emp")
    public Result upload( MultipartFile f) throws IOException {
    /*
       u.setCreateTime(LocalDateTime.now());
*/       String s=f.getOriginalFilename();
       f.transferTo(new File("D:/"+s));
        return  new Result(1,"post",s);
    }
}
