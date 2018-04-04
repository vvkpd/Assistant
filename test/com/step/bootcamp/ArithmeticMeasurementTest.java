package com.step.bootcamp;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class ArithmeticMeasurementTest {
  @Test
  public void shouldReturnTrueFor1FootEquals1Foot() {
    ArithmeticMeasurement oneFoot = ArithmeticMeasurement.inFeet(1);
    ArithmeticMeasurement expectedFoot = ArithmeticMeasurement.inFeet(1);
    assertThat(oneFoot,is(expectedFoot));
    assertThat(oneFoot.hashCode(),is(expectedFoot.hashCode()));
  }

  @Test
  public void shouldReturnTrueFor1FootAnd12Inches() {
    ArithmeticMeasurement oneFoot = ArithmeticMeasurement.inFeet(1);
    ArithmeticMeasurement twelveInches = ArithmeticMeasurement.inInches(12.0);
    assertThat(oneFoot,is(twelveInches));
    assertThat(oneFoot.hashCode(),is(twelveInches.hashCode()));
  }

  @Test
  public void shouldReturnFalseFor1And10Inches() {
    ArithmeticMeasurement oneFoot = ArithmeticMeasurement.inFeet(0);
    ArithmeticMeasurement tenInches = ArithmeticMeasurement.inInches(10.0);
    assertThat(oneFoot,not(tenInches));
  }

  @Test
  public void shouldReturnTrueFor2InchesAnd5Centimetres() {
    ArithmeticMeasurement fiveCentimetres = ArithmeticMeasurement.inCentimetres(5.0);
    ArithmeticMeasurement twoInches = ArithmeticMeasurement.inInches(2.0);
    assertThat(fiveCentimetres,is(twoInches));
  }

  @Test
  public void shouldReturnFalseFor2CentimetresAnd2Inches() {
    ArithmeticMeasurement twoInches = ArithmeticMeasurement.inInches(2.0);
    ArithmeticMeasurement twoCentimetres = ArithmeticMeasurement.inCentimetres(2);
    assertThat(twoCentimetres,not(twoInches));
  }

  @Test
  public void shouldReturnTrueFor7Point8InchesAnd19Point5Centimetres() {
    ArithmeticMeasurement sevenPoint8Inches = ArithmeticMeasurement.inInches(7.8);
    ArithmeticMeasurement nineteenPoint5Centimetres = ArithmeticMeasurement.inCentimetres(19.5);
    assertThat(nineteenPoint5Centimetres,is(sevenPoint8Inches));
  }

  @Test
  public void shouldReturnTrueFor1CMAnd10MM() {
    ArithmeticMeasurement tenMM = ArithmeticMeasurement.inMillimetres(10);
    ArithmeticMeasurement oneCM = ArithmeticMeasurement.inCentimetres(1);
    assertThat(oneCM,is(tenMM));
  }

  @Test
  public void oneTonEquals1000KG() {
    ArithmeticMeasurement thousandKG = ArithmeticMeasurement.inKilograms(1000);
    ArithmeticMeasurement oneTon = ArithmeticMeasurement.inTons(1);
    assertThat(thousandKG, is(oneTon));
  }

  @Test
  public void oneKGEquals1000G() {
    ArithmeticMeasurement thousandG = ArithmeticMeasurement.inGrams(1000);
    ArithmeticMeasurement oneKG = ArithmeticMeasurement.inKilograms(1);
    assertThat(oneKG, is(thousandG));
  }

  @Test
  public void oneGNotEquals1Litres() {
    ArithmeticMeasurement oneG = ArithmeticMeasurement.inGrams(1);
    ArithmeticMeasurement oneLitres = ArithmeticMeasurement.inLitres(1);
    assertThat(oneLitres, not(oneG));
    assertThat(oneG.hashCode(),not(oneLitres.hashCode()));
  }

  @Test
  public void oneTonEquals1000000G() {
    ArithmeticMeasurement twoTons = ArithmeticMeasurement.inTons(2);
    ArithmeticMeasurement twoMillionGrams = ArithmeticMeasurement.inGrams(2000000);
    assertThat(twoTons,is(twoMillionGrams) );
  }

  @Test
  public void onePoint5KGEquals1500G() {
    ArithmeticMeasurement onePoint5KG = ArithmeticMeasurement.inKilograms(1.5);
    ArithmeticMeasurement oneThousand500G = ArithmeticMeasurement.inGrams(1500);
    assertThat(onePoint5KG,is(oneThousand500G));
  }

  @Test
  public void oneGallonIsOneGallon() {
    ArithmeticMeasurement oneGallon = ArithmeticMeasurement.inGallons(1);
    ArithmeticMeasurement anotherOneGallon = ArithmeticMeasurement.inGallons(1);
    assertThat(oneGallon, is(anotherOneGallon));
  }

  @Test
  public void oneLitreIsOneLitre() {
    ArithmeticMeasurement oneLitre = ArithmeticMeasurement.inLitres(1);
    ArithmeticMeasurement anotherOneLitre = ArithmeticMeasurement.inLitres(1);
    assertThat(oneLitre,is(anotherOneLitre));
  }

  @Test
  public void oneGallonIs3Point78Litres() {
    ArithmeticMeasurement oneGallon = ArithmeticMeasurement.inGallons(1);
    ArithmeticMeasurement threePoint78Litres = ArithmeticMeasurement.inLitres(3.78);
    assertThat(oneGallon, is(threePoint78Litres));
  }

  @Test
  public void oneLtAndOneCM() {
    ArithmeticMeasurement oneCentimetre = ArithmeticMeasurement.inCentimetres(1);
    ArithmeticMeasurement oneLitre = ArithmeticMeasurement.inLitres(1);
    assertThat(oneCentimetre,not(oneLitre) );
  }

  @Test
  public void shouldAddTwoMeasurementOf2And2Inches() {
    ArithmeticMeasurement twoInches = ArithmeticMeasurement.inInches(2);
    ArithmeticMeasurement anotherTwoInches = ArithmeticMeasurement.inInches(2);
    ArithmeticMeasurement fourInches = ArithmeticMeasurement.inInches(4);
    assertThat(fourInches, is(twoInches.add(anotherTwoInches)));
  }

  @Test
  public void shouldAddTwoMeasurementOf5And3Inches() {
    ArithmeticMeasurement fiveInches = ArithmeticMeasurement.inInches(5);
    ArithmeticMeasurement threeInches = ArithmeticMeasurement.inInches(3);
    ArithmeticMeasurement eightInches = ArithmeticMeasurement.inInches(8);
    assertThat(eightInches, is(fiveInches.add(threeInches)));
  }

  @Test
  public void shouldAddTwoMeasurementOf5FeetAnd3Inches() {
    ArithmeticMeasurement fiveFeet = ArithmeticMeasurement.inFeet(5);
    ArithmeticMeasurement threeInches = ArithmeticMeasurement.inInches(3);
    ArithmeticMeasurement sixty3Inches = ArithmeticMeasurement.inInches(63);
    assertThat(sixty3Inches, is(fiveFeet.add(threeInches)));
  }

  @Test
  public void shouldAdd5FeetAnd3InchesNotEqual6Feet() {
    ArithmeticMeasurement fiveFeet = ArithmeticMeasurement.inFeet(5);
    ArithmeticMeasurement threeInches = ArithmeticMeasurement.inInches(3);
    ArithmeticMeasurement threeFeet = ArithmeticMeasurement.inFeet(6);
    assertThat(threeFeet, not(fiveFeet.add(threeInches)));
  }

  @Test
  public void shouldAddTwoMeasurementOf5KGAnd300Grams() {
    ArithmeticMeasurement fiveKG = ArithmeticMeasurement.inKilograms(5);
    ArithmeticMeasurement three100Grams = ArithmeticMeasurement.inGrams(300);
    ArithmeticMeasurement fivePoint3KG = ArithmeticMeasurement.inKilograms(5.3);
    assertThat(fivePoint3KG, is(fiveKG.add(three100Grams)));
  }

  @Test
  public void shouldAdd2InchesAnd2Point5CM() {
    ArithmeticMeasurement twoInches = ArithmeticMeasurement.inInches(2);
    ArithmeticMeasurement twoPoint5CM = ArithmeticMeasurement.inCentimetres(2.5);
    ArithmeticMeasurement threeInches = ArithmeticMeasurement.inInches(3);
    ArithmeticMeasurement result = twoInches.add(twoPoint5CM);
    assertThat(threeInches, is(result.toUnit(Unit.INCH)));
    assertThat(threeInches.toString(), is(result.toUnit(Unit.INCH).toString()));
  }

  @Test(expected = TypeMismatchException.class)
  public void shouldNotAdd5KGAnd3Feet() {
    ArithmeticMeasurement fiveKG = ArithmeticMeasurement.inKilograms(5);
    ArithmeticMeasurement threeFeet = ArithmeticMeasurement.inFeet(3);
    fiveKG.add(threeFeet);
  }

  @Test
  public void shouldAdd1GallonAnd1Litre() {
    ArithmeticMeasurement oneGallon = ArithmeticMeasurement.inGallons(1);
    ArithmeticMeasurement oneLitre = ArithmeticMeasurement.inLitres(1);
    ArithmeticMeasurement fourPoint78Litres = ArithmeticMeasurement.inLitres(4.78);
    ArithmeticMeasurement result = oneGallon.add(oneLitre);
    assertThat(result, is(fourPoint78Litres));
    assertThat(fourPoint78Litres.toString(), is(result.toUnit(Unit.LITRES).toString()));
    assertThat(fourPoint78Litres, is(result.toUnit(Unit.GALLON)));
  }

  @Test(expected = TypeMismatchException.class)
  public void shouldNotConvertUnitWhenTypeMismatch() {
    ArithmeticMeasurement oneGallon = ArithmeticMeasurement.inGallons(1);
    ArithmeticMeasurement oneLitre = ArithmeticMeasurement.inLitres(1);
    oneGallon.add(oneLitre).toUnit(Unit.KILOGRAM);
  }
}
