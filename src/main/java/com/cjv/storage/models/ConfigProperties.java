package com.cjv.storage.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "params")
@Data
@NoArgsConstructor
public class ConfigProperties {
  private String secretkey;
}
