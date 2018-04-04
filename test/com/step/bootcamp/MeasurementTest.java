package com.step.bootcamp;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class MeasurementTest {
  @Test
  public void shouldReturnTrueFor1FootEquals1Foot() {
    Measurement oneFoot = new Measurement(1.0, Unit.FEET);
    Measurement expectedFoot = new Measurement(1.0, Unit.FEET);
    assertThat(oneFoot,is(expectedFoot));
    assertThat(oneFoot.hashCode(),is(expectedFoot.hashCode()));
  }

  @Test
  public void shouldReturnTrueFor1FootAnd12Inches() {
    Measurement oneFoot = new Measurement(1.0, Unit.FEET);
    Measurement twelveInches = new Measurement(12.0, Unit.INCH);
    assertThat(oneFoot,is(twelveInches));
    assertThat(oneFoot.hashCode(),is(twelveInches.hashCode()));
  }

  @Test
  public void shouldReturnFalseFor1And10Inches() {
    Measurement oneFoot = new Measurement(1.0, Unit.FEET);
    Measurement tenInches = new Measurement(10.0, Unit.INCH);
    assertThat(oneFoot,not(tenInches));
  }

  @Test
  public void shouldReturnTrueFor2InchesAnd5Centimetres() {
    Measurement fiveCentimetres = new Measurement(5.0, Unit.CENTIMETRES);
    Measurement twoInches = new Measurement(2.0, Unit.INCH);
    assertThat(fiveCentimetres,is(twoInches));
  }

  @Test
  public void shouldReturnFalseFor2CentimetresAnd2Inches() {
    Measurement twoInches = new Measurement(2.0, Unit.INCH);
    Measurement twoCentimetres = new Measurement(2, Unit.CENTIMETRES);
    assertThat(twoCentimetres,not(twoInches));
  }

  @Test
  public void shouldReturnTrueFor7Point8InchesAnd19Point5Centimetres() {
    Measurement sevenPoint8Inches = new Measurement(7.8, Unit.INCH);
    Measurement nineteenPoint5Centimetres = new Measurement(19.5, Unit.CENTIMETRES);
    assertThat(nineteenPoint5Centimetres,is(sevenPoint8Inches));
  }

  @Test
  public void shouldReturnTrueFor1CMAnd10MM() {
    Measurement tenMM = new Measurement(10, Unit.MILLIMETRES);
    Measurement oneCM = new Measurement(1, Unit.CENTIMETRES);
    assertThat(oneCM,is(tenMM));
  }

  @Test
  public void oneTonEquals1000KG() {
    Measurement thousandKG = new Measurement(1000, Unit.KILOGRAM);
    Measurement oneTon = new Measurement(1, Unit.TON);
    assertThat(thousandKG, is(oneTon));
  }

  @Test
  public void oneKGEquals1000G() {
    Measurement thousandG = new Measurement(1000, Unit.GRAM);
    Measurement oneKG = new Measurement(1, Unit.KILOGRAM);
    assertThat(oneKG, is(thousandG));
  }

  @Test
  public void oneGNotEquals1Litres() {
    Measurement oneG = new Measurement(1, Unit.GRAM);
    Measurement oneLitres = new Measurement(1, Unit.LITRES);
    assertThat(oneLitres, not(oneG));
    assertThat(oneG.hashCode(),not(oneLitres.hashCode()));
  }

  @Test
  public void oneTonEquals1000000G() {
    Measurement twoTons = new Measurement(2, Unit.TON);
    Measurement twoMillionGrams = new Measurement(2000000, Unit.GRAM);
    assertThat(twoTons,is(twoMillionGrams) );
  }

  @Test
  public void onePoint5KGEquals1500G() {
    Measurement onePoint5KG = new Measurement(1.5, Unit.KILOGRAM);
    Measurement oneThousand500G = new Measurement(1500, Unit.GRAM);
    assertThat(onePoint5KG,is(oneThousand500G));
  }

  @Test
  public void oneGallonIsOneGallon() {
    Measurement oneGallon = new Measurement(1, Unit.GALLON);
    Measurement anotherOneGallon = new Measurement(1, Unit.GALLON);
    assertThat(oneGallon, is(anotherOneGallon));
  }

  @Test
  public void oneLitreIsOneLitre() {
    Measurement oneLitre = new Measurement(1, Unit.LITRES);
    Measurement anotherOneLitre = new Measurement(1, Unit.LITRES);
    assertThat(oneLitre,is(anotherOneLitre));
  }

  @Test
  public void oneGallonIs3Point78Litres() {
    Measurement oneGallon = new Measurement(1, Unit.GALLON);
    Measurement threePoint78Litres = new Measurement(3.78, Unit.LITRES);
    assertThat(oneGallon, is(threePoint78Litres));
  }

  @Test
  public void oneLtAndOneCM() {
    Measurement oneCentimetre = new Measurement(1, Unit.CENTIMETRES);
    Measurement oneLitre = new Measurement(1, Unit.LITRES);
    assertThat(oneCentimetre,not(oneLitre) );
  }

  @Test
  public void shouldAddTwoMeasurementOf2And2Inches() {
    Measurement twoInches = new Measurement(2, Unit.INCH);
    Measurement anotherTwoInches = new Measurement(2, Unit.INCH);
    Measurement fourInches = new Measurement(4, Unit.INCH);
    assertThat(fourInches, is(twoInches.add(anotherTwoInches)));
  }

  @Test
  public void shouldAddTwoMeasurementOf5And3Inches() {
    Measurement fiveInches = new Measurement(5, Unit.INCH);
    Measurement threeInches = new Measurement(3, Unit.INCH);
    Measurement eightInches = new Measurement(8, Unit.INCH);
    assertThat(eightInches, is(fiveInches.add(threeInches)));
  }

  @Test
  public void shouldAddTwoMeasurementOf5FeetAnd3Inches() {
    Measurement fiveFeet = new Measurement(5, Unit.FEET);
    Measurement threeInches = new Measurement(3, Unit.INCH);
    Measurement sixty3Inches = new Measurement(63, Unit.INCH);
    assertThat(sixty3Inches, is(fiveFeet.add(threeInches)));
  }

  @Test
  public void shouldAdd5FeetAnd3InchesNotEqual6Feet() {
    Measurement fiveFeet = new Measurement(5, Unit.FEET);
    Measurement threeInches = new Measurement(3, Unit.INCH);
    Measurement threeFeet = new Measurement(6, Unit.FEET);
    assertThat(threeFeet, not(fiveFeet.add(threeInches)));
  }

  @Test
  public void shouldAddTwoMeasurementOf5KGAnd300Grams() {
    Measurement fiveKG = new Measurement(5, Unit.KILOGRAM);
    Measurement three100Grams = new Measurement(300, Unit.GRAM);
    Measurement fivePoint3KG = new Measurement(5.3, Unit.KILOGRAM);
    assertThat(fivePoint3KG, is(fiveKG.add(three100Grams)));
  }

  @Test
  public void shouldAdd2InchesAnd2Point5CM() {
    Measurement twoInches = new Measurement(2, Unit.INCH);
    Measurement twoPoint5CM = new Measurement(2.5, Unit.CENTIMETRES);
    Measurement threeInches = new Measurement(3, Unit.INCH);
    Measurement result = twoInches.add(twoPoint5CM);
    assertThat(threeInches, is(result));
    assertThat(threeInches.toString(), is(result.toUnit(Unit.INCH).toString()));
  }

  @Test(expected = TypeMismatchException.class)
  public void shouldNotAdd5KGAnd3Feet() {
    Measurement fiveKG = new Measurement(5, Unit.KILOGRAM);
    Measurement threeFeet = new Measurement(3, Unit.FEET);
    fiveKG.add(threeFeet);
  }

  @Test
  public void shouldAdd1GallonAnd1Litre() {
    Measurement oneGallon = new Measurement(1, Unit.GALLON);
    Measurement oneLitre = new Measurement(1, Unit.LITRES);
    Measurement fourPoint78Litres = new Measurement(4.78, Unit.LITRES);
    Measurement result = oneGallon.add(oneLitre);
    assertThat(result, is(fourPoint78Litres));
    assertThat(fourPoint78Litres.toString(), is(result.toUnit(Unit.LITRES).toString()));
  }

  @Test(expected = TypeMismatchException.class)
  public void shouldNotConvertUnitWhenTypeMismatch() {
    Measurement oneGallon = new Measurement(1, Unit.GALLON);
    Measurement oneLitre = new Measurement(1, Unit.LITRES);
    oneGallon.add(oneLitre).toUnit(Unit.KILOGRAM);
  }

  @Test
  public void hundredCShouldEqualTo212F() {
    Measurement twoHundred12F = new Measurement(212, Unit.FAHRENHEIT);
    Measurement hundredC = new Measurement(100, Unit.CELSIUS);
    assertEquals(twoHundred12F, hundredC);
  }

  @Test
  public void twoHundred12FShouldEqualHundredCelsius() {
    Measurement twoHundred12F = new Measurement(212, Unit.FAHRENHEIT);
    Measurement hundredC = new Measurement(100, Unit.CELSIUS);
    assertEquals(hundredC, twoHundred12F);
    assertEquals(hundredC.hashCode(), twoHundred12F.hashCode());
  }

  @Test
  public void hundredCShouldEqualHundredCelsius() {
    Measurement hundredC = new Measurement(100, Unit.CELSIUS);
    Measurement anotherHundredC = new Measurement(100, Unit.CELSIUS);
    assertEquals(anotherHundredC, hundredC);
  }

  @Test
  public void hundredFShouldEqualHundredF() {
    Measurement hundredF = new Measurement(100, Unit.FAHRENHEIT);
    Measurement anotherHundredF = new Measurement(100, Unit.FAHRENHEIT);
    assertEquals(hundredF, anotherHundredF);
    assertEquals(hundredF.hashCode(), anotherHundredF.hashCode());
  }
}
