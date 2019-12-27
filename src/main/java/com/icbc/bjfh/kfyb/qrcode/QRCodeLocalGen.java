package com.icbc.bjfh.kfyb.qrcode;

import java.awt.image.BufferedImage;
import java.io.OutputStream;

public class QRCodeLocalGen {
 
	public static void main(String[] args) throws Exception {
		// 存放在二维码中的内容
		String text = "hello world";
		// 嵌入二维码的图片路径
		String imgPath = "C:\\Users\\ICBC\\Desktop\\黄显凯\\图片素材\\1.jpg";
		// 生成的二维码的路径及名称
		String destPath = "C:\\Users\\ICBC\\Desktop\\MyQRCode.png";
		// 生成二维码
		QRCodeUtil.encode(text, imgPath, destPath, true);
		// 解析二维码
		String str = QRCodeUtil.decode(destPath);
		// 打印出解析出的内容
		System.out.println(str);
	}
 
}