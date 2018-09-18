import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ViewCadastro {
	private Scanner input;

	public ViewCadastro() {
		input = new Scanner(System.in);

	}

	public String mostraMenu() {
		System.out.println("Cadastro de Produtos");
		System.out.println("-------------------------");
		System.out.println("1 - Inserir");
		System.out.println("2 - Listar");
		System.out.println("3 - Alterar");
		System.out.println("4 - Excluir");
		System.out.println("5 - Pesquisar");
		System.out.println("6 - Sair");
		System.out.println("7 - Excluir Logicamente");
		System.out.println("8 - Produtos Ativos");
		System.out.println("Opção: ");
		return input.nextLine();
	}

	public Produtos inserir(ArrayList<Produtos> listaProdutos) {

		Produtos Produtos = new Produtos();

		System.out.println("Nome Do produto: ");
		Produtos.setNome(input.nextLine());

		System.out.println("Setor: ");
		Produtos.setSetor(input.nextLine());

		System.out.println("Cor: ");
		Produtos.setCor(input.nextLine());

		System.out.println("Marca: ");
		Produtos.setMarca(input.nextLine());
		
		System.out.println("Preco: ");
		Produtos.setPreco(Double.parseDouble(input.nextLine()));

		listaProdutos.add(Produtos);

		return Produtos;
	}

	public void listar(ArrayList<Produtos> listaProdutos) {
		for (int i = 0; i < listaProdutos.size(); i++) {
			System.out.println(listaProdutos.get(i).toString() + "Posição: " + i);
			System.out.println("\n");
		}
	}

	public void alterar(ArrayList<Produtos> listaProdutos) {
		listar(listaProdutos);
		boolean continuar = true;
		int i = 0;
		do {
			System.out.println("Digite a posição do registro para alterar: ");
			try {
				i = Integer.parseInt(input.nextLine());
				if (i >= 0 & i < listaProdutos.size()) {
					continuar = false;
				} else {
					System.out.println("Digite um valor válido!)");
				}
			} catch (Exception e) {
				System.out.println("Valor digitado inválido!!!");
			}
		} while (continuar);

		System.out.println("Nome do Produto (" + listaProdutos.get(i).getNome() + "): ");
		listaProdutos.get(i).setNome(input.nextLine());

		System.out.println("Setor (" + listaProdutos.get(i).getSetor() + "): ");
		listaProdutos.get(i).setSetor(input.nextLine());

		System.out.println("Cor (" + listaProdutos.get(i).getCor() + "): ");
		listaProdutos.get(i).setCor(input.nextLine());

		System.out.println("Marca (" + listaProdutos.get(i).getMarca() + "): ");
		listaProdutos.get(i).setMarca(input.nextLine());
		
		System.out.println("Preço (" + listaProdutos.get(i).getPreco() + "): ");
		listaProdutos.get(i).setPreco(Double.parseDouble(input.nextLine()));

	}

	public void excluir(ArrayList<Produtos> listaProdutos) {
		listar(listaProdutos);
		int i = 0;
		System.out.println("Digite a posição do registro para deletar");
		i = Integer.parseInt(input.nextLine());
		listaProdutos.remove(i);
	}

	public void pesquisar(ArrayList<Produtos> listaProdutos) {
		boolean flag = true;
		Produtos Produtos = new Produtos();
		System.out.println("Digite o nome do produto que deseja pesquisar: ");
		Produtos.setNome(input.nextLine());

		for (int i = 0; i < listaProdutos.size(); i++) {
			if (listaProdutos.get(i).getNome().equals(Produtos.getNome()) == true) {
				System.out.println("Nome do Produto: " + listaProdutos.get(i).getNome());
				System.out.println("Setor: " + listaProdutos.get(i).getSetor());
				System.out.println("Cor: " + listaProdutos.get(i).getCor());
				System.out.println("Marca: " + listaProdutos.get(i).getMarca());
				System.out.println("Preço: " + listaProdutos.get(i).getPreco());
				flag = false;
			}
		}

		if (flag == true) {
			System.out.println("Não encontrado.");
		}
	}

	public void ordernarPorNome(List<Produtos> listaProdutos){
		Collections.sort(listaProdutos, new Comparator<Produtos>() {
			@Override
			public int compare(Produtos p1, Produtos p2) {
				return p1.getNome().compareTo(p2.getNome());
			}
		});
	}
	
	public void exclusaoLogica(Produtos produto) {		
		produto.setAtivo(false);
	}	
	
	public List<Produtos> listaProdutosAtivos(List<Produtos> listaProdutos){
		List<Produtos> produtosAtivos = new ArrayList<Produtos>();
		listaProdutos.forEach(produto -> {
			if(produto.isAtivo()) {
				produtosAtivos.add(produto);
			}
		});
		for (int i = 0; i < produtosAtivos.size(); i++) {
			System.out.println(produtosAtivos.get(i).toString() + "Posição: " + i);
			System.out.println("\n");
		}
		return produtosAtivos;
	}

	public void getProdutoExclusaoLogica(ArrayList<Produtos> listaProdutos) {
		listar(listaProdutos);
		System.out.println("Digite o nome do produto: ");
		String nomeProduto = input.nextLine();
		Produtos produto = procurarProdutoPorNome(listaProdutos, nomeProduto);
		if(produto != null) {
			exclusaoLogica(produto);
		} else {
			System.out.println("Não existe este produto!");
		}
	}
	
	public Produtos procurarProdutoPorNome(ArrayList<Produtos> listaProdutos, String nomeProduto) {
		for(Produtos produto : listaProdutos) {
			if(nomeProduto.equals(produto.getNome())) {
				return produto;
			}
		}
		return null;
	}
}
