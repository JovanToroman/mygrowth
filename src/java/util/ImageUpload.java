/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import constants.WebConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author solstinger
 */
public class ImageUpload {

    public static String uploadImage(HttpServletRequest request, String fileName, String suffix) throws IOException, ServletException {

        if (request.getPart(fileName) != null) {
            Part filePart = request.getPart(fileName);
            InputStream fileContent = filePart.getInputStream();
            byte[] buffer = new byte[fileContent.available()];
            fileContent.read(buffer);
            String relativeWebPath = "/resources";
            String absoluteDiskPath = request.getServletContext().getRealPath(relativeWebPath);
            System.out.println("Put do sacuvane slike: "+absoluteDiskPath);
            File targetFile = new File(absoluteDiskPath, fileName + suffix + ".jpg");
            OutputStream outStream = new FileOutputStream(targetFile);
            outStream.write(buffer);
        }
        return fileName + suffix + ".jpg";
    }
}
