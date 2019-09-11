package com.imooc.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
    private static  String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();
    public static String generateThumbnail(File thumbnail, String targetAddr) {

        String realFileName = getRandomFileName();
        String extension = getFileExtension(thumbnail);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(thumbnail).size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/login.png")), 0.25f)
                    .outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return relativeAddr;
    }

    /**
     * 创建模板路径所涉及到的目录，即/home/work/xiangze/xx.jpg
     * 那么 home work xiangze 这三个文件夹都得自动创建
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr){
        String reakFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(reakFileParentPath);
        //如果没有这个文件夹的话
        if(!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    /**
     * 获取输入文件流的扩展名
     * @param cFile
     * @return
     */
    private static String getFileExtension(File cFile){
        String originalFileName = cFile.getName();  //获取文件名
        return originalFileName.substring(originalFileName.lastIndexOf("."));
    }
    /**
     * 生成随机文件名，当前年月日小时分钟秒钟 + 5位随机数
     * @return
     */
    private static String getRandomFileName(){
        //获取随机的五位数
        int rannum = r.nextInt(89999) + 10000;
        String nowTimeStr = sDateFormat.format(new Date());
        return nowTimeStr + rannum;
    }

    public static void main(String[] args) throws IOException {
        Thumbnails.of(new File("D:\\code\\hcredits-frontend\\build\\images\\b1.553c69e9.jpg"))
                .size(200, 200).watermark(Positions.BOTTOM_RIGHT,
                ImageIO.read(new File(basePath + "/login.png")), 0.25f)
                .outputQuality(0.8f).toFile("D:\\code\\hcredits-frontend\\build\\images\\b1.553c69e9_new.jpg");
    }
}
