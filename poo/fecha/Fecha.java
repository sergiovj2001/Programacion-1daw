package fecha;

/**
 * 
 * @author sergio Vera
 * 
 *         Crea una clase Fecha. Los objetos de la clase Fecha son fechas de tiempo y se crean de la
 *         forma:
 * 
 *         Fecha f = Fecha(1, 10, 2020); donde los parámetros que se le pasan al constructor son el
 *         día, el mes y el año respectivamente. Si la fecha creada es incorrecta mostraremos un
 *         mensaje de error en la salida estándar de errores (lo ideal sería lanzar una excepción,
 *         ya lo haremos cuando se vea en clase). Crea métodos para: Saber si la fecha almacenada es
 *         correcta. Sumar y restar días a la fecha. Comparar la fecha almacenada con otra, el
 *         método devolverá un valor negativo si la fecha almacenada es ANTERIOR a la otra, 0 si son
 *         IGUALES y un valor positivo si es POSTERIOR. Saber si el año de la fecha almacenada es
 *         bisiesto. El método toString() devuelve una cadena con el formato "<día del mes> de
 *         <nombre del mes> de <año>". Las opciones a partir de la segunda, solo se realizarán si la
 *         fecha almacenada es correcta, en caso de no serlo, se dará un aviso, por la salida
 *         estándar de errores, de que la operación no se puede realizar. Puedes usar una variable
 *         de clase para almacenar el número de días de cada mes del año (que no sea bisiesto).
 *
 */

public class Fecha {

  private int dias;
  private int meses;
  private int anyos;

  /**
   * @param dias
   * @param meses
   * @param anyos
   */
  public Fecha(int dias, int meses, int anyos) {
    setMeses(meses);
    setAnyos(anyos);
    setDias(dias);
  }

  /**
   * @return the dias
   */
  public int getDias() {
    return dias;
  }

  /**
   * @param dias the dias to set
   */
  public void setDias(int dias) {
    this.dias = dias;
    if (!esCorrecta()) {
      System.err.println("La fecha introducida es incorrecta");
    }
  }

  /**
   * @return the meses
   */
  public int getMeses() {
    return meses;
  }

  /**
   * @param meses the meses to set
   */
  public void setMeses(int meses) {
    if (meses > 0) {
      this.meses = meses;
    } else {
      System.err.println("No existen los meses negativos");
    }

  }

  /**
   * @return the anyos
   */
  public int getAnyos() {
    return anyos;
  }

  /**
   * @param anyos the anyos to set
   */
  public void setAnyos(int anyos) {
    this.anyos = anyos;
  }

  // Metodo que averigua si el año es bisiesto
  public boolean bisiesto() {
    return (this.anyos % 4 == 0 && (this.anyos % 100 != 0 || this.anyos % 400 == 0));
  }

  // metodo que contiene los nombres de cada mes
  private String nombreMes() {
    String[] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto",
        "septiembre", "octubre", "noviembre", "diciembre"};
    if (this.meses > 0 && this.meses <= 12) {
      return meses[this.meses - 1];
    } else {
      return "Mes_erroneo";
    }
  }

  // Metodo que contiene los dias de cada mes
  private int diasMes(int meses, int anyos) {
    int[] diasDelMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    if (meses == 2 && bisiesto()) {
      diasDelMes[1] = 29;
    }
    return diasDelMes[meses - 1];
  }

  // Metodo que comprueba si la fecha es correcta
  public boolean esCorrecta() {
    if (this.dias < 0 || this.dias > diasMes(this.meses, this.anyos)) {
      return false;
    }
    if (this.anyos == 0) {
      return false;
    }
    return (this.meses > 0 || this.meses < 12);
  }

  // Metodo toString para formateo de texto
  public String toString() {
    return this.dias + " de " + nombreMes() + " de " + this.anyos;
  }

  /*
   * Compara una fecha con otra y devuelve un -1 si la primera es menor un 1 si es mayor y un 0 si
   * son iguales
   */
  public int compara(Fecha f2) {
    if (this.anyos < f2.anyos) {
      return -1;
    }
    if (this.anyos > f2.anyos) {
      return 1;
    }
    if (this.anyos == f2.anyos) {
      if (this.meses < f2.meses) {
        return -1;
      }
      if (this.meses > f2.meses) {
        return 1;
      }
      if (this.meses == f2.meses) {
        if (this.dias < f2.dias) {
          return -1;
        }
        if (this.dias > f2.dias) {
          return 1;
        }
      }
    }
    return 0;
  }

  /*
   * Suma un dia, este metodo sirve de apoyo a sumaNDias
   */
  private Fecha suma1Dia() {
    this.dias++;
    if (this.dias > diasMes(this.meses, this.anyos)) {
      this.dias = 1;
      this.meses++;
      if (this.meses > 12) {
        this.meses = 1;
        this.anyos++;
      }
    }

    return this;
  }

  /*
   * Suma una cantidad de dias a elección
   */
  public Fecha sumaNDia(int numeroDeDias) {
    if (!esCorrecta()) {
      System.out.println("La fecha no es correcta y no se puede operar");
      return this;
    } else {
      for (int i = 0; i < numeroDeDias; i++) {
        suma1Dia();
      }
      return this;
    }
  }

  /*
   * Resta un dia, este metodo sirve de apoyo a restaNDias
   */
  private Fecha resta1Dia() {
    this.dias--;
    if (this.dias < 1) {
      this.dias = diasMes(this.meses, this.anyos);
      this.meses--;
      if (this.meses < 1) {
        this.meses = 12;
        this.anyos--;
        if (this.anyos == 0) {
          this.anyos = -1;
        }
      }

    }
    return this;

  }

  /*
   * Resta una cantidad de dias a elección
   */
  public Fecha restaNDia(int numeroDeDias) {
    if (!esCorrecta()) {
      System.out.println("La fecha no es correcta y no se puede operar");
    } else {
      for (int i = 0; i < numeroDeDias; i++) {
        resta1Dia();
      }
    }
    return this;
  }
}

