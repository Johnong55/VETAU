package com.PBL4.test.Service;

import com.PBL4.test.DTO.request.Authentication_Request;
import com.PBL4.test.DTO.request.IntrospectRequest;
import com.PBL4.test.DTO.response.Authentication_response;
import com.PBL4.test.DTO.response.IntrospectResponse;
import com.PBL4.test.Exception.AppException;
import com.PBL4.test.entity.Account;
import com.PBL4.test.enums.ErrorCode;
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
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Set;
import java.util.StringJoiner;

@Service
public class Authentication_Service {
    @Autowired
    Account_Repository account_Repository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Value("${jwt.signing.key}")
    protected  String SignKey;
    public IntrospectResponse introspect(IntrospectRequest rq) {
        var token = rq.getToken();

        JWSVerifier verifier;
        try {
            verifier = new MACVerifier(SignKey.getBytes());

        } catch (JOSEException e) {
            throw new AppException(ErrorCode.INVALID_TOKEN);
        }

        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            Date expiretime = signedJWT.getJWTClaimsSet().getExpirationTime();
            var    verified = signedJWT.verify(verifier);
            return new IntrospectResponse(verified && expiretime.after(new Date()));
        } catch (ParseException e) {
            throw new AppException(ErrorCode.INVALID_TOKEN);
        } catch (JOSEException e) {
            throw new AppException(ErrorCode.INVALID_TOKEN);
        }


    }

    public Authentication_response authentication(Authentication_Request request) {
        var account = account_Repository.existsByEmailOrUsername(request.getUsername()).orElseThrow(() -> new AppException(ErrorCode.ACCOUNT_NOT_EXISTED));
        System.out.println(account);
        boolean authenticated = passwordEncoder.matches(request.getPassword(), account.getPassword());
        if (!authenticated) {
            throw new AppException(ErrorCode.UNAUTHENTICATED);
        }
        var token = generateToken(account);
        return new Authentication_response(token, true);
    }

    private String generateToken(Account account) {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(account.getUsername())
                .issuer("PBL4.com")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()
                ))

                .claim("scope",buildeScope(account))
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
    private String buildeScope(Account account)
    {
        StringJoiner stringJoiner = new StringJoiner(" ");
        if(!CollectionUtils.isEmpty(account.getRoles()))
        {
            account.getRoles().forEach(stringJoiner::add);
        }
        return stringJoiner.toString();
    }
}
