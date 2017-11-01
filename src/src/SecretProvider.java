/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author duongmatheo
 */
public class SecretProvider {
    public String gen(String key, String url, String randomString, String timestamp, String body) {
        StringBuilder builder = new StringBuilder();
        builder.append(url);
        if(body != null) {
            builder.append(body);
        }
        builder.append(randomString);
        builder.append(timestamp);
        String message = builder.toString();
        return encodeHMACSHA256(key, message);
    }
    
    private String encodeHMACSHA256(String secret, String message) {
        String result = "";
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] bytes = sha256_HMAC.doFinal(message.getBytes("UTF-8"));
            byte[] encodedBytes = Base64.getEncoder().encode(bytes);
            result = new String(encodedBytes);
        } catch (Exception e) {
            
        }
        
        return result;
    }
}
