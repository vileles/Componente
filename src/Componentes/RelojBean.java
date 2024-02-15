package Componentes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Calendar;
import java.util.EventListener;

import javax.swing.JLabel;
import javax.swing.Timer;

// Definición de la clase RelojBean que extiende JLabel e implementa Serializable y ActionListener
public class RelojBean extends JLabel implements ActionListener, Serializable {
    
    // Propiedades del componente
    private boolean formato24Horas;
    private boolean alarmaActivada;
    private int horaAlarma;
    private int minutosAlarma;
    private AlarmaListener listener;

    // Constructor
    public RelojBean() {
        // Inicialización de propiedades
        this.formato24Horas = true;
        this.alarmaActivada = false;
        
        // Inicializa el reloj y comienza a actualizar la hora cada segundo
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarHora();
            }
        });
        timer.start();
    }

    // Método para obtener el formato de 24 horas
    public boolean isFormato24Horas() {
        return formato24Horas;
    }

    // Método para establecer el formato de 24 horas
    public void setFormato24Horas(boolean formato24Horas) {
        this.formato24Horas = formato24Horas;
        actualizarHora();
    }

    // Método para verificar si la alarma está activada
    public boolean isAlarmaActivada() {
        return alarmaActivada;
    }

    // Método para establecer la alarma activada
    public void setAlarmaActivada(boolean alarmaActivada) {
        this.alarmaActivada = alarmaActivada;
    }

    // Método para obtener la hora de la alarma
    public int getHoraAlarma() {
        return horaAlarma;
    }

    // Método para establecer la hora de la alarma
    public void setHoraAlarma(int horaAlarma) {
        this.horaAlarma = horaAlarma;
    }

    // Método para obtener los minutos de la alarma
    public int getMinutosAlarma() {
        return minutosAlarma;
    }

    // Método para establecer los minutos de la alarma
    public void setMinutosAlarma(int minutosAlarma) {
        this.minutosAlarma = minutosAlarma;
    }       
    // Método para actualizar la hora del reloj
    private void actualizarHora() {
    
    // Obtiene la hora actual del sistema
    Calendar ahora = Calendar.getInstance();
    
    // Obtiene la hora y los minutos del sistema
    int hora = ahora.get(Calendar.HOUR_OF_DAY);
    int minuto = ahora.get(Calendar.MINUTE);

    // Si el formato no es de 24 horas y la hora es mayor a 12, se ajusta la hora
    if (!formato24Horas && hora > 12) {
        hora -= 12;
    }
    
    // Formatea la hora y los minutos para asegurar que tengan dos dígitos
    String horaStr = String.format("%02d", hora);
    String minutoStr = String.format("%02d", minuto);

    // Establece el texto del JLabel con la hora y los minutos formateados
    setText(horaStr + ":" + minutoStr);

    // Verifica si la alarma está activada y si coincide con la hora y los minutos actuales
    if (alarmaActivada && hora == horaAlarma && minuto == minutosAlarma) {
        // Si la alarma está activada y coincide con la hora y los minutos actuales, se lanza el evento de alarma
        lanzarEventoAlarma();
    }
}

    // Método para lanzar el evento de alarma
    private void lanzarEventoAlarma() {
        if (this.listener != null) {
            listener.alarmaOcurred(new AlarmaEvent(this));
            alarmaActivada = false;
        }
    }

    // Método de la interfaz ActionListener (aunque no está implementado)
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Interfaz para gestionar el evento de la alarma
    public interface AlarmaListener extends EventListener {
        void alarmaOcurred(AlarmaEvent evt);
    }

    // Método para añadir un listener de alarma
    public void addAlarmaListener(AlarmaListener listener) {
        this.listener = listener;
    }

    // Método para eliminar un listener de alarma
    public void removeAlarmaListener(AlarmaListener listener) {
        this.listener = null;
    }
}