package employeeb.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MiscController {
	@Autowired
	ServletContext context; 
	
	@RequestMapping("/miscellaneous")
	public ModelAndView submitDepartment()
	{  
	    ModelAndView model = new ModelAndView("miscellaneous");
		return model;
	}
	
	@RequestMapping("/UploadFile")
	public ModelAndView uploadFile(@RequestParam("file") MultipartFile file, BindingResult result,ModelMap modelMap) throws IOException {
		  ModelAndView model = new ModelAndView("miscellaneous");
	      if (result.hasErrors()) {
	          System.out.println("validation errors");
	          return model;
	       } else {            
	          System.out.println("Fetching file");
	          String uploadPath = "h:\\uploadfiles\\";
			  // Get the file and save it somewhere
			  //byte[] bytes = file.getBytes();
			  //System.out.println(file.getOriginalFilename());
			  //Path path = Paths.get(uploadPath + file.getOriginalFilename());
			  //Files.write(path, bytes);
			  modelMap.addAttribute("file", file);
			  //System.out.println("You successfully uploaded '" + file.getOriginalFilename() + "'");
	          return model;
	       }
	    }
	
	@RequestMapping("/DownloadFile")
	public ModelAndView downloadFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
		    ModelAndView model = new ModelAndView("miscellaneous");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String gfile = request.getParameter("gfile");
			String gpath = "h:/uploadfiles/";
			response.setContentType("APPLICATION/OCTET-STREAM");
			response.setHeader("Content-Disposition", "attachment; filename=\""
					+ gfile + "\"");
	 
			FileInputStream fileInputStream = new FileInputStream(gpath
					+ gfile);
	 
			int i;
			while ((i = fileInputStream.read()) != -1) {
				out.write(i);
			}
			fileInputStream.close();
			out.close();
	        return model;
	       }
}
