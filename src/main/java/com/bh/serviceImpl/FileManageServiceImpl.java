package com.bh.serviceImpl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.bh.service.FileManageService;
@Service(value="FileManageService")
public class FileManageServiceImpl implements FileManageService {

	public void saveFileFromInputStream(InputStream stream,String path,String filename) throws IOException
    {
        FileOutputStream fs=new FileOutputStream( path + "/"+ filename);
        byte[] buffer =new byte[1024*1024];
        int bytesum = 0;
        int byteread = 0;
        while ((byteread=stream.read(buffer))!=-1)
        {
            bytesum+=byteread;
            fs.write(buffer,0,byteread);
            fs.flush();
        }
        fs.close();
        stream.close();
        
    }
	
//	public void saveFileFromInputStream(InputStream stream,String path,String fileName) throws IOException
//	{
//	      // 发送http请求
//		  URL url=new URL(path);
//          HttpURLConnection connection=(HttpURLConnection)url.openConnection();
//          connection.setDoInput(true);
//          connection.setDoOutput(true);
//          connection.setRequestMethod("POST");
//          connection.addRequestProperty("FileName", fileName);
//          connection.setRequestProperty("content-type", "text/html");
//          BufferedOutputStream  out=new BufferedOutputStream(connection.getOutputStream());
//          
//          //读取文件上传到服务器
//          byte[]bytes=new byte[1024];
//  			int numReadByte=0;
//          while((numReadByte=stream.read(bytes,0,1024))>0)
//          {
//              out.write(bytes, 0, numReadByte);
//          }
//
//          out.flush();
//          out.close();
//          stream.close();
//          //读取URLConnection的响应
//       //   DataInputStream in=new DataInputStream(connection.getInputStream());
//	}
	
}
