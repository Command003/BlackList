package xmlReceiver;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet ("/BlackList")
public class xmlServlet extends HttpServlet{
	final String FILE_LOCATION = "https://www.treasury.gov/ofac/downloads/sdn.xml";//location of file which should be downloaded 
	final String [][] contentTypes = {{"xml", "text/xml"}, {"pdf", "application/pdf"}};//variable for contentType. Could be added new 
	//type. If type wil be XML, then contentType wil be text/xml
	private static final long serialVersionUID = -6458761303742176263L;

//@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Object requestObject = request.getParameter("filename");//filename parametr which comes from http-request
		if(requestObject != null){                              //check is there any file, the do some processing
			String fileName = (String) requestObject;           //takes name of the file from resource 
			String contentType = getContentType(fileName.split("\\.")[1]);//depending on the fyleType from RequestObject with help 
			                                                              //of SPLIT method I will get part of the file name after dot(.)
			                                                              //it will be in "fileName" string(only .xml part)
			File file = new File(FILE_LOCATION + "/" + fileName);//I built new file which will be dovnloaded from fileLocation 
			                                                     //and then I passed fileName I need to download
			response.setContentType(contentType);//set up content type which could be downloaded. 
			                                     //I set it up with help of getContentType method
			response.addHeader("Content-Disposition", "attachment); filename = " + fileName);//when file will be downloaded,
			                                                   //it will get ContentDisposition header plus name of current file
			response.setContentLength((int) file.length());//here I take the length of our current "file"
			ServletOutputStream servletOutputStream = response.getOutputStream();//get client outputStream from response method(library)
			BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));//use to retrieve file content to read
			                                                                                         //bytes from file using bufferedInputStream
			int bytesRead = bufferedInputStream.read();//here we are, bytes from the file
			while(bytesRead != -1){//if it is not -1 it means that we still have something to read
				servletOutputStream.write(bytesRead);//here we writes bytesThread - writing data
				bytesRead = bufferedInputStream.read();//reading from file bytes using 2 dimensional array
			}
			if(servletOutputStream != null) servletOutputStream.close();//closing thread of servletOutputStream
			if(bufferedInputStream != null) bufferedInputStream.close();//closing thread of bufferedInputStream
		}
	}	
	
	private String getContentType(String fileType){//the method will check for contentType to return type of file
		                               //if it will find that file type XML, it will return text/xml TYPE
		String returnType = null;
		for(int i = 0; i < contentTypes.length; i++){
			if(fileType.equals(contentTypes[i][0])) returnType = contentTypes[i][1];
			
		}
		return returnType;
	}
}


//super.doGet(request, response);
//	PrintWriter printWriter = resp.getWriter();
//	printWriter.write("hello world");