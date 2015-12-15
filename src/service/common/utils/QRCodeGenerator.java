package service.common.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import service.common.ServiceResult;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * @author dlz
 */
public class QRCodeGenerator {
	Logger logger = Logger.getLogger(this.getClass());

	private String imgPath;
	
    public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	/**
     * 编码
     * @param contents
     * @param width
     * @param height
     * @param imgPath
     */
    public ServiceResult encode(String contents, int width, int height) {
    	ServiceResult result=new ServiceResult();
		Map<EncodeHintType, Object> hints = new Hashtable<EncodeHintType, Object>();
        // 指定纠错等级
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        // 指定编码格式
        hints.put(EncodeHintType.CHARACTER_SET, "GBK");
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,
                    BarcodeFormat.QR_CODE, width, height, hints);
            imgPath=imgPath+File.separator+UUID.randomUUID().toString()+".png";
            MatrixToImageWriter
                    .writeToFile(bitMatrix, "png", new File(imgPath));

        	result.setResultcode(1);
        	result.setDescription("generate qrcode success");
        	result.setResultdata(imgPath);
        } catch (Exception e) {
        	result.setResultcode(0);
        	result.setDescription("Exception:\n"+e.getMessage());
        }
        return result;
    }
    /** 解码
     * @param imgPath 
     * @return String 
     */  
    public ServiceResult decode(String imgPath) {  
    	ServiceResult serviceresult=new ServiceResult();
		BufferedImage image = null;  
        Result result = null;  
        try {  
            image = ImageIO.read(new File(imgPath));  
            if (image == null) {  
            	serviceresult.setResultcode(0);
            	serviceresult.setDescription("the decode image may be not exit.");
            }else{
            	LuminanceSource source = new BufferedImageLuminanceSource(image);  
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                Map<DecodeHintType, Object> hints = new Hashtable<DecodeHintType, Object>();  
                hints.put(DecodeHintType.CHARACTER_SET, "GBK");
                result = new MultiFormatReader().decode(bitmap, hints);
            	serviceresult.setResultcode(1);
            	serviceresult.setDescription("success");
            	serviceresult.setResultdata(result.getText());
            }  
            
        } catch (Exception e) {  
        	serviceresult.setResultcode(0);
        	serviceresult.setDescription("Exception:\n"+e.getMessage());
        	logger.info(e.getMessage());
        }  
        return serviceresult;  
    } 
 
}