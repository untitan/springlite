package cn.titan.test;

import cn.titan.service.HelloService;
import cn.titan.spring.bean.BeanDefinition;
import cn.titan.spring.factory.AutowireBeanFactory;
import cn.titan.spring.factory.BeanFactory;
import cn.titan.spring.reader.io.ResourceLoader;
import cn.titan.spring.reader.xml.XmlBeanDefinitionReader;

import java.util.Map;

public class Test {

	public static void main(String[] args) throws Exception {
		// 加载xml
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(new ResourceLoader());
		reader.loadBeanDefinitions("spring.xml");
		// 注册bean
		BeanFactory factory = new AutowireBeanFactory();
		for (Map.Entry<String, BeanDefinition> entry : reader.getRegistry().entrySet()) {
			factory.registry(entry.getKey(), entry.getValue());
		}
		// 调用
		HelloService hello = (HelloService) factory.getBean("helloService");
		hello.helloworld();
	}
}
