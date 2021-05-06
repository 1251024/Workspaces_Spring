package com.mvc.updown.validate;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


//유효성검사
@Service
public class FileValidator implements Validator {

	@Override	
	// 검증기가 검증할 수 있는 오브젝트 타입인지 확인해주는 메소드
	public boolean supports(Class<?> clazz) { //타입검증
		//supports: validator 사용 가능 여부 확인
		return false;
	}

	@Override
	//supports() 통과한 경우에만 validate가 호출된다.
	public void validate(Object target, Errors errors) { // 입력값검증 
		UploadFile file = (UploadFile) target;
		
		if(file.getMpfile().getSize() == 0) { //파일 안넘어왔을 때
			//mpfile(field)에 대한 errorCode return. 해당 errorCode가 없으면 default message 전달

			errors.rejectValue("mpfile", "fileNPE", "Please select a file");
			//두번째인자 "fileNPE"는 에러코드
			//fileNPE 프로퍼티스파일에 설정해주면 fileNPE가 나오게 설정할 수 있다.
			//세번째인자 "Please select a file"는 디폴트 메세지
			//errors객체에 reject됨 -<form:errors> 랑 연결됨(BindingResult 자동으로 연결)
		}

	}

}

/*
	Validator를 이용한 검증 중에 오류가 발생하면 Errors 인터페이스를 통해서 특정 필드나 모델 오브젝트 전체에 대해 오류정보를 등록할 수 있다. 
	Errors 인터페이스를 통해서 등록된 오류는 최종적으로 BindingResult에 담겨 컨트롤러에 전달된다. 
	검증 결과를 보고 컨트롤러는 그에 맞는 처리를 하고 뷰를 선택한다.

	-BindingResult와 Errors 인터페이스의 주요 메서드
		reject() - 객체에 대한 에러코드 및 메시지, 메시지 인자 전달
		rejectValue() - 필드(객체의 프로퍼티)에 대한 에러정보 추가(에러코드 및 메시지, 메시지 인자 전달)
		
		boolean hasErrors() - 에러 발생 여부 확인
		int getErrorCount() - 에러 갯수 리턴
		boolean hasGlobalErrors()
		int getGlobalErrorCount()
 */
/*
	Validator: xml 문서 읽는 프로세스, 스키마
	주어진 시간에 하나 이상의 스레드에서 하나의 객체가 사용되지 않도록 함
	Validate 메소드가 호출되는동안 재귀적으로 호출할 수 없음
	
	Validate: 지정된 입력의 유효성 검사, 증가된 유효성 검사결과를 지정된 출력으로 보낸다.
	
	
	//validate 메서드에서는 ValidationUtils의 rejectValue 메서드를 사용하여 객체의 title 필드가 비어있거나 
    //공백일 경우에는 errors에 에러 정보를 담는 로직을 구현하였다.
    //"fileNPE"는 에러코드이며 "Please select a file."는 디폴트 메세지다.
*/