package com.bh.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.methods.GetMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bh.entity.SysFile;
import com.bh.service.FileManageService;
import com.bh.service.SysFileService;
import com.bh.util.StringUtils;
import com.shuyin.framework.controller.HttpTemplate;
import com.shuyin.framework.controller.OperateTemplate;
import com.shuyin.framework.exception.BHException;
import com.shuyin.framework.exception.BHExceptionType;

@Controller
@RequestMapping("file")
public class FileManageController {
	@Autowired
	@Qualifier("FileManageService")
	FileManageService fileManageService;
	
	@Autowired
	@Qualifier("SysFileService")
	SysFileService sysFileService;
	
	/**
	 * 文件上传
	 * @param request
	 * @return
	 */
	@RequestMapping(value="fileUpload",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> fileUpload(final HttpServletRequest request){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				 String contentType = request.getContentType();  //获取Content-Type  
				 if(!(contentType.toLowerCase().startsWith("multipart/"))) {  
					 throw new BHException("非multipart/form-data格式!");
				 }
				Map<String,Object> result=new HashMap<String,Object>();
				// 转型为MultipartHttpRequest：
			    MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			    String fileType=request.getParameter("fileType");//文件类型
			    String fileId=request.getParameter("fileId");//文件id
			    if(StringUtils.isBlank(fileType)){
			    	fileType="image";
			    }
			    MultipartFile file = multipartRequest.getFile("fileUpload");
			    Long fileSize=file.getSize(); //文件大小
			    String fileName=file.getOriginalFilename();
			    String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();//文件扩展名
			    String ProjectName=request.getContextPath();//项目名称
			    String fileUrl=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+ProjectName+"/image/"+fileName;
			    
			    if(fileSize>1024*1024*2){
			    	throw new BHException("上传图片不能大于2M！",BHExceptionType.FILE_SIZE_ERROR);
			    }
			    if(!("jpg,png".contains(fileExt))){
			    	throw new BHException("只能上传jpg和png文件！",BHExceptionType.FILE_TYPE_ERROR);
			    }
			    String saveFileName=fileName.substring(0,fileName.lastIndexOf("."));
			    String path=request.getSession().getServletContext().getRealPath("/WEB-INF/image");
			    File savePath=new File(path);
			    if(!savePath.exists()){
			    	savePath.mkdir();
			    }
			    
			    fileManageService.saveFileFromInputStream(file.getInputStream(), path, fileName);
			   
			    if(StringUtils.isNotBlank(fileId)){//判断fileId是否为空
			    	Long fileIdL= Long.parseLong(fileId);
			    	sysFileService.updateSysFile(fileIdL, fileUrl);
			    	result.put("fileId",fileIdL);
			    }else{
			    	 SysFile sysFile=new SysFile();
					 sysFile.setCreadtime(new Date());
					// sysFile.setFileDescribe("用户营业执照图片");
					 sysFile.setFileName(saveFileName);
					 sysFile.setFileUrl(fileUrl);
					 sysFile.setFileType(fileType);
					 result.put("fileId",sysFileService.addSysFile(sysFile));
			    }
			    result.put("fileUrl",fileUrl);
			    map.putAll(result);
			}
		};
		return template.operate();
	}
	@RequestMapping(value="homeLogoInfo",method=RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> homeLogoInfo(final @RequestParam("fileType") String fileType){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				map.put("data",sysFileService.homeLogoInfo(fileType));
			}
		};
		return template.operate();
	}
}
