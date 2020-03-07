package classes.desafio;

public class Jantar {
	
	public static void main(String[] args) {
	
		Comida c1 = new Comida("arroz", 0.3);
		Comida c2 = new Comida("feijão", 0.1);
		
		Pessoa p = new Pessoa("João", 50.0);
		
		System.out.println(p.nome + " pesava " + p.peso + " quilos.");
			
		p.comer(c1);
		p.comer(c2);
		
		System.out.printf("Após comer %s e %s, %s passou a pesar %.2f quilos.\n", c1.nome, c2.nome, p.nome, p.peso);
	}
}
