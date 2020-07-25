package br.unicamp.mc322.projeto.gameengine.service.keyinput;

import java.util.Scanner;

public class ScannerInputService implements KeyInputService
{

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public char getUserInput() {
		Scanner input = new Scanner(System.in);
		return Character.toLowerCase(input.next().strip().replace(" ", "").charAt(0));
	}

}

