package com.example.ebor.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Properties;

/**
 *
 */
@Configuration
public class DruidConfig {

//    private static final String PUBLICKEY = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKVI5Vnk+OzENexZLji5mGQod0xz7noB1L//4NPY16I8YXQv4k3EjRrGLR7ScTGuHTlHOU+U+Y8oMiooLXD5ryECAwEAAQ==";

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource druidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setStatLogger(new StatLogger());
        Properties properties = new Properties();
//        properties.setProperty("config.decrypt", "true");
//        properties.setProperty("config.decrypt.key", PUBLICKEY);
        dataSource.setConnectProperties(properties);
        return dataSource;
    }

}

