package com.example.demo.Control;

import com.example.demo.Sever.SSMserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/SSM")
public class SSM {
    @Autowired
    SSMserver ssMserver;
    @PostMapping("get")
    public Result getSSM(@RequestParam("num") String num){
        String code=ssMserver.getSSM(num);
        return new Result(1,"OK",code);
    }
    @GetMapping("/check/{num}/{code}")
    public Result check(@PathVariable String num,@PathVariable String code){
        Boolean ans=ssMserver.check(num,code);
        return new Result(1,"check",ans);
    }
}
