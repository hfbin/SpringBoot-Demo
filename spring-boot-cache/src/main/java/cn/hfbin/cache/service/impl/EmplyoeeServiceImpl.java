package cn.hfbin.cache.service.impl;

import cn.hfbin.cache.bean.Employee;
import cn.hfbin.cache.mapper.EmployeeMapper;
import cn.hfbin.cache.service.EmplyoeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by: HuangFuBin
 * Date: 2018/6/5
 * Time: 9:41
 * Such description:
 */
@Slf4j
@Service("emplyoeeService")
public class EmplyoeeServiceImpl implements EmplyoeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    @Cacheable(cacheNames = "emp")
    public Employee getEmplyoeeById(Integer id) {
        return employeeMapper.getEmployeeById(id);
    }

    @CachePut(cacheNames = "emp" , key = "#employee.id")
    public Employee updateEmp(Employee employee) {

        int row = employeeMapper.updata(employee);

        log.info("返回结果"+row);

        return employee;
    }
}
