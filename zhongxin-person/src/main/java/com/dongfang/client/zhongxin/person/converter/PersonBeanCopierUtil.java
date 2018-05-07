package com.dongfang.client.zhongxin.person.converter;

import org.springframework.cglib.beans.BeanCopier;

import com.dongfang.client.zhongxin.person.dao.entity.Person;
import com.dongfang.client.zhongxin.person.vo.PersonVO;

/**
  * @ClassName: PersonBeanCopierUtil
  * @Description: PersonBeanCopier工具
  * @author heliqiang@xbniao.com
  * @date 2016年2月5日 上午10:58:45
  *
*/
public class PersonBeanCopierUtil {
	
	/**
	  * 生成员工VO,Entity->VO
	  * @param person
	  * @return 
	  */
	public static PersonVO generateVO(Person person) {
		PersonVO personVO = new PersonVO();
		personEntity2VoCopier.copy(person, personVO, personEntity2VoConverter);
		return personVO;
	}
	
	public static Person generateEntity(PersonVO personVO) {
		Person person = new Person();
		personVo2EntityCopier.copy(personVO, person, personVo2EntityConverter);
		return person;
	}
	
	/**
	  * @Fields personEntity2VoCopier : 复制器，Entity->Vo
	  */
	private static final BeanCopier personEntity2VoCopier = BeanCopier.create(Person.class, PersonVO.class, true);
	/**
	  * @Fields personEntity2VoConverter : 转换器，Entity->Vo
	  */
	private static final PersonEntity2VoConverter personEntity2VoConverter = new PersonEntity2VoConverter();
	/**
	  * @Fields personVo2EntityCopier : 复制器，Vo->Entity
	  */
	private static final BeanCopier personVo2EntityCopier = BeanCopier.create(PersonVO.class, Person.class, true);
	/**
	  * @Fields personVo2EntityConverter : 转换器，Vo->Entity
	  */
	private static final PersonVo2EntityConverter personVo2EntityConverter = new PersonVo2EntityConverter();
}
