package com.andry.reflection_task.model.entity;

public class ComplexFraction extends Fraction {
	private int complexNumerator;
	private int complexDenumerator;
	private Fraction realFraction;
	private Fraction complexFraction;
	
	public ComplexFraction(Fraction realFraction, Fraction complexFraction) {
		this.realFraction = realFraction;
		this.complexFraction = complexFraction;
		super.numerator = realFraction.getNumerator();
		super.denumerator = realFraction.getDenumerator();
		this.complexNumerator = complexFraction.getNumerator();
		this.complexDenumerator = complexFraction.getDenumerator();
	}
	
	public ComplexFraction(int numerator, int denumerator, int complexNumerator, int complexDenumerator) {
		super.numerator = numerator;
		super.denumerator = denumerator;
		realFraction = new Fraction(numerator, denumerator);
		complexFraction = new Fraction(complexNumerator, complexDenumerator);
		this.complexNumerator = complexFraction.getNumerator();
		this.complexDenumerator = complexFraction.getDenumerator();
	}
	
	public Fraction add(ComplexFraction addedFraction) {
		return new ComplexFraction(realFraction.add(addedFraction.getRealFraction()),
				complexFraction.add(addedFraction.getComplexPartFraction()));
	}

	public Fraction subtraction(ComplexFraction subtract) {
		return new ComplexFraction(realFraction.subtraction(subtract.getRealFraction()),
				complexFraction.add(subtract.getComplexPartFraction()));
	}
	
	public Fraction multiply(ComplexFraction multiplied) {
		Fraction newRealFraction = realFraction.multiply(multiplied.getRealFraction())
				.add(complexFraction.multiply(multiplied.getComplexPartFraction()));
		Fraction newComplexPartFraction = realFraction.multiply(multiplied.getComplexPartFraction())
				.add(complexFraction.multiply(multiplied.getRealFraction()));
		return new ComplexFraction(newRealFraction, newComplexPartFraction);
	}


	@Override
	public Fraction add(Fraction addedFraction) {
		return new ComplexFraction(realFraction.add(addedFraction), complexFraction);
	}
	
	@Override
	public Fraction subtraction(Fraction subtract) {
		return new ComplexFraction(realFraction.subtraction(subtract), complexFraction);
	}

	@Override
	public Fraction multiply(Fraction multiplied) {
		return new ComplexFraction(realFraction.multiply(multiplied), complexFraction.multiply(multiplied));
	}

	public Fraction getRealFraction() {
		return realFraction;
	}
	
	public Fraction getComplexPartFraction() {
		return realFraction;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		if (complexNumerator < 0 && complexDenumerator > 0) {
			sb.append("-");
			sb.append("i");
			sb.append(new Fraction(-complexNumerator, complexDenumerator));
		} else if (complexNumerator < 0 && complexDenumerator > 0) {
			sb.append("-");
			sb.append("i");
			sb.append(new Fraction(complexNumerator, -complexDenumerator));
		} else {
			sb.append("+");
			sb.append("i");
			sb.append(complexFraction.toString());
		}
		return sb.toString();
	}
	
	
}