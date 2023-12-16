import java.util.ArrayList;

public class Pessoa {
        public String nome, sobrenome;
        private String cpf;
        public int idade;
        private ArrayList<ContaBancaria> arrayContaBancaria;

        public Pessoa(String nome, String sobrenome, String cpf, int idade) {
                this.nome = nome;
                this.sobrenome = sobrenome;
                this.cpf = cpf;
                this.idade = idade;
                this.arrayContaBancaria = new ArrayList<>();
        }

        public void infoContas(){
                System.out.println("=============================");
                System.out.println("Contas de " + this.nome);
                for(int i = 0; i < arrayContaBancaria.size(); i++){
                        System.out.println("=============================");
                        System.out.println("Tipo de conta: " + arrayContaBancaria.get(i).getTipoDeConta());
                        System.out.println("Banco: " + arrayContaBancaria.get(i).banco.getNome());
                        System.out.println("Nro da conta: " + arrayContaBancaria.get(i).getNroConta());
                        System.out.println("Saldo: " + arrayContaBancaria.get(i).getSaldo());

                }
        }

        public boolean buscaPessoa(){
                if(this.cpf.equals(cpf)){
                        return true;
                } else {
                        return false;
                }
        }

        public void info(){
                System.out.println("Info Pessoa:");
                System.out.println("Nome:" + this.getNome());
                System.out.println("Sobrenome: " + this.getSobrenome());
                System.out.println("CPF: " + this.getCpf());
                System.out.println("Idade: " + this.getIdade());
        }

        public static Pessoa criarPessoa(String nome, String sobrenome, String cpf, int idade){
                return new Pessoa(nome, sobrenome, cpf, idade);
        }
        public void adicionarContaBancaria(ContaBancaria conta){
                arrayContaBancaria.add(conta);
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getSobrenome() {
                return sobrenome;
        }

        public void setSobrenome(String sobrenome) {
                this.sobrenome = sobrenome;
        }

        public String getCpf() {
                return cpf;
        }

        public void setCpf(String cpf) {
                this.cpf = cpf;
        }

        public int getIdade() {
                return idade;
        }

        public void setIdade(int idade) {
                this.idade = idade;
        }

        public ArrayList<ContaBancaria> getArrayContaBancaria() {
                return arrayContaBancaria;
        }

        public void setArrayContaBancaria(ArrayList<ContaBancaria> arrayContaBancaria) {
                this.arrayContaBancaria = arrayContaBancaria;
        }
}
