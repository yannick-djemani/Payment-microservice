package com.codeimmig.PaymentService.security;

/*@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .antMatchers("/payment/**")
                                .hasAuthority("SCOPE_internal")
                                .anyRequest()
                                .authenticated())
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
        return http.build();
    }

}*/
