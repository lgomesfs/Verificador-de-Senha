package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import business.ValidadorSenhaPersonalizada;

public class Formulario {

	private JFrame form;
	private JLabel lblTamanho, lblMaiuscula, lblMinuscula, lblNumeros, lblCaracterEspecial, lblSenha, lblValida,
			lblNome;
	private JTextField txtTamanho, txtMaiuscula, txtMinuscula, txtNumeros, txtCaracterEspecial, txtSenha;
	private JButton btnValidar;

	public Formulario() {
		inicializarComponentes();
	}

	private void inicializarComponentes() {
		form = new JFrame("Validador de senha");
		form.setBounds(500, 250, 270, 310);
		form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		form.setLayout(null);
		Container painel = form.getContentPane();

		lblTamanho = new JLabel("Número min de char da senha:");
		lblTamanho.setBounds(10, 10, 185, 25);
		painel.add(lblTamanho);

		txtTamanho = new JTextField();
		txtTamanho.setBounds(200, 10, 50, 25);
		painel.add(txtTamanho);
		txtTamanho.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				validarCampoNumerico(e);

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				limparResultado();

			}
		});

		lblMaiuscula = new JLabel("Possui letras maiúsculas (S/N):");
		lblMaiuscula.setBounds(10, 40, 185, 25);
		painel.add(lblMaiuscula);

		txtMaiuscula = new JTextField();
		txtMaiuscula.setBounds(200, 40, 50, 25);
		painel.add(txtMaiuscula);
		txtMaiuscula.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				validarCampoBoolean(e);
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				limparResultado();

			}
		});

		lblMinuscula = new JLabel("Possui letras minusculas (S/N):");
		lblMinuscula.setBounds(10, 70, 185, 25);
		painel.add(lblMinuscula);

		txtMinuscula = new JTextField();
		txtMinuscula.setBounds(200, 70, 50, 25);
		painel.add(txtMinuscula);
		txtMinuscula.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				validarCampoBoolean(e);

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				limparResultado();

			}
		});

		lblNumeros = new JLabel("Possui números (S/N):");
		lblNumeros.setBounds(10, 100, 185, 25);
		painel.add(lblNumeros);

		txtNumeros = new JTextField();
		txtNumeros.setBounds(200, 100, 50, 25);
		painel.add(txtNumeros);
		txtNumeros.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				validarCampoBoolean(e);

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				limparResultado();

			}
		});

		lblCaracterEspecial = new JLabel("Possui caracter especial (S/N):");
		lblCaracterEspecial.setBounds(10, 130, 185, 25);
		painel.add(lblCaracterEspecial);

		txtCaracterEspecial = new JTextField();
		txtCaracterEspecial.setBounds(200, 130, 50, 25);
		painel.add(txtCaracterEspecial);
		txtCaracterEspecial.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				validarCampoBoolean(e);

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				limparResultado();

			}
		});

		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 160, 40, 25);
		painel.add(lblSenha);

		txtSenha = new JTextField();
		txtSenha.setBounds(55, 160, 195, 25);
		painel.add(txtSenha);
		txtSenha.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				limparResultado();

			}
		});

		btnValidar = new JButton("Validar senha");
		btnValidar.setBounds(10, 190, 240, 25);
		btnValidar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (validarPreenchimentoObrigatorio()) {
					int tamanhoSenha;
					boolean maiuscula, minuscula, numeros, caracterEspecial;
					tamanhoSenha = numeroInt(txtTamanho.getText());
					maiuscula = stringToBoolean(txtMaiuscula.getText());
					minuscula = stringToBoolean(txtMinuscula.getText());
					numeros = stringToBoolean(txtNumeros.getText());
					caracterEspecial = stringToBoolean(txtCaracterEspecial.getText());
					ValidadorSenhaPersonalizada valid = new ValidadorSenhaPersonalizada(tamanhoSenha, maiuscula,
							minuscula, numeros, caracterEspecial);
					validarSenha(valid);
				} else {
					msgCampoObrigatorio();
				}
			}
		});
		painel.add(btnValidar);

		lblValida = new JLabel("Resultado:");
		lblValida.setBounds(10, 215, 200, 25);
		painel.add(lblValida);

		lblNome = new JLabel("Leonardo Gomes");
		lblNome.setBounds(10, 245, 150, 25);
		painel.add(lblNome);

		form.setVisible(true);

	}

	private int numeroInt(String num) {
		return Integer.parseInt(num);
	}

	private boolean stringToBoolean(String a) {
		if (a.charAt(0) == 's' || a.charAt(0) == 'S') {
			return true;
		} else {
			return false;
		}
	}

	private void validarSenha(ValidadorSenhaPersonalizada valid) {
		boolean validar = valid.validarSenha(txtSenha.getText());
		if (validar == true) {
			lblValida.setText("Resultado: senha válida");
		} else {
			lblValida.setText("Resultado: senha inválida");
		}
	}

	private void limparResultado() {
		lblValida.setText("Resultado:");
	}

	private boolean validarPreenchimentoObrigatorio() {
		return !(txtTamanho.getText().isEmpty() || txtMaiuscula.getText().isEmpty() || txtMinuscula.getText().isEmpty()
				|| txtNumeros.getText().isEmpty() || txtCaracterEspecial.getText().isEmpty());
	}

	private void msgCampoObrigatorio() {
		JOptionPane.showMessageDialog(form, "Valores não preenchidos", "Preenchimento inválido",
				JOptionPane.WARNING_MESSAGE);
	}
	
	private void validarCampoNumerico(KeyEvent e) {
		char caracter = e.getKeyChar();
		if(!(Character.isDigit(caracter)) ||
		(caracter==KeyEvent.VK_BACK_SPACE) ||
		(caracter==KeyEvent.VK_DELETE)){
			e.consume();
		}
	}
	
	private void validarCampoBoolean(KeyEvent e) {
		char caracter = e.getKeyChar();
		caracter = Character.toLowerCase(caracter);
		
		boolean charValido = (caracter=='s' || caracter=='n');
		if(!(charValido) ||
				(caracter==KeyEvent.SHIFT_DOWN_MASK) ||
				(caracter==KeyEvent.VK_BACK_SPACE) ||
				(caracter==KeyEvent.VK_DELETE)) {
			e.consume();
		}
	}
}
