package nl.hu.prbed.airline.security;

import nl.hu.prbed.airline.security.presentation.filter.JwtAuthenticationFilter;
import nl.hu.prbed.airline.security.presentation.filter.JwtAuthorizationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * This class configures authentication and authorisation
 * for the application.
 *
 * The configure method
 * - permits all POSTs to the registration and login endpoints
 * - requires all requests other URLs to be authenticated
 * - sets up JWT-based authentication and authorisation
 * - enforces sessions to be stateless (see: REST)
 *
 * We make sure user data is securely stored
 * by utilizing a BcryptPasswordEncoder.
 * We don't store passwords, only hashes of passwords.
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    public static final String LOGIN_PATH = "/login";
    public static final String REGISTER_PATH = "/register";

    // Swagger endpoints
    public static final String SWAGGER_UI = "/swagger-ui/**";
    public static final String SWAGGER_DOCS = "/v2/api-docs";
    public static final String SWAGGER_RESOURCES = "/swagger-resources/**";


    @Value("${security.jwt.secret}")
    private String jwtSecret;

    @Value("${security.jwt.expiration-in-ms}")
    private Long jwtExpirationInMs;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .csrf().disable()
                .authorizeRequests()
                .expressionHandler(createExpressionHandler())
                // Authentication
                .antMatchers(HttpMethod.POST, REGISTER_PATH).permitAll()
                .antMatchers(HttpMethod.POST, LOGIN_PATH).permitAll()
                // Swagger
                .antMatchers(HttpMethod.GET, SWAGGER_UI).permitAll()
                .antMatchers(HttpMethod.GET, SWAGGER_DOCS).permitAll()
                .antMatchers(HttpMethod.GET, SWAGGER_RESOURCES).permitAll()

                .anyRequest().hasAuthority("ROLE_USER")
                .and()
                .addFilterBefore(
                        new JwtAuthenticationFilter(
                                LOGIN_PATH,
                                this.jwtSecret,
                                this.jwtExpirationInMs,
                                this.authenticationManager()
                        ),
                        UsernamePasswordAuthenticationFilter.class
                )
                .addFilter(new JwtAuthorizationFilter(this.jwtSecret, this.authenticationManager()))
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }

    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        String hierarchy = "ROLE_ADMIN > ROLE_EMPLOYEE \n ROLE_EMPLOYEE > ROLE_USER";
        roleHierarchy.setHierarchy(hierarchy);

        return roleHierarchy;
    }

    protected DefaultWebSecurityExpressionHandler createExpressionHandler() {
        DefaultWebSecurityExpressionHandler webSecurityExpressionHandler = new DefaultWebSecurityExpressionHandler();
        webSecurityExpressionHandler.setRoleHierarchy(roleHierarchy());
        return webSecurityExpressionHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
