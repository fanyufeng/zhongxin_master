package com.dongfang.client.zhongxin.web.front.controller.mail;

import java.util.Date;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongfang.client.zhongxin.commons.enums.ApiStatusCode;
import com.dongfang.client.zhongxin.employee.service.EmployeeService;
import com.dongfang.client.zhongxin.employee.vo.EmployeeVO;
import com.dongfang.client.zhongxin.mail.message.code.service.MailMessageCodeService;
import com.dongfang.client.zhongxin.mail.message.code.vo.MailMessageCodeVO;
import com.dongfang.client.zhongxin.web.front.request.mail.MailMessageRequest;
import com.dongfang.client.zhongxin.web.front.response.ResponseDataModel;
import com.sun.mail.util.MailSSLSocketFactory;


/**
 * @author 邮箱绑定
 *
 */
@Controller
@RequestMapping("/mail")
public class MailController {
	/**
	 * 邮箱发送Email
	 * @param employeeGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value ="/sendMailCode",method = RequestMethod.POST)
	@ResponseBody
	public ResponseDataModel sendMailMessageCode(@RequestBody MailMessageRequest mailMessageRequest, HttpServletRequest request,HttpServletResponse response )throws Exception{
		
		ResponseDataModel resDataModel = new ResponseDataModel();
		try {
			final Properties props=new Properties();
//			props.put("mail.smtp.auth", "true");
//			props.put("mail.smtp.host","smtp.qq.com");
//			
//			// 发件人的账号
//			props.put("mail.user","1754905293@qq.com");
//			props.put("mail.password", "4565757517");
//			props.put("mail.smtp.port", "465");
//			MailSSLSocketFactory sf = new MailSSLSocketFactory();
//			sf.setTrustAllHosts(true);
//			props.put("mail.smtp.ssl.enable","true");
//			props.put("mail.smtp.ssl.socketFactory", sf);
			
			props.put("mail.smtp.auth","true");
			props.put("mail.smtp.host","smtp.163.com");
			
			// 发件人的账号
			props.put("mail.user","jiaodapaopao@163.com");
			props.put("mail.password", "jiaodapaopao456");
			
			Authenticator authenticator = new Authenticator(){
	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                // 用户名、密码
	                String userName = props.getProperty("mail.user");
	                String password = props.getProperty("mail.password");
	                return new PasswordAuthentication(userName, password);
	            }
	        };
	        
	        Session mailSession=Session.getInstance(props, authenticator);
	        MimeMessage message = new MimeMessage(mailSession);
	        
	        // 设置发件人
	        InternetAddress form = new InternetAddress(
	                props.getProperty("mail.user"));
	        message.setFrom(form);
	        
	     // 设置收件人
	        InternetAddress to = new InternetAddress(mailMessageRequest.getEmailAdress());
	        message.setRecipient(RecipientType.TO, to);
	        
	        UUID uuid = UUID.randomUUID();
	     
	       
	        
	        EmployeeVO employeeVOModel=employeeService.getById(mailMessageRequest.getUserId());
	        String codeOne=createRandomCode();
	        MailMessageCodeVO mailMessageCode1=new MailMessageCodeVO();
	        MailMessageCodeVO mailMessageCode= mailMessageCodeService.getByEmail(mailMessageRequest.getEmailAdress());
	        if(mailMessageCode!=null){
	        	if(mailMessageCode.getIsDealWith()!=null){
	        		resDataModel.setStatusCode(ApiStatusCode.EMPLOYEE_EMAIL_EXIST.value());
	            	return resDataModel;
	        	}else{
	        		mailMessageCode.setCode(codeOne);
	        		mailMessageCodeService.update(mailMessageCode);
	        	}
	        }else{
	        	mailMessageCode1.setEmail(mailMessageRequest.getEmailAdress());
	        	mailMessageCode1.setCode(codeOne);
	        	mailMessageCode1.setUserId(mailMessageRequest.getUserId());
	        	mailMessageCodeService.save(mailMessageCode1);
	        }
	        
	    
	       
	        
	     // 设置邮件标题
	        message.setSubject("交大跑跑－学生认证");

	        // 设置邮件的内容体
	        if(employeeVOModel!=null){
	        	 message.setContent("[交大跑跑]您的验证码是"+ codeOne, "text/html;charset=UTF-8");

	        }
	       
	        // 发送邮件
	        Transport.send(message);
			
			
		} catch(Exception e){
			logger.info("===========mail_error==========="+e.getMessage());
			e.printStackTrace();
		}
		
		
		
		
		resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		
	    return resDataModel;
	}
	
	/**
	 * 邮箱发送Email
	 * @param employeeGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value ="/sendMailCode1",method = RequestMethod.POST)
	@ResponseBody
	public ResponseDataModel sendMailMessageCodeC(@RequestBody MailMessageRequest mailMessageRequest, HttpServletRequest request,HttpServletResponse response )throws Exception{
		
		ResponseDataModel resDataModel = new ResponseDataModel();
		try {
			
			resDataModel.setData("success");
			
		} catch(Exception e){
			logger.info("===========mail_error==========="+e.getStackTrace());
		}
		resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
	    return resDataModel;
	}
	
	@RequestMapping(value ="/sendMailCompare",method = RequestMethod.POST)
	@ResponseBody
	public ResponseDataModel sendMailCompare(@RequestBody MailMessageRequest mailMessageRequest, HttpServletRequest request,HttpServletResponse response )throws Exception{
		
		ResponseDataModel resDataModel = new ResponseDataModel();
		
		MailMessageCodeVO mailMessageCode=new MailMessageCodeVO();
		
		mailMessageCode=mailMessageCodeService.getByEmail(mailMessageRequest.getEmailAdress());
		
		
		if(mailMessageCode!=null){
			
			Date now = new Date();
			long time = 30*60*1000;
			Date beforeDate = new Date(now.getTime() - time);
			
			//&&mailMessageCode.getCreateDate().after(beforeDate) 
			if(mailMessageCode.getCode().equals(mailMessageRequest.getCode())){
				
				EmployeeVO employeeVO=employeeService.getById(mailMessageRequest.getUserId());
				mailMessageCode.setIsDealWith(true);
				mailMessageCodeService.update(mailMessageCode);
				if(employeeVO!=null){
					employeeVO.setEmail(mailMessageRequest.getEmailAdress());
					employeeVO.setCollege("1");
					employeeService.update(employeeVO);
					resDataModel.setData(employeeVO);
					resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
				}
				
				
				
			}else{
				resDataModel.setStatusCode(ApiStatusCode.EMPLOYEE_TIME_EXCEED.value());
			}
		}
	    return resDataModel;
	}
	
	/**
	 *  注册验证码生成
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	public static String createRandomCode(){
		String code="";
		for(int i=0;i<6;i++){
			code=code+(int)(Math.random()*9);
		}
		return code;
	}
	
	/** 日志统计 */
	private static final Logger logger = LoggerFactory.getLogger(MailController.class);
	@Autowired
	public MailMessageCodeService mailMessageCodeService;
	@Autowired
	public EmployeeService employeeService;
	

}
