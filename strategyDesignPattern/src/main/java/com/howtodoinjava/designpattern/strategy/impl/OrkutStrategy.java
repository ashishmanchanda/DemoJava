package com.howtodoinjava.designpattern.strategy.impl;

import com.howtodoinjava.designpattern.strategy.ISocialMediaStrategy;

public class OrkutStrategy implements ISocialMediaStrategy {

	public void connectTo(String friendName) 
	{
		System.out.println("Connecting with " + friendName + " through Orkut [not possible though :)]");
	}
}
