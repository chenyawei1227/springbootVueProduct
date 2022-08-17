package com.example.springbootvueproduct.controller.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description: 文件上传
 * @Author: Luck
 * @Date: 2022/8/17
 */
@Controller("/file")
@Slf4j
public class FileUploadController {

  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/");

  @PostMapping("/upload")
  @ResponseBody
  public String upload(MultipartFile uploadFile, HttpServletRequest request){

    String realPath = request.getSession().getServletContext().getRealPath("/uploadFile/");
    log.info("realPath: {}", realPath);
    String format = sdf.format(new Date());
    File file = new File(realPath + format);
    if (!file.isDirectory()) {
      file.mkdirs();
    }
    String oldFilename = uploadFile.getOriginalFilename();
    String newFilename = UUID.randomUUID().toString() + oldFilename.substring(oldFilename.lastIndexOf("."),oldFilename.length());

    try {
      uploadFile.transferTo(new File(file,newFilename));
      String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/uploadFile/" + format
          + newFilename;
      return filePath;
    } catch (IOException e) {
      e.printStackTrace();
    }

    return "上传失败!";
  }

}
