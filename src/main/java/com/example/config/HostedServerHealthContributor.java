package com.example.config;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This will expose hosted machine server info
 * under /actuator/health endpoint
 */
@Component
public class HostedServerHealthContributor extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        Map<String, Object> hostInfo = new HashMap<>();
        InetAddress localHost = InetAddress.getLocalHost();
        hostInfo.put("hostName", localHost.getHostName());
        hostInfo.put("hostAddress", localHost.getHostAddress());
        hostInfo.put("canonicalHostName", localHost.getCanonicalHostName());
        hostInfo.put("serverLocalDateTime", LocalDateTime.now().toString());
        hostInfo.put("serverZonedDateTime", ZonedDateTime.now().toString());
        hostInfo.put("serverOffsetDateTime", OffsetDateTime.now().toString());

        builder.up().withDetails(Collections.unmodifiableMap(hostInfo));
    }
}
