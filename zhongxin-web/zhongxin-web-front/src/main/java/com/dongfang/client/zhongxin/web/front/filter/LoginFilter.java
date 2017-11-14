package com.dongfang.client.zhongxin.web.front.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.dongfang.client.zhongxin.commons.constants.Constants;
import com.dongfang.client.zhongxin.commons.enums.ApiStatusCode;
import com.dongfang.client.zhongxin.web.front.response.ResponseDataModel;
import com.google.gson.Gson;

public class LoginFilter implements Filter{
	
	
	
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		String uriStr = httpRequest.getRequestURI();
		Object obj = httpRequest.getSession().getAttribute(Constants._SESSION_USER_ID_KEYPREFIX);
		
		//得到对应的session值
		String sessionIdModel=httpRequest.getSession().getId();
		boolean sessionIdStr=Constants.mapSession.containsValue(sessionIdModel);
		if(StringUtils.isNotBlank(uriStr) &&
				!uriStr.equals("/") &&		
				!uriStr.equals("/hr-web-front/user/login") &&
				obj == null){
					ResponseDataModel resDataModel = new ResponseDataModel();
					resDataModel.setStatusCode(ApiStatusCode.ACCESS_DENY.value());
					response.setCharacterEncoding("UTF-8");
					response.setContentType("application/json; charset=utf-8");
					PrintWriter out = null;
					Gson gson = new Gson();
					try {
						out = response.getWriter();
						out.append(gson.toJson(resDataModel));
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
						if (out != null) {
							out.flush();
							out.close();
						}
					}
			
		}else{
			filterChain.doFilter(request, response); 
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	

}
