package com.example.demo.Trancation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
public class Transcation {
    @Transactional//尽量写在接口不写实现类降低耦合
    public int zhuan(int money){
        try{

        }
        catch (Exception e){

        }
        finally {
            log(""+money);
        }
        return money;
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void log(String s){
        log.info(s);
    }
}
