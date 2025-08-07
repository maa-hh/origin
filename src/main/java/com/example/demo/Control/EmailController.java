package com.example.demo.Control;

import com.example.demo.Sever.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class EmailController {

    @Autowired
    private MailService mailService;

    @GetMapping("/send")
    public Result send(@RequestParam String to,
                       @RequestParam String subject,
                       @RequestParam String content) {
        mailService.sendSimpleMail(to, subject, content);
        return new Result(1, "OK", "sendMail");
    }
}

