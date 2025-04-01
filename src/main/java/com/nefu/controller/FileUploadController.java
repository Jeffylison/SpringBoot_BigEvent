package com.nefu.controller;

import com.nefu.AliOssUtil;
import com.nefu.pojo.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws Exception {
        //文件存储本地磁盘
        String originalFilename = file.getOriginalFilename();
        //UUID保证文件名称唯一
        String filename = UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf("."));

//        file.transferTo(new File("C:\\Users\\10065\\Desktop\\BigEventImg\\" + filename));
        String url = AliOssUtil.uploadFile(filename, file.getInputStream());
        return Result.success(url);
    }
}
