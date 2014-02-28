package br.com.cursojsf.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "forcaBean")
public class ForcaBean {
	
	private String updatedWord;
	
	private static final String [] words = {"agua", "terra", "fogo", "ar", "gato", "cachorro", "cidade", "estado", "samba", "carnaval"};
	
	private String generateAleatoryWord(){
		return words[(int) (Math.floor(Math.random()* 10))];
	}
	
	private String aleatoryWord;
	
	private String typedWord;
	
    @ManagedProperty("0")
    private Integer numberOfTries;
    
    private Integer remainingTries = 6;
    
    public Integer getRemainingTries() {
		return remainingTries;
	}
    
    private String mensagem;
    
    public String init() {
    	this.typedWord = "";
    	this.updatedWord = "";
        numberOfTries = 0;
        remainingTries = 6;
        mensagem = "";
        this.aleatoryWord = generateAleatoryWord();
        return "forca";
    }
    
    public void updateWord(){
    	if (this.typedWord != null && !this.typedWord.isEmpty()) {

    		if (numberOfTries <= remainingTries) {
        		numberOfTries++;
        		remainingTries--;
    			char[] aleatoryWordCopy = this.aleatoryWord.substring(0).toCharArray();
    			for (int i = 0; i < aleatoryWordCopy.length; i++) {
    				if (!this.typedWord.contains(String.valueOf(aleatoryWordCopy[i]))) {
    					aleatoryWordCopy[i] = '_';
    					
    					
    				}
    			}
    			
    			this.updatedWord = String.valueOf(aleatoryWordCopy);
    			
    			if (this.updatedWord.equals(this.aleatoryWord)) {
    				this.mensagem = "Você acertou!";
    			}else {
    				this.mensagem = "Você errou. Tente novamente!";
    			}
    			
    		}else {
    			this.remainingTries = 0;
    			this.mensagem = "Fim de jogo. Você perdeu!";
    			
    		}
			
		}
    	
    }

	public String getUpdatedWord() {
		return updatedWord;
	}

	public void setUpdatedWord(String updatedWord) {
		this.updatedWord = updatedWord;
	}

	public String getAleatoryWord() {
		return aleatoryWord;
	}

	public void setAleatoryWord(String aleatoryWord) {
		this.aleatoryWord = aleatoryWord;
	}

	public String getTypedWord() {
		return typedWord;
	}

	public void setTypedWord(String typedWord) {
		this.typedWord = typedWord;
	}

	public Integer getNumberOfTries() {
		return numberOfTries;
	}

	public void setNumberOfTries(Integer numberOfTries) {
		this.numberOfTries = numberOfTries;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}