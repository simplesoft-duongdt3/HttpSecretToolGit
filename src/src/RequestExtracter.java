/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.Scanner;

/**
 *
 * @author duongmatheo
 */
public class RequestExtracter {
    public RequestInfo extract(String rawRequest) {
        Scanner scanner = new Scanner(rawRequest);
        boolean needBody = false;
        String partUrl = "";
        String hostUrl = "";
        String randomKey = "";
        String timestamp = "";
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String [] arr = line.split(" ");
            if("POST".equals(arr[0])) {
                needBody = true;
            }
            partUrl = arr[1];
        }
        
        while (scanner.hasNextLine()) {
          String line = scanner.nextLine();
          if(needBody) {
              if(line.isEmpty()) {
                  break;
              }
          }
          String [] arr = line.split(": ");
          if(arr.length == 2) {
              String key = arr[0];
              String value = arr[1].trim();
              if("Host".equals(key)) {
                  //Host: sandbox.foodypos.vn:8483
                  hostUrl = value;
              } else if("X-Foody-Random-Key".equals(key)) {
                  //X-Foody-Random-Key: hmlxsqz9lp
                  randomKey = value;
              } else if("X-Foody-Access-Timestamp".equals(key)) {
                  //X-Foody-Access-Timestamp: 2017-11-01 07:43:53
                  timestamp = value;
              }
          }
        }
        
        //start body
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if(builder.length() != 0) {
                builder.append("\r\n");
            }
            builder.append(line);
        }
        scanner.close();
        
        return new RequestInfo(hostUrl + partUrl, randomKey, timestamp, builder.toString());
    }
}
