package com.example.demo.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .regexMatchers("/secure").access("#oauth2.hasScope('write')")
                .anyRequest().permitAll();
    }

    @Bean
    public RemoteTokenServices remoteTokenServices(){
        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
        remoteTokenServices.setClientId("trusted-admin");
        remoteTokenServices.setClientSecret("secretadmin");
        remoteTokenServices.setCheckTokenEndpointUrl("http://localhost:8081/oauth/check_token");
        return remoteTokenServices;
    }

}
