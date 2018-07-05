package br.com.exemplo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.exemplo.model.Carro;
import br.com.exemplo.model.Cliente;
import br.com.exemplo.repository.CarroRepository;
import br.com.exemplo.repository.ClienteRepository;

/**
 * 
 * @author Marcos Araujo
 *
 */

@Controller
public class HomeController implements ErrorController{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CarroRepository carroRepository;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/listaClientes")
	public ModelAndView listaClientes() {
		ModelAndView mv = new ModelAndView("listaClientes");
		Iterable<Cliente> clientes = clienteRepository.findAll();
		mv.addObject("clientes", clientes);
		return mv;
	}
	
	@GetMapping("/listaCarros")
	public ModelAndView listaCarros() {
		ModelAndView mv = new ModelAndView("listaCarros");
		Iterable<Carro> carros = carroRepository.findAll();
		mv.addObject("carros", carros);
		return mv;
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
	
	@RequestMapping("/error")
    public String handleError() {
        return "error";
    }
}
