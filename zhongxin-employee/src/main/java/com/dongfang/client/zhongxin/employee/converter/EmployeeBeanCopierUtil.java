package com.dongfang.client.zhongxin.employee.converter;

import org.springframework.cglib.beans.BeanCopier;

import com.dongfang.client.zhongxin.employee.dao.entity.Employee;
import com.dongfang.client.zhongxin.employee.vo.EmployeeVO;

/**
  * @ClassName: EmployeeBeanCopierUtil
  * @Description: EmployeeBeanCopier工具
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午10:58:45
  *
*/
public class EmployeeBeanCopierUtil {
	
	/**
	  * 生成员工VO,Entity->VO
	  * @param employee
	  * @return 
	  */
	public static EmployeeVO generateVO(Employee employee) {
		EmployeeVO employeeVO = new EmployeeVO();
		employeeEntity2VoCopier.copy(employee, employeeVO, employeeEntity2VoConverter);
		return employeeVO;
	}
	
	public static Employee generateEntity(EmployeeVO employeeVO) {
		Employee employee = new Employee();
		employeeVo2EntityCopier.copy(employeeVO, employee, employeeVo2EntityConverter);
		return employee;
	}
	
	/**
	  * @Fields employeeEntity2VoCopier : 复制器，Entity->Vo
	  */
	private static final BeanCopier employeeEntity2VoCopier = BeanCopier.create(Employee.class, EmployeeVO.class, true);
	/**
	  * @Fields employeeEntity2VoConverter : 转换器，Entity->Vo
	  */
	private static final EmployeeEntity2VoConverter employeeEntity2VoConverter = new EmployeeEntity2VoConverter();
	/**
	  * @Fields employeeVo2EntityCopier : 复制器，Vo->Entity
	  */
	private static final BeanCopier employeeVo2EntityCopier = BeanCopier.create(EmployeeVO.class, Employee.class, true);
	/**
	  * @Fields employeeVo2EntityConverter : 转换器，Vo->Entity
	  */
	private static final EmployeeVo2EntityConverter employeeVo2EntityConverter = new EmployeeVo2EntityConverter();
}
