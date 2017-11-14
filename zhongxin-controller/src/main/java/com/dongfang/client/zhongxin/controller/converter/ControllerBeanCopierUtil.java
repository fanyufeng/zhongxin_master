package com.dongfang.client.zhongxin.controller.converter;

import org.springframework.cglib.beans.BeanCopier;

import com.dongfang.client.zhongxin.controller.dao.entity.Controller;
import com.dongfang.client.zhongxin.controller.vo.ControllerVO;

/**
  * @ClassName: ControllerBeanCopierUtil
  * @Description: ControllerBeanCopier工具
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午10:58:45
  *
*/
public class ControllerBeanCopierUtil {
	
	/**
	  * 生成员工VO,Entity->VO
	  * @param controller
	  * @return 
	  */
	public static ControllerVO generateVO(Controller controller) {
		ControllerVO controllerVO = new ControllerVO();
		controllerEntity2VoCopier.copy(controller, controllerVO, controllerEntity2VoConverter);
		return controllerVO;
	}
	
	public static Controller generateEntity(ControllerVO controllerVO) {
		Controller controller = new Controller();
		controllerVo2EntityCopier.copy(controllerVO, controller, controllerVo2EntityConverter);
		return controller;
	}
	
	/**
	  * @Fields controllerEntity2VoCopier : 复制器，Entity->Vo
	  */
	private static final BeanCopier controllerEntity2VoCopier = BeanCopier.create(Controller.class, ControllerVO.class, true);
	/**
	  * @Fields controllerEntity2VoConverter : 转换器，Entity->Vo
	  */
	private static final ControllerEntity2VoConverter controllerEntity2VoConverter = new ControllerEntity2VoConverter();
	/**
	  * @Fields controllerVo2EntityCopier : 复制器，Vo->Entity
	  */
	private static final BeanCopier controllerVo2EntityCopier = BeanCopier.create(ControllerVO.class, Controller.class, true);
	/**
	  * @Fields controllerVo2EntityConverter : 转换器，Vo->Entity
	  */
	private static final ControllerVo2EntityConverter controllerVo2EntityConverter = new ControllerVo2EntityConverter();
}
