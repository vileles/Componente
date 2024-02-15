package Componentes;

import java.io.Serializable;
import java.util.EventObject;

// Clase que representa un evento de alarma
public class AlarmaEvent extends EventObject {
    // Constructor que recibe el origen del evento
    public AlarmaEvent(Object source) {
        // Llama al constructor de la clase base con el origen del evento
        super(source);
    }
}
