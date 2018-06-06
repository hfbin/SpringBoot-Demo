package cn.hfbin.cache.controller;

import cn.hfbin.cache.bean.Employee;
import cn.hfbin.cache.service.EmplyoeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by: HuangFuBin
 * Date: 2018/6/5
 * Time: 9:43
 * Such description:
 */

@Slf4j
@RestController
public class EmplyoeeController {

    @Autowired
    EmplyoeeService emplyoeeService;

    @GetMapping("/emp/{id}")
    public Employee emp(@PathVariable("id") Integer id){
        log.info(""+id);
        return  emplyoeeService.getEmplyoeeById(id);
    }
    @GetMapping("/emp")
    public Employee  emps(Employee employee){

        return  emplyoeeService.updateEmp(employee);
    }
}
