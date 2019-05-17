package com.example.ebor.config;

import com.alibaba.druid.pool.DruidDataSourceStatLogger;
import com.alibaba.druid.pool.DruidDataSourceStatLoggerAdapter;
import com.alibaba.druid.pool.DruidDataSourceStatValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataSourceStatLogger extends DruidDataSourceStatLoggerAdapter implements DruidDataSourceStatLogger {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceStatLogger.class);

    @Override
    public void log(DruidDataSourceStatValue statValue) {
        super.log(statValue);
        logger.info("***************************************************");
        logger.info("                  监控数据持久化                    ");
        logger.info("***************************************************");
    }
}
