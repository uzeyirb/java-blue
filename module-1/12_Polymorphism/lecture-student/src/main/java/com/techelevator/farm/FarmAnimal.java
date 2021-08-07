package com.techelevator.farm;

public class FarmAnimal implements Singable{
	private String name;
	private String sound;
	private boolean isSleeping = false;


	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;

	}

	public String getName() {
		return name;
	}

	public String getSound() {
		if(isSleeping){
			return "zzzzzzzzzz";
		}

		return sound;
	}

	public void wake(){
		this.isSleeping = false;
	}

	public void sleep(){
		this.isSleeping = true;
	}

}