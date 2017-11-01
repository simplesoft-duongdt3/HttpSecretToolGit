/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;

/**
 *
 * @author duongmatheo
 */
public class Clipboarder {
    public void saveText(String text) {
        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection stringSelection = new StringSelection(text);
        c.setContents(stringSelection, null);
    }
    
    public String getText() {
        String result = "";
        // Create a Clipboard object using getSystemClipboard() method
        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();

        try {
            result = (String) c.getData(DataFlavor.stringFlavor);
        } catch (Exception e) {
        }
        return result;
    }
}
