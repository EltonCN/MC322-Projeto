package br.unicamp.mc322.projeto.gameengine.service.keyinput;

public class NullKeyInputService implements KeyInputService
{

	@Override
	public void end() 
	{
		
	}

	@Override
	public char getUserInput() {
		return ' ';
	}
}

