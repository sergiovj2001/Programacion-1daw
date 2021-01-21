package tiempo;

/**
 * 
 * @author sergio Vera Jurado
 * 
 * Los objetos de la clase Tiempo son intervalos de tiempo y 
 * se crean de la forma:
 * t = Tiempo(1, 20, 30)
 * donde los parámetros que se le pasan al constructor son las horas
 * los minutos y los segundos respectivamente. 
 * Crea métodos para:
 * Sumar y restar otro objeto de la clase Tiempo (el resultado es otro objeto).
 * Sumar y restar segundos, minutos y/o horas (se cambia el objeto actual).
 * Devolver una cadena con el tiempo almacenado, 
 * de forma que si lo que hay es (10 35 5) la cadena sea 10h 35m 5s.
 *
 */
public class Tiempo {
  private int horas;
  private int minutos;
  private int segundos;

  /**
   * @param horas
   * @param minutos
   * @param segundos
   */
  public Tiempo(int horas, int minutos, int segundos) {
    setHoras(horas);
    setMinutos(minutos);
    setSegundos(segundos);
  }

  /**
   * @return the horas
   */
  public int getHoras() {
    return horas;
  }

  /**
   * @param horas the horas to set
   */
  public void setHoras(int horas) {
    if (horas < 0) {
      System.err.println("Las horas no pueden ser negativas,esto causa un " 
      + "estado inconsistente");
    }
    this.horas = horas;
  }

  /**
   * @return the minutos
   */
  public int getMinutos() {
    return minutos;
  }

  /**
   * @param minutos the minutos to set
   */
  public void setMinutos(int minutos) {
    if (minutos < 0) {
      System.err.println("Los minutos no pueden ser negativos,esto causa un " 
      + "estado inconsistente");
    }
    this.minutos = minutos;
  }

  /**
   * @return the segundos
   */
  public int getSegundos() {
    return segundos;
  }

  /**
   * @param segundos the segundos to set
   */
  public void setSegundos(int segundos) {
    if (segundos < 0) {
      System.err.println("Los segundos no pueden ser negativos ,esto "
          + "causa un estado inconsistente");
    }
    this.segundos = segundos;
  }
  //Este metodo arregla los minutos y segundos para que sean posibles
  public Tiempo arregla() {
    while (this.minutos > 59) {
      this.minutos -= 60;
      this.horas++;
    }
    while (this.segundos > 59) {
      this.segundos -= 60;
      this.minutos++;
    }
    while (this.minutos < 0) {
      this.minutos += 59;
      this.horas--;
    }
    while (this.segundos < 0) {
      this.segundos += 59;
      this.minutos--;
    }
    return this;
  }
  //Suma de un objeto tiempo con otro
  public Tiempo suma(Tiempo t2) {
    Tiempo t3 = new Tiempo (this.horas + t2.horas , this.minutos + 
        t2.minutos, this.segundos + t2.segundos);
    t3.arregla();
    return t3;
  }
  //Resta de un objeto tiempo con otro
  public Tiempo resta(Tiempo t2) {
    Tiempo t4 = new Tiempo (this.horas - t2.horas , this.minutos - 
        t2.minutos, this.segundos - t2.segundos);
    t4.arregla();
    return t4;
  }
  //Suma de un objeto tiempo con una cantidad de horas minutos o segundos
  public void suma (int sumaHoras,int sumaMinutos,int sumaSegundos) {
    setHoras(horas+sumaHoras);
    setMinutos(minutos+sumaMinutos);
    setSegundos(segundos+sumaSegundos);
  }
  public String toString() {
    return " es de "+horas +" horas " +minutos
        +" minutos " +segundos + " segundos";
  }
  //resta de un objeto tiempo con una cantidad de horas minutos o segundos
  public void resta (int restaHoras,int restaMinutos,int restaSegundos) {
    restaHoras = (-restaHoras);
    restaMinutos = (-restaMinutos);
    restaSegundos = (-restaSegundos);
    this.suma(restaHoras,restaMinutos,restaSegundos);
  }
}
