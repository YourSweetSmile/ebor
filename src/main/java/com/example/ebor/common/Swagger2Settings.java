package com.example.ebor.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * 获取swagger2的配置
 */
@Component
@ConfigurationProperties(prefix = "app.swagger2")
public class Swagger2Settings {

    @NotNull
    private boolean isShow;

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }
}
