import java.util.Scanner;

import projetoSquad39.Apoiador;



public public class Principal {

	/**
	 * @param args
	 */
	public static void main(String args[]) {

		ApoiadorDAO apoiadorDAO = new ApoiadorDAOO();
		Apoiador ap1 = new Apoiador();
		

		Scanner entrada = new Scanner(System.in);
		int escolha = 0;
		String nome = "";
		String dataNasString;
		String emalString;
		int Id_Apoiador = 0;
		String telefone;
		String telContato;
		String senha;
		

		do {

			System.out.println("===== ************************************=====");
			System.out.println("Escolha uma opção:");
			System.out.println("1 - Cadastrar novo Apoador");
			System.out.println("2 - Excluir dados de um Apoiador");
			System.out.println("3 - Atualizar dados cadastrais");
			System.out.println("4 - Mostrar todos os dados Cadastrados");
			
		

			System.out.println("0 - Sair");
			escolha = entrada.nextInt();

			switch (escolha) {
				// metodo salvar
			case 1: {
				System.out.println("Digite o nome completo a ser Incluído no cadastro: ");
				nome = entrada.next();
				System.out.println("Digite o E-mail para cadastro: ");
				emailString = entrada.next();
				System.out.println("Digite o telefone do Cliente: ");
				telefone = entrada.next();
                System.out.println("Digite o Telefone para contato a ser Incluído no cadastro: ");
				telContato = entrada.next();
                System.out.println("Digite o tipo de doação a ser feita pelo Apoiador: ");
			    tipoDoacao = entrada.next();
                System.out.println("Digite a senha para o cadastro: ");
				senha = entrada.next();
				ap1.setNome(nome);
				ap1.setemail(Cpf);
				ap1.setTelefone(telefone);
                ap1.setTelContato(telContato);
                ap1.setTipoDoacao(tipoDoacao);
				ApoiadorDAO.save(c1);
				break;
			}
			// metodo Deletar 
			case 2: {
				System.out.println("Digite o ID do Apoiador para exclusão: ");
				try {
					Id_Apoiador = entrada.nextInt();
					
					ApoiadorDAO.removeById(Id_Apoiador);
					
				} catch (Exception e) {
					// e.getMessage();
					 
					System.out.println(" ID não foi encontrado");
				}

				break;
			}
			// método de atualizar
			case 3: {

				System.out.println("Digite o ID do Apoiador que deseja atualizar: ");
				Id_Apoiador = entrada.nextInt();

				System.out.println("Digite o novo nome do cadastro: ");
				nome = entrada.next();
				ap1.setNome(nome);
				
				System.out.println("Digite o Telefone para Contato: ");
				telContato = entrada.next();
				ap1.setTelContato(telContato);
				
				System.out.println("Digite o email do Cliente: ");
				 emailString = entrada.next();				
				ap1.setEmail(emalString);
				

				ap1.setId(Id_Apoiador);

				ApoiadorDAO.update(ap1);
			}
			case 4: {
				// READ - Leitura
				try {
					for (Apoiador ap2: ApoiadorDAO.getApoiador()) {
						System.out.println("Nome: " + ap2.getNome());
						System.out.println("Telefone:  " + ap2.getTelefone());
						System.out.println("Email: "+ ap2.getEmail());
                        System.out.println("dataNasc: "+ ap2.getDataNasc());
						System.out.println("-------------------------------");
					} 
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				break; {case 0: {
                    System.out.println(" Você saiu do menu ");
                    break;
                }
                default:
                    System.out.println("Opção invalida: ");
    
                };
    
            } while (escolha != 9);
    
            entrada.close();
    
        }
    }
    
}
