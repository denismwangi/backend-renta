package com.renta.app.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class imgUtil {


    // Static method: three parameters: binary file, file path, file name
    // This method will add the specified file in the specified directory
    public static void fileupload(byte[] file,String filePath,String fileName) throws IOException {
        // Target directory
        File targetfile = new File(filePath);
        if(targetfile.exists()) {
            targetfile.mkdirs();
        }

        // Binary stream write
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }

}
