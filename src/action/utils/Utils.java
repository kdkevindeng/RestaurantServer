package action.utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
@RequestMapping(value = "/utils")
public class Utils {

	// @Autowired
	// private UserService userService;

	/**
	 * upload
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/upload")
	public void upload2(HttpServletRequest request,
			HttpServletResponse response,HttpSession session, PrintWriter out) throws IllegalStateException,
			IOException {
		String basepath = request.getContextPath();
		basepath=session.getServletContext().getRealPath("/");
		System.out.println("basepath:"+basepath);
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());

		System.out.println(multipartResolver.isMultipart(request));
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				int pre = (int) System.currentTimeMillis();
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null) {
					String myFileName = file.getOriginalFilename();
					if (myFileName.trim() != "") {
						System.out.println(myFileName);
						String filename=UUID.randomUUID().toString()+file.getOriginalFilename();
						String path = basepath + "upload"+File.separator+"img"
						+File.separator+filename;
						System.out.println("path:"+path);
						
						File localFile = new File(path);
						file.transferTo(localFile);
						basepath=filename;
					}
				}
				int finaltime = (int) System.currentTimeMillis();
				System.out.println(finaltime - pre);
			}

		}
		out.print(basepath);
	}

}
