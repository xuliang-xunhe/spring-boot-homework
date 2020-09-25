package com.xunhe.bj.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.xunhe.bj.po.TblUsers;
import org.springframework.stereotype.Service;
import java.util.Date;

/***
 * token 下发
 * @Title: TokenService.java
 * @author MRC
 * @date 2019年5月27日 下午5:40:25
 * @version V1.0
 */
@Service("TokenService")
public class TokenService {

    public String getToken(TblUsers user) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis()  + 60* 60 * 1000;//一小时有效时间
        Date end = new Date(currentTime);
        String token = "";

        token = JWT.create().withAudience(user.getId()).withIssuedAt(start).withExpiresAt(end)
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
