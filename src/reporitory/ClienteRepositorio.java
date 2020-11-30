package reporitory;

import model.Carro;
import model.Cliente;

import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepositorio {


    private List<Cliente> clientes;

    public ClienteRepositorio() {
        // TODO Auto-generated constructor stub
        this.clientes =  new ArrayList();
    }

    public void createCliete(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public Boolean replaceCliente(Cliente cliente, Cliente newCliente) {
        Cliente tempCliente =  new Cliente();
        int indexReplace = 0;
        boolean locateToReplace = false;

        for (int i = 0; i < this.clientes.size(); i++) {
            tempCliente = this.clientes.get(i);
            if(tempCliente.getCpf().equals(cliente.getCpf())) {
                indexReplace = i;
                locateToReplace  = true;
            }
        }

        if(locateToReplace ) {
            this.clientes.remove(indexReplace);
            this.clientes.add(newCliente);
            return true;
        }else {
            return false;
        }

    }

    public boolean updateCliente(Cliente cliente, Cliente newCliente){
        Cliente tempCliente =  new Cliente();
        int indexUpdate = 0;
        boolean locateToUpdate = false;

        for (int i = 0; i < this.clientes.size(); i++) {
            tempCliente = this.clientes.get(i);
            if(tempCliente.getCpf().equals(cliente.getCpf())) {
                indexUpdate = i;
                locateToUpdate  = true;
            }
        }

        if(locateToUpdate) {
            this.clientes.set(indexUpdate,newCliente);
            return true;
        }else {
            return false;
        }

    }

    public boolean updateCliente(Cliente cliente, String endereco) {
        Cliente tempCliente =  new Cliente();
        int indexUpdate = 0;
        boolean locateToUpdate = false;

        for (int i = 0; i < this.clientes.size(); i++) {
            tempCliente = this.clientes.get(i);
            if(tempCliente.getEndereco().equals(cliente.getEndereco())) {
                indexUpdate = i;
                locateToUpdate = true;
            }
        }

        if(locateToUpdate) {
            tempCliente.setEndereco(endereco);
            this.clientes.set(indexUpdate,tempCliente);
            return true;
        }else {
            return false;
        }

    }




    public boolean deleteCliente(String cpf) {
        Cliente tempCliente =  new Cliente();
        int indexDeletar = 0;
        boolean locateToDelete = false;

        for (int i = 0; i < this.clientes.size(); i++) {
            tempCliente = this.clientes.get(i);
            if(tempCliente.getCpf().equals(cpf)) {
                indexDeletar = i;
                locateToDelete = true;
            }
        }

        if(locateToDelete) {
            this.clientes.remove(indexDeletar);
            return true;
        }else {
            return false;
        }

    }

    public void listarClientes() {
        Cliente tempCliente =  new Cliente();

        for (int i = 0; i < this.clientes.size(); i++) {
            tempCliente = this.clientes.get(i);
            System.out.println(tempCliente.getNome()+" "+tempCliente.getCpf()+" "+tempCliente.getEndereco());
        }
    }


}
