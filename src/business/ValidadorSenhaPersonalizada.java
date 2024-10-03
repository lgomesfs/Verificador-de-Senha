package business;

public class ValidadorSenhaPersonalizada implements IValidadorSenha {

	private int tamanhoSenha;
	private boolean maiuscula;
	private boolean minuscula;
	private boolean numeros;
	private boolean charEspecial;

	public ValidadorSenhaPersonalizada(int tamanhoSenha, boolean maiuscula, boolean minuscula, boolean numeros,
			boolean charEspecial) {
		this.tamanhoSenha = tamanhoSenha;
		this.maiuscula = maiuscula;
		this.minuscula = minuscula;
		this.numeros = numeros;
		this.charEspecial = charEspecial;
	}

	@Override
	public boolean validarSenha(String senha) {
		boolean vTamanho = (senha.length() >= tamanhoSenha);
		boolean temMaiuscula = false, temMinuscula = false, temNumeros = false, temCharEspecial = false;
		for (int i = 0; i < senha.length(); i++) {
			if (senha.charAt(i) >= 'a' && senha.charAt(i) <= 'z') {
				temMinuscula = true;
			} else if (senha.charAt(i) >= 'A' && senha.charAt(i) <= 'Z') {
				temMaiuscula = true;
			} else if (senha.charAt(i) >= '0' && senha.charAt(i) <= '9') {
				temNumeros = true;
			} else {
				temCharEspecial = true;
			}
		}
		
		boolean vMaiuscula,vMinuscula,vNumeros,vCharEspecial;
		
		vMaiuscula = (maiuscula==false || temMaiuscula==maiuscula);
		vMinuscula = (minuscula==false || temMinuscula==minuscula);
		vNumeros= (numeros==false || temNumeros==numeros);
		vCharEspecial = (charEspecial==false || temCharEspecial==charEspecial);
		
		if (vTamanho && vMinuscula && vMaiuscula && vNumeros && vCharEspecial) {
			return true;
		} else {
			return false;
		}
	}

}
