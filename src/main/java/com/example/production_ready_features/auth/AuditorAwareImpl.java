package com.example.production_ready_features.auth;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {


    @Override
    public Optional<String> getCurrentAuditor() {
        //get security context
        //get authentication
        return Optional.of("Harsh Venkatesh Badagandi");
    }
}
