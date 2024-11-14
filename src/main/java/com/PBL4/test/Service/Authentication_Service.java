package com.PBL4.test.Service;

import com.PBL4.test.DTO.request.Authentication_Request;
import com.PBL4.test.DTO.request.Introspect_Request;
import com.PBL4.test.DTO.response.Authentication_response;
import com.PBL4.test.DTO.response.Introspect_Response;
import com.PBL4.test.Exception.AppException;
import com.PBL4.test.Exception.ErrorCode;
import com.PBL4.test.repository.Account_Repository;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class Authentication_Service {
    @Autowired
    Account_Repository account_Repository;

    @Value("${jwt.signing.key}")
    protected  String SignKey;
    public Introspect_Response introspect(Introspect_Request rq) {
        var token = rq.getToken();

        JWSVerifier verifier;
        try {
            verifier = new MACVerifier(SignKey.getBytes());

        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }

        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            Date expiretime = signedJWT.getJWTClaimsSet().getExpirationTime();
            var    verified = signedJWT.verify(verifier);
            return new Introspect_Response(verified && expiretime.after(new Date()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }


    }

    public Authentication_response authentication(Authentication_Request request) {
        if(!account_Repository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.ACCOUNT_NOT_EXISTED);
        }
        var account = account_Repository.findByUsername(request.getUsername()).orElseThrow(() -> new AppException(ErrorCode.ACCOUNT_NOT_EXISTED));
        System.out.println(account);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        boolean authenticated = passwordEncoder.matches(request.getPassword(), account.getPassword());
        if (!authenticated) {
            throw new AppException(ErrorCode.UNAUTHENTICATED);
        }
        var token = generateToken(request.getUsername());
        return new Authentication_response(token, true);
    }

    private String generateToken(String username) {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(username)
                .issuer("PBL4.com")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()
                ))
                .claim("customClaim", "custom")
                .build();
        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);

        try {
            jwsObject.sign(new MACSigner(SignKey.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {

            throw new RuntimeException(e);
        }

    }
}
