package com.icbc.bjfh.kfyb.controller;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.icbc.bjfh.kfyb.qrcode.QRCodeUtil;

@RestController
@RequestMapping("/qrcode")
public class QRCodeController {

    @RequestMapping(value = "/generateqrcode", method = RequestMethod.GET)
    public void generateQRCode4Product(HttpServletRequest request, HttpServletResponse response) {
        String longUrl;
        String imgPath;
        try {
            longUrl = "https://item.jd.com/59431058018.html#crumb-wrap";
            imgPath = "C:\\Users\\ICBC\\Desktop\\黄显凯\\图片素材\\1.jpg";
            // 转换成短url
            //String shortUrl = ShortNetAddressUtil.generateShortUrl(longUrl);
            // 生成二维码
            BufferedImage qRcodeImg = QRCodeUtil.encode(longUrl, imgPath, true);
            // 将二维码输出到页面中
            ImageIO.write(qRcodeImg, "png", response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}