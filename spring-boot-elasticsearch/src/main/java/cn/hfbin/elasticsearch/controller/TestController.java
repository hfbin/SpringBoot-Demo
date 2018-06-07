package cn.hfbin.elasticsearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by: HuangFuBin
 * Date: 2018/6/8
 * Time: 0:12
 * Such description:
 */
@RestController
public class TestController {

    @GetMapping("/hellos")
    public String idnex(){
        return "index";
    }

}
