/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.repaso3.controller;

import com.repaso3.playLoad.FileResponse;
import com.repaso3.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping ("/file")

public class controller {
    
    @Autowired
    private service fileService;
    

    @Value("${project.image}")
    private String path;
    
    @PostMapping ("/upload")
    public ResponseEntity <FileResponse> fileUpload(
            @RequestParam ("image") MultipartFile image
    ){
        String fileName = this.fileService.uploadImage(path, image);
        return new ResponseEntity<>(new FileResponse(fileName,"algo"),HttpStatus.OK);
    
    }
    
    @GetMapping("/prueba")
    public String prueba(){
        return "funca";
    }


}
