package org.huha.bsresponsewrap.demo;

import org.huha.bsresponsewrap.demo.exception.DataConflictException;
import org.huha.bsresponsewrap.demo.exception.DataNotFoundException;
import org.huha.bsresponsewrap.module.annotations.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WangKun
 * @create 2018-12-21
 * @desc
 **/
@RestController
@ResponseResult
public class IndexController {
    @GetMapping("/index")
    public String index() {
        return "index hello";
    }

    @GetMapping("/home")
    public String home() throws Exception {
        if (true) {
            throw new DataConflictException("123123123");
        }
        return "index hello";
    }

    @GetMapping("/test")
    public String test() throws Exception {
        if (true) {
            throw new DataNotFoundException();
        }
        return "index hello";
    }
}
