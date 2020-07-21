package com.hangyu.platform.utils;

import com.hangyu.platform.global.CommonFields;
import com.hangyu.platform.global.PlatException;
import com.hangyu.platform.global.ResultStatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtils {

    private static final Logger log = LoggerFactory.getLogger(FileUtils.class);

    /**
     * 默认大小 50M
     */
    public static final long DEFAULT_MAX_SIZE = 50 * 1024 * 1024;


    /**
     * 文件上传
     *
     * @param file 上传的文件
     * @return 返回上传成功的文件名
     * @throws IOException 比如读写文件出错时
     */
    public static String uploads(MultipartFile file)
            throws IOException {


       // long size = file.getSize();
//        if (DEFAULT_MAX_SIZE != -1 && size > DEFAULT_MAX_SIZE) {
//            throw new PlatException("文件大小超出限制");
//        }
        String fileName = file.getOriginalFilename();
        try {
            int i = fileName.lastIndexOf(".");
        } catch (IndexOutOfBoundsException e) {
            throw new PlatException(ResultStatusEnum.File_ERROR.getMessage());
        }
        //获取后缀名
        String suffix = fileName.substring(fileName.lastIndexOf("."));

        int random = (int) Math.random() * 10000;
        //时间格式化格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        //获取当前时间并作为时间戳
        String timeStamp = simpleDateFormat.format(new Date());
        String newFileName = timeStamp + random + suffix;
        File destDir = new File(CommonFields.getFilePath());
        //判断文件夹是否存在，不存在则逐层创建
        if (!destDir.exists() && !destDir.isDirectory()) {
            destDir.mkdirs();
        }
        File dest = new File(CommonFields.getFilePath() + newFileName);

        file.transferTo(dest);
        return newFileName;
    }

    /**
     * 图片上传，需要页面加载的图片
     *
     * @param file 上传的文件
     * @return 返回上传成功的文件名
     * @throws IOException 比如读写文件出错时
     */
    public static String uploadStaticFile(MultipartFile file)
            throws IOException {

//        long size = file.getSize();
//        if (DEFAULT_MAX_SIZE != -1 && size > DEFAULT_MAX_SIZE) {
//            throw new PlatException("文件大小超出限制");
//        }
        String fileName = file.getOriginalFilename();
        try {
            int i = fileName.lastIndexOf(".");
        } catch (IndexOutOfBoundsException e) {
            throw new PlatException(ResultStatusEnum.File_ERROR.getMessage());
        }
        //获取后缀名
        String suffix = fileName.substring(fileName.lastIndexOf("."));

        int random = (int) Math.random() * 10000;
        //时间格式化格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        //获取当前时间并作为时间戳
        String timeStamp = simpleDateFormat.format(new Date());
        String newFileName = timeStamp + random + suffix;
        File destDir = new File(CommonFields.getPicPath());
        //判断文件夹是否存在，不存在则逐层创建
        if (!destDir.exists() && !destDir.isDirectory()) {
            destDir.mkdirs();
        }
        File dest = new File(CommonFields.getPicPath() + newFileName);
        file.transferTo(dest);
        return newFileName;
    }

    /**
     * 删除文件操作
     *
     * @param pathname
     * @return
     */
    public static boolean deleteFile(String pathname) {
        boolean result = false;
        File file = new File(CommonFields.getFilePath() + pathname);
        if (file.exists()) {
            file.delete();
            result = true;
        }
        return result;
    }

    /**
     * 删除静态文件操作
     *
     * @param pathname
     * @return
     */
    public static boolean deleteStaticFile(String pathname) throws IOException {
        boolean result = false;
        File file = new File(CommonFields.getPicPath() + pathname);
        if (file.exists()) {
            file.delete();
            result = true;
        }
        return result;
    }

    /**
     * 文件下载
     *
     * @param response
     * @param fileName
     * @throws IOException
     */
    public static void download(HttpServletResponse response, String path, String fileName) throws IOException {
        File file = new File(path + fileName);
        log.info("file url :{}",file.getPath());
        //判断文件父目录是否存在
        if (file.exists()) {
            response.setContentType("application/force-download");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment;fileName=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;

            OutputStream os = null; //输出流
            os = response.getOutputStream();
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer);
                i = bis.read(buffer);
            }
            bis.close();
            fis.close();
            os.close();
        } else {
            throw new PlatException(ResultStatusEnum.File_NOT_EXISTS.getMessage());
        }

    }


}
