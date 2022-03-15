package com.sdtech.learning.SpringSecurity;

import org.apache.catalina.authenticator.BasicAuthenticator.BasicCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource
{
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    MyUserDetailService userDetailService;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping( "/" )
    public String home()
    {
        return "Welcome home!";
    }

    @GetMapping( "/user" )
    public String user()
    {
        return "Welcome User!";
    }

    @GetMapping( "/admin" )
    public String admin()
    {
        return "Welcome Admin!";
    }

    @PostMapping( "/authenticate" )
    public ResponseEntity<AuthenticationResponse> authenticate( @RequestBody AuthenticationRequest authenticationRequest ) throws BadCredentialsException
    {
        try
        {
            authenticationManager.authenticate( new UsernamePasswordAuthenticationToken( authenticationRequest.getUserName(),
                                                                                         authenticationRequest.getPassword() ) );
        }
        catch( BadCredentialsException bce )
        {
            throw new BadCredentialsException( "Incorrect username and password" );
        }

        final UserDetails userDetails = userDetailService.loadUserByUsername( authenticationRequest.getUserName() );

        final String jwt = jwtUtil.generateToken( userDetails );

        return ResponseEntity.ok( new AuthenticationResponse( jwt ) );
    }

}
