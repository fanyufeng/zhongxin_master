package com.dongfang.client.zhongxin.commons.enums;

/**
  * @ClassName: ApiStatusCode
  * @Description: API接口返回状态码
  * 00-00-00-00
  * 1、2-状态级别，01-系统异常，02-普通异常
  * 3、4-模块，01-会员，02-员工
  * 5、6-子模块，默认00，不划分；01-基础，02-列表等
  * 7、8-错误详情，01-员工姓名填写错误等
  * @author fyf820@163.com
  * @date 2016年7月8日 下午5:22:49
  *
*/
public enum ApiStatusCode {
	/**
	 * @Fields SUCCESS : 成功
	 */
	SUCCESS("02000000"),
	/**
	 * @Fields EMPLOYEE_OPENID_ERROR : 微信openid反悔错误
	 */
	EMPLOYEE_OPENID_ERROR("01000000"),
	/**
	  * @Fields EMPLOYEE_NAME_ERROR : 员工姓名错误
	  */
	EMPLOYEE_NAME_ERROR("02020001"),
	/**
	  * @Fields EMPLOYEE_NAME_ERROR : 员工重复注册
	  */
	EMPLOYEE_TELEPHONE_EXIST("02020002"),
	/**
	  * @Fields EMPLOYEE_NAME_ERROR : 员工自定义模块有空指针
	  */
	EMPLOYEE_CUSTOM_FORM_NULL("02020003"),
	
	/**
	  * @Fields EMPLOYEE_NAME_ERROR : 员工登陆密码错误
	  */
	EMPLOYEE_LOGIN_PASSWORD_ERROR("02020114"),
	/**
	  * @Fields EMPLOYEE_NAME_ERROR : 员工不存在
	  */
	EMPLOYEE_USER_NOT_EXIST("02020004"),
	/**
	  * @Fields  CODE_NUMBER_ERROR : 验证码错误
	  */
	CODE_NUMBER_ERROR("02020005"),
	
	/**
	  * @Fields  CODE_NUMBER_ERROR : 部门不存在
	  */
	
	DEPARTMENTLIST_NO_EXIST("02020006"),
	/**
	  * @Fields  CODE_COMPARE_ERROR : 验证码匹配错误
	  */
	CODE_COMPARE_ERROR("02020008"), 
	/**
	  * @Fields  CODE_COMPARE_ERROR : 登陆登出
	  * 
	  */
	LOGIN_OUT("02020009"),
	
	/**
	  * @Fields  INVITATOR_NOT_EXIST : 邀请人不存在
	  * 
	  */
	INVITATOR_NOT_EXIST("02020010"),
	
	/**
	  * @Fields  INVITATOR_NOT_EXIST : 邀请人已有公司
	  * 
	  */
	INVITATOR_EXIST_COMPANY("02020011"),
	
	/**
	  * @Fields  INVITATOR_NOT_EXIST : 权限为0 的员工列表不存在
	  * 
	  */
	EMPLOYEE_POWER_ZEOR_NOT_EXIST("02020012"),
	
	/**
	  * @Fields  EMPLOYEE_POWER_ONE_NOT_EXIST : 权限为1 的员工列表不存在
	  * 
	  */
	EMPLOYEE_POWER_ONE_NOT_EXIST("02020013"),
	
	/**
	  * @Fields  EMPLOYEE_POWER_TWO_NOT_EXIST : 权限为2 的员工列表不存在
	  * 
	  */
	EMPLOYEE_POWER_TWO_NOT_EXIST("02020014"),
	
	/**
	  * @Fields  EMPLOYEE_POWER_TWO_NOT_EXIST : 权限此等级人数超过5个
	  * 
	  */
	EMPLOYEE_POWER_LIMIT_FIVE("02020015"),
	/**
	  * @Fields  PASSWORD_NOT_EQUAL : 修改密码两次输入密码不一致
	  * 
	  */
	PASSWORD_NOT_EQUAL("02020016"),
	
	/**
	  * @Fields  EMPLOYEE_EMAIL_EXIST : 绑定邮箱已经存在
	  * 
	  */
	EMPLOYEE_EMAIL_EXIST("02020017"),
	
	/**
	  * @Fields  EMPLOYEE_EMAIL_EXIST : 绑定邮箱已经存在
	  * 
	  */
	EMPLOYEE_TIME_EXCEED("02020018"),
	/**
	  * @Fields  CHECKER_NOT_CREATER : 审核人为创建人
	  * 
	  */
	CHECKER_NOT_CREATER("02020019"),
	
	/**
	  * @Fields  INVITER_ALREADY_EXIST : 邀请人已经存在
	  * 
	  */
	INVITER_ALREADY_EXIST("02020020"),
	
	/**
	  * @Fields  LOWER_DEPARTMENT_EMPLOYEE_NOT_EXIST : 不存在下属员工
	  * 
	  */
	LOWER_DEPARTMENT_EMPLOYEE_NOT_EXIST("02020021"),
	/**
	  * @Fields  DEPARTMENT_NOT_DIRECTOR : 未设主管
	  * 
	  */
	DEPARTMENT_NOT_DIRECTOR("02020022"),
	/**
	  *@Fields  VIVATOR_JOIN_COMPANY: 已经提出申请
	  * 
	  */
	VIVATOR_JOIN_COMPANY("02020023"),
	/**
	  *@Fields  EXIST_SON_EMPLOYEE: 存在子员工
	  * 
	  */
	EXIST_SON_EMPLOYEE("02020024"),
	/**
	  *@Fields  EXIST_SON_DEPARTMENT: 存在子部门
	  * 
	  */
	EXIST_SON_DEPARTMENT("02020025"),
	/**
	  *@Fields  EXIST_SON_DEPARTMENT: 存在子部门
	  * 
	  */
	ADMIN_EXIST("02020026"),
	/**
	  *@Fields  EXIST_SON_DEPARTMENT: 存在子部门
	  * 
	  */
	EMPLOYEE_NO_PASSWORD("02020027"),
	
	/**
	  *@Fields  EMPLOYEE_DEIRCT_NOT_LEAVE: 员工为管理员不能离职
	  * 
	  */
	EMPLOYEE_DEIRCT_NOT_LEAVE("02020028"),
	/**
	  *@Fields  EMPLOYEE_ACCEPT_EXIST: 已经存在公司不能接受邀请
	  * 
	  */
	EMPLOYEE_ACCEPT_EXIST("02020029"),
	/**
	  *@Fields  EMPLOYEE_SIGN_IN_ONLY: 单点登陆返回码
	  * 
	  */
	EMPLOYEE_SIGN_IN_ONLY("02020030"),
	/**
	  *@Fields  EMPLOYEE_SIGN_UP: 用户已报名
	  * 
	  */
	EMPLOYEE_SIGN_UP("02020031"),
	/**
	  *@Fields  EMPLOYEE_SIGN_UP: 用户已报名
	  * 
	  */
	OUT_DATE("02020032"),
	/**
	  * @Fields  过滤器 
	  */
	ACCESS_DENY("02020007");
	private final String value;

	ApiStatusCode(String v) {
		value = v;
	}

	public String getValue() {
		return value;
	}

	public String value() {
		return value;
	}

	public static ApiStatusCode fromValue(String v) {
		for (ApiStatusCode c : ApiStatusCode.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}

}
