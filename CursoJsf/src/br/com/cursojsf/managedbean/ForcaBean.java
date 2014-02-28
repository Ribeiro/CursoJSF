package br.com.cursojsf.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "forcaBean")
public class ForcaBean {
	
	private static final String [] words = {"agua", "terra", "fogo", "ar", "gato", "cachorro", "cidade", "estado", "samba", "carnaval"};
	
	private String getAleatoryWord(){
		return words[(int) (Math.floor(Math.random()* 10))];
	}
	
    @ManagedProperty("0")
    private Integer tentativas;
    
    public Integer getTentativas() {
        return tentativas;
    }

    public void setTentativas(Integer tentativas) {
        this.tentativas = tentativas;
    }
    
    public String init() {
        /*numero = (int) (1 + (Math.random() * 100));
        palpite = null;*/
        tentativas = 0;
/*        mensagem = "page.guess.label.branco";
        if (palpiteInput != null) {
            palpiteInput.setRendered(true);
        }*/
        System.out.println(getAleatoryWord());
        return "forca";
    }

}
