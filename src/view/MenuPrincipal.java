package view;

import java.io.IOException;
import java.util.Scanner;

public class MenuPrincipal {

    private MenuOperacao menuOperacao;

    public MenuOperacao getMenuOperacao() {
        return menuOperacao;
    }

    public void setMenuOperacao(MenuOperacao menuOperacao) {
        this.menuOperacao = menuOperacao;
    }

    public void gerenciaMenu() throws InterruptedException, IOException {
        //variavel usada para resgatar dados e opções do menu
        MenuOperacao menuOperacao = new MenuOperacao();
        MenuCarros  menuCarros =  new MenuCarros();
        int opcao = -1;

        while(opcao < 1 || opcao >3){
            opcao = this.imprimeTelaPrincipal();

            if(opcao > 3 || opcao < 1){
                System.out.print("Opção invalida!!!");
                Thread.sleep(1000);
                this.limpaTela();
            }
        }

        if(opcao == 1){
            //apos selecionado a opção carro vai para menu carro
            menuCarros.lerOpcao();
            this.setMenuOperacao(menuCarros.getMenuOperacao());
        }


 }

    public void limpaTela(){
        for (int i = 0; i < 30; i++) {
            System.out.println("");
        }
    }

    public int imprimeTelaPrincipal(){
        int opcao;
        Scanner entrada = new Scanner(System.in);

        System.out.println("\t\t\t\t Sistema de Locção de Carros");
        System.out.println("");
        System.out.println("");
        System.out.println("\t 1 - Carros");
        System.out.println("\t 2 - Cliente");
        System.out.println("\t 3 - Locação");

        System.out.println("");
        System.out.print("Opção: ");
        opcao = entrada.nextInt();
        return opcao;
    }
}
