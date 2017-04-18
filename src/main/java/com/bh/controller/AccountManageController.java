package com.bh.controller;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bh.entity.Authentification;
import com.bh.entity.SysFile;
import com.bh.service.AuthentificationService;
import com.bh.service.BaseUserService;
import com.bh.service.FileManageService;
import com.bh.service.SysDictionaryService;
import com.bh.service.SysFileService;
import com.shuyin.framework.controller.HttpTemplate;
import com.shuyin.framework.controller.OperateTemplate;
import com.shuyin.framework.exception.BHException;
import com.shuyin.framework.exception.BHExceptionType;
@Controller
@RequestMapping("Account")
public class AccountManageController {
	@Autowired
	@Qualifier("FileManageService")
	FileManageService fileManageService;
	
	@Autowired
	@Qualifier("SysFileService")
	SysFileService sysFileService;
	
	@Autowired
	@Qualifier("AuthentificationService")
	AuthentificationService authentificationService;
	
	@Autowired
	@Qualifier("SysDictionaryService")
	SysDictionaryService sysDictionaryService;
	
	@Autowired
	@Qualifier("BaseUserService")
	BaseUserService baseUserService;
	/**
	 * 企业认证文件上传
	 * @param request
	 * @return
	 */
	@RequestMapping("fileUpload")
	@ResponseBody
	public Map<String,Object> fileUpload(final HttpServletRequest request){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				Map<String,Object> result=new HashMap<String,Object>();
				// 转型为MultipartHttpRequest：
			    MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			    MultipartFile file = multipartRequest.getFile("image");
			    Long fileSize=file.getSize(); //文件大小
			    String fileName=file.getOriginalFilename();
			    String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();//文件扩展名
			    String ProjectName=request.getContextPath();//项目名称
			    String fileUrl=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+ProjectName;
			    
			    if(fileSize>1024*1024*2){
			    	throw new BHException("上传图片不能大于2M！",BHExceptionType.FILE_SIZE_ERROR);
			    }
			    if(!("jpg,png".contains(fileExt))){
			    	throw new BHException("只能上传jpg和png文件！",BHExceptionType.FILE_TYPE_ERROR);
			    }
			    String path=request.getSession().getServletContext().getRealPath("/WEB-INF/image");
			    File savePath=new File(path);
			    if(!savePath.exists()){
			    	savePath.mkdir();
			    }
			    
			    fileManageService.saveFileFromInputStream(file.getInputStream(), path, fileName);
			    SysFile sysFile=new SysFile();
			    sysFile.setCreadtime(new Date());
			    sysFile.setFileDescribe("用户营业执照图片");
			    sysFile.setFileName(fileName);
			    sysFile.setFileUrl(fileUrl+"/image/"+fileName);
			    sysFile.setFileType("image");
			    result.put("fileId",sysFileService.addSysFile(sysFile));
			    map.putAll(result);
			}
		};
		return template.operate();
	}
	@RequestMapping("test")
	public String index(final HttpServletRequest request){
		return "index";
	}
	/**
	 * 企业认证
	 * @param authentification
	 * @return
	 */
	@RequestMapping("enterpriseCertification")
	@ResponseBody
	public Map<String,Object> enterpriseCertification(final Authentification authentification){
		OperateTemplate template=new OperateTemplate() {
			@Override
			protected void doSomething() throws Exception {
				// TODO Auto-generated method stub
				authentificationService.enterpriseCertification(authentification);
			}
		};
		return template.operate();
	}
	
	@RequestMapping("userInfo/{userId}")
	@ResponseBody
	public Map<String,Object> userInfoById(@PathVariable("userId")final  Integer userId ){
		OperateTemplate template=new HttpTemplate() {
			
			@Override
			protected void doSomething() throws Exception {
				map.put("data",baseUserService.userInfoById(userId));
			}
		};
		return template.operate();
	}
	/**
	 * 获取模板信息
	 * @param code
	 * @return
	 */
	@RequestMapping("industryInfo")
	@ResponseBody
	public Map<String,Object> industryInfo(final String code){
		OperateTemplate template=new HttpTemplate() {
			@Override
			protected void doSomething() throws Exception {
				map.put("data", sysDictionaryService.dictionaryInfo(code));
			}
		};
		return template.operate();
	}
	
}
