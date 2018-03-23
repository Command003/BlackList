package getFile;

import java.io.IOException;

import GUI.Set;

public class HttpDownloader extends Set {
 
    public static void main(String[] args) {
    	
        String fileURL = "https://www.youtube.com/watch?v=5uR8_xoKaCo";//"http://www.polyglotinc.com/resume/resumeXML.zip";//"http://jdbc.postgresql.org/download/postgresql-9.2-1002.jdbc4.jar";
        String saveDir = "/home/student/NewFiles/";
        
        
        
       
        
        
        try {
            Download.downloadFile(fileURL, saveDir);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
