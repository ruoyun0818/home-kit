package com.whitesky.home.env;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.whitesky.home.utils.DesEncrypt;

/**
 * @Title: 配置文件
 * @Description: !!!Spring容器仅允许最多定义一个PropertyPlaceholderConfigure
 * @author whitesky
 * @date 2016年10月13日
 */
public class EnvPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer  {
	private final String desKey = "测试2421FｊｊJJJFEj密钥jjffweｆｊｊ14ｆｅ";
	
	public final static Logger LOGGER = Logger.getLogger(EnvPropertyPlaceholderConfigurer.class);
	
	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
			throws BeansException {
		try {
			final String[] propKeys = new String[]{"jdbc.url","jdbc.username","jdbc.password"};
			//指定编码方式
			DesEncrypt encrypt = new DesEncrypt(desKey, EnvConstant.DEFAULT_ENCODING);
			for (String key : propKeys) {
				String value = props.getProperty(key);
				String encryptValue = encrypt.decrypt(value);
				props.setProperty(key, encryptValue);
			}
		} catch (Exception e) {
			LOGGER.error("解密配置文件失败!", e);
		}
		super.processProperties(beanFactoryToProcess, props);
	}
}
