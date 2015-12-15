package service.common.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import service.common.ServiceResult;

public class FileUploadService {
	Logger logger = Logger.getLogger(this.getClass());
	private String basepath;
	
	public String getBasepath() {
		return basepath;
	}
	public void setBasepath(String basepath) {
		this.basepath = basepath;
	}
	public ServiceResult uploadExcel(HttpServletRequest request){
		String[] allowedfiletype={"xls","xlsx"};
		return uploadFile(request,allowedfiletype);
	}
	public ServiceResult uploadImg(HttpServletRequest request){
		String[] allowedfiletype={"jpg","png"};
		return uploadFile(request,allowedfiletype);
	}
	
	public ServiceResult uploadFile(HttpServletRequest request,String[] allowedfiletype){
		ServiceResult result=new ServiceResult();
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		logger.info("uploadFile---request is contains Multipart:"+multipartResolver.isMultipart(request));
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				int pre = (int) System.currentTimeMillis();
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null) {
					String myFileName = file.getOriginalFilename();
					if (myFileName!=null&& !"".equals(myFileName.trim())) {
						boolean isallowedtype=false;
						for(int i=0;i<allowedfiletype.length;i++){
							String[] filetypes = myFileName.split(".");
							if(filetypes.length>0&&filetypes[filetypes.length-1].equals(allowedfiletype[i])){
								isallowedtype=true;
							}
						}
						if(isallowedtype){
							String filename=UUID.randomUUID().toString()+myFileName;
							String approotpath = request.getSession().getServletContext().getRealPath("/");
							String path = approotpath+File.separator+this.basepath+File.separator+filename;
							logger.info("file has upload to the url:"+path);
							File localFile = new File(path);
							try {
								file.transferTo(localFile);
							} catch (IllegalStateException e) {

								result.setResultcode(0);
								result.setDescription("File save error:"+e.getMessage());
							
							} catch (IOException e) {

								result.setResultcode(0);
								result.setDescription("File save error:"+e.getMessage());
							
							}
							result.setResultcode(1);
							result.setDescription("file upload success");
							result.setResultdata(path);
						}else{
							result.setResultcode(0);
							result.setDescription(myFileName+" not allowed upload");
						}
						
					}else{
						result.setResultcode(0);
						result.setDescription("OriginalFilename is empty or null");
					}
				}
				int finaltime = (int) System.currentTimeMillis();
				System.out.println(finaltime - pre);
			}
	
		}else{
			result.setResultcode(0);
			result.setDescription("request is not contains Multipart");
		}
		return result;
	}
	public ServiceResult createPreviewImage(String srcFile, String destFile,double width) {   
		ServiceResult result=new ServiceResult();
		try {   
            File srcfi = new File(srcFile); // src   
            File desfo = new File(destFile); // dest   
            BufferedImage srcbis = ImageIO.read(srcfi);
            double newwith=width;
            double rate=1;
            double newheight=width;
            if(srcbis.getWidth()>newwith){
            	rate=((double)(srcbis.getWidth()))/newwith;
            	newheight=((double)(srcbis.getHeight()))/rate;
            }else{
            	rate=newwith/((double)(srcbis.getWidth()));
            	logger.info("120/100:"+((double)120/(double)100));
            	newheight=((double)(srcbis.getHeight()))*rate;
            }
            /*新生成结果图片*/  
            BufferedImage resultimg = new BufferedImage((int)newwith, (int)newheight, BufferedImage.TYPE_INT_RGB);  
            resultimg.getGraphics().drawImage(srcbis.getScaledInstance((int)newwith, (int)newheight, BufferedImage.TYPE_INT_RGB), 0, 0, null);  
            ImageIO.write(resultimg, "jpg", desfo);  
            resultimg.flush();

			result.setResultcode(1);
			result.setDescription("CreatePreviewImage Success");
        } catch (Exception e) { 

			result.setResultcode(0);
			result.setDescription("Exception:\n"+e.getMessage());
		
        	logger.info("Exception:"+e.getMessage());
        }  
		return result;
    }
}
