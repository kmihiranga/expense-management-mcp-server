package com.kmihiranga.expensive_management_mcp_server.common;

import java.util.UUID;

public class Utils {

    public static String idGenerator() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 24);
    }
}
