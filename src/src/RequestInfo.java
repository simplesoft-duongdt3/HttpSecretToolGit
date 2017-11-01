/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author duongmatheo
 */
public class RequestInfo {
    private String url;
    private String randomString;
    private String timestamp;
    private String body;
    private boolean isHttps = true;

    public RequestInfo(String url, String randomString, String timestamp, String body) {
        this.url = url;
        this.randomString = randomString;
        this.timestamp = timestamp;
        this.body = body;
    }

    public String getUrl() {
        return isHttps ? "https://" + url : "http://" + url;
    }

    public String getRandomString() {
        return randomString;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getBody() {
        return body;
    }

    public void setIsHttps(boolean isHttps) {
        this.isHttps = isHttps;
    }    
}
