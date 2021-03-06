package cn.titan.spring.factory;

import cn.titan.spring.bean.BeanDefinition;

public interface BeanFactory {
	Object getBean(String beanName) throws Exception;

	void registry(String beanName, BeanDefinition beanDefine) throws Exception;
}
