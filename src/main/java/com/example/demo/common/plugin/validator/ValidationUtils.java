package com.example.demo.common.plugin.validator;

import com.example.demo.response.CustomException;
import com.example.demo.response.ResponseCode;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.MessageSourceResourceBundleLocator;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class ValidationUtils {

    private static Validator validator;

    static {
        validator = Validation.byDefaultProvider().configure().messageInterpolator(
                new ResourceBundleMessageInterpolator(new MessageSourceResourceBundleLocator(getMessageSource())))
                .buildValidatorFactory().getValidator();
    }

    private static ResourceBundleMessageSource getMessageSource(){
        ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
        bundleMessageSource.setDefaultEncoding("UTF-8");
        bundleMessageSource.setBasenames("i18n/validation");
        return bundleMessageSource;
    }

    /**
     * 校验对象
     * @param object 待校验对象
     * @param groups 待校验的组
     * @throws CustomException
     */
    public static void validateEntity(Object object,Class<?>...groups)
            throws CustomException{
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object,groups);
        if(!constraintViolations.isEmpty()){
            ConstraintViolation<Object> constraint = constraintViolations.iterator().next();
            throw new CustomException(ResponseCode.ILLEGAL_REQUEST.getErrorCode(),constraint.getMessage());
        }
    }
}
