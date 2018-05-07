package com.dongfang.client.zhongxin.web.front.controller.employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dongfang.client.zhongxin.commons.constants.Constants;
import com.dongfang.client.zhongxin.commons.enums.ApiStatusCode;
import com.dongfang.client.zhongxin.employee.service.EmployeeService;
import com.dongfang.client.zhongxin.employee.vo.EmployeeVO;
import com.dongfang.client.zhongxin.web.front.request.employee.UserLoginRequest;
import com.dongfang.client.zhongxin.web.front.request.employee.UserRegisterRequest;
import com.dongfang.client.zhongxin.web.front.response.ResponseDataModel;

import net.sf.json.JSONObject;




/**
 * @author 员工控制器
 *
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	
	
	/**
	 *  注册
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/register")
	public @ResponseBody ResponseDataModel save(@RequestBody EmployeeVO employeeVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			System.out.println("success");
			//employeeService.save(employeeVO);
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("EmployeeController#save({}) : {}", 
					employeeVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	}
	
	/**
	 *  个人信息返回
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getById")
	public @ResponseBody ResponseDataModel getById(@RequestBody EmployeeVO employeeVO) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			EmployeeVO employeeResponse= employeeService.getById(employeeVO.getId());
			if(employeeResponse!=null){
				resDataModel.setData(employeeResponse);		
			}
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
		}catch(Exception e){
			logger.error("EmployeeController#save({}) : {}", 
					employeeVO.toString(),
					ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	}
	/**
	 *  登陆
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/login")
	public @ResponseBody ResponseDataModel login(@RequestBody UserRegisterRequest userRegisterRequest, HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			
			
			String JSCODE=userRegisterRequest.getCode();
			String jsonString="https://api.weixin.qq.com/sns/jscode2session?appid="+Constants.APPID+"&secret="+Constants.SECRET+"&js_code="+JSCODE+"&grant_type=authorization_code";
			String jsonFan = loadJson(jsonString);   
			//检测jsonFan字符串
		    String res=".*errmsg.*";
		    
		    Boolean matchResult= jsonFan.matches(res);	    
			if(matchResult){
				resDataModel.setStatusCode(ApiStatusCode.EMPLOYEE_OPENID_ERROR.value());
				
			}else{
				
				
				JSONObject jsonObject = JSONObject.fromObject(jsonFan);
				System.out.println(jsonFan);
				String openid = jsonObject.getString("openid");
				String sessionKey=jsonObject.getString("session_key");
				
				byte[] resultByte = AESUtil.instance.decrypt(Base64.decodeBase64(userRegisterRequest.getEncryptedData()), Base64.decodeBase64(sessionKey), Base64.decodeBase64(userRegisterRequest.getIv()));
				
				
				logger.info("=========resultByte======="+resultByte);
				if(null != resultByte && resultByte.length > 0){
				      String userInfo = new String(resultByte, "UTF-8");
				      JSONObject json = JSONObject.fromObject(userInfo); //将字符串{“id”：1}
				      logger.info("=========json======="+json);
				      String unionidx=json.getString("unionId"); 
				      
				   
				      if(unionidx!=null){
							EmployeeVO employeeVO=employeeService.getByUnionId(unionidx);
							
							if(employeeVO==null){
								EmployeeVO employeeVOModel=new EmployeeVO();
								employeeVOModel.setOpenid(openid);
								employeeVOModel.setUnionId(unionidx);
								request.getSession().setAttribute(Constants._SESSION_USER_ID_KEYPREFIX,unionidx);
								employeeVOModel.setAvatarUrl(userRegisterRequest.getAvatarUrl());
								employeeVOModel.setNickName(userRegisterRequest.getNickName());
								employeeVOModel.setGender(userRegisterRequest.getGender());
								employeeVOModel.setSessionKey(sessionKey);
								
								String id =employeeService.save(employeeVOModel);
								EmployeeVO employeeVOElem=employeeService.getById(id);
								resDataModel.setData(employeeVOElem);
								resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());	
							}else{
								request.getSession().setAttribute(Constants._SESSION_USER_ID_KEYPREFIX,unionidx);
								employeeVO.setOpenid(openid);
								employeeVO.setUnionId(unionidx);
								employeeVO.setSessionKey(sessionKey);
								employeeService.update(employeeVO);
								resDataModel.setData(employeeVO);
								resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());	
							}
						}else{
							resDataModel.setStatusCode(ApiStatusCode.EMPLOYEE_OPENID_ERROR.value());
						}
				      
				}
			}		
		}catch(Exception e){
			logger.error("EmployeeController#save({}) : {}", 
					userRegisterRequest.toString(),
					ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	
	}
	
	/**
	 *  员工注册
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/loginUnion",method=RequestMethod.POST)
	@ResponseBody
	public ResponseDataModel login(@RequestBody UserLoginRequest userLoginRequest, HttpServletRequest request,HttpServletResponse response) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			
			EmployeeVO employeeVO=employeeService.getByUnionId(userLoginRequest.getUnionid());
			if(employeeVO==null){
				resDataModel.setStatusCode(ApiStatusCode.EMPLOYEE_USER_NOT_EXIST.value());
			}else{
				resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
				request.getSession().setAttribute(Constants._SESSION_USER_ID_KEYPREFIX,employeeVO.getUnionId());
				resDataModel.setData(employeeVO);
				
			}
		}catch(Exception e){
			logger.error("EmployeeController#save({}) : {}", 
					userLoginRequest.toString(),
					ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	}
	public static String loadJson (String url) {  
        StringBuilder json = new StringBuilder();  
        try {  
            URL urlObject = new URL(url);  
            URLConnection uc = urlObject.openConnection();  
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));  
            String inputLine = null;  
            while ( (inputLine = in.readLine()) != null) {  
                json.append(inputLine);  
            }  
            in.close();  
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return json.toString();  
    } 
	/** 日志统计 */
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	public EmployeeService employeeService;
}
