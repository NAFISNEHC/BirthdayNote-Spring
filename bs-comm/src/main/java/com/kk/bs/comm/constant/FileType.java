/**
 * Copyright (C), 2015-2019, 知融科技服务有限公司
 * FileName: FileType
 * Author:   allahbin
 * Date:     2019/4/25 16:28
 * Description: 记录SysFile表中的文件类型
 */
package com.kk.bs.comm.constant;

import java.util.regex.Pattern;

/**
 * 〈一句话功能简述〉<br> 
 * 〈记录SysFile表中的文件类型〉
 *
 * @author allahbin
 * @create 2019/4/25
 * @since 1.0.0
 */
public class FileType {
    /**
     * Excel文件
     */
    public static final String EXCEL = "excel";

    /**
     * 图片
     */
    public static final String IMG = "img";

    /**
     * 安装包
     */
    public static final String APK = "apk";

    /**
     * 普通文件
     */
    public static final String FILE = "file";

    /**
     * 压缩包
     */
    public static final String ZIP = "zip";

    /**
     * 日志文件
     */
    public static final String LOG = "log";

    public static String getFileUrl(String fileType, UploadPathConfig uploadPathConfig){
        // 根据不同的文件类型，返回不同的文件地址
        switch (fileType){
            case APK: {
                return uploadPathConfig.getApk();
            }
            case IMG: {
                return uploadPathConfig.getImg();
            }
            case ZIP: {
                return uploadPathConfig.getZip();
            }
            case EXCEL: {
                return uploadPathConfig.getExcel();
            }
            case LOG: {
                return uploadPathConfig.getLog();
            }
            default:{
                return uploadPathConfig.getFile();
            }
        }
    }

    /**
     * 获取文件的类型
     * @param suffix 文件的后缀
     */
    public static String getFileType(String suffix){
        suffix = suffix.toLowerCase();
        if(Pattern.matches(".*(xls|xlsx).*", suffix)){
            return EXCEL;
        }
        if(Pattern.matches(".*(bmp|jpg|png|tif|gif|pcx|tga|exif|fpx|svg|psd|cdr|pcd|dxf|ufo|eps|ai|raw|WMF|webp).*", suffix)){
            return IMG;
        }
        if(Pattern.matches(".*(apk|ipa|exe).*", suffix)){
            return APK;
        }
        if(Pattern.matches(".*(.rar|.zip|.7z).*", suffix)){
            return ZIP;
        }
        if(Pattern.matches(".*(.log).*", suffix)){
            return LOG;
        }
        return FILE;
    }
}
