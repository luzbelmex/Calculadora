import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Calculadora extends JFrame {

    String datos = "";
    String operador = "";
    int cantidad1;
    int cantidad2;
    boolean reiniciar = false;
    boolean segundaCantidad = false;

    // Declaración de la pantalla de texto
    JTextField pantalla = new JTextField(datos);

    // Declaración de los botones
    JButton boton1 = new JButton("1");
    JButton boton2 = new JButton("2");
    JButton boton3 = new JButton("3");
    JButton boton4 = new JButton("4");
    JButton boton5 = new JButton("5");
    JButton boton6 = new JButton("6");
    JButton boton7 = new JButton("7");
    JButton boton8 = new JButton("8");
    JButton boton9 = new JButton("9");
    JButton boton0 = new JButton("0");
    JButton botonS1 = new JButton("+");
    JButton botonS2 = new JButton("-");
    JButton botonS3 = new JButton("*");
    JButton botonS4 = new JButton("/");
    JButton botonS5 = new JButton("C");
    JButton botonS6 = new JButton("=");

    Calculadora() {
        setTitle("Calculadora");
        setSize(380, 470);
        setLayout(null);

        // configuracion de la pantalla
        pantalla.setBounds(10, 10, 350, 50);
        pantalla.setEditable(false);

        // Agregar pantalla
        getContentPane().add(pantalla);

        // configuracion de los botones
        boton1.setBounds(10, 70, 80, 80);
        boton2.setBounds(100, 70, 80, 80);
        boton3.setBounds(190, 70, 80, 80);
        boton4.setBounds(10, 160, 80, 80);
        boton5.setBounds(100, 160, 80, 80);
        boton6.setBounds(190, 160, 80, 80);
        boton7.setBounds(10, 250, 80, 80);
        boton8.setBounds(100, 250, 80, 80);
        boton9.setBounds(190, 250, 80, 80);
        boton0.setBounds(100, 340, 80, 80);
        botonS1.setBounds(280, 70, 80, 80);
        botonS2.setBounds(280, 160, 80, 80);
        botonS3.setBounds(280, 250, 80, 80);
        botonS4.setBounds(280, 340, 80, 80);
        botonS5.setBounds(10, 340, 80, 80);
        botonS6.setBounds(190, 340, 80, 80);

        // Evento en los numeros
        EventoNumero EventoNumero = new EventoNumero();
        boton1.addActionListener(EventoNumero);
        boton2.addActionListener(EventoNumero);
        boton3.addActionListener(EventoNumero);
        boton4.addActionListener(EventoNumero);
        boton5.addActionListener(EventoNumero);
        boton6.addActionListener(EventoNumero);
        boton7.addActionListener(EventoNumero);
        boton8.addActionListener(EventoNumero);
        boton9.addActionListener(EventoNumero);
        boton0.addActionListener(EventoNumero);

        // Evento en los Operadores
        EventoOperador eventoOperador = new EventoOperador();
        botonS1.addActionListener(eventoOperador);
        botonS2.addActionListener(eventoOperador);
        botonS3.addActionListener(eventoOperador);
        botonS4.addActionListener(eventoOperador);
        botonS5.addActionListener(eventoOperador);
        botonS6.addActionListener(eventoOperador);

        // Agregar los botones
        getContentPane().add(boton1);
        getContentPane().add(boton2);
        getContentPane().add(boton3);
        getContentPane().add(boton4);
        getContentPane().add(boton5);
        getContentPane().add(boton6);
        getContentPane().add(boton7);
        getContentPane().add(boton8);
        getContentPane().add(boton9);
        getContentPane().add(boton0);
        getContentPane().add(botonS1);
        getContentPane().add(botonS2);
        getContentPane().add(botonS3);
        getContentPane().add(botonS4);
        getContentPane().add(botonS5);
        getContentPane().add(botonS6);
        setVisible(true);
        
        // Desactivar botones
        botonS5.setEnabled(false);
        botonS6.setEnabled(false);
        
    }
    
    public void bloquearBotonesOperadores (){
        botonS1.setEnabled(false);
        botonS2.setEnabled(false);
        botonS3.setEnabled(false);
        botonS4.setEnabled(false);
    }
    public void desbloquearBotonesOperadores (){
        botonS1.setEnabled(true);
        botonS2.setEnabled(true);
        botonS3.setEnabled(true);
        botonS4.setEnabled(true);
    }
    public void bloquearIgual(){
        botonS6.setEnabled(false);
    }
    public void desbloquearIgual(){
        botonS6.setEnabled(true);
    }
    public void bloquearC (){
        botonS5.setEnabled(false);
    }
    public void desbloquearC (){
        botonS5.setEnabled(true);
    }
    public void bloquearBotonesInteractivos (){
        botonS5.setEnabled(false);
        botonS6.setEnabled(false);
    }
    public void desbloquearBotonesInteractivos (){
        botonS5.setEnabled(true);
        botonS6.setEnabled(true);
    }

    public static void main(String[] args) {
        Calculadora e = new Calculadora();
    }

    public class EventoOperador implements ActionListener {

        Operaciones operar = new Operaciones();

        @Override
        public void actionPerformed(ActionEvent e) {

            switch (e.getActionCommand()) {
                case "+" -> {
                    operador = "+";
                    pantalla.setText(operador);
                    cantidad1 = Integer.parseInt(datos);
                    datos = "";
                    segundaCantidad = true;
                    bloquearBotonesOperadores();
                    desbloquearBotonesInteractivos();
                }
                case "-" -> {
                    operador = "-";
                    pantalla.setText(operador);
                    cantidad1 = Integer.parseInt(datos);
                    datos = "";
                    segundaCantidad = true;
                    bloquearBotonesOperadores();
                    desbloquearBotonesInteractivos();
                }
                case "/" -> {
                    operador = "/";
                    pantalla.setText(operador);
                    cantidad1 = Integer.parseInt(datos);
                    datos = "";
                    segundaCantidad = true;
                    bloquearBotonesOperadores();
                    desbloquearBotonesInteractivos();
                }
                case "*" -> {
                    operador = "*";
                    pantalla.setText(operador);
                    cantidad1 = Integer.parseInt(datos);
                    datos = "";
                    segundaCantidad = true;
                    bloquearBotonesOperadores();
                    desbloquearBotonesInteractivos();
                }
                case "C" -> {
                    operador = "";
                    datos = "";
                    cantidad1 = 0;
                    cantidad2 = 0;
                    pantalla.setText(datos);
                    bloquearBotonesOperadores();
                    bloquearBotonesInteractivos();
                }
                case "=" -> {

                    cantidad2 = Integer.parseInt(datos);
                    bloquearBotonesOperadores();
                    bloquearIgual();

                    switch (operador) {
                        case "+" -> {
                            int resultado = operar.sumar(cantidad1, cantidad2);
                            datos = String.valueOf(resultado);
                            pantalla.setText(datos);
                            segundaCantidad = true;
                        }
                        case "-" -> {
                            int resultado = operar.restar(cantidad1, cantidad2);
                            datos = String.valueOf(resultado);
                            pantalla.setText(datos);
                            segundaCantidad = true;
                        }
                        case "*" -> {
                            int resultado = operar.multiplicar(cantidad1, cantidad2);
                            datos = String.valueOf(resultado);
                            pantalla.setText(datos);
                            segundaCantidad = true;
                        }
                        case "/" -> {
                            if (cantidad1 % cantidad2 == 0) {
                                int resultado = operar.dividirInt(cantidad1, cantidad2);
                                datos = String.valueOf(resultado);
                                pantalla.setText(datos);
                            } else {
                                double resultado = operar.dividirDouble(Double.valueOf(cantidad1), Double.valueOf(cantidad2));
                                datos = String.valueOf(resultado);
                                pantalla.setText(datos);
                            }
                            segundaCantidad = true;
                        }
                    }

                    operador = "";
                    reiniciar = true;
                    segundaCantidad = false;
                    
                    botonS6.setEnabled(false);

                }
            }

        }
    }

    public class EventoNumero implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (datos != "0" || datos != "") {
                if (reiniciar) {
                    datos = e.getActionCommand();
                    pantalla.setText(datos);
                    reiniciar = false;
                    desbloquearC();
                    desbloquearBotonesOperadores();
                } else {
                    if(segundaCantidad){
                        datos += e.getActionCommand();
                        pantalla.setText(datos);
                        desbloquearIgual();
                    } else {
                        datos += e.getActionCommand();
                        pantalla.setText(datos);
                        desbloquearC();
                        desbloquearBotonesOperadores();
                    }
                }

            } else {
                datos = e.getActionCommand();
                pantalla.setText(datos);
                bloquearBotonesOperadores();
                
            }

        }
    }

    public class Operaciones {

        public int sumar(int c1, int c2) {
            return c1 + c2;
        }

        public int restar(int c1, int c2) {
            return c1 - c2;
        }

        public int multiplicar(int c1, int c2) {
            return c1 * c2;
        }

        public int dividirInt(int c1, int c2) {
            return c1 / c2;
        }

        public double dividirDouble(double c1, double c2) {
            return c1 / c2;
        }
    }

}
