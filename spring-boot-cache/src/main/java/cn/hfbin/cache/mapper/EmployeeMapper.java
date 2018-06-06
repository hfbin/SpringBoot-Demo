package cn.hfbin.cache.mapper;

import cn.hfbin.cache.bean.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by: HuangFuBin
 * Date: 2018/6/5
 * Time: 9:25
 * Such description:
 */
@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id=#{id}")
    Employee getEmployeeById(Integer id);

    @Update("update employee set lastName=#{lastName} , email = #{email} , gender = #{gender} , d_id=#{dId} where id = #{id}")
    int updata(Employee employee);

}
