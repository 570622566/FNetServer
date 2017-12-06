package cn.hotapk.fhttpserver.utils;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author laijian
 * @version 2017/9/11
 * @Copyright (C)下午12:02 , www.hotapk.cn
 * 文件操作工具类
 */
public class FFileUtils {

    /**
     * 文件转InputStream
     *
     * @param absPath
     * @return
     */
    public static InputStream file2Inp(String absPath) {
        File file = new File(absPath);
        if (!file.exists()) {
            return null;
        }
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(file));
            return is;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }


    }

    /**
     * InputStream 转字符串
     */
    public static String readInp(InputStream inputStream) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            int len1;
            while ((len1 = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len1);
            }
            inputStream.close();
            outputStream.close();
        } catch (IOException var5) {
        }

        return outputStream.toString();
    }

    /**
     * 获取sd卡下所有文件路径，sd卡下的文件目录不能有.(点) 符号
     *
     * @param filePath
     * @param fileNameFilter
     * @return
     */
    public static Map<String, String> getFileLs(String filePath, String fileNameFilter) {
        Map<String, String> maps = new HashMap<>();
        try {
            File[] files = new File(filePath).listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    getFiles(file, maps, fileNameFilter);
                } else {
                    String fileName = file.getName();
                    if (!fileName.matches(fileNameFilter)) {
                        maps.put(fileName, file.getAbsolutePath());
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return maps;
    }

    private static void getFiles(File fileDir, Map<String, String> maps, String fileNameFilter) {
        File[] files = fileDir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                getFiles(file, maps, fileNameFilter);
            } else {
                String fileName = file.getName();
                if (!fileName.matches(fileNameFilter)) {
                    maps.put(fileName, file.getAbsolutePath());
                }
            }
        }
    }
}
