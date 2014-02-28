package br.com.cursojsf.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 * Classe que guarda a SKIN seleconada.
 * 
 * @author Fabio Barros
 */
@ManagedBean
@SessionScoped
public class SkinBean {

    private static List<SelectItem> SKINS;

    static {
        SKINS = new ArrayList<SelectItem>();
        SKINS.add(new SelectItem("aristo","aristo"));
        SKINS.add(new SelectItem("black-tie","black-tie"));
        SKINS.add(new SelectItem("blitzer","blitzer"));
        SKINS.add(new SelectItem("bluesky","bluesky"));
        SKINS.add(new SelectItem("casablanca","casablanca"));
        SKINS.add(new SelectItem("cupertino","cupertino"));
        SKINS.add(new SelectItem("dark-hive","dark-hive"));
        SKINS.add(new SelectItem("dot-luv","dot-luv"));
        SKINS.add(new SelectItem("eggplant","eggplant"));
        SKINS.add(new SelectItem("excite-bike","excite-bike"));
        SKINS.add(new SelectItem("flick","flick"));
        SKINS.add(new SelectItem("hot-sneaks","hot-sneaks"));
        SKINS.add(new SelectItem("humanity","humanity"));
        SKINS.add(new SelectItem("le-frog","le-frog"));
        SKINS.add(new SelectItem("midnight","midnight"));
        SKINS.add(new SelectItem("mint-choc","mint-choc"));
        SKINS.add(new SelectItem("overcast","overcast"));
        SKINS.add(new SelectItem("pepper-grinder","pepper-grinder"));
        SKINS.add(new SelectItem("redmond","redmond"));
        SKINS.add(new SelectItem("rocket","rocket"));
        SKINS.add(new SelectItem("smoothness","smoothness"));
        SKINS.add(new SelectItem("south-street","south-street"));
        SKINS.add(new SelectItem("start","start"));
        SKINS.add(new SelectItem("sunny","sunny"));
        SKINS.add(new SelectItem("swanky-purse","swanky-purse"));
        SKINS.add(new SelectItem("trontastic","trontastic"));
        SKINS.add(new SelectItem("ui-darkness","ui-darkness"));
        SKINS.add(new SelectItem("ui-lightness","ui-lightness"));
        SKINS.add(new SelectItem("vader","vader"));
    }

    private String skin ="aristo";

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public List<SelectItem> getSkinsList() {
        return SKINS;
    }
}
