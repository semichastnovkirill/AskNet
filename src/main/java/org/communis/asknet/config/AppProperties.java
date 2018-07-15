package org.communis.asknet.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;

@Configuration
@ConfigurationProperties(prefix = "asknet", ignoreUnknownFields = false)
@Getter
@Setter
public class AppProperties {

    @NotNull
    private String timezone;
}
