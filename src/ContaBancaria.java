import java.util.Scanner;

abstract class ContaBancaria {

    Scanner input = new Scanner(System.in);
    protected Pessoa titular;
    protected Banco banco;
    protected int nroConta;
    protected double saldo;
    protected String senha;

    public String tipoDeConta;

    public ContaBancaria(Pessoa titular, Banco banco, int nroConta, double saldo, String senha) {
        this.titular = titular;
        this.banco = banco;
        this.nroConta = nroConta;
        this.saldo = saldo;
        this.senha = senha;
        this.tipoDeConta = "---";
    }

    public boolean verificaSenha(String senha){
        if(this.senha.equals(senha)){
            return true;
        } else {
            System.out.println("Senha incorreta!");
            return false;
        }
    }

    public void vincularPessoa(Pessoa pessoa){
        pessoa.adicionarContaBancaria(this);
    }

    public void vincularBanco(Banco banco){
        banco.adicionarContaBancaria(this);
    }

    public boolean verificaSenha(){
        String verificaSenha;
        System.out.println("Digite a senha:");
        verificaSenha = input.nextLine();
        if(verificaSenha.equals(this.senha)){
            return true;
        } else {
            System.out.println("Senha incorreta!");
            return false;
        }
    }



    public void saque(double valor){
        if(this.saldo >= valor) {
            this.saldo = this.saldo - valor;
            System.out.println("Saque efetuado.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void saque(){
        Scanner input = new Scanner(System.in);
        double valor;

        System.out.println("Digite o valor para saque: ");
        valor = input.nextDouble();

        if(this.saldo >= valor) {
            this.saldo = this.saldo - valor;
            System.out.println("Saque efetuado.");
            System.out.println("Novo saldo: R$ "  + this.getSaldo());
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void novoMes(){

    }

    public void deposito(double valor){
        this.saldo = this.saldo + valor;
        System.out.println("Deposito efetuado.");
    }

    public void deposito(){
        Scanner input = new Scanner(System.in);
        double valorDepositado;

        System.out.println("Digite o valor a depositar:");
        valorDepositado = input.nextDouble();
        this.saldo = this.saldo + valorDepositado;

        System.out.println("Novo saldo: R$ " + this.getSaldo());
    }

    public String getTipoDeConta() {
        return tipoDeConta;
    }

    public void setTipoDeConta(String tipoDeConta) {
        this.tipoDeConta = tipoDeConta;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public int getNroConta() {
        return nroConta;
    }

    public void setNroConta(int nroConta) {
        this.nroConta = nroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
