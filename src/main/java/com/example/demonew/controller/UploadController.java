package com.example.demonew.controller;

import com.example.demonew.utils.Result;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {
    @Value("${Anlifile-save-path}")
    private String AnlifileSavePath;
    @Value("${Chanpinfile-save-path}")
    private String ChanpinfileSavePath;
    @Value("${Lunbotufile-save-path}")
    private String LunbotufileSavePath;
    @Value("${Userfile-save-path}")
    private String UserfileSavePath;
    @Value("${Newsfile-save-path}")
    private String NewsfileSavePath;
    @Value("${Honorfile-save-path}")
    private String HonorfileSavePath;

    @PostMapping("/anli")
    public Result uploadanli(MultipartFile image, HttpServletRequest request) throws Exception {
        log.info("image::{}", image);
        String filename = image.getOriginalFilename();

//        System.currentTimeMillis()是java中的生成毫秒级的时间戳，也可以使用UUID，lastindexof是获取最后一个点的位置为了提取拓展名，substring是字符串截取，如果用split方法截取的就是一个数组了
//        int index = filename.lastIndexOf(".");
//        String extname = filename.substring(index);
//        String newfilename = UUID.randomUUID().toString()+extname;
//        log.info("新的文件名"+newfilename);
        String newfilename = System.currentTimeMillis() + filename;
        image.transferTo(new File(AnlifileSavePath + newfilename));//保存上传的文件到这个目录下
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/anli/"  + newfilename;
        log.info("url的request.getScheme的东西{},url的request.getServerName的东西{},url的request.getServerPort的东西{}",request.getScheme(),request.getServerName(),request.getServerPort());
//        image.transferTo(new File("C:\\kindupload\\" + newfilename));
        return Result.success(url);
    }
    @PostMapping("/chanpin")
    public Result uploadchanpin(MultipartFile image, HttpServletRequest request) throws Exception {
        log.info("image::{}", image);
        String filename = image.getOriginalFilename();

//        System.currentTimeMillis()是java中的生成毫秒级的时间戳，也可以使用UUID，lastindexof是获取最后一个点的位置为了提取拓展名，substring是字符串截取，如果用split方法截取的就是一个数组了
//        int index = filename.lastIndexOf(".");
//        String extname = filename.substring(index);
//        String newfilename = UUID.randomUUID().toString()+extname;
//        log.info("新的文件名"+newfilename);
        String newfilename = System.currentTimeMillis() + filename;
        image.transferTo(new File(ChanpinfileSavePath + newfilename));
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/chanpin/"  + newfilename;
        System.out.println("url:"+url);
        log.info("url的request.getScheme的东西{},url的request.getServerName的东西{},url的request.getServerPort的东西{}",request.getScheme(),request.getServerName(),request.getServerPort());
//        image.transferTo(new File("C:\\kindupload\\" + newfilename));
        return Result.success(url);
    }
    @PostMapping("/lunbotu")
    public Result uploadlunbotu(MultipartFile image, HttpServletRequest request) throws Exception {
        log.info("image::{}", image);
        String filename = image.getOriginalFilename();
//        System.currentTimeMillis()是java中的生成毫秒级的时间戳，也可以使用UUID，lastindexof是获取最后一个点的位置为了提取拓展名，substring是字符串截取，如果用split方法截取的就是一个数组了
//        int index = filename.lastIndexOf(".");
//        String extname = filename.substring(index);
//        String newfilename = UUID.randomUUID().toString()+extname;
//        log.info("新的文件名"+newfilename);
        String newfilename = System.currentTimeMillis() + filename;
        image.transferTo(new File(LunbotufileSavePath + newfilename));
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/lunbotu/"  + newfilename;
        log.info("url的request.getScheme的东西{},url的request.getServerName的东西{},url的request.getServerPort的东西{}",request.getScheme(),request.getServerName(),request.getServerPort());
//        image.transferTo(new File("C:\\kindupload\\" + newfilename));
        return Result.success(url);
    }
    @PostMapping("/user")
    public Result uploaduser(MultipartFile image, HttpServletRequest request) throws Exception {
        log.info("image::{}", image);
        String filename = image.getOriginalFilename();
//        System.currentTimeMillis()是java中的生成毫秒级的时间戳，也可以使用UUID，lastindexof是获取最后一个点的位置为了提取拓展名，substring是字符串截取，如果用split方法截取的就是一个数组了
//        int index = filename.lastIndexOf(".");
//        String extname = filename.substring(index);
//        String newfilename = UUID.randomUUID().toString()+extname;
//        log.info("新的文件名"+newfilename);
        String newfilename = System.currentTimeMillis() + filename;
        image.transferTo(new File(UserfileSavePath + newfilename));
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/user/"  + newfilename;
        log.info("url的request.getScheme的东西{},url的request.getServerName的东西{},url的request.getServerPort的东西{}",request.getScheme(),request.getServerName(),request.getServerPort());
//        image.transferTo(new File("C:\\kindupload\\" + newfilename));
        return Result.success(url);
    }
    @PostMapping("/news")
    public Result uploadnews(MultipartFile image, HttpServletRequest request) throws Exception {
        log.info("image::{}", image);
        String filename = image.getOriginalFilename();
//        System.currentTimeMillis()是java中的生成毫秒级的时间戳，也可以使用UUID，lastindexof是获取最后一个点的位置为了提取拓展名，substring是字符串截取，如果用split方法截取的就是一个数组了
//        int index = filename.lastIndexOf(".");
//        String extname = filename.substring(index);
//        String newfilename = UUID.randomUUID().toString()+extname;
//        log.info("新的文件名"+newfilename);
        String newfilename = System.currentTimeMillis() + filename;
        image.transferTo(new File(NewsfileSavePath + newfilename));
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/new/"  + newfilename;
        log.info("url的request.getScheme的东西{},url的request.getServerName的东西{},url的request.getServerPort的东西{}",request.getScheme(),request.getServerName(),request.getServerPort());
//        image.transferTo(new File("C:\\kindupload\\" + newfilename));
        return Result.success(url);
    }
    @PostMapping("/honor")
    public Result uploadhonor(MultipartFile image, HttpServletRequest request) throws Exception {
        log.info("image::{}", image);
        String filename = image.getOriginalFilename();
//        System.currentTimeMillis()是java中的生成毫秒级的时间戳，也可以使用UUID，lastindexof是获取最后一个点的位置为了提取拓展名，substring是字符串截取，如果用split方法截取的就是一个数组了
//        int index = filename.lastIndexOf(".");
//        String extname = filename.substring(index);
//        String newfilename = UUID.randomUUID().toString()+extname;
//        log.info("新的文件名"+newfilename);
        String newfilename = System.currentTimeMillis() + filename;
        image.transferTo(new File(HonorfileSavePath + newfilename));
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/honors/"  + newfilename;
        log.info("url的request.getScheme的东西{},url的request.getServerName的东西{},url的request.getServerPort的东西{}",request.getScheme(),request.getServerName(),request.getServerPort());
//        image.transferTo(new File("C:\\kindupload\\" + newfilename));
        return Result.success(url);
    }
}
