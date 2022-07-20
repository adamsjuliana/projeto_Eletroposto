package br.com.adams.Eletroposto.controller;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.adams.Eletroposto.model.Agendamento;
import br.com.adams.Eletroposto.model.Papel;
import br.com.adams.Eletroposto.model.Usuario;
import br.com.adams.Eletroposto.repository.AgendamentoRepository;
import br.com.adams.Eletroposto.repository.PapelRepository;
import br.com.adams.Eletroposto.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private BCryptPasswordEncoder criptografia;

	@Autowired
	private PapelRepository papelRepository;

	@GetMapping
	public String pagInicial() {
		   return "home";
		   }
	@GetMapping("/no")
	public String acessoNegado() {
		   return "acesso-negado";
		   }

	@GetMapping("/agendar")
	public String agendar (@ModelAttribute Agendamento agendamento, Model model) {
		   DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		   LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
		   now = now.truncatedTo(ChronoUnit.HOURS);
		   String nowstr = now.format(dateTimeFormatter);
		   for (int i=1; i<24; i++)
		   {
		      LocalDateTime currdate = now.plusHours(i);
		      String currdatestr = currdate.format(dateTimeFormatter);
		      agendamentoRepository.saveData(currdatestr);
		   }
		   List<Agendamento> listaAgendamento = agendamentoRepository.findByIdData(nowstr);
		   model.addAttribute("agendamento", listaAgendamento);
		return "agendar";
	}
	@GetMapping("/meus")
	public String meusAgendamentos (){
		return "meusAgendamentos";
	}
	@GetMapping("/agendamentos")
	public String agendamentos (@ModelAttribute Agendamento agendamento, Model model) {
		   DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		   LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
		   now = now.truncatedTo(ChronoUnit.HOURS);
		   String nowstr = now.format(dateTimeFormatter);
		   List<Agendamento> listaAgendamento = agendamentoRepository.findAllAgendamentos(nowstr);
		   model.addAttribute("agendamento", listaAgendamento);
		   return "agendamentos";
	}
	@GetMapping("/del/{id}") /* DELETAR AGENDAMENTOS */
	public String delAgendamentos(@PathVariable("id") Long id, RedirectAttributes attributes) {
	agendamentoRepository.delAgendamento(null ,id);
	attributes.addFlashAttribute("mensagem", "Agendamento deletado!!");
	return "redirect:/agendamentos";
	}
	
	@GetMapping("/login")
	public String login (@Valid Usuario usuario, BindingResult result){
		if (result.hasErrors()) {
			return "login";
		}
		return "login";
	}
	
}