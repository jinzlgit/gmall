package com.atguigu.gmall.manage.util;

import org.apache.commons.lang3.StringUtils;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class PmsUploadUtil {


    public static String uploadImage(MultipartFile multipartFile, String fileUrl) throws IOException, MyException {
        String configFile = PmsUploadUtil.class.getResource("/tracker.conf").getPath();
        ClientGlobal.init(configFile);
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(trackerServer, null);
        byte[] bytes = multipartFile.getBytes();// 获得上传的二进制对象
        String originalFilename = multipartFile.getOriginalFilename();
        String extName = StringUtils.substringAfterLast(originalFilename, ".");
        String[] uploadInfos = storageClient.upload_file(bytes, extName, null);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(fileUrl).append("/");
        for (String uploadInfo : uploadInfos) {
            stringBuilder.append(uploadInfo);
        }
        return stringBuilder.toString();
    }
}
