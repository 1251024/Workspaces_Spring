package com.mvc.updown;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.mvc.updown.validate.FileValidator;
import com.mvc.updown.validate.UploadFile;

@Controller
public class HomeController {

	@Autowired
	private FileValidator fileValidator;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	// ▼ 업로드, 다운로드▼
	@RequestMapping("/form")
	public String uploadForm() {
		return "upload";
	}

	// 업로드
	@RequestMapping("/upload")
	public String fileUpload(HttpServletRequest request, Model model, UploadFile uploadFile, BindingResult result) {
	// HttpServletRequest : doGet, doPost 등으로 들어올때
	// BindingResult : 결과 묶음, ModelAttribute을 이용해 매개변수를 bean에 binding할 때 발생 한 오류정보를 받기 위해 선언(Validator를 상속받는 클래스에서 객체값을 검증하는 방식)
	// Validator: 오브젝트 검증기
		
		//파일 유효성 검사
		//BindingResult: Validator메소드 호출했을때 결과값이 나올때까지 잠시 묶어두는애
		//결과가 나올때까지 값을 묶어뒀다가 보내줌
		fileValidator.validate(uploadFile, result); //xml문서를 읽어와서
		if (result.hasErrors()) {					//만약 결과값이 에러라면 upload 페이지를 그대로 보여준다.
			return "upload";
		}
		
		//MultipartFile 인터페이스 : 큰 파일을 청크단위로 쪼개서 효율적으로 파일 업로드 할 수 있게 해줌
		//파일 내용은 메모리에 저장되거나 디스크에 임시로 저장됩니다. 두 경우 모두 사용자는 원하는 경우 파일 내용을 세션 수준 또는 영구 저장소에 복사 할 책임이 있습니다. 요청 처리가 끝나면 임시 저장소가 지워집니다.
		
		MultipartFile file = uploadFile.getMpfile();	//validator로 읽어온 mpfile을 변수명 file에 저장
		String name = file.getOriginalFilename();		//원래 파일이름을 name이라고 하고

		//UploadFile: 지정된 URI를 사용하여 리소스에 지정된 로컬 파일을 업로드합니다.
		UploadFile fileObj = new UploadFile();		//파일업로드하면 객체생성 할거임
		fileObj.setName(name);						//업로드된 파일의 이름은 원래파일명
		fileObj.setDesc(uploadFile.getDesc());		//업로드된파일의 순서는 getDesc순서로

		InputStream inputStream = null;
		OutputStream outputStream = null;

		try {
			inputStream = file.getInputStream(); // 해당 경로의 파일을 읽는다
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");//파일경로
			//C:\Workspace\Workspaces_Spring\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringMVC04_file\resources\storage
			System.out.println("업로드 실제 경로 : " + path);

			File storage = new File(path);
			if (!storage.exists()) { // 해당 경로에 파일이 있는지 없는지 확인해서 storage가 없다면
				storage.mkdir(); // storage를 만든다
				//resources 폴더가 안생기면 mkdirs로 바꿔준다
			}

			File newFile = new File(path + "/" + name);//newFile 객체생성(해당경로에 원래파일이름으로)
			if (!newFile.exists()) {		//exists : 해당경로에 파일이 있는지 아닌지 확인 //!newFile이 경로에 파일이 없다면
				newFile.createNewFile();	//newFile을 만든다.
			}

			outputStream = new FileOutputStream(newFile);	//newFile을 쓴다

			int read = 0;	

			byte[] b = new byte[(int) file.getSize()];	//validator로 읽어온 mpfile의 길이만큼 바이트 배열생성하는데

			while ((read = inputStream.read(b)) != -1) {	//바이트배열 읽어왔을때 -1과 같지 않으면
				outputStream.write(b, 0, read);				//배열을 써준다.

				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("fileObj", fileObj);	//업로드한 파일을 model에 담는다.

		return "download";	//download로 보낸다
		
		//javaIO참고 (https://dololak.tistory.com/436)
	}

	// 다운로드
	@ResponseBody
	//@ResponseBody : 자바의 값을 해당컨트롤러에서 리턴해주는 값을 바로 넣어주겠다. 엮어주겠다.
	@RequestMapping("/download")
	public byte[] fileDownload(HttpServletRequest request, HttpServletResponse response, String name) {

		byte[] down = null;

		try {
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "resources/storage");
			//getRealPath: 절대경로,서블릿 컨테이너가 제공하는 웹 애플리케이션 내에서 주어진 경로의 실제 경로를 반환합니다.
			//				이클립스에서 만든 톰캣의 서버, 톰캣 server location의 배포하는 경로는 wtpwebapps 실제 동작하는 애들의 경로
			File file = new File(path + "/" + name);	//file객체 생성

			down = FileCopyUtils.copyToByteArray(file);	//복사해서
			String filename = new String(file.getName().getBytes(), "8859_1");//문자로 바꿔서
			//FileCopyUtils: 파일 및 스트림 복사를 위한 간단한 유틸리티 메소드 집합체, 
			//				모든 복사방법은 4096byte의 블록크기를 사용 하고 완료되면 모든 영향을 받는 스트림을 닫는다.
			//copyToByteArray: 지정한 input인 file의 내용을 새로운 byte[]로 복사한다.(리턴값은 copy된 새로운 byte[]이다.
			
			 //한글은 http 헤더에 사용할 수 없기때문에 파일명은 영문으로 인코딩하여 헤더에 적용한다
			//content-disPosition : 컨텐트 타입의 옵션
            //attachment : 브라우저 인식 파일확장자를 포함하여 모든 확장자의 파일들에 대해, 다운로드 시 무조건 '파일다운로드' 대화상자가 뜨도록 하는 해더속성
			
			//Content-Disposition: attachment->file download 설정(filename 설정)
			response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\""); //이름설정
			response.setContentLength(down.length); //크기는 이만큼
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return down;

	}
}
/*
	@RequestMapping("/upload")
	public String fileUpload(HttpServletRequest request, Model model, UploadFile uploadFile, BindingResult result) {
		
		// 파일 유효성 검사
		fileValidator.validate(uploadFile, result);
		if(result.hasErrors()) {
			return "upload";
			// 에러시 업로드 페이지 리턴
		}
		
		//MultipartFile 이란?
		MultipartFile file = uploadFile.getMpfile();	// 사용자가 업로드한 파일을 가지고 옴
		String name = file.getOriginalFilename(); 		// 사용자가 업로드한 파일의 이름을 가지고옴
		UploadFile fileObj = new UploadFile(); 			// 서버에 넣은 파일정보에 대한 내용의 객체생성
		
		fileObj.setName(name);							// 서버쪽 객체에 업로드한 파일 이름을 넣음
		fileObj.setDesc(uploadFile.getDesc());			// 서버쪽 객체에 내용을 넣음
		
		InputStream inputStream = null;					// 데이터를 가지고 올 객체
		OutputStream outputStream = null;				// 데이터를 내보낼 객체
		
		try {
			inputStream = file.getInputStream();		// 사용자가 업로드한 파일의 내용을 읽어옴 
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");
			// 서버에 넣을 path 를 정함
			System.out.println("업로드 경로 : " + path);
			
			//폴더를을 만듬
			File storage = new File(path);
			if(!storage.exists()) {
				storage.mkdir();
			}
			
			//파일이 없을 경우 파일을 만듬 파일의 이름은 원래 경로임
			File newFile = new File(path+"/"+name);
			if(!newFile.exists()) {
				newFile.createNewFile();
			}
			
			// 서버에 저장된 파일에 write 해줄 부분
			outputStream = new FileOutputStream(newFile);
			
			int read = 0;
			byte[] b = new byte[(int)file.getSize()];
			//읽어온 파일르 바이트 단위로 가지고옴			
			
			// 읽어온 파일이 끝이 될때까지 서버내용부분에 저장
			while((read=inputStream.read(b)) != -1) {
				outputStream.write(b,0,read);
			}			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("fileObj",fileObj);
		return "download";
	}
	@ResponseBody
	@RequestMapping("/download")
	public byte[] fileDownload(HttpServletRequest request, HttpServletResponse response, String name) {
		byte[] down = null;
		try {
			String path = WebUtils.getRealPath(request.getSession().getServletContext(),"/resources/storage");
			File file = new File(path+"/"+name);
			// 서버에 있는 파일
			// 해당파일을 웹브라우저에서 읽어온다.
			down = FileCopyUtils.copyToByteArray(file);
			// 한글형식으로 읽어옴
			String filename= new String(file.getName().getBytes(), "8859_1");
			// setheader를 통해 첨부파일 명시 // 파일이름까지 설정
			response.setHeader("Content-Disposition", "attachment; filename=\""+filename+"\"");
			// 길이만큼 응답한다.
			response.setContentLength(down.length);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return down;
	}

*/