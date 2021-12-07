package itau.com.br.financiamento.controller.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

import itau.com.br.financiamento.model.Cliente;
import itau.com.br.financiamento.model.Proposta;
import itau.com.br.financiamento.repository.ClienteRepository;
import lombok.Data;

@Data
public class PropostaForm {
	
	@NotBlank(message = "Digite o valor da taxa de Juros")
	private BigDecimal taxaJuros;
	@NotBlank(message = "Digite o valor do financiamento")
	private BigDecimal valorFinanciamento;
	private Cliente cliente;
	
	public Proposta converter(ClienteRepository clienteRepository) {
		Cliente dadoCliente = clienteRepository.getById(cliente.getId());
		this.cliente.setId(dadoCliente.getId());
		this.cliente.setCpf(dadoCliente.getCpf());
		this.cliente.setNome(dadoCliente.getNome());
		Proposta proposta = new Proposta();
		proposta.setTaxaJuros(this.taxaJuros);
		proposta.setValorFinanciamento(this.valorFinanciamento);
		proposta.setCliente(dadoCliente);
		return proposta;
	}
	
}
