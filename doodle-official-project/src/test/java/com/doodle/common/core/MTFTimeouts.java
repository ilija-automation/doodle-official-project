package com.doodle.common.core;

import java.util.concurrent.TimeUnit;

public class MTFTimeouts {

    public final static String DRIVER_WAIT_DEFAULT = "driver.wait.default";

    public static long getTimeout(String timeout, TimeUnit timeUnit) {
        timeout = MTFProperties.timeouts.getProperty(timeout);
        return timeUnit.convert(Long.parseLong(timeout), TimeUnit.MILLISECONDS);
    }

}
