package com.exemple.Validator;


import com.exemple.DAO.StudentDAO;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

import java.util.ResourceBundle;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator {
    public StudentDAO studentDAO= new StudentDAO();
    ResourceBundle messages = ResourceBundle.getBundle("messages");
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        String email = o.toString();
        if (!email.contains("@")) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, messages.getString("emailerreur"), null));
        }
        if(studentDAO.emailExisteDeja(email)){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, messages.getString("msgExistDeja"), null));
        }

    }
}
