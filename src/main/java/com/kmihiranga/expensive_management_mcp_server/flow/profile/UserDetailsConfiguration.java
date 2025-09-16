package com.kmihiranga.expensive_management_mcp_server.flow.profile;

import com.kmihiranga.expensive_management_mcp_server.application.profile.UserDetailsApplicationService;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserDetailsConfiguration {

    @Bean
    public List<ToolCallback> userDetailsCallbacks(UserDetailsApplicationService userDetailsApplicationService) {
        return List.of(ToolCallbacks.from(userDetailsApplicationService));
    }

}
