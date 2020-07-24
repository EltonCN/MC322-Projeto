package br.unicamp.mc322.projeto.gameengine.service;

import br.unicamp.mc322.projeto.gameengine.service.KeyInputService;

public class NullKeyInputService implements KeyInputService
{

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public char getUserInput() {
		return ' ';
	}
}

