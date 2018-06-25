package com.xq.live.backend.framework.property;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * 常量配置
 * Created by lipeng on 2018/4/14.
 */
@Configuration
@ConfigurationProperties(prefix = "constants")
@Data
@EqualsAndHashCode(callSuper = false)
@Order(-1)
public class ConstantsProperties {
    /**
     * 域名常量
     */
    private String domainXqUrl;

    public String getDomainXqUrl() {
        return domainXqUrl;
    }

    public void setDomainXqUrl(String domainXqUrl) {
        this.domainXqUrl = domainXqUrl;
    }
}
