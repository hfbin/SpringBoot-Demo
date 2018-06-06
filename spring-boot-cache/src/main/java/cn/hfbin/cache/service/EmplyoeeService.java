package cn.hfbin.cache.service;

import cn.hfbin.cache.bean.Employee;

/**
 * My Blog : www.hfbin.cn
 * github: https://github.com/hfbin
 * Created by: HuangFuBin
 * Date: 2018/6/5
 * Time: 9:41
 * Such description:
 */
public interface EmplyoeeService {

    Employee getEmplyoeeById(Integer id);

    Employee updateEmp(Employee employee );
}
