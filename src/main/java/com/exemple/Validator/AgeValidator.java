package com.exemple.Validator;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

import java.util.ResourceBundle;

@FacesValidator("ageValidator")
public class AgeValidator implements Validator {


    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        ResourceBundle messages = ResourceBundle.getBundle("messages");
        int age = (Integer)o;
        if(age<12){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, messages.getString("ageErreur"), null));
        }
    }
}
