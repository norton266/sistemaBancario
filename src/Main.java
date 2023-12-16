import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Pessoa> arrayPessoa = new ArrayList<>();
        ArrayList<Banco> arrayBanco = new ArrayList<>();

        int option = 999;

        while (option != 0) {
            System.out.println("Digite a opção desejada:");
            System.out.println("1- Adicionar pessoa.");
            System.out.println("2- Informações de pessoa.");
            System.out.println("3- Listar pessoas.");
            System.out.println("4- Listar contas de determinada pessoa.");
            System.out.println("5- Adicionar banco.");
            System.out.println("6- Listar bancos.");
            System.out.println("7- Listar contas de determinado banco.");
            System.out.println("8- Criar conta corrente.");
            System.out.println("9- Criar conta poupança.");
            System.out.println("10- Acessar conta corrente ou bancária.");

            option = input.nextInt();

            switch (option) {
                case 1:
                    arrayPessoa.add(adicionarPessoa()); //metodo adicionarPessoa da Classe main,
                    break;                              //retorna um objeto Pessoa que é adicionado no array
                case 2:
                    infoPessoa(arrayPessoa); //metodo info da classe pessoa
                    break;
                case 3:
                    listarPessoas(arrayPessoa); //lista objetos do array
                    break;
                case 4:
                    listarContasPessoa(arrayPessoa); //lista contas do objeto do array
                    break;
                case 5:
                    arrayBanco.add(adicionarBanco()); //metodo adicionarBanco da Classe main
                    break;                            //retorna um objeto Banco que é adicionado no array
                case 6:
                    listarBancos(arrayBanco);       //lista bancos do array de objetos
                    break;
                case 7:
                    listarContasBanco(arrayBanco);  //lista contas de determinado objeto no array
                    break;
                case 8:
                    criarContaCorrente(arrayPessoa,arrayBanco);  //cria conta corrente de uma pessoa
                    break;                                       //vincula pessoa a banco e vice versa
                case 9:
                    criarContaPoupanca(arrayPessoa, arrayBanco); //cria conta poupança de uma pessoa
                    break;                                       //vincula pessoa a banco e vice versa
                case 10:
                    acessarConta(arrayPessoa,arrayBanco);  //acessa a conta, pede senha, saca, deposita, fecha conta
                    break;

            }
        }

        /*
        //instancia banco
        Banco b1 = new Banco("Itaú","01925891054",1);
        arrayBanco.add(b1);
        //instancia pessoa
        Pessoa p1 = new Pessoa("Norton Jaguarema","Wolff dos Santos","019.258.910-54",28);
        arrayPessoa.add(p1);
        //instancia conta corrente
        ContaCorrente cc1 = new ContaCorrente(5.07,p1,b1,01,1617.54,"123");
        cc1.vincularPessoa(p1);
        cc1.vincularBanco(b1);
        //instancia conta poupança
        ContaPoupanca cp1 = new ContaPoupanca(4.07, 3, p1, b1, 01, 3000, "456");
        cp1.vincularPessoa(p1);
        cp1.vincularBanco(b1);

        //listar conta da pessoa
        p1.listarContas();

        //metodo info de conta corrente
        cc1.info();

        //mmetodo novo mes de conta corrente
        cc1.novoMes();

        //metodo info e novo mes de conta poupança
        cp1.info();
        cp1.novoMes();

        //metodo de saque da conta poupança
        cp1.saque(1500);
        cp1.saque(100);
        cp1.saque(100);
        cp1.saque(300);

        //metodo de saque da conta poupança (polimorfismo)
        cp1.saque();

        //metodo info banco
        b1.info();
        b1.infoContas();

         */
    }

    public static Pessoa adicionarPessoa() {
        Scanner input = new Scanner(System.in);
        String nome, sobrenome, cpf;
        int idade;

        System.out.println("Digite o nome:");
        nome = input.nextLine();
        System.out.println("Digite o sobrenome:");
        sobrenome = input.nextLine();
        System.out.println("Digite o CPF:");
        cpf = input.nextLine();
        System.out.println("Digite a idade:");
        idade = input.nextInt();

        //metodo criarPessoa da classe Pessoa retorna uma pessoa
        Pessoa pessoa = Pessoa.criarPessoa(nome, sobrenome, cpf, idade);

        System.out.println("Pessoa adicionada ao sisema!");
        return pessoa;
    }

    public static void infoPessoa(ArrayList<Pessoa> arrayPessoa){
        Scanner input = new Scanner(System.in);
        String cpfBusca;
        System.out.println("Digite o CPF da pessoa quer quer obter informações:");
        cpfBusca = input.nextLine();

        for(int i=0;i<arrayPessoa.size();i++){
            if(cpfBusca.equals(arrayPessoa.get(i).getCpf())){
                arrayPessoa.get(i).info();
            }
        }

    }

    public static void listarPessoas(ArrayList<Pessoa> arrayPessoa) {
        System.out.println("Pessoas cadastradas no sistema:");
        for (int i = 0; i < arrayPessoa.size(); i++) {
            System.out.println("=============================");
            System.out.println("Nome: " + arrayPessoa.get(i).getNome());
            System.out.println("CPF: " + arrayPessoa.get(i).getCpf());
        }
    }

    public static void listarContasPessoa(ArrayList<Pessoa> arrayPessoa){
        Scanner input = new Scanner(System.in);
        String cpfPessoa;
        System.out.println("Digite o cpf da pessoa que quer listar as contas");
        cpfPessoa = input.nextLine();

        //procura por um CPF no array de pessoas para que seja listado
        for(int i = 0; i < arrayPessoa.size(); i++){
            if(arrayPessoa.get(i).getCpf().equals(cpfPessoa)){
                arrayPessoa.get(i).infoContas();
            }
        }
    }

    public static Banco adicionarBanco() {
        Scanner input = new Scanner(System.in);
        String nome, cnpj;
        int nroBanco;

        System.out.println("Digite o nome:");
        nome = input.nextLine();
        System.out.println("Digite o CNPJ:");
        cnpj = input.nextLine();
        System.out.println("Digite o número do banco:");
        nroBanco = input.nextInt();

        Banco banco = Banco.criarBanco(nome, cnpj, nroBanco);
        System.out.println("Banco adicionado ao sisema!");
        return banco;
    }

    public static void listarBancos(ArrayList<Banco> arrayBanco) {
        System.out.println("Bancos cadastrados no sistema:");
        for (int i = 0; i < arrayBanco.size(); i++) {
            System.out.println("=============================");
            System.out.println("Nome: " + arrayBanco.get(i).getNome());
            System.out.println("CNPJ: " + arrayBanco.get(i).getCnpj());
        }
    }
    public static void listarContasBanco(ArrayList<Banco> arrayBanco){
        Scanner input = new Scanner(System.in);
        String cnpjBanco;
        System.out.println("Digite o cnpj do banco que quer listar as contas");
        cnpjBanco = input.nextLine();
        for(int i = 0; i < arrayBanco.size(); i++){
            if(arrayBanco.get(i).getCnpj().equals(cnpjBanco)){
                arrayBanco.get(i).infoContas();
            }
        }
    }

    public static ContaCorrente criarContaCorrente(ArrayList<Pessoa> arrayPessoa, ArrayList<Banco> arrayBanco){
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\n");
        double taxasMensais, saldo;
        int nroConta;
        String senha;
        String cpfBusca, bancoBusca;

        System.out.println("Digite o cpf do titular da conta: ");
        cpfBusca = input.nextLine();

        for(int i=0; i<arrayPessoa.size(); i++){
            if(arrayPessoa.get(i).getCpf().equals(cpfBusca)){
                System.out.println("Digite a taxa mensal:");
                taxasMensais = input.nextDouble();
                System.out.println("Digite o saldo:");
                saldo = input.nextDouble();
                System.out.println("Digite a senha:");
                senha = input.next();
                System.out.println("Digite o numero da conta:");
                nroConta = input.nextInt();
                System.out.println("Digite o nome do banco:");
                bancoBusca = input.next();

                for(int j=0; j<arrayBanco.size(); j++){
                    if(arrayBanco.get(j).getNome().equals(bancoBusca)){
                        ContaCorrente contaCorrente = ContaCorrente.criarContaCorrente(taxasMensais,
                                arrayPessoa.get(i), arrayBanco.get(j), nroConta, saldo,senha);

                        System.out.println("Conta corrente criada!");
                        contaCorrente.vincularPessoa(arrayPessoa.get(i));
                        contaCorrente.vincularBanco(arrayBanco.get(j));

                        return contaCorrente;
                    }
                }
            }
        }
        System.out.println("Banco não cadastrado no sistema!");
        return null;
    }

    public static ContaPoupanca criarContaPoupanca(ArrayList<Pessoa> arrayPessoa, ArrayList<Banco> arrayBanco){
        Scanner input = new Scanner(System.in);
        input.useDelimiter("\n");
        double rendimento, saldo;
        int nroConta;
        String senha;
        String cpfBusca, bancoBusca;

        System.out.println("Digite o cpf do titular da conta: ");
        cpfBusca = input.nextLine();

        for(int i=0; i<arrayPessoa.size(); i++){
            if(arrayPessoa.get(i).getCpf().equals(cpfBusca)){
                System.out.println("Digite o rendimento mensal:");
                rendimento = input.nextDouble();
                System.out.println("Digite o saldo:");
                saldo = input.nextDouble();
                System.out.println("Digite a senha:");
                senha = input.next();
                System.out.println("Digite o numero da conta:");
                nroConta = input.nextInt();
                System.out.println("Digite o nome do banco:");
                bancoBusca = input.next();

                for(int j=0; j<arrayBanco.size(); j++){
                    if(arrayBanco.get(j).getNome().equals(bancoBusca)){
                        ContaPoupanca contaPoupanca = ContaPoupanca.criarContaPoupanca(rendimento,
                                3, arrayPessoa.get(i), arrayBanco.get(j), nroConta,
                                saldo,senha);

                        System.out.println("Conta corrente criada!");
                        contaPoupanca.vincularPessoa(arrayPessoa.get(i));
                        contaPoupanca.vincularBanco(arrayBanco.get(j));

                        return contaPoupanca;
                    }
                }
            }
        }
        System.out.println("Banco não cadastrado no sistema!");
        return null;
    }

    public static void acessarConta(ArrayList<Pessoa> arrayPessoa, ArrayList<Banco> arrayBanco){
        Scanner input = new Scanner(System.in);
        String buscaCpf, verificaSenha, verificaBanco;
        int selecionaConta, opcaoConta;
        input.useDelimiter("\n");

        System.out.println("Digite o CPF do titular da conta:");
        buscaCpf = input.nextLine();

        for(int i= 0; i < arrayPessoa.size(); i++){
            if(buscaCpf.equals(arrayPessoa.get(i).getCpf())){
                Pessoa p = arrayPessoa.get(i);
                if(p.getArrayContaBancaria().size() > 0){
                    System.out.println("Digite a conta para acessar:");
                    int j=0;
                    for(;j< p.getArrayContaBancaria().size(); j++){
                        System.out.println(j + "- " + p.getArrayContaBancaria().get(j).getTipoDeConta());
                    }
                    selecionaConta = input.nextInt();
                    if(selecionaConta <= j && selecionaConta >= 0){
                        System.out.println("Digite a Senha: ");
                        verificaSenha = input.next();
                        if(p.getArrayContaBancaria().get(selecionaConta).verificaSenha(verificaSenha)){
                            System.out.println("Digite a opção desejada: ");
                            System.out.println("1- Deposito.");
                            System.out.println("2- Saque.");
                            System.out.println("3- Novo mes.");
                            System.out.println("4- Deleta conta.");

                            opcaoConta = input.nextInt();
                            if(opcaoConta == 1){
                                p.getArrayContaBancaria().get(selecionaConta).deposito();
                            } else if(opcaoConta == 2){
                                p.getArrayContaBancaria().get(selecionaConta).saque();
                            } else if(opcaoConta == 3){
                                p.getArrayContaBancaria().get(selecionaConta).novoMes();
                            } else if(opcaoConta == 4){
                                Banco b = p.getArrayContaBancaria().get(selecionaConta).getBanco(); //instancia um objeto banco com os mesmos atributos do banco do array
                                p.getArrayContaBancaria().remove(selecionaConta);                   //remove a conta do array dentro de main
                                b.fecharConta(b.getArrayContaBancaria().get(selecionaConta));       //remove o objeto no array dentro de Banco
                            }
                        }
                    }
                }
            }

        }
    }
}