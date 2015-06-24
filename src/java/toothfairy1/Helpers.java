/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package toothfairy1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;

/**
 *
 * @author valya
 */
public class Helpers {
     public static String convert(String s) throws UnsupportedEncodingException {
        return new String(s.getBytes("ISO-8859-1"), "UTF-8");
        // return s;
    }
     
     public static String convertToDB(String s) throws UnsupportedEncodingException {
       return new String(s.getBytes("UTF-8"), "ISO-8859-1");
        // return s;
    }
     
    public static byte[] toByteArray(Blob fromImageBlob) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
          return toByteArrayImpl(fromImageBlob, baos);
        } catch (Exception e) {
        }
        return null;
    }

    private static byte[] toByteArrayImpl(Blob fromImageBlob, 
            ByteArrayOutputStream baos) throws SQLException, IOException {
          byte buf[] = new byte[4000];
          int dataSize;
          InputStream is = fromImageBlob.getBinaryStream(); 

          try {
            while((dataSize = is.read(buf)) != -1) {
              baos.write(buf, 0, dataSize);
            }    
          } finally {
            if(is != null) {
              is.close();
            }
          }
          return baos.toByteArray();
        }
}
