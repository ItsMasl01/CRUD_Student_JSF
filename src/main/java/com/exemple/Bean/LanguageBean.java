package com.exemple.Bean;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.context.FacesContext;

import java.util.Locale;

@SessionScoped
@ManagedBean
public class LanguageBean {

    private Locale locale;
    private String selectedLocale;


    @PostConstruct
    public void init() {
        FacesContext.getCurrentInstance().getViewRoot().getLocale();
    }

    public Locale getLocale() {
        return locale;
    }
    public void setLocale(Locale locale) {
        this.locale = locale;
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }


    public String getSelectedLocale() {
        return selectedLocale;
    }

    public void setSelectedLocale(String selectedLocale) {
        this.selectedLocale = selectedLocale;
    }


    public void changeLocale() {
        if (selectedLocale.equals("en")) {
            setLocale(Locale.ENGLISH);
        } else if (selectedLocale.equals("fr")) {
            setLocale(Locale.FRENCH);
        }

    }
}
