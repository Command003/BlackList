package BlackList.BlackList;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DownloadFileServlet")
public class XMLReceiver extends HttpServlet{
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
	   final long serialVersionUID = 1l;
	   final String FILE_LOCATION = "https://www.treasury.gov/ofac/downloads/sdn.xml";
	   final String[][] contentTypes = {{"xml", "text/xml"}, {"pdf", "application/pdf"}};
	   Object requestObject = request.getParameter("filename");
	   
	   if(requestObject != null){
		   String fileName = (String) requestObject;
		   String contentType = getContentType(fileName.split("\\.")[1]);
		   File file = new File(FILE_LOCATION + "/" + fileName);
		   response.setContentType(contentType);
		   response.addHeader("Content-Disposition", "attachment; filename" + fileName );
		   response.setContentLength((int) file.length());
		   ServletOutputStream servletOutputStream = response.getOutputStream();
		   BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
	   }	   
   }
    private String getContentType(String fileType){
    	return null;
    }
    
}
