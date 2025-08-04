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

import com.aliyun.oss.Service.OssService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.Domain.Emp;
import com.example.demo.Filter.JWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Sever.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author <a href="mailto:chenxilzx1@gmail.com">theonefx</a>
 */
@Slf4j
@RestController
//@RequestMapping(value = "/qq",method=RequestMethod.GET);
public class PathVariableController {
    @Autowired
    sever sever;
    @Autowired
    deptSever deptSever;
    @Autowired
    private OssService ossService;
    @Autowired
    private JWT jwt;


   @GetMapping("/Emps")
    public Result list(){
       List<Emp>s=sever.getAll();
       log.info("getEmps");
       return new Result(1,"OK",s);
   }
   @GetMapping("/Emp")
   public  Result listLimit(@RequestParam(defaultValue = "1") int page,@RequestParam(defaultValue = "10") int size){
       //PageInfo<Emp> s = sever.getAllLimit(page, size);
       IPage<Emp> s= sever.getAllLimit(page,size);
       log.info("检查第 " + page + " 页，本页 " + s.getTotal() + " 行数据");
       return new Result(1, s.getTotal()+"selectLimit", s);
   }
   /*@GetMapping("/Emp")
   public Result selectListId(@RequestBody List<Emp> l){
       List<Emp> m=sever.selectListId(l);
       return new Result(1,"OK",m);
   }*/
   @DeleteMapping("/Emp/{id}")
   public Result deleteid(@PathVariable int id){
       int n=sever.deleteId(id);
       return  new Result(1,"delete"+id,"delete"+n);
   }
    /*@PostMapping("/Emp")
    public Result upload( MultipartFile f) throws IOException {
       u.setCreateTime(LocalDateTime.now());
      String s=f.getOriginalFilename();
        int index=s.lastIndexOf('.');
        String name =s.substring(0,index);
        name= UUID.randomUUID().toString()+name;
        log.info("唯一文件名"+name);
       f.transferTo(new File("D:/"+name));
        return  new Result(1,"post",name);
    }*/

    //上传头像，返回图片的url给
    @PostMapping("/Emp")
    public Result uploadOssFile(@RequestParam("file") MultipartFile file) throws Exception {
        String url = ossService.uploadFileAvatar(file);
        return new Result(1, "upload", url);
    }
    @GetMapping("/Load")
    public  Result getOssFile(String url) throws Exception {
        String s= ossService.downloadFile(url);
        return new Result(1,"OK",s);
    }
    @PostMapping("/login")
    public Result login(@RequestBody Emp e){
        boolean flag=sever.login(e);
        if(!flag) return new Result(0,"登陆失败",e);
        Map<String,Object> m=new HashMap<>();
        m.put("id",e.getId());
        m.put("name",e.getName());
        m.put("username",e.getUsername());
        String s=jwt.genJwt(m);
        return new Result(1,"JWT",s);
    }
    @PostMapping("/logincookie")
    public Result login(@RequestBody Emp Emp, HttpServletResponse response) {
        // 模拟认证成功
        if ("admin".equals(Emp.getUsername()) && "123".equals(Emp.getPassword())) {
            Cookie cookie = new Cookie("token", "abc123xyz"); // 设置 Cookie 名称和值
            cookie.setPath("/");               // 设置作用路径
            cookie.setMaxAge(3600);            // 设置有效时间（秒），3600s = 1小时
            cookie.setHttpOnly(true);          // 防止前端 JS 访问（增加安全性）
            response.addCookie(cookie);        // 添加到响应中
            return new Result(1, "登录成功","");
        }
        return new Result(0, "用户名或密码错误","");
    }
    @GetMapping("/profile")
    public Result profile(@CookieValue(value = "token", defaultValue = "") String token) {
        //Cookie [] cookies=request.getCookies();
        if ("abc123xyz".equals(token)) {
            return new Result(1, "获取用户资料成功","");
        }
        return new Result(0, "未登录或 token 无效","");
    }
    @GetMapping("/logout")
    public Result logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("token", null);
        cookie.setPath("/");
        cookie.setMaxAge(0); // 立即过期
        response.addCookie(cookie);
        return new Result(1, "注销成功","");
    }
    @GetMapping("/opt")
    public Result opt(int id){
        boolean ans=sever.optimsim(id);
        return new Result(1,"OK",String.valueOf(ans));
    }

}
