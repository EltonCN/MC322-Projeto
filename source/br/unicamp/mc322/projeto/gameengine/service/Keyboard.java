package br.unicamp.mc322.projeto.gameengine.service;

import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Keyboard implements KeyInputService
{

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public char getUserInput() {
		Scanner input = new Scanner(System.in);
		// TODO CHANGE IMPLEMENTATION LATER
		return Character.toLowerCase(input.next().strip().replace(" ", "").charAt(0));
	}

}

