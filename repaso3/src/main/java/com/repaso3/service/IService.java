
package com.repaso3.service;

import org.springframework.web.multipart.MultipartFile;


public interface IService {
    String uploadImage (String path, MultipartFile file);
}
