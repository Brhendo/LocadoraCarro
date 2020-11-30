package reporitory;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledEditorKit.BoldAction;

import model.Carro;

public class CarroRepositorio {
	
	private List<Carro> carros;
	
	public CarroRepositorio() {
		// TODO Auto-generated constructor stub
		this.carros =  new ArrayList();
	}
	
	public void createCarro(Carro carro) {
		this.carros.add(carro);
	}
	
	public Boolean replaceCarro(Carro carro, Carro newCarro) {
		Carro tempCarros =  new Carro();
		int indexReplace = 0;
		boolean locateToReplace = false;
		
		for (int i = 0; i < this.carros.size(); i++) {
			tempCarros = this.carros.get(i);
			if(tempCarros.getPlaca().equals(carro.getPlaca())) {
				indexReplace = i;
				locateToReplace  = true;
			}
		}
		
		if(locateToReplace ) {
			this.carros.remove(indexReplace);
			this.carros.add(newCarro);
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean updateCarro(Carro carro, Carro newCarro) {
		Carro tempCarros =  new Carro();
		int indexUpdate = 0;
		boolean locateToUpdate = false;
		
		for (int i = 0; i < this.carros.size(); i++) {
			tempCarros = this.carros.get(i);
			if(tempCarros.getPlaca().equals(carro.getPlaca())) {
				indexUpdate = i;
				locateToUpdate = true;
			}
		}
		
		if(locateToUpdate) {
			this.carros.set(indexUpdate,newCarro);
			return true;
		}else {
			return false;
		}
		
	}
	
	public boolean updateCarro(Carro carro, Double novoValorDiaria) {
		Carro tempCarros =  new Carro();
		int indexUpdate = 0;
		boolean locateToUpdate = false;
		
		for (int i = 0; i < this.carros.size(); i++) {
			tempCarros = this.carros.get(i);
			if(tempCarros.getPlaca().equals(carro.getPlaca())) {
				indexUpdate = i;
				locateToUpdate = true;
			}
		}
		
		if(locateToUpdate) {
			tempCarros.setValorDiaria(novoValorDiaria);
			this.carros.set(indexUpdate,tempCarros);
			return true;
		}else {
			return false;
		}
		
	}
	
	
	
	
	public boolean deleteCarro(String placaCarro) {
		Carro tempCarros =  new Carro();
		int indexDeletar = 0;
		boolean locateToDelete = false;

		for (int i = 0; i < this.carros.size(); i++) {
			tempCarros = this.carros.get(i);
			if(tempCarros.getPlaca().equals(placaCarro)) {
				indexDeletar = i;
				locateToDelete = true;
			}
		}
		System.out.println("Index deletar"+indexDeletar);
		if(locateToDelete) {
			this.carros.remove(indexDeletar);
			return true;
		}else {
			return false;
		}
		
	}
	
	public void listarCarros() {

		Carro tempCarros =  new Carro();
		System.out.println("\t\tListando carro");
		for (int i = 0; i < this.carros.size(); i++) {
			tempCarros = this.carros.get(i);
			System.out.println("Id: "+i);
			System.out.println("Placa: "+tempCarros.getPlaca());
			System.out.println("Modelo: "+tempCarros.getModelo());
			System.out.println("Ano: "+tempCarros.getAno());
			System.out.println("Valor Diária: "+tempCarros.getValorDiaria()+" R$");

			System.out.println("");

		}
	}

}
