package com.fc.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {
    /**
     * @Bean相当于
     * <bean id="RestTemplate" class="xxx.xxx.xxx.RestTemplate"></bean>
     * @return
     */
    @LoadBalanced //使用Ribbon实现负载均衡调用
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 覆盖掉ribbon默认的轮询负载均衡策略
     * @return
     */
    @Bean
    public IRule iRule(){
        //return new RandomRule();//采用随机负载均衡策略
        return new RetryRule();
    }
}
