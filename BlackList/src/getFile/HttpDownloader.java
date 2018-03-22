package getFile;

import java.io.IOException;

public class HttpDownloader {
 
    public static void main(String[] args) {
        String fileURL = "http://www.polyglotinc.com/resume/resumeXML.zip";//"http://jdbc.postgresql.org/download/postgresql-9.2-1002.jdbc4.jar";
        String saveDir = "/home/student/NewFiles/";
        try {
            Download.downloadFile(fileURL, saveDir);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
