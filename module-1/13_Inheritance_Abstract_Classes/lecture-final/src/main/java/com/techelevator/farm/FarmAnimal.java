package com.techelevator.farm;

/*
An abstract class is a class that can be used as a
superclass (so it can pass on code through inheritance) and
can force methods to be  Overridden like an interface, but
cannot be instantiated.

An abstract class is extended like a superclass
 */
public abstract class FarmAnimal implements Singable {
	private String name;
	private String sound;
	private boolean isSleeping = false;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}

	/*
	An abstract (can only exist in an abstract class method
	forces a subclass to Override the method and provide
	a implementation (just like an interface does)
	 */
	public abstract void eat();
	public abstract boolean walk(int distance);

	public String getName() {
		return name;
	}

	/*
	The final keyword keeps a method from
	being Overridden in a subclass
	 */
	public final String getSound() {
		if (isSleeping) {
			return "zzzzzzzzzzz";
		}
		return sound;
	}

	public void wake() {
		this.isSleeping = false;
	}

	public void sleep() {
		this.isSleeping = true;
	}


}