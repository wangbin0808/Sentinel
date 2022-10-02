/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.csp.sentinel.dashboard;

import com.alibaba.csp.sentinel.init.InitExecutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Sentinel dashboard application.
 *
 * @author Carpenter Lee
 */
@SpringBootApplication
public class DashboardApplication {

    private static final String LOG_DIR_KEY = "csp.sentinel.log.dir";
    private static final String LOG_DIR_VALUE = "/data/middleware/sentinel/sentinel-dashboard/logs/";
    private static final String PROJECT_NAME_KEY = "project.name";
    private static final String PROJECT_NAME_VALUE = "sentinel-dashboard";

    public static void main(String[] args) {
        triggerSentinelInit();
        SpringApplication.run(DashboardApplication.class, args);
    }

    private static void triggerSentinelInit() {
//        System.setProperty(LOG_DIR_KEY, LOG_DIR_VALUE);
        System.setProperty(PROJECT_NAME_KEY, PROJECT_NAME_VALUE);
        new Thread(() -> InitExecutor.doInit()).start();
    }
}
