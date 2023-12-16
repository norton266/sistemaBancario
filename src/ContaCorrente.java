public class ContaCorrente extends ContaBancaria {
    private double taxasMensais;

    public ContaCorrente(double taxasMensais, Pessoa titular, Banco banco, int nroConta,
                         double saldo, String senha) {
        super(titular,banco,nroConta,saldo,senha);
        this.taxasMensais = taxasMensais;
        this.tipoDeConta = "Conta Corrente";


    }

    public double getTaxasMensais() {
        return taxasMensais;
    }

    public void setTaxasMensais(double taxasMensais) {
        this.taxasMensais = taxasMensais;
    }

    public void info(){
        System.out.println("=============================");
        System.out.println("Nome do Banco: " + this.banco.getNome());
        System.out.println("Nº da conta: " + this.getNroConta());
        System.out.println("Nome do cliente: " + this.titular.getNome());
        System.out.println("Saldo: R$ " + this.getSaldo());
        System.out.println("Taxas ao mês: " + this.getTaxasMensais());


    }

    public void novoMes(){
        double valor = this.getSaldo() * (this.getTaxasMensais()/100);
        this.setSaldo(this.getSaldo() - valor);

        System.out.println("=============================");
        System.out.printf("Taxas do mês no valor de: R$ %.2f\n", valor);
        System.out.printf("Saldo atualizado: R$ %.2f\n" , this.getSaldo());

    }

    public void saque(double valor){
        double valorFinal;
        if(this.getSaldo() < valor){
            System.out.println("=============================");
            System.out.println("Valor indisponível para saque.");
        } else {
            valorFinal = this.getSaldo() - valor;
            System.out.println("=============================");
            System.out.println("Valor autorizado para saque!");
            System.out.println("Novo saldo: R$" + valorFinal);
            this.setSaldo(valorFinal);
        }
    }

    public static ContaCorrente criarContaCorrente(double taxasMensais, Pessoa titular,
                                                   Banco banco, int nroConta,
                                                   double saldo, String senha){
        return new ContaCorrente(taxasMensais, titular, banco, nroConta, saldo, senha);
    }
}
