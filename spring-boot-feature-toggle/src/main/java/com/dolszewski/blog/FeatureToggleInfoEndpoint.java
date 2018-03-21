package com.dolszewski.blog;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Endpoint(id = "feature-toggles")
class FeatureToggleInfoEndpoint {

    private final FeatureDecisions featureDecisions;

    FeatureToggleInfoEndpoint(FeatureDecisions featureDecisions) {
        this.featureDecisions = featureDecisions;
    }

    @ReadOperation
    public Map<String, Boolean> featureToggles() {
        return featureDecisions.getToggles();
    }

}
