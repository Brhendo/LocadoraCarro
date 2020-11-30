package view;

import model.Carro;

import java.io.IOException;
import java.util.Scanner;

public class MenuCarros {


    private MenuOperacao menuOperacao;

    public MenuOperacao getMenuOperacao() {
        return menuOperacao;
    }

    public void setMenuOperacao(MenuOperacao menuOperacao) {
        this.menuOperacao = menuOperacao;
    }

    public int lerOpcao() throws InterruptedException, IOException {
        this.limpaTela();
        int opcao = -1;
        while(opcao < 0 || opcao >3){
            //imprime tela com as opções
            opcao = this.imprimeTelaPrincipal();

            if(opcao > 4 || opcao < 1){
                System.out.print("Opção invalida!!!");
                Thread.sleep(1000);
                this.limpaTela();
            }
        }

        return opcao;
    }

    public void limpaTela(){
        for (int i = 0; i < 30; i++) {
            System.out.println("");
        }
    }

    public int imprimeTelaPrincipal(){
        int opcao;
        MenuOperacao menuOperacao = new MenuOperacao();
        Scanner entrada = new Scanner(System.in);

        System.out.println("\t\t\t\t Sistema de Locção de Carros");
        System.out.println("");
        System.out.println("");
        System.out.println("********** Carros **********");
        System.out.println("");
        System.out.println("\t 1 - Cadastrar");
        System.out.println("\t 2 - Listar");
        System.out.println("\t 3 - Alterar");
        System.out.println("\t 4 - Excluir");

        System.out.println("");
        System.out.print("Opção: ");
        opcao = entrada.nextInt();

        //caso opção de cadastrar ler itns do carro
        if(opcao == 1){
            //imprime tela de cadastro de carro
            Carro carro = this.imprimeCadastrarCarro();
            menuOperacao.setOperacao("cadastrar");
            menuOperacao.setNomeClasse("Carro");
            menuOperacao.setObjeto(carro);
            //set parametros com opções
            this.setMenuOperacao(menuOperacao);
            this.limpaTela();

        }

        if(opcao == 2){
            this.limpaTela();
            menuOperacao.setOperacao("listar");
            menuOperacao.setNomeClasse("Carro");
            //set parametros com opções
            this.setMenuOperacao(menuOperacao);

        }

        if(opcao == 3){
            Carro carro = this.imprimeCadastrarCarro();
            menuOperacao.setOperacao("excluir");
            menuOperacao.setNomeClasse("Carro");
            menuOperacao.setObjeto(carro);
            //set parametros com opções
            this.setMenuOperacao(menuOperacao);

        }


        if(opcao == 4){
            Carro carro = this.imprimeExcluirCarro();
            menuOperacao.setOperacao("excluir");
            menuOperacao.setNomeClasse("Carro");
            menuOperacao.setObjeto(carro);
            //set parametros com opções
            this.setMenuOperacao(menuOperacao);

        }
        return opcao;
    }

    public Carro imprimeCadastrarCarro(){
        Scanner entrada = new Scanner(System.in);

        System.out.println("\t\t\t\t Sistema de Locção de Carros");
        System.out.println("");
        System.out.println("");
        System.out.println("********** Carros - Cadastrar **********");
        System.out.println("");
        
        Carro carro = new Carro();
        
        System.out.print("\t Insira Placa: ");
        carro.setPlaca(entrada.nextLine());
        System.out.print("\t Insira Ano: ");
        carro.setAno(entrada.nextLine());
        System.out.print("\t Insira Modelo: ");
        carro.setModelo(entrada.nextLine());
        System.out.print("\t Insira Valor Diária: ");
        carro.setValorDiaria(entrada.nextDouble());

        return carro;
    }

    public Carro imprimeExcluirCarro(){
        Scanner entrada = new Scanner(System.in);

        System.out.println("\t\t\t\t Sistema de Locção de Carros");
        System.out.println("");
        System.out.println("");
        System.out.println("********** Carros - Excluir **********");
        System.out.println("");

        Carro carro = new Carro();

        System.out.print("\t Placa do carro a excluir:  ");
        carro.setPlaca(entrada.nextLine());

        return carro;
    }
}
