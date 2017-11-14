package com.dongfang.client.zhongxin.web.front.response;

import java.io.Serializable;

/**
  * @ClassName: ResponseDataModel
  * @Description: 响应信息模型
  * @author heliqiang@xbniao.com
  * @date 2016年7月1日 下午4:30:22
  *
*/
public class ResponseDataModel implements Serializable {
	/**
	  * @Fields serialVersionUID : TODO
	  */
	private static final long serialVersionUID = 1L;

	/**
	 * <p>Title: </p>
	 * <p>Description: </p>
	 */
	public ResponseDataModel() {}
	
	
	/**
	  * @Fields statusCode : 接口返回状态码
	  */
	private String statusCode ; 
	
	/**
	  * @Fields data : 返回数据
	  */
	private Object data ;


	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	} 
}
