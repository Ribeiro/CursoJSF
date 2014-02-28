package br.com.cursojsf.listeners;

import java.util.Locale;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.Cookie;

import br.com.cursojsf.util.CookiesHelper;

public class LocalePhaseListener implements PhaseListener {

    private static final long serialVersionUID = -885702509958179279L;

    public void afterPhase(PhaseEvent event) {
        Cookie cookie = CookiesHelper.getCookie("cursojsf.locale");
        if (cookie != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getViewRoot().setLocale(new Locale(cookie.getValue()));
        }
    }

    public void beforePhase(PhaseEvent event) {
        // NOP
    }

    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}