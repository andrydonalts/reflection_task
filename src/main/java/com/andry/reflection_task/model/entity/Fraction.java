package com.andry.reflection_task.model.entity;

import com.andry.reflection_task.annotations.ReflectionInvoke;

//TODO:  Handle denumerator = 0 option
public class Fraction {
	protected int numerator;
	protected int denumerator;
	
	public Fraction() {
		checkSign(numerator, denumerator);
	}
	
	public Fraction(int numerator, int denumerator) {
		checkSign(numerator, denumerator);
	}
	
	public void checkSign(int numerator, int denumerator) {
		if (numerator < 0 && denumerator < 0) {
			this.numerator = -numerator;
			this.denumerator = -denumerator;
			return;
		} else if (denumerator < 0) {
			this.numerator = -numerator;
			this.denumerator  = -denumerator;
			return;
		}
		this.numerator = numerator;
		this.denumerator = denumerator;
	}
	
	@ReflectionInvoke
	public Fraction add(Fraction addedFraction) {
		Fraction newFraction = new Fraction();
		if (denumerator != addedFraction.getDenumerator()) {
			newFraction.setDenumerator(denumerator * addedFraction.getDenumerator());
			newFraction.setNumerator(numerator*addedFraction.getDenumerator() + addedFraction.getNumerator()*denumerator);
			return newFraction;
		}
		newFraction.setDenumerator(denumerator);
		newFraction.setNumerator(numerator + addedFraction.getNumerator());
		return newFraction;
	}
	
	@ReflectionInvoke
	public Fraction subtraction(Fraction subtract) {
		Fraction newFraction = new Fraction();
		if (denumerator != subtract.getDenumerator()) {
			newFraction.setDenumerator(denumerator * subtract.getDenumerator());
			newFraction.setNumerator(numerator*subtract.getDenumerator() - subtract.getNumerator()*denumerator);
			return newFraction;
		}
		newFraction.setDenumerator(denumerator);
		newFraction.setNumerator(numerator - subtract.getNumerator()); 
		return newFraction;
	}
	
	@ReflectionInvoke
	public Fraction multiply(Fraction multiplied) {
		Fraction newFraction = new Fraction();
		newFraction.setDenumerator(denumerator * multiplied.getDenumerator());
		newFraction.setNumerator(numerator * multiplied.getNumerator());
		return newFraction;
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenumerator() {
		return denumerator;
	}

	public void setDenumerator(int denumerator) {
		this.denumerator = denumerator;
	}
		
	@Override
	public String toString() {
		return numerator + "/" + denumerator;
	}
	
	
}
