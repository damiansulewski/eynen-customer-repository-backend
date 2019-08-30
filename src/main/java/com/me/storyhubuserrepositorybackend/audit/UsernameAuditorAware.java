package com.me.storyhubuserrepositorybackend.audit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
public class UsernameAuditorAware implements AuditorAware<String> {
    @Value("${user-repository.audit.auditor:user-repository}")
    private String emptySecurityContextUserName;

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(emptySecurityContextUserName);
    }
}
