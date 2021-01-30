package fecha;

public class TestFecha {

  public static void main(String[] args) {
    Fecha f1 = new Fecha(10, 12, 2022);
    Fecha f2 = new Fecha(1, 1, -2);
    if (f1.esCorrecta()) {
      System.out.println("La fecha " + f1 + " es correcta");
    } else {
      System.out.println("La fecha " + f1 + " no es correcta");
    }
    System.out
        .println("La suma de 2000 dias a la fecha " + f2 + " da la fecha " + f2.sumaNDia(2000));
    System.out
        .println("La resta de 1000 dias a la fecha " + f1 + " da la fecha " + f1.restaNDia(1000));
    System.out.println("voy a averiguar cual fecha es menor, "
        + "si sale un numero negativo es que la primera es menor");
    System.out.println("Si sale positivo es que es mayor" + " y si sale 0 es que son iguales");
    System.out.println("La fecha " + f1 +" es " +f1.compara(f2) + " Respecto a la fecha " + f2);
    if (f1.bisiesto()) {
      System.out.println("La fecha " + f1 + " es un año bisiesto");
    } else {
      System.out.println("La fecha " + f1 + " no es un año bisiesto");
    }
  }


}
