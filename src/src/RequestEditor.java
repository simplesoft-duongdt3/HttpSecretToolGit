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
public class RequestEditor {
    public String edit(String rawRequest, String keyEdit, String valueEdit) {
        Scanner scanner = new Scanner(rawRequest);
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNextLine()) {
          String line = scanner.nextLine();
          String [] arr = line.split(": ");
          String newLine = "";
          if(arr.length == 2) {
              String key = arr[0];
              if(keyEdit.equals(key)) {
                  newLine = keyEdit + ": " + valueEdit;
              }
          }
          
          if(builder.length() > 0) {
              builder.append("\r\n");
          }
          
          if(!newLine.isEmpty()) {
              builder.append(newLine);
          } else {
              builder.append(line);
          }
        }
        scanner.close();
        return builder.toString();
    }
}
