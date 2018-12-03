package com.dongfang.client.zhongxin.web.front.controller.message;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
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
import com.dongfang.client.zhongxin.message.code.service.MessageCodeService;
import com.dongfang.client.zhongxin.message.code.vo.MessageCodeVO;
import com.dongfang.client.zhongxin.web.front.request.messageCode.CodeMessage;
import com.dongfang.client.zhongxin.web.front.response.ResponseDataModel;


/**
 * @author 验证码控制器
 *
 */
@Controller
@RequestMapping("/messageCode")
public class MessageCodeController {
	
	//查账户信息的http地址
    private static String URI_GET_USER_INFO = "https://sms.yunpian.com/v1/user/get.json";

    //智能匹配模版发送接口的http地址
    private static String URI_SEND_SMS = "https://sms.yunpian.com/v1/sms/send.json";

    //模板发送接口的http地址
    private static String URI_TPL_SEND_SMS = "https://sms.yunpian.com/v1/sms/tpl_send.json";

    //发送语音验证码接口的http地址
    private static String URI_SEND_VOICE = "https://voice.yunpian.com/v1/voice/send.json";

    //编码格式。发送编码格式统一用UTF-8
    private static String ENCODING = "UTF-8";
    
    /**
     * 取账户信息
     *
     * @return json格式字符串
     * @throws java.io.IOException
     */

    public static String getUserInfo(String apikey) throws IOException, URISyntaxException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("apikey", apikey);
        return post(URI_GET_USER_INFO, params);
    }

    /**
     * 智能匹配模版接口发短信
     *
     * @param apikey apikey
     * @param text   　短信内容
     * @param mobile 　接受的手机号
     * @return json格式字符串
     * @throws IOException
     */

    public static String sendSms(String apikey, String text, String mobile) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("apikey", apikey);
        params.put("text", text);
        params.put("mobile", mobile);
        return post(URI_SEND_SMS, params);
    }

    /**
     * 通过模板发送短信(不推荐)
     *
     * @param apikey    apikey
     * @param tpl_id    　模板id
     * @param tpl_value 　模板变量值
     * @param mobile    　接受的手机号
     * @return json格式字符串
     * @throws IOException
     */

    public static String tplSendSms(String apikey, long tpl_id, String tpl_value, String mobile) throws IOException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("apikey", apikey);
        params.put("tpl_id", String.valueOf(tpl_id));
        params.put("tpl_value", tpl_value);
        params.put("mobile", mobile);
        return post(URI_TPL_SEND_SMS, params);
    }

    /**
     * 通过接口发送语音验证码
     * @param apikey apikey
     * @param mobile 接收的手机号
     * @param code   验证码
     * @return
     */

    public static String sendVoice(String apikey, String mobile, String code) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("apikey", apikey);
        params.put("mobile", mobile);
        params.put("code", code);
        return post(URI_SEND_VOICE, params);
    }

    /**
     * 基于HttpClient 4.3的通用POST方法
     *
     * @param url       提交的URL
     * @param paramsMap 提交<参数，值>Map
     * @return 提交响应
     */

    public static String post(String url, Map<String, String> paramsMap) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost method = new HttpPost(url);
            if (paramsMap != null) {
                List<NameValuePair> paramList = new ArrayList<NameValuePair>();
                for (Map.Entry<String, String> param : paramsMap.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
                    paramList.add(pair);
                }
                method.setEntity(new UrlEncodedFormEntity(paramList, ENCODING));
            }
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }
   
    /**
	 *  注册验证码发送
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/send",method=RequestMethod.POST)
	@ResponseBody
	public ResponseDataModel sendCode(@RequestBody CodeMessage codeMessage,HttpServletRequest request,HttpServletResponse response ) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			//修改为您的apikey.apikey可在官网（http://www.yuanpian.com)登录后获取
	        String apikey = "cb195b7626fd7165563eb0df0b751bcd";

	        //修改为您要发送的手机号
	        String mobile = URLEncoder.encode(codeMessage.getTelephone(),ENCODING);

	        /**************** 查账户信息调用示例 *****************/
	     //   System.out.println(JavaSmsApi.getUserInfo(apikey));
	        String codeNumber=MessageCodeController.createRandomCode();
	        /**************** 使用智能匹配模版接口发短信(推荐) *****************/
	        //设置您要发送的内容(内容必须和某个模板匹配。以下例子匹配的是系统提供的1号模板）
	        String text = "【bjtu跑跑】感谢您注册交大跑跑，您的验证码是"+codeNumber;
	        
	        
	        
	        
	        //发短信调用示例
	        System.out.println(MessageCodeController.sendSms(apikey, text, mobile));
	        
	        List<MessageCodeVO> messageCodeVOList=messageCodeService.getByTelephone(codeMessage.getTelephone());
	        if(messageCodeVOList!=null){
	        	for(MessageCodeVO e:messageCodeVOList){
	        		e.setCode(codeNumber);
	        		messageCodeService.update(e);
	        	}
	        }else{
	        	MessageCodeVO messageCodeVO = new MessageCodeVO();
		        messageCodeVO.setTelephone(codeMessage.getTelephone());
		        messageCodeVO.setCode(codeNumber);
		        messageCodeService.save(messageCodeVO);
	        }
	        
	        

	        /**************** 使用指定模板接口发短信(不推荐，建议使用智能匹配模版接口) *****************/
	        //设置模板ID，如使用1号模板:【#company#】您的验证码是#code#
	        long tpl_id = 1;
	        //设置对应的模板变量值

	        String tpl_value = URLEncoder.encode("#code#",ENCODING) +"="
	            + URLEncoder.encode("1234", ENCODING) + "&"
	            + URLEncoder.encode("#company#",ENCODING) + "="
	            + URLEncoder.encode("云片网",ENCODING);
	        //模板发送的调用示例
	        System.out.println(tpl_value);
	 //       System.out.println(JavaSmsApi.tplSendSms(apikey, tpl_id, tpl_value, mobile));

	        /**************** 使用接口发语音验证码 *****************/
	        String code = "1234";
	        
	        //System.out.println(JavaSmsApi.sendVoice(apikey, mobile ,code));
				
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
	//		resDataModel.setData();
		}catch(Exception e){
			logger.error("审核人添加失败,原因{}", ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	}
	
	/**
	 *  注册验证码匹配
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/compare",method=RequestMethod.POST)
	@ResponseBody
	public ResponseDataModel compare(@RequestBody CodeMessage codeMessage,HttpServletRequest request,HttpServletResponse response ) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			List<MessageCodeVO> messageCodeVOList=messageCodeService.getByTelephone(codeMessage.getTelephone());
			for(MessageCodeVO u:messageCodeVOList){
				if(u.getCode().equals(codeMessage.getCodeNumber())){
					MessageCodeVO messageCodeVO=new MessageCodeVO();
					messageCodeVO.setTelephone(u.getTelephone());
					EmployeeVO employeeVO=employeeService.getById(codeMessage.getEmployeeId());
					if(employeeVO!=null){
						employeeVO.setTelephone(codeMessage.getTelephone());
					}
					employeeService.update(employeeVO);
					messageCodeVO.setCode(u.getCode());
					resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
					messageCodeVO.setCode(null);
					resDataModel.setData(employeeVO);
				}else {
					MessageCodeVO messageCodeVO=new MessageCodeVO();
					messageCodeVO.setTelephone(u.getTelephone());
					messageCodeVO.setCode(u.getCode());
					resDataModel.setStatusCode(ApiStatusCode.CODE_COMPARE_ERROR.value());
					messageCodeVO.setCode(null);
					EmployeeVO employeeVOg=employeeService.getById(codeMessage.getEmployeeId());
					if(employeeVOg!=null){
						resDataModel.setData(employeeVOg);
					}
					
				}
			}	
			
		}catch(Exception e){
			logger.error("审核人添加失败,原因{}", ExceptionUtils.getFullStackTrace(e));
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
	private static final Logger logger = LoggerFactory.getLogger(MessageCodeController.class);
	
	@Autowired
	public EmployeeService employeeService;
	@Autowired
	public MessageCodeService messageCodeService;
	
}
