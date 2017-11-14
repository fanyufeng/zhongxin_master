package com.dongfang.client.zhongxin.finance.converter;

import org.springframework.cglib.beans.BeanCopier;

import com.dongfang.client.zhongxin.finance.dao.entity.Finance;
import com.dongfang.client.zhongxin.finance.vo.FinanceVO;

/**
  * @ClassName: FinanceBeanCopierUtil
  * @Description: FinanceBeanCopier工具
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午10:58:45
  *
*/
public class FinanceBeanCopierUtil {
	
	/**
	  * 生成员工VO,Entity->VO
	  * @param finance
	  * @return 
	  */
	public static FinanceVO generateVO(Finance finance) {
		FinanceVO financeVO = new FinanceVO();
		financeEntity2VoCopier.copy(finance, financeVO, financeEntity2VoConverter);
		return financeVO;
	}
	
	public static Finance generateEntity(FinanceVO financeVO) {
		Finance finance = new Finance();
		financeVo2EntityCopier.copy(financeVO, finance, financeVo2EntityConverter);
		return finance;
	}
	
	/**
	  * @Fields financeEntity2VoCopier : 复制器，Entity->Vo
	  */
	private static final BeanCopier financeEntity2VoCopier = BeanCopier.create(Finance.class, FinanceVO.class, true);
	/**
	  * @Fields financeEntity2VoConverter : 转换器，Entity->Vo
	  */
	private static final FinanceEntity2VoConverter financeEntity2VoConverter = new FinanceEntity2VoConverter();
	/**
	  * @Fields financeVo2EntityCopier : 复制器，Vo->Entity
	  */
	private static final BeanCopier financeVo2EntityCopier = BeanCopier.create(FinanceVO.class, Finance.class, true);
	/**
	  * @Fields financeVo2EntityConverter : 转换器，Vo->Entity
	  */
	private static final FinanceVo2EntityConverter financeVo2EntityConverter = new FinanceVo2EntityConverter();
}
