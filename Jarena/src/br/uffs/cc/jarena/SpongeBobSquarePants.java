package br.uffs.cc.jarena;
//Patrícia Trevisan
public class SpongeBobSquarePants extends Agente{

    
    int contadorAnda;
    public SpongeBobSquarePants(Integer x, Integer y, Integer energia) {
        super(x, y, energia);
        setDirecao(geraDirecaoAleatoria());
    
        contadorAnda = 0;
    }

    public void pensa(){
        contadorAnda ++;
    

        if(!podeMoverPara(getDirecao())) {
			setDirecao(geraDirecaoAleatoria());
        }

        
        if(contadorAnda >=40){
            setDirecao(geraDirecaoAleatoria());
            contadorAnda = 0;
        }
      
    

    }
    public void recebeuEnergia() {
        para();
        System.out.println(getId() + "Achei um cogumelo aqui, x= " + getX() + " y = " + getY() );
        enviaMensagem("cogumelo");
	}
	
	public void tomouDano(int energiaRestanteInimigo) {
        setDirecao(geraDirecaoAleatoria());
        System.out.println(getId() + " inimigo aqui, x= " + getX() + " y = " + getY() + ", CORRE! , ini = " + energiaRestanteInimigo);
        enviaMensagem("foge");
	}
    
    
	public void ganhouCombate() {
		
	}
	
	public void recebeuMensagem(String msg) {
		if(msg.equals("foge")){
            setDirecao(geraDirecaoAleatoria());
        }
        if(msg.equals("cogumelo")){
            para();
        }
	}

    public String getEquipe() {
		return "SpongeBobSquarePants";
	}
}
