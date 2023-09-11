package de.tiere;

import java.util.ArrayList;
import java.util.List;

public class Schwein {
	
	private List<PigTooFatListener> pigTooFatListeners = new ArrayList<>();
	
	public void addPigTooFatListener(PigTooFatListener listener) {
		pigTooFatListeners.add(listener);
	}
	
	public void removePigTooFatListener(PigTooFatListener listener) {
		pigTooFatListeners.remove(listener);
	}
	
	
	private void firePigTooFatEvent() {
		for (PigTooFatListener pigTooFatListener : pigTooFatListeners) {
			pigTooFatListener.pigTooFat(this);
		}
	}
	
	private String name;
	private int gewicht;
	
	public Schwein() {
		this("nobody");
	}

	public Schwein(String name) {
		this.gewicht = 10;
		this.name = name;

	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGewicht() {
		return gewicht;
	}

	private void setGewicht(int gewicht) {
		this.gewicht = gewicht;
		if(this.gewicht > 20) firePigTooFatEvent();
	}

	public void fuettern() {
		setGewicht(getGewicht() + 1);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Schwein [name=");
		builder.append(name);
		builder.append(", gewicht=");
		builder.append(gewicht);
		builder.append("]");
		return builder.toString();
	}
	

}
