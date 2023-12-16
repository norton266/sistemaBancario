public class ContaPoupanca extends ContaBancaria{

    private double rendimento;
    private int saquesMensais;

    public ContaPoupanca(double rendimento, int saquesMensais, Pessoa titular,
                         Banco banco, int nroConta, double saldo, String senha) {
        super(titular,banco,nroConta,saldo,senha);
        this.rendimento = rendimento;
        this.saquesMensais = saquesMensais;
        this.tipoDeConta = "Conta Poupança";
    }

    public void info(){
        System.out.println("=============================");
        System.out.println("Nome do Banco: " + this.banco.getNome());
        System.out.println("Nº da conta: " + this.getNroConta());
        System.out.printf("Variação da poupança: R$ %.2f\n" , this.getSaldo() * (this.getRendimento()/100));
        System.out.println("Nome do cliente: " + this.titular.getNome());
        System.out.printf("Saldo: R$ %.2f\n" , this.getSaldo());
        System.out.println("Rendimento mensal: " + this.getRendimento() + "%");
        System.out.println("Saques restantes no mês: " + this.getSaquesMensais());


    }

    public void novoMes(){
        double valor = this.getSaldo() * (this.getRendimento()/100);
        this.setSaldo(getSaldo() + valor);
        this.setSaquesMensais(3);

        System.out.println("=============================");
        System.out.printf("Valor atualizado : R$ %.2f\n", this.getSaldo());

    }

    public void saque(double valor){
        double valorFinal;
        if(this.saquesMensais == 0){
            System.out.println("=============================");
            System.out.println("Você não pode fazer mais saques este mês.");
        } else if(this.getSaldo() < valor){
            System.out.println("=============================");
            System.out.println("Valor indisponível para saque.");
        } else {
            valorFinal = this.getSaldo() - valor;
            System.out.println("=============================");
            System.out.println("Valor autorizado para saque!");
            System.out.println("Novo saldo: R$" + valorFinal);
            this.setSaldo(valorFinal);
            this.saquesMensais = this.saquesMensais - 1;
        }
    }

    public void saque(){
        System.out.println("=============================");
        System.out.println("Digite o valor a ser sacado.");
        double valor = input.nextDouble();
        double valorFinal;
        if(this.saquesMensais == 0){
            System.out.println("=============================");
            System.out.println("Você não pode fazer mais saques este mês.");
        } else if(this.getSaldo() < valor){
            System.out.println("=============================");
            System.out.println("Valor indisponível para saque.");
        } else {
            valorFinal = this.getSaldo() - valor;
            System.out.println("=============================");
            System.out.println("Valor autorizado para saque!");
            System.out.println("Novo saldo: R$" + valorFinal);
            this.setSaldo(valorFinal);
            this.saquesMensais = this.saquesMensais - 1;
        }
    }

    public static ContaPoupanca criarContaPoupanca(double rendimento, int saquesMensais, Pessoa titular,
                                                   Banco banco, int nroConta, double saldo, String senha){
        return new ContaPoupanca(rendimento, saquesMensais, titular, banco, nroConta, saldo, senha);
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }

    public int getSaquesMensais() {
        return saquesMensais;
    }

    public void setSaquesMensais(int saquesMensais) {
        this.saquesMensais = saquesMensais;
    }
}
