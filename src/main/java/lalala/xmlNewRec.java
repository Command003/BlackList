package lalala;



	
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.io.OutputStream;
	 
	import javax.servlet.ServletContext;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	public class xmlNewRec extends HttpServlet{
		private static final long serialVersionUID = 5277214040974960409L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // reads input file from an absolute path
	        String filePath = "/home/student/.ssh";//https://www.treasury.gov/ofac/downloads/sdn.xml
	        File downloadFile = new File(filePath);
	        FileInputStream inStream = new FileInputStream(downloadFile);
	         
	        // if you want to use a relative path to context root:
	        String relativePath = getServletContext().getRealPath("");
	        System.out.println("relativePath = " + relativePath);
	         
	        // obtains ServletContext
	        ServletContext context = getServletContext();
	         
	        // gets MIME type of the file
	        String mimeType = context.getMimeType(filePath);
	        if (mimeType == null) {        
	            // set to binary type if MIME mapping not found
	            mimeType = "application/octet-stream";
	        }
	        System.out.println("MIME type: " + mimeType);
	         
	        // modifies response
	        response.setContentType(mimeType);
	        response.setContentLength((int) downloadFile.length());
	         
	        // forces download
	        String headerKey = "Content-Disposition";
	        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
	        response.setHeader(headerKey, headerValue);
	         
	        // obtains response's output stream
	        OutputStream outStream = response.getOutputStream();
	         
	        byte[] buffer = new byte[4096];
	        int bytesRead = -1;
	         
	        while ((bytesRead = inStream.read(buffer)) != -1) {
	            outStream.write(buffer, 0, bytesRead);
	        }
	         
	        inStream.close();
	        outStream.close();     
	    }
	}
	
	
	
	/*<servlet>
	<description>This servlet sends file to client</description>
	<display-name>DownloadFileServlet</display-name>
	<servlet-name>DownloadFileServlet</servlet-name>
	<servlet-class>net.codejava.DownloadFileServlet</servlet-class>
	</servlet>
	
	<servlet-mapping>
	<servlet-name>DownloadFileServlet</servlet-name>
	<url-pattern>/DownloadFileServlet</url-pattern>
	</servlet-mapping>  
	https://o7planning.org/ru/10839/uploading-and-downloading-files-from-database-using-java-servlet*/
