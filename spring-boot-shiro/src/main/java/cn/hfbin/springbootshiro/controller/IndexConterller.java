package cn.hfbin.springbootshiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by: HuangFuBin
 * Date: 2018/6/29
 * Time: 12:27
 * Such description:
 */
@Controller
public class IndexConterller {

    @GetMapping("/index")
    public String Index(){
       int i = 0;
        if(i == 0){
            new RuntimeException("运行异常");
        }

        return "index1";
    }
}
