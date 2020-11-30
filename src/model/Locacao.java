package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Locacao {

    private int idLocacao;
    private int numeroDias;
    private Date dataInicio;
    private Date dataFim;
    private Double valorLocacao;
    private Cliente cliente;
    private Carro carro;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

    public int getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;
    }

    public int getNumeroDias() {
        return numeroDias;
    }

    public void setNumeroDias(int numeroDias) {
        this.numeroDias = numeroDias;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) throws ParseException {
        SimpleDateFormat dateConvert = new SimpleDateFormat("dd/MM/yyyy");
        this.dataInicio = dateConvert.parse(dataInicio);

    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) throws ParseException {
        SimpleDateFormat dateConvert = new SimpleDateFormat("dd/MM/yyyy");
        this.dataFim = dateConvert.parse(dataFim);
    }

    public Double getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(Double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public void locarCarro(Cliente cliente,Carro carro,String dataInicio,String dataFim) throws ParseException {

        this.setCliente(cliente);
        this.setCarro(carro);
        this.setDataInicio(dataInicio);
        this.setDataFim(dataFim);

        long diffInMillies = Math.abs(this.getDataFim().getTime()-this.getDataInicio().getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

        this.setValorLocacao(diff*carro.getValorDiaria());
        this.setStatus("Locado");
    }

    public void devolverCarro(){
        this.setStatus("Devolvido");
    }
}
