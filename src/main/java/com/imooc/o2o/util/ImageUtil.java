package com.imooc.o2o.util;

import com.imooc.o2o.dto.ImageHolder;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ImageUtil {
    private static  String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random r = new Random();
    public static String generateThumbnail(ImageHolder thumbnail, String targetAddr) {

        String realFileName = getRandomFileName();
        //获取文件的扩展名如png,jpg等
        String extension = getFileExtension(thumbnail.getImageName());
        //如模板路径不存在，则自动创建
        makeDirPath(targetAddr);
        //获取文件存储的相对路径（带文件名）
        String relativeAddr = targetAddr + realFileName + extension;
        //获取文件要保存到的目标路径
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        try {
            //调用Thumbnails生成带有水印的图片
            Thumbnails.of(thumbnail.getImage()).size(200, 200)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/login.png")), 0.25f)
                    .outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回图片相对路径地址
        return relativeAddr;
    }
    public static String generateNormalImg(ImageHolder thumbnail, String targetAddr) {

        String realFileName = getRandomFileName();
        String extension = getFileExtension(thumbnail.getImageName());
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(thumbnail.getImage()).size(337, 640)
                    .watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "/login.png")), 0.25f)
                    .outputQuality(0.9f).toFile(dest);
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
     * @param fileName
     * @return
     */
    private static String getFileExtension(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }
    /**
     * 生成随机文件名，当前年月日小时分钟秒钟 + 5位随机数
     * @return
     */
    public static String getRandomFileName(){
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

    /**
     * storePath 是文件的路径还是目录的路径，
     * 如果storePath是文件路径则删除该文件
     * 如果storePath是目录路径则删除该目录下的所有文件
     * @param storePath
     */
    public static void deleteFileOrPath(String storePath) {
        File fileOrPath = new File(PathUtil.getImgBasePath() + storePath);
        if(fileOrPath.exists()) {
            if(fileOrPath.isDirectory()) {
                File files[] = fileOrPath.listFiles();
                for (int i = 0; i < files.length; i++) {
                    files[i].delete();
                }
            }
            fileOrPath.delete();
        }
    }
}
