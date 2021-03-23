package com.motorsSmart.env;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration("MotorsEnvironmen")
public class MotorsEnvironmen {

    private static String urlCrossOrigin;

    @Value("${environmen.url.origins}")
    public void setProjectId(String env) { urlCrossOrigin = env; }

}
