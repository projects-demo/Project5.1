package com.spring.model;

public class Car {

	private Engine engine;
	private Transmission transmission;

	public Car(Engine engine, Transmission transmission) {
		this.engine = engine;
		this.transmission = transmission;
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Transmission getTransmission() {
		return transmission;
	}

	public void setTransmission(Transmission transmission) {
		this.transmission = transmission;
	}
}