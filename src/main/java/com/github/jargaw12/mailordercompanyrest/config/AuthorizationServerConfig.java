package com.github.jargaw12.mailordercompanyrest.config;
//import org.springframework.security.crypto.password.PasswordEncoder;
import com.github.jargaw12.mailordercompanyrest.service.impl.CustomUserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.security.authentication.AuthenticationManager;
        import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
        import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
        import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

//    @Autowired
//    private PasswordEncoder passwordEncoder;
    @Autowired
    CustomUserDetailsService userDetailsService;


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

        security
                .checkTokenAccess("isAuthenticated()")
                .addTokenEndpointAuthenticationFilter(new CorsFilter());
    }



    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                .withClient("frontclient")
                .authorizedGrantTypes("client_credentials", "password")
                .authorities("ROLE_CLIENT","ROLE_TRUSTED_CLIENT")
                .scopes("read","write","trust")
                .resourceIds("oauth2-resource")
                .accessTokenValiditySeconds(20)
                .secret("{noop}frontpassword");
//                .secret(passwordEncoder.encode("secret"));
    }


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        endpoints
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }
}