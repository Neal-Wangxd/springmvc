package com.springmvc.util.validator;

import java.util.Date;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.springmvc.util.date.DateUtil;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年4月27日 下午2:30:25 
* 类说明 
*/
public class DateFormatValidator implements ConstraintValidator<DateFormat, Date>{
	
	private String dateReg = "((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s((([0-1][0-9])|(2?[0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))";
    private Pattern datePattern = Pattern.compile(dateReg);
    
    @Override
    public void initialize(DateFormat dateFormat) {
    	
    }

	@Override
	public boolean isValid(Date value, ConstraintValidatorContext arg1) {
		if (value == null){
	        return false;
		}else{
			return datePattern.matcher(DateUtil.DateFormat(value,"yyyy-MM-dd HH:mm:ss")).matches();
		}
	}
}
 