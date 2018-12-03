package com.dongfang.client.zhongxin.web.front.controller.person;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.dongfang.client.zhongxin.annex.library.service.AnnexLibraryService;
import com.dongfang.client.zhongxin.annex.library.vo.AnnexLibraryVO;
import com.dongfang.client.zhongxin.commons.enums.ApiStatusCode;
import com.dongfang.client.zhongxin.employee.service.EmployeeService;
import com.dongfang.client.zhongxin.web.front.response.ResponseDataModel;
import com.dongfang.client.zhongxin.web.front.response.upload.UploadResponse;



/**
 * @author 文件上传控制器
 *
 */
@Controller
@RequestMapping("/personAnnexLibrary")
public class PersonAnnexLibraryController {
	private Image img;
	
	
	AnnexLibraryVO uploadVOModel=new AnnexLibraryVO();
	
	public AnnexLibraryVO getUploadVOModel() {
		return uploadVOModel;
	}
	public void setUploadVOModel(AnnexLibraryVO uploadVOModel) {
		this.uploadVOModel = uploadVOModel;
	}



	/***
	 * 保存文件
	 * @param file
	 * @return
	 */
	private boolean saveFile(MultipartFile file) {
		// 判断文件是否为空
		if (!file.isEmpty()) {
			try {
				// 文件保存路径
				String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/"
						+ file.getOriginalFilename();
				// 转存文件
				file.transferTo(new File(filePath));
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	
	
	/**
	 *  多文件上传
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/filesSave",method=RequestMethod.POST)
	@ResponseBody
	public ResponseDataModel filesUpload(@RequestParam("files") MultipartFile[] files ) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			
			//判断file数组不能为空并且长度大于0
			if(files!=null&&files.length>0){
				//循环获取file数组中得文件
				for(int i = 0;i<files.length;i++){
					MultipartFile file = files[i];
					//保存文件
					saveFile(file);
				}
			}
	        //System.out.println(JavaSmsApi.sendVoice(apikey, mobile ,code));
				
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
	//		resDataModel.setData();
		}catch(Exception e){
			logger.error("审核人添加失败,原因{}", ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	}
	
	 
	//文件名称处理  
	private String handlerFileName(String fileName) {  
		  //处理名称start  
		  fileName = (new Date()).getTime()+"_"+fileName;  
		//时间戳+文件名，防止覆盖重名文件  
		  String pre = StringUtils.substringBeforeLast(fileName, ".");  
		  String end = StringUtils.substringAfterLast(fileName, ".");  
		//  fileName = Digests.encodeByMd5(pre)+"."+end;//用MD5编码文件名，解析附件名称  
		  //处理名称end  
		  return fileName;  
	 }  
	
	/**
	 * 上传文件信息导入
	 * @param employeeGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value ="/messageSave",method = RequestMethod.POST)
	@ResponseBody
	public ResponseDataModel uploadMessage(@RequestBody AnnexLibraryVO annexLibraryVO, HttpServletRequest request,HttpServletResponse response )throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		annexLibraryService.save(annexLibraryVO);
	    resDataModel.setData(annexLibraryVO);
	    resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
	    return resDataModel;
	}
	
	
	
	
	
	
	/**
	 * 上传文件删除
	 * @param employeeGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value ="/fileDelete",method = RequestMethod.POST)
	@ResponseBody
	public ResponseDataModel fileDelete(@RequestBody AnnexLibraryVO annexLibraryVO, HttpServletRequest request,HttpServletResponse response )throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		
		File file = new File(annexLibraryVO.getFilePath());
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
        }
		resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
	    return resDataModel;
	}
	public String uploadMessageShow(){
		String name=this.getUploadVOModel().getFileName();
		System.out.println(name);
		return name;
	}
	
	/**
	 *  文件上传
	 * @param companyGetParameter
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value="/fileSave",method = RequestMethod.POST,produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public ResponseDataModel fileUpload(HttpServletRequest request) throws Exception{
		ResponseDataModel resDataModel = new ResponseDataModel();
		try{
			CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
			if(multipartResolver.isMultipart(request)){
				AnnexLibraryVO annexLibraryVO=new AnnexLibraryVO();
				  MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
			      //取得request中的所有文件名
			      Iterator<String> iter = multiRequest.getFileNames();
			      while(iter.hasNext()){
			        //记录上传过程起始时的时间，用来计算上传时间
			        int pre = (int) System.currentTimeMillis();
			        //取得上传文件
			        MultipartFile file = multiRequest.getFile(iter.next());
			        if(file != null){
			          //取得当前上传文件的文件名称
			          String myFileName = file.getOriginalFilename();
			          //如果名称不为“”,说明该文件存在，否则说明该文件不存在
			          if(myFileName.trim()!=""){
			            System.out.println(myFileName);
			            //重命名上传后的文件名
			            String fileName = file.getOriginalFilename();
			            UUID uuid = UUID.randomUUID();
			            String fileEnd = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
			            String changefileName=uuid.toString()+"."+fileEnd;
			            //定义上传路径
			            /*
			            String path = "/Users/fanyufeng/2017/duode-webfront/apache-tomcat-7.0.70/webapps/duode_1.7/duode_V2_3/personAnnexLibrary/" + changefileName;
			            String xpath="/duode_1.7/duode_V2_3/personAnnexLibrary/" + changefileName;
			            
			            String pathCompression="/Users/fanyufeng/2017/duode-webfront/apache-tomcat-7.0.70/webapps/duode_1.7/duode_V2_3/personAnnexLibrary/compression/" + changefileName;
			            String xpathCompression="/duode_1.7/duode_V2_3/personAnnexLibrary/compression/" + changefileName;
			          */
			          
			            
			            String pathCompression="/usr/local/jiaodapaopao/dreameclipse/apache-tomcat-7.0.70/webapps/personAnnexLibrary/compression/" + changefileName;
			            String xpathCompression="/personAnnexLibrary/compression/" + changefileName;
			            
			            String path = "/usr/local/jiaodapaopao/dreameclipse/apache-tomcat-7.0.70/webapps/personAnnexLibrary/" + changefileName;
			            String xpath="/personAnnexLibrary/" + changefileName;
			             
			         
			            
			            annexLibraryVO.setFilePath(xpath);
			            annexLibraryVO.setFileName(myFileName);
			            this.setUploadVOModel(annexLibraryVO);
			            
			            File localFile = new File(path);
			            
			            String uninName=changefileName.substring(0,5).toString();
			            UploadResponse uploadResponse=new UploadResponse();
			            uploadResponse.setFileName(uninName);
			            uploadResponse.setFilePath(xpath);
			            uploadResponse.setCompressFilePath(xpathCompression);
			            uploadResponse.setStatus(1);
			            resDataModel.setData(uploadResponse);
			            file.transferTo(localFile);
			            
			            File fileImage = new File(path);
			            img=ImageIO.read(fileImage);
			            BufferedImage image = new BufferedImage(200, 200,BufferedImage.TYPE_INT_RGB );   
			            image.getGraphics().drawImage(img, 0, 0, 200,200, null); // 绘制缩小后的图  
			            File destFile = new File(pathCompression);  
			            ImageIO.write(image, "png", destFile);
			         
			            
			          }
			          
			        }
			        //记录上传该文件后的时间
			        int finaltime = (int) System.currentTimeMillis();
			        System.out.println(finaltime - pre);
			        
			      }
			}	
			resDataModel.setStatusCode(ApiStatusCode.SUCCESS.value());
			
		}catch(Exception e){
			logger.error("审核人添加失败,原因{}", ExceptionUtils.getFullStackTrace(e));
		}
		return resDataModel;
	}
	
	
	/***
	 * 读取上传文件中得所有文件并返回
	 * 
	 * @return
	 */
	@RequestMapping(value="/list")
	public ModelAndView list() {
		String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/";
		ModelAndView mav = new ModelAndView("list");
		File uploadDest = new File(filePath);
		String[] fileNames = uploadDest.list();
		for (int i = 0; i < fileNames.length; i++) {
			System.out.println(fileNames[i]);
		}
		return mav;
	}
	
	
	
	
	
	
	/** 日志统计 */
	private static final Logger logger = LoggerFactory.getLogger(PersonAnnexLibraryController.class);

	@Autowired
	public EmployeeService employeeService;

	@Autowired
	private HttpServletRequest request;

	@Autowired
	public AnnexLibraryService annexLibraryService;
	

}
