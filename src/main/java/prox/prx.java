package prox;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;

public class prx {
	public static void main(String[] args) throws IOException {
        String url="http://komok.fl2.fo.ru/file/chunk69/240734/8572/%D0%9D%D0%BE%D0%B2%D1%8B%D0%B9%20%D1%82%D0%B5%D0%BA%D1%81%D1%82%D0%BE%D0%B2%D1%8B%D0%B9%20%D0%B4%D0%BE%D0%BA%D1%83%D0%BC%D0%B5%D0%BD%D1%82.txt";
        OutputStream outStream=null;
        URLConnection connection=null;
        InputStream is=null;
        File targetFile=null;
        URL server=null;
        //Setting up proxies
        Properties systemSettings = System.getProperties();
            systemSettings.put("proxySet", "true");
          systemSettings.put("https.proxyHost", "https proxy of my organisation");
        systemSettings.put("https.proxyPort", "8080");
            //The same way we could also set proxy for http
            System.setProperty("java.net.useSystemProxies", "true");
            //code to fetch file
        try {
            server=new URL(url);
            connection = server.openConnection();
            is = connection.getInputStream();
            byte[] buffer = new byte[is.available()];
            is.read(buffer);

                targetFile = new File("/home/student/NewFiles/Xmtx777t.txt");
                outStream = new FileOutputStream(targetFile);
                outStream.write(buffer);
        } catch (MalformedURLException e) {
            System.out.println("THE URL IS NOT CORRECT ");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Io exception");
            e.printStackTrace();
        }
        finally{
            if(outStream!=null) outStream.close();
        }
    }
}
