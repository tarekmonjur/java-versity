package Site.Services;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;
import java.io.File;


/**
 * Created by Tarek Monjur on 1/17/2018.
 */
public class UploadService {

    private static boolean isMultipart;
    private static int maxFileSize = 5000 * 1024;
    private static int maxMemSize = 1000 * 1024;
    private static File file ;

    public static String upload(HttpServletRequest request,String filePath)   throws ServletException, java.io.IOException
    {
        // Check that we have a file upload request
        isMultipart = ServletFileUpload.isMultipartContent(request);

        if( !isMultipart )
        {
            System.out.println("No Upload This Time");
            return "";
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // maximum size that will be stored in memory
        factory.setSizeThreshold(maxMemSize);

        // Location to save data that is larger than maxMemSize.
        factory.setRepository(new File("c:\\temp"));

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        upload.setSizeMax( maxFileSize );

        try{
            List fileItems = upload.parseRequest(request);
            FileItem fi = (FileItem)fileItems.get(0);

            String fieldName = fi.getFieldName();
            String fileName = fi.getName();
            String contentType = fi.getContentType();
            boolean isInMemory = fi.isInMemory();
            long sizeInBytes = fi.getSize();

            if( fileName.lastIndexOf("\\") >= 0 ){
                file = new File( filePath +"\\"+ fileName.substring( fileName.lastIndexOf("\\"))) ;
            }else{
                file = new File( filePath +"\\"+fileName.substring(fileName.lastIndexOf("\\")+1)) ;
            }

            fi.write( file ) ;
            System.out.println("Uploaded Filename: " + fileName + "<br>"+ filePath);
            return fileName;
        }catch(Exception ex) {
            System.out.println("FILE UPLOAD ::-"+ex);
        }
        return "";
    }


    public static void uploadAll(HttpServletRequest request,String filePath)   throws ServletException, java.io.IOException
    {
        // Check that we have a file upload request
        isMultipart = ServletFileUpload.isMultipartContent(request);

        if( !isMultipart )
        {
            System.out.println("No Upload This Time");
            return;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // maximum size that will be stored in memory
        factory.setSizeThreshold(maxMemSize);

        // Location to save data that is larger than maxMemSize.
        factory.setRepository(new File("c:\\temp"));

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        upload.setSizeMax( maxFileSize );

        try{
            List fileItems = upload.parseRequest(request);
            Iterator element = fileItems.iterator();

            while ( element.hasNext () )
            {
                FileItem fi = (FileItem)element.next();
                if ( !fi.isFormField () )
                {
                    String fieldName = fi.getFieldName();
                    String fileName = fi.getName();
                    String contentType = fi.getContentType();
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();

                    if( fileName.lastIndexOf("\\") >= 0 ){
                        file = new File( filePath +"\\"+ fileName.substring( fileName.lastIndexOf("\\"))) ;
                    }else{
                        file = new File( filePath +"\\"+fileName.substring(fileName.lastIndexOf("\\")+1)) ;
                    }

                    fi.write( file ) ;
                    System.out.println("Uploaded Filename: " + fileName + "<br>"+ filePath);
                }
            }
        }catch(Exception ex) {
            System.out.println("FILE UPLOAD ::-"+ex);
        }
    }


}
