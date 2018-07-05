package br.com.exemplo;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.exemplo.model.Carro;

/**
 * 
 * @author Marcos Araujo
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CarroEndpointTest {

	final static String URL_CARROS = "http://localhost:8080/carros";

	private RestTemplate restTemplate;
	
	private List<Carro> lista;

	@Before
	public void init() throws JsonParseException, JsonMappingException, RestClientException, IOException {
		restTemplate = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();
		lista = mapper.readValue(restTemplate.getForObject(URL_CARROS, String.class),
				mapper.getTypeFactory().constructCollectionType(List.class, Carro.class));
	}
	
	@Test
	public void verificarLista() {
		Assert.assertNotNull(lista);
	}

	@Test
	public void criarCarro() throws JsonProcessingException {
		Carro response = restTemplate.postForObject(URL_CARROS, carregarCarro(1999, "Uno Fiat"), Carro.class);
		Assert.assertEquals("Uno Fiat 1999", response.getNomeModelo() + " " + response.getAno());
	}
	
	@Test
	public void alterarCarro() throws IOException{
	    restTemplate.put(URL_CARROS + "/" + lista.get(0).getId(), carregarCarro(2005, "Palio Fiat"));
	     
	    Carro carro2 = restTemplate.getForObject(URL_CARROS + "/" + lista.get(0).getId(), Carro.class);
	    
	    Assert.assertNotNull(carro2);
	    Assert.assertEquals("Onix Chevrolet", carro2.getNomeModelo());
	    Assert.assertEquals(2005, carro2.getAno(), 0);
	}

	@Test
	public void buscarCarro() throws IOException {
		Carro carro = restTemplate.getForObject(URL_CARROS + "/" + lista.get(0).getId(), Carro.class);
		Assert.assertNotNull(carro);
		Assert.assertEquals("Onix Chevrolet", carro.getNomeModelo());
		Assert.assertEquals(2005, carro.getAno(), 0);
	}
	
	@Test
	public void deletarCa() throws IOException{
	    restTemplate.delete(URL_CARROS + "/" + lista.get(0).getId(), lista.get(0));
	}

	private Carro carregarCarro(int ano, String nomeModelo) {
		Carro carro = new Carro();
		carro.setNome(nomeModelo);
		carro.setAno(ano);
		return carro;
	}
}
