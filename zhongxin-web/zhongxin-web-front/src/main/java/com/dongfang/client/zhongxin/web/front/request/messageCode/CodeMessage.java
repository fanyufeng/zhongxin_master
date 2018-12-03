package com.dongfang.client.zhongxin.web.front.request.messageCode;
/** 
 * 
 * @author  fyf820@163.com: 
 * @date 创建时间：2017年5月10日 下午2:55:58 
 * @version 1.0 
 * @parameter  
 * @since  
 * @return  
 */
public class CodeMessage {
	public String employeeId;
	public String urlCode;
	public String telephone;
	public String codeNumber;
	public String getUrlCode() {
		return urlCode;
	}
	public void setUrlCode(String urlCode) {
		this.urlCode = urlCode;
	}
	
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCodeNumber() {
		return codeNumber;
	}
	public void setCodeNumber(String codeNumber) {
		this.codeNumber = codeNumber;
	}
	

}
