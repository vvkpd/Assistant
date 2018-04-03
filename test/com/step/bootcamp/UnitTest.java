package com.step.bootcamp;

import org.junit.Test;

import static com.step.bootcamp.Unit.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UnitTest{
  @Test
  public void oneFootShouldReturn30Centimetres() {
    double thirtyCM = 30.0;
    int oneFoot = 1;
    assertThat(FEET.toUnit(oneFoot, CENTIMETRES),is(thirtyCM));
  }

  @Test
  public void twoPoint5FeetShouldReturn75Centimetres() {
    double twoPoint5Feet = 2.5;
    double seventyFiveCM = 75.0;
    assertThat(FEET.toUnit(twoPoint5Feet,CENTIMETRES),is(seventyFiveCM));
  }

  @Test
  public void oneInchShouldReturn2Point5Centimetres() {
    double oneInch = 1;
    double twoPoint5CM = 2.5;
    assertThat(INCH.toUnit(oneInch,CENTIMETRES),is(twoPoint5CM));
  }

  @Test
  public void twoPoint5InchShouldReturn6Point25Centimetres() {
    double twoPoint5Inch = 2.5;
    double sixPoint25CM = 6.25;
    assertThat(INCH.toUnit(twoPoint5Inch,CENTIMETRES),is(sixPoint25CM));
  }

  @Test
  public void oneCentimetreShouldReturn1Centimetre() {
    double oneCM = 1;
    double anotherOneCM = 1.0;
    assertThat(CENTIMETRES.toUnit(oneCM,CENTIMETRES),is(anotherOneCM));
  }

  @Test
  public void threeInchesShouldReturn7Point5Centimetres() {
    double threeInch = 3;
    double sevenPoint5CM = 7.5;
    assertThat(INCH.toUnit(threeInch,CENTIMETRES),is(sevenPoint5CM));
  }

  @Test
  public void tenMMShouldReturn1CM() {
    double tenMM = 10;
    double oneCM = 1.0;
    assertThat(MILLIMETRES.toUnit(tenMM,CENTIMETRES),is(oneCM));
  }

  @Test
  public void shouldReturn3point78For1Litre() {
    double oneGallon = 1;
    double threePoint78Litres = 3.78;
    assertThat(GALLON.toUnit(oneGallon,LITRES),is(threePoint78Litres));
  }

  @Test
  public void oneLitreShouldReturn1Litre() {
    double oneLitre = 1;
    double anotherOneLitre = 1.0;
    assertThat(LITRES.toUnit(oneLitre,LITRES),is(anotherOneLitre) );
  }
}
