import java.util.ArrayList;

public class Banco {
    private String nome, cnpj;
    private int nroBanco;
    private ArrayList<ContaBancaria> arrayContaBancaria;

    public Banco(String nome, String cnpj, int nroBanco) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.nroBanco = nroBanco;
        this.arrayContaBancaria = new ArrayList<>();
    }

    public void adicionarContaBancaria(ContaBancaria conta){
        arrayContaBancaria.add(conta);
    }

    public static Banco criarBanco(String nome, String cnpj, int nroBanco){
        return new Banco(nome, cnpj, nroBanco);
    }

    public void info(){
        System.out.println("=============================");
        System.out.println("Nome do banco: " + this.getNome());
        System.out.println("CNPJ: " + this.getCnpj());
        System.out.println("Nº do banco:" + this.getNroBanco());
    }

    public void infoContas(){
        System.out.println("=============================");
        System.out.println("Informações das contas bancárias do Banco " + this.getNome());
        for(int i = 0; i < arrayContaBancaria.size(); i++) {
            System.out.println("=============================");
            System.out.println("Tipo de conta: " + arrayContaBancaria.get(i).getTipoDeConta());
            System.out.println("Nro da conta: " + arrayContaBancaria.get(i).getNroConta());
            System.out.printf("Saldo: R$ %.2f\n" , arrayContaBancaria.get(i).getSaldo());
            System.out.println("Titular da conta: " + arrayContaBancaria.get(i).getTitular().getNome());
        }
    }

    public void fecharConta(ContaBancaria conta){
        for(int i = 0; i < arrayContaBancaria.size(); i++){
            if(arrayContaBancaria.get(i).equals(conta)){
                arrayContaBancaria.remove(i);
                break;
            }
        }
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getNroBanco() {
        return nroBanco;
    }

    public void setNroBanco(int nroBanco) {
        this.nroBanco = nroBanco;
    }

    public ArrayList<ContaBancaria> getArrayContaBancaria() {
        return arrayContaBancaria;
    }

    public void setArrayContaBancaria(ArrayList<ContaBancaria> arrayContaBancaria) {
        this.arrayContaBancaria = arrayContaBancaria;
    }
}
