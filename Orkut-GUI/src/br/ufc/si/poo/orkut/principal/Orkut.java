package br.ufc.si.poo.orkut.principal;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import br.ufc.si.poo.orkut.beans.comunidade.Comunidade;
import br.ufc.si.poo.orkut.beans.comunidade.ComunidadePrivada;
import br.ufc.si.poo.orkut.beans.comunidade.ComunidadePublica;
import br.ufc.si.poo.orkut.beans.forum.Forum;
import br.ufc.si.poo.orkut.beans.usuario.Usuario;
import br.ufc.si.poo.orkut.beans.usuario.UsuarioComum;
import br.ufc.si.poo.orkut.beans.usuario.UsuarioVip;
import br.ufc.si.poo.orkut.util.Categoria;
import br.ufc.si.poo.orkut.util.Menu;
import br.ufc.si.poo.orkut.util.Opcao;

/**
 * Controle de comunidades e usuarios do orkut
 * 
 * @author italoney
 * 
 */
public class Orkut {

	// TODO alterar o nome
	private static Map<String, Comunidade> comunidades = new HashMap<String, Comunidade>();
	private static Map<String, Forum> usuarios = new HashMap<String, Forum>();
	private static Map<String, Forum> foruns = new HashMap<String, Forum>();

	/**
	 * Metodo principal
	 * 
	 * @param args
	 *            dados inseridos pela linha de comando
	 */
	public static void main(String[] args) {
//		int opcao = 1;
//		// exibi menu com as acoes disponiveis
//		while (opcao != 0) {
//			String op = JOptionPane.showInputDialog(null,
//					"Escolha uma das opcoes: " + "\n0 - Sair"
//							+ "\n1 - Adicionar Usuario"
//							+ "\n2 - Adcionar Comunidade"
//							+ "\n3 - Adicionar usuario em comunidade"
//							+ "\n4 - Exibir comunidade"
//							+ "\n5 - Adicionar Forum"
//							+ "\n6 - Adicionar forum em comunidade"
//							+ "\n7 - Adicionar recado"
//							+ "\n8 - Adcionar mensagem", "Aviso", 1);
//
//			if (op == null) {
//				System.exit(0);
//			} else {
//				try {
//					opcao = Integer.parseInt(op);
//				} catch (NumberFormatException e) {
//					opcao = -1;
//				}
//			}
//
//			// faz o teste para saber qual opcao foi selecionada
//			switch (opcao) {
//			case Menu.SAIR:
//				break;
//
//			case Menu.ADCIONAR_USUARIO:
//				adicionarUsuario();
//				break;
//
//			case Menu.ADCIONAR_COMUNIDADE:
//				adicionarComunidade();
//				break;
//
//			case Menu.ADCIONAR_USUARIO_COMUNIDADE:
//				adicionarUsuarioComunidade();
//				break;
//
//			case Menu.EXIBIR_COMUNIDADE:
//				exibirComunidade();
//
//				break;
//			case Menu.ADCIONAR_FORUM:
//				adicionarForum();
//				break;
//
//			case Menu.ADCIONAR_FORUM_COMUNIDADE:
//				adicionarForumComunidade();
//				break;
//
//			case Menu.ADCIONAR_MENSAGEM:
//				adicionarMensagem();
//				break;
//
//			case Menu.ADCIONAR_RECADO:
//				adicionarRecado();
//				break;
//
//			default: {
//				JOptionPane.showMessageDialog(null, "Operacao invalida",
//						"Aviso", 1);
//			}
//			}
//		}
	}

	/**
	 * Adicionar novo usuario
	 */
//	private static void adicionarUsuario() {
//		int opcao = 0;
//		String op = JOptionPane.showInputDialog(null,
//				"Escolha o tipo de usuario: " + "\n1 - Usuario Comum"
//						+ "\n2 - usuário VIP", "Aviso", 1);
//
//		if (op == null) {
//			System.exit(0);
//		} else {
//			try {
//				opcao = Integer.parseInt(op);
//			} catch (NumberFormatException e) {
//				opcao = -1;
//			}
//		}
//
//		// define o tipo de usuario
//		switch (opcao) {
//
//		case Opcao.USUARIOCOMUM:// usuario comum
//			int idade = 0;
//			Forum userC = new UsuarioComum();
//			String nome = JOptionPane
//					.showInputDialog("Digite o nome do usuário");
//
//			String aux = JOptionPane
//					.showInputDialog("Digite a idade do usuário");
//
//			if (!aux.isEmpty()) {
//
//				try {
//					idade = Integer.parseInt(aux);
//				} catch (NumberFormatException e) {
//					// TODO remover idade depois
//					JOptionPane.showMessageDialog(null,
//							"Valor inválido para idade",
//							"Erro: " + e.getMessage(), idade);
//				}
//			} else {
//				JOptionPane.showMessageDialog(null, "Vocẽ não digitou a idade",
//						"Erro", JOptionPane.ERROR_MESSAGE);
//			}
//
//			userC.setIdade(idade);
//			userC.setNome(nome);
//			usuarios.put(userC.getNome(), userC);
//			break;
//
//		case Opcao.USUARIOVIP:// usuario vip
//			int idade2 = 0;
//			Forum userV = new UsuarioVip();
//			String nome2 = JOptionPane
//					.showInputDialog("Digite o nome do usuário");
//
//			String aux2 = JOptionPane
//					.showInputDialog("Digite a idade do usuário");
//
//			if (!aux2.isEmpty()) {
//
//				try {
//					idade = Integer.parseInt(aux2);
//				} catch (NumberFormatException e) {
//					// TODO remover idade deṕois
//					JOptionPane.showMessageDialog(null,
//							"Valor inválido para idade",
//							"Erro: " + e.getMessage(), idade2);
//				}
//			} else {
//				JOptionPane.showMessageDialog(null, "Vocẽ não digitou a idade",
//						"Erro", JOptionPane.ERROR_MESSAGE);
//			}
//
//			userV.setIdade(idade2);
//			userV.setNome(nome2);
//			usuarios.put(userV.getNome(), userV);
//			break;
//
//		default:
//			break;
//		}
//
//	}
//
//	/**
//	 * Adicionar nova comunidade
//	 */
//	private static void adicionarComunidade() {
//		int opcao = 0;
//		String op = JOptionPane.showInputDialog(null,
//				"Escolha o tipo de comunidade: " + "\n1 - Comunidade Publica"
//						+ "\n2 - Comuniadade Privada", "Aviso", 1);
//
//		if (op == null) {
//			System.exit(0);
//		} else {
//			try {
//				opcao = Integer.parseInt(op);
//			} catch (NumberFormatException e) {
//				opcao = -1;
//			}
//		}
//
//		// definie o tipo de comunidade
//		switch (opcao) {
//		case Opcao.COMUNIDADEPRIVADA:// comunidade privada
//
//			// instancia da Class Comunidade
//			Comunidade comunidadeP = new ComunidadePrivada();
//
//			int categoria = 0;
//
//			// obtem os dados da nova comunidade
//			String titulo = JOptionPane.showInputDialog(null, "Titulo:",
//					"Dados da Comunidade", 1);
//			try {
//				categoria = Integer
//						.parseInt(JOptionPane
//								.showInputDialog(
//										null,
//										"Categoria:\n0 - Sem Categoria\n1 - Esporte\n2 - Educacao",
//										"Dados da Comunidade", 1));
//			} catch (Exception e) {
//			}
//
//			// exibe categoria selecionada
//			if (categoria == Categoria.COD_CATEGORIA_EDUCACAO) {
//				JOptionPane.showMessageDialog(null,
//						Categoria.DESC_CATEGORIA_EDUCACAO);
//			} else if (categoria == Categoria.COD_CATEGORIA_ESPORTE) {
//				JOptionPane.showMessageDialog(null,
//						Categoria.DESC_CATEGORIA_ESPORTE);
//			} else if (categoria == Categoria.COD_SEM_CATEGORIA) {
//				JOptionPane.showMessageDialog(null,
//						Categoria.DESC_SEM_CATEGORIA);
//			}
//
//			comunidadeP.setCategoria(categoria);
//			comunidadeP.setTitulo(titulo);
//
//			comunidades.put(comunidadeP.getTitulo(), comunidadeP);
//
//			break;
//
//		case Opcao.COMUNIDADEPUBLICA: // comunidade publica
//
//			// instancia da Class Comunidade
//			Comunidade comunidadePu = new ComunidadePrivada();
//
//			int categoria2 = 0;
//
//			// obtem os dados da nova comunidade
//			String titulo2 = JOptionPane.showInputDialog(null, "Titulo:",
//					"Dados da Comunidade", 1);
//			try {
//				categoria = Integer
//						.parseInt(JOptionPane
//								.showInputDialog(
//										null,
//										"Categoria:\n0 - Sem Categoria\n1 - Esporte\n2 - Educacao",
//										"Dados da Comunidade", 1));
//			} catch (Exception e) {
//			}
//
//			// exibe categoria selecionada
//			if (categoria2 == Categoria.COD_CATEGORIA_EDUCACAO) {
//				JOptionPane.showMessageDialog(null,
//						Categoria.DESC_CATEGORIA_EDUCACAO);
//			} else if (categoria2 == Categoria.COD_CATEGORIA_ESPORTE) {
//				JOptionPane.showMessageDialog(null,
//						Categoria.DESC_CATEGORIA_ESPORTE);
//			} else if (categoria2 == Categoria.COD_SEM_CATEGORIA) {
//				JOptionPane.showMessageDialog(null,
//						Categoria.DESC_SEM_CATEGORIA);
//			}
//
//			comunidadePu.setCategoria(categoria2);
//			comunidadePu.setTitulo(titulo2);
//
//			comunidades.put(comunidadePu.getTitulo(), comunidadePu);
//			break;
//		default:
//			break;
//		}
//	}
//
//	/**
//	 * Adicionar usuario a uma determinada comunidade
//	 * 
//	 * @author italoney
//	 */
//	private static void adicionarUsuarioComunidade() {
//		String usuario = JOptionPane.showInputDialog(null,
//				"Digite o nome do usuario ", "Aviso", 1);
//
//		while (usuario.isEmpty()) {
//			usuario = JOptionPane.showInputDialog(null,
//					"Digite o nome do usuario ", "Aviso", 1);
//		}
//
//		if (usuarios.containsKey(usuario)) {
//			Forum user = usuarios.get(usuario);
//
//			String comunidade = JOptionPane.showInputDialog(null,
//					"Digite o titulo da comunidade ", "Aviso", 1);
//
//			while (comunidade.isEmpty()) {
//				usuario = JOptionPane.showInputDialog(null,
//						"Digite o titulo da comunidade ", "Aviso", 1);
//			}
//
//			if (comunidades.containsKey(comunidade)) {
//				Comunidade c = comunidades.get(comunidade);
//				c.adicionarUsuario(user);
//
//				JOptionPane.showMessageDialog(null,
//						"Usuario: " + usuario + " adicionado a comunidade "
//								+ comunidade.toUpperCase(), "Sucesso",
//						JOptionPane.INFORMATION_MESSAGE);
//			} else {
//				JOptionPane.showMessageDialog(null, "Comunidade: " + comunidade
//						+ " não existe", "Erro", JOptionPane.ERROR_MESSAGE);
//				return;
//			}
//		} else {
//			JOptionPane.showMessageDialog(null, "usuário: " + usuario
//					+ " não existe", "Erro", JOptionPane.ERROR_MESSAGE);
//			return;
//		}
//
//	}
//
//	/**
//	 * Exibir comunidade atual
//	 */
//	private static void exibirComunidade() {
//		String titulo = JOptionPane.showInputDialog(null,
//				"Digite o titulo da comunidade que deseja exibir!");
//
//		if (comunidades.containsKey(titulo)) {
//			Comunidade comunidade = comunidades.get(titulo);
//			if (comunidade instanceof ComunidadePrivada) {
//				((ComunidadePrivada) comunidade).exibir();
//			}
//
//			if (comunidade instanceof ComunidadePublica) {
//				((ComunidadePrivada) comunidade).exibir();
//			}
//
//		} else {
//			JOptionPane.showMessageDialog(null, "Essa comunidade não existe",
//					"Erro ao exibir comunidade", JOptionPane.ERROR_MESSAGE);
//		}
//	}
//
//	/**
//	 * Adicionar um novo forum
//	 * 
//	 * @author italoney
//	 */
//	private static void adicionarForum() {
//		String titulo = JOptionPane.showInputDialog("Digite o titulo do forum");
//
//		if (!foruns.containsKey(titulo)) {
//			Forum forum = new Forum();
//			forum.setTitulo(titulo);
//			foruns.put(forum.getTitulo(), forum);
//			JOptionPane.showMessageDialog(null, "Novo forum adicionado");
//			return;
//		} else {
//			JOptionPane.showMessageDialog(null,
//					"Já existe um forum com esse titulo");
//			adicionarForum();
//		}
//
//	}
//
//	/**
//	 * Adicionar uma nova mensagem a um forum
//	 * 
//	 * @author italoney
//	 */
//	private static void adicionarMensagem() {
//		String mensagem = JOptionPane.showInputDialog("Digite a mensagem");
//		String titulo = JOptionPane.showInputDialog("Digite o titulo do forum");
//
//		if (foruns.containsKey(titulo)) {
//			Forum forum = foruns.get(titulo);
//			forum.adicionarMensagem(mensagem);
//		} else {
//			JOptionPane.showMessageDialog(null, "O forum: " + titulo
//					+ " não existe", "Erro", JOptionPane.ERROR_MESSAGE);
//		}
//	}
//
//	/**
//	 * Adicionar um recao a um usuario VIP
//	 */
//	private static void adicionarRecado() {
//		String recado = JOptionPane.showInputDialog("Digite o recado");
//		String nome = JOptionPane.showInputDialog("Digite o nome do usuario");
//
//		if (usuarios.containsKey(nome)) {
//			Forum usuario = usuarios.get(nome);
//			if (usuario instanceof UsuarioVip) {
//				((UsuarioVip) usuario).adicionarRecado(recado);
//			} else {
//				JOptionPane.showMessageDialog(null,
//						"Este  usuario nao pode receber recados", "Erro",
//						JOptionPane.ERROR_MESSAGE);
//			}
//		} else {
//			JOptionPane.showMessageDialog(null, "O usuario: " + nome
//					+ " não existe", "Erro", JOptionPane.ERROR_MESSAGE);
//		}
//	}
//
//	/**
//	 * Adicionar forum a uma comunidade
//	 * 
//	 * @author italoney
//	 */
//	private static void adicionarForumComunidade() {
//		String tituloForum = JOptionPane
//				.showInputDialog(null,
//						"Digite o titulo do forum que deseja adiconar a uma comunidade!");
//
//		if (foruns.containsKey(tituloForum)) {
//			Forum forum = foruns.get(tituloForum);
//
//			String tituloComunidade = JOptionPane.showInputDialog(null,
//					"Digite o titulo da comunidade");
//
//			if (comunidades.containsKey(tituloComunidade)) {
//				Comunidade com = comunidades.get(tituloComunidade);
//
//				if (com instanceof ComunidadePrivada) {
//					((ComunidadePrivada) com).adicionarForum(forum);
//				}
//
//				if (com instanceof ComunidadePublica) {
//					((ComunidadePrivada) com).adicionarForum(forum);
//				}
//
//				JOptionPane.showMessageDialog(null,
//						"Forum adicionado com sucesso", "Sucesso.",
//						JOptionPane.INFORMATION_MESSAGE);
//
//			} else {
//				JOptionPane.showMessageDialog(null, "Esse forum não existe",
//						"Erro ao selecionar foeum", JOptionPane.ERROR_MESSAGE);
//			}
//
//		} else {
//			JOptionPane.showMessageDialog(null, "Esse forum não existe",
//					"Erro ao selecionar foeum", JOptionPane.ERROR_MESSAGE);
//
//		}
//
//	}
}
