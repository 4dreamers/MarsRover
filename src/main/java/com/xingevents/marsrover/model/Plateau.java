package com.xingevents.marsrover.model;

public class Plateau
{
	private int upperXCorner;
	private int upperYCorner;
	private int lowerXCorner;
	private int lowerYCorner;

	public Plateau(int upperXCorner, int upperYCorner)
	{

		if(upperXCorner < 0 || upperYCorner < 0)
			throw new IllegalArgumentException("Upper Corners have to be bigger than 1");

		this.upperXCorner = upperXCorner;
		this.upperYCorner = upperYCorner;
		this.lowerXCorner = 0;
		this.lowerYCorner = 0;
	}

	public int getUpperXCorner()
	{
		return upperXCorner;
	}

	public int getUpperYCorner()
	{
		return upperYCorner;
	}

	public int getLowerXCorner()
	{
		return lowerXCorner;
	}

	public int getLowerYCorner()
	{
		return lowerYCorner;
	}
}
