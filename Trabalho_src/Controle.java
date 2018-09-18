	import java.util.ArrayList;
	
	public class Controle 
	{
	
		private ViewCadastro viewCadastro;
		private ArrayList<Produtos> listaProdutos = new ArrayList<>();
		public Controle() {
			viewCadastro = new ViewCadastro();
			trataMenu();
		}
		
		private void trataMenu() 
		{
			boolean continuar = true;
			do {
				String opc = viewCadastro.mostraMenu();
	
				switch (opc) {
				case "1":
					viewCadastro.inserir(listaProdutos);
					break;
				case "2":
					viewCadastro.ordernarPorNome(listaProdutos);
					viewCadastro.listar(listaProdutos);
					break;
				case "3":
					viewCadastro.alterar(listaProdutos);
					break;
				case "4":
					viewCadastro.excluir(listaProdutos);
					break;
				case "5":
					viewCadastro.pesquisar(listaProdutos);
					break;
				case "6":
					System.out.println("Aplicação Encerrada");
					continuar = false;
					break;
				case "7":
					viewCadastro.getProdutoExclusaoLogica(listaProdutos);					
					break;
				case "8":
					viewCadastro.listaProdutosAtivos(listaProdutos);
					break;
				default:
					System.out.println("Opção inválida");
					System.exit(0);
					break;
				}
			} while (continuar);
		}
	}
