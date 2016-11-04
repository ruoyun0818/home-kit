package com.whitesky.home.common.config;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.whitesky.home.common.Constant;
import com.whitesky.home.utils.DesEncrypt;

/**
 * @Title: 配置文件
 * @Description: !!!Spring容器仅允许最多定义一个PropertyPlaceholderConfigure
 * @author whitesky
 * @date 2016年10月13日
 */
public class JdbcPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer  {
	private final String desKey = "测试2421FｊｊJJJFEj密钥jjffweｆｊｊ14ｆｅ";
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
			throws BeansException {
		try {
			final String[] propKeys = new String[]{"jdbc.url","jdbc.username","jdbc.password"};
			//指定编码方式
			DesEncrypt encrypt = new DesEncrypt(desKey, Constant.DEFAULT_ENCODING);
			for (String key : propKeys) {
				String value = props.getProperty(key);
				String encryptValue = encrypt.decrypt(value);
				props.setProperty(key, encryptValue);
			}
		} catch (Exception e) {
			logger.error("解密配置文件失败!", e);
		}
		super.processProperties(beanFactoryToProcess, props);
	}
}
