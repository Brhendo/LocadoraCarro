import model.Carro;
import model.Cliente;
import model.Locacao;
import reporitory.CarroRepositorio;
import reporitory.ClienteRepositorio;
import reporitory.LocacaoRepositorio;
import view.MenuCarros;
import view.MenuPrincipal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        // TODO Auto-generated method stub
        int opcao = -1;
        ClienteRepositorio clienteRepositorio =  new ClienteRepositorio();
        CarroRepositorio carroRepositorio = new CarroRepositorio();
        LocacaoRepositorio locacaoRepositorio =  new LocacaoRepositorio();

        Scanner entrada = new Scanner(System.in);

        while(true){
            MenuPrincipal menuPrincipal =  new MenuPrincipal();

            menuPrincipal.gerenciaMenu();



            if(menuPrincipal.getMenuOperacao().getNomeClasse() == "Carro" && menuPrincipal.getMenuOperacao().getOperacao() == "cadastrar"){
                carroRepositorio.createCarro((Carro) menuPrincipal.getMenuOperacao().getObjeto());
            }
            if(menuPrincipal.getMenuOperacao().getNomeClasse() == "Carro" && menuPrincipal.getMenuOperacao().getOperacao() == "listar"){
                carroRepositorio.listarCarros();
                entrada.nextLine();
            }
            if(menuPrincipal.getMenuOperacao().getNomeClasse() == "Carro" && menuPrincipal.getMenuOperacao().getOperacao() == "excluir"){
                System.out.println("E cadastrar");
            }
            if(menuPrincipal.getMenuOperacao().getNomeClasse() == "Carro" && menuPrincipal.getMenuOperacao().getOperacao() == "atualizar"){
                Carro tempCarro = (Carro) menuPrincipal.getMenuOperacao().getObjeto();
                System.out.println("Aqui");
                carroRepositorio.deleteCarro(tempCarro.getPlaca());
            }
        }





    }

}