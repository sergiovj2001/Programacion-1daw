package tiempo;
import java.util.Scanner;
public class TestTiempo {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Tiempo t1 = new Tiempo(1,20,30);
    Tiempo t2 = new Tiempo(0,50,20);
    System.out.println("El intervalo de tiempo de t1 "+t1);
    System.out.println("El intervalo de tiempo de t2 "+t2);
    System.out.println("la suma de t1 y t2 " +t1.suma(t2));
    System.out.println("la resta de t1 y t2 " +t1.resta(t2));
    System.out.println("Introduce las horas que quieres "
        + "sumar a t1");
    int horas= s.nextInt();
    System.out.println("Introduce los minutos que quieres "
        + "sumar a t1");
    int minutos = s.nextInt();
    System.out.println("Introduce los segundos que quieres "
        + "sumar a t1");
    int segundos = s.nextInt();
    t1.suma(horas, minutos, segundos);
    System.out.println("El resultado " + t1.arregla());
    System.out.println("Introduce las horas que quieres "
        + "restar a t2");
    horas = s.nextInt();
    System.out.println("Introduce los minutos que quieres "
        + "restar a t2");
    minutos = s.nextInt();
    System.out.println("Introduce los segundos que quieres "
        + "restar a t2");
    segundos = s.nextInt();
    t2.resta(horas,minutos,segundos);
    System.out.println("El resultado " + t2.arregla());
  }

}
