package com.example.ebor.config;

import com.alibaba.druid.pool.DruidDataSourceStatLogger;
import com.alibaba.druid.pool.DruidDataSourceStatLoggerAdapter;
import com.alibaba.druid.pool.DruidDataSourceStatValue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataSourceStatLogger extends DruidDataSourceStatLoggerAdapter implements DruidDataSourceStatLogger {

    @Override
    public void log(DruidDataSourceStatValue statValue) {
        super.log(statValue);
        log.info("***************************************************");
        log.info("                  监控数据持久化                    ");
        log.info("***************************************************");
    }
}
