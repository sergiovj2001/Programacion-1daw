package fraccion;

public class Fraccion {
  private int numerador;
  private int denominador;

  Fraccion(int numerador, int denominador) {
    this.numerador = numerador;
    this.denominador = denominador;
  }

  public String toString() {
    return "La fracción es: " + numerador + "/" + denominador;
  }

  public int getNumerador() {
    return numerador;
  }

  public void setNumerador(int numerador) {
    this.numerador = numerador;
  }

  public int getDenominador() {
    return denominador;
  }

  public void setDenominador(int denominador) {
    this.denominador = denominador;
  }

  public Fraccion cambiaobjeto(int num, int den) {
    if (den == 0) {
      System.err.println("El denominador no puede ser 0 ");
    } else {
      this.setNumerador(num);
      this.setDenominador(den);
    }
    return this;
  }

  public double resultado() {
    return (double) this.numerador/this.denominador;
  }

  public Fraccion multiplica(int multiplicador) {
    return  new Fraccion (this.numerador * multiplicador,this.denominador);
  }
  public Fraccion multiplica(Fraccion y) {
    return new Fraccion (this.numerador * y.numerador,this.denominador * y.denominador);
  }

  public Fraccion suma(Fraccion y) {
    return new Fraccion (this.numerador * y.denominador + this.denominador * 
        y.numerador, this.denominador * y.denominador);
  }

  public Fraccion resta(Fraccion y) {
    return new Fraccion (this.numerador * y.denominador - this.denominador * 
        y.numerador, this.denominador * y.denominador);
  }

  public Fraccion simplifica() {
    int num = Math.abs(numerador);
    int den = Math.abs(denominador);
    int r;
    while (den != 0) {
      r = num % den;
      num = den;
      den = r;
    }
    int n = num;
    numerador = numerador / n;
    denominador = denominador / n;
    return this;
  }
}
