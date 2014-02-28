package br.com.cursojsf.managedbean;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.Cookie;

import br.com.cursojsf.util.CookiesHelper;
import br.com.cursojsf.util.MessageHelper;

@ManagedBean
@RequestScoped
public class LocaleBean {
    private static final List<SelectItem> LOCALES;
    static {
        LOCALES = new ArrayList<SelectItem>(2);
        LOCALES.add(new SelectItem("pt_BR", MessageHelper
                .getMessage("bean.localeBean.localePtBr")));
        LOCALES.add(new SelectItem("en", MessageHelper
                .getMessage("bean.localeBean.localeEn")));
    }
    private String locale;

    public String getLocale() {
        if (locale == null) {
            Cookie cookie = CookiesHelper.getCookie("cursojsf.locale");
            if (cookie != null) {
                return cookie.getValue();
            } else {
                return "pt_BR";
            }
        }
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public List<SelectItem> getLocaleList() {
        return LOCALES;
    }

    public void changeLocale(ValueChangeEvent event) {
        locale = event.getNewValue().toString();
        FacesContext context = FacesContext.getCurrentInstance();
        context.getViewRoot().setLocale(new Locale(locale));
        CookiesHelper.addCookie("cursojsf.locale", locale, Integer.MAX_VALUE);
    }
}