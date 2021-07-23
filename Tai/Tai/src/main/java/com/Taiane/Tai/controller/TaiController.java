package com.Taiane.Tai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/hello")

public class TaiController
{
	@GetMapping ("/rota1")
	public String hello () {
		return "Usei a habilidade de atenção aos detalhes para seguir passo a passo,"
				+ " também de trabalho em equipe, além da mentalidade de persistência, "
				+ "pois fiquei com dificuldades no início.";
				
	}
	@GetMapping ("/rota2")
	public String hello2 () {
		return "Eu espero não ficar até muito tarde fazendo os execícios, "
				+ "poder aprender prezando meu descanso.";
	}
	
}
