package fraccion;

import java.util.Scanner;

public class TestFraccion {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.println("Introduce el numerador: ");
    int num = s.nextInt();

    System.out.println("Introduce el denominador: ");
    int den = s.nextInt();

    Fraccion x = new Fraccion(num, den);
    Fraccion y = new Fraccion(1, 4);

    System.out.println("ahora voy a mostrar la fracción que has introducido("
        + "a partir de ahora la llamaremos x cuando nos refiramos a ella):");
    System.out.println(x);

    System.out.println("Ahora vamos a modificar la fraccion 'y' que esta creada por defecto"
        + "(a partir de ahora la llamaremos x cuando nos refiramos a ella)");
    System.out.println(y);

    System.out.println("introduce el nuevo numerador:");

    num = s.nextInt();

    System.out.println("introduce el nuevo denominador:");
    den = s.nextInt();

    y.cambiaobjeto(num, den);

    if (den == 0) {
      System.out.println("No se puede dividir por cero");
    } else {
      y.setDenominador(den);
    }
    System.out.println("el resultado de la fracción"
        + " x es : " + x.resultado());

    System.out.println("¿Por cual numero quieres multiplicar la fracción y? :");
    int multiplicador = s.nextInt();
    System.out.println(y.multiplica(multiplicador));
    
    System.out.println("Ahora voy a multiplicar la fracción x con la y ");
    
    System.out.println("El resultado es: " +x.multiplica(y));

    System.out.println("Ahora voy a sumar la fracción x con la y : ");
    System.out.println("El resultado es: " +x.suma(y));


    System.out.println("Ahora voy a sumar la fracción x con la y : ");
    System.out.println(x.resta(y));

    System.out.println("La fracción x simplificada es :");
    x.simplifica();
    System.out.println(x);
  }
}
