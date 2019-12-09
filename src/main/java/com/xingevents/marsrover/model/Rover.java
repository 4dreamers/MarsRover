package com.xingevents.marsrover.model;

import com.xingevents.marsrover.utils.IConstants;

import java.io.CharConversionException;

public class Rover
{
	private int positionX;
	private int positionY;
	private String compassPosition;

	public Rover(int positionX, int positionY, String compassPosition) throws CharConversionException {
		if(positionX < 0 || positionY < 0){
			throw new IllegalArgumentException("Rover Position is out of Plateau");
		}
		if(!IConstants.compassPositions.contains(compassPosition)){
			throw new CharConversionException("Rover Compass Position is unknown");
		}
		this.positionX = positionX;
		this.positionY = positionY;
		this.compassPosition = compassPosition;
	}


	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public String getCompassPosition() {
		return compassPosition;
	}

	public void setCompassPosition(String compassPosition) {
		this.compassPosition = compassPosition;
	}
}
