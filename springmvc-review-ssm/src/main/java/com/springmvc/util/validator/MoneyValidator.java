package com.springmvc.util.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/** 
* @author 作者 wxd  
* @version 1.0
* E-mail: wangxudong@jetsen.cn
* 创建时间：2018年4月27日 下午2:30:25 
* 类说明 
*/
public class MoneyValidator implements ConstraintValidator<Money, Double>{
	
	private String moneyReg = "^\\d+(\\.\\d{1,2})?$";//表示金额的正则表达式
    private Pattern moneyPattern = Pattern.compile(moneyReg);

    public void initialize(Money money) {

    }

    public boolean isValid(Double value, ConstraintValidatorContext arg1) {
       if (value == null)
           return true;
       return moneyPattern.matcher(value.toString()).matches();
    }

}
 