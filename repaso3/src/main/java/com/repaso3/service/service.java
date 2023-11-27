
package com.repaso3.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class service implements IService {

    @Override
    public String uploadImage(String path, MultipartFile file) {
        
        //File name
        String name= file.getOriginalFilename();
        
        //random name generate file
        String randomID= UUID.randomUUID().toString();
        String fileName1 =randomID.concat(name.substring(name.lastIndexOf(".")));
        //Fullpath
        String filePath= path+File.separator+fileName1;
        
        
        
        //create folder if not created
        File f = new File(path);
        if(!f.exists()){
            f.mkdir();
        }
        
        try {
            //file copy
            Files.copy(file.getInputStream(), Paths.get(filePath));
        } catch (IOException ex) {
            Logger.getLogger(service.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return name;
    }
    
}
