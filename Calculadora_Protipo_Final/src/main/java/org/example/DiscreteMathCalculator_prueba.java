package org.example;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JOptionPane;
import org.mariuszgromada.math.mxparser.*;
public class DiscreteMathCalculator_prueba extends JFrame implements ActionListener {
    private final JComboBox<String> comboBox;
    private final JButton button;
    public DiscreteMathCalculator_prueba() {
        setTitle("Calculadora de Matemáticas Discretas v.2");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // Crear el menú desplegable con las opciones, y dejarlo en la parte superior de la ventana, al lado del botón
        String [] options = {"Seleccione una opción", "Compuertas Lógicas", "Álgebra Booleana", "Teoría de Conjuntos", "Relaciones y Funciones", "Propiedades de Lógica Proposicional", "Expresión Booleana en tabla"};
        comboBox = new JComboBox<>(options);
        comboBox.setBounds(150, 50, 200, 30);
        add(comboBox);
        // Crear el botón
        button = new JButton("Calcular");
        //Dejarlo al lado del menú desplegable
        button.setBounds(150, 100, 200, 30);
        button.addActionListener(this);
        add(button);
        setVisible(true);
    }
    public static void main(String[] args) {
        DiscreteMathCalculator_prueba calculator = new DiscreteMathCalculator_prueba();
    }
    public void actionPerformed(ActionEvent e) {
        int option = comboBox.getSelectedIndex();
        switch(option) {
            case 0:
                JOptionPane.showMessageDialog(this, "Por favor, seleccione una opción del menú.", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            case 1:
                calcularCompuertasLogicas();
                break;
            case 2:
                calcularAlgebraBooleana();
                break;
            case 3:
                calcularTeoriaDeConjuntos();
                break;
            case 4:
                calcularRelacionesYFunciones();
                break;
            case 5:
                calcularPropiedadesDeLogicaProposicional();
                break;
            case 6:
                expresión_booleanaTABLA();
                break;
        }
    }
    public void calcularCompuertasLogicas() {
        JOptionPane.showMessageDialog(this, "Compuertas Lógicas seleccionado.");
        Scanner input = new Scanner(System.in);
        JOptionPane.showMessageDialog(this, "Ingrese las entradas para las compuertas lógicas:");
        boolean entradaA = Boolean.parseBoolean(JOptionPane.showInputDialog(this, "Entrada A: "));
        boolean entradaB = Boolean.parseBoolean(JOptionPane.showInputDialog(this, "Entrada B: "));
        boolean and = entradaA && entradaB;
        boolean or = entradaA || entradaB;
        boolean notA = !entradaA;
        boolean notB = !entradaB;
        boolean xor = entradaA ^ entradaB;
        boolean nand = !(entradaA && entradaB);
        boolean nor = !(entradaA || entradaB);
        JOptionPane.showMessageDialog(this, "Resultados:");
        JOptionPane.showMessageDialog(this, "Tabla de Verdad \n");
        JOptionPane.showMessageDialog(this, "| A | B | AND | OR | NOT A | NOT B | XOR | \n"+ entradaA+ "| " +entradaB+ " | " +and+ " | " +or+ " | " +notA+ " | " +notB+ " |" +xor+"| \n"+entradaA+ "| " + (!entradaB)+ " | " +(entradaA && !entradaB)+ " | " + (entradaA || !entradaB)+ " | " + notA+ " | " + entradaB+ " | " + (entradaA ^ !entradaB)+"| \n"+(!entradaA)+ " | " + entradaB+ " | " + (!entradaA && entradaB)+ " | " + (!entradaA || entradaB)+ " | " + entradaA+ " | " + notB+ " | " +(!entradaA ^ entradaB)+"| \n"+(!entradaA)+ " | " + (!entradaB)+ " | " + (!entradaA && !entradaB)+ " | " + (!entradaA || !entradaB)+ " | " + entradaA+ " | " + entradaB+ " | " +(!entradaA ^ !entradaB));
        JOptionPane.showMessageDialog(this, "NAND: " + nand+"\n" + "NOR: " + nor);
    }
    public void calcularAlgebraBooleana() {
        JOptionPane.showMessageDialog(this, "Álgebra Booleana seleccionado.");
        Scanner input = new Scanner(System.in);
        JOptionPane.showMessageDialog(this, "Ingrese las entradas para álgebra booleana:");
        boolean entradaA = Boolean.parseBoolean(JOptionPane.showInputDialog(this, "Entrada A: "));
        boolean entradaB = Boolean.parseBoolean(JOptionPane.showInputDialog(this, "Entrada B: "));
        boolean entradaC = Boolean.parseBoolean(JOptionPane.showInputDialog(this, "Entrada C: "));
        boolean demorgan1 = !(entradaA && entradaB) == (!entradaA || !entradaB);
        boolean demorgan2 = !(entradaA || entradaB) == (!entradaA && !entradaB);
        boolean absorcion1 = (entradaA && (entradaA || entradaB)) == entradaA;
        boolean absorcion2 = (entradaA || (entradaA && entradaB)) == entradaA;
        JOptionPane.showMessageDialog(this, "Leyes de De Morgan");
        JOptionPane.showMessageDialog(this, "!(A && B) == !A || !B: " + demorgan1);
        JOptionPane.showMessageDialog(this, "!(A || B) == !A && !B: " + demorgan2);
        JOptionPane.showMessageDialog(this, "Leyes de Absorción");
        JOptionPane.showMessageDialog(this, "A && (A || B) == A: " + absorcion1);
        JOptionPane.showMessageDialog(this, "A || (A && B) == A: " + absorcion2);
    }

    public void calcularTeoriaDeConjuntos() {
        JOptionPane.showMessageDialog(this, "Teoría de Conjuntos seleccionado.");
        Scanner input = new Scanner(System.in);
        JOptionPane.showMessageDialog(this, "Ingrese los conjuntos A y B separados por comas:");
        String conjuntoA = JOptionPane.showInputDialog(this, "Conjunto A: ");
        String conjuntoB = JOptionPane.showInputDialog(this, "Conjunto B: ");
        Set<Integer> setA = new HashSet<Integer>();
        Set<Integer> setB = new HashSet<Integer>();
        for (String s : conjuntoA.split(",")) {
            setA.add(Integer.parseInt(s));
        }
        for (String s : conjuntoB.split(",")) {
            setB.add(Integer.parseInt(s));
        }
        Set<Integer> union = new HashSet<Integer>(setA);
        union.addAll(setB);
        Set<Integer> interseccion = new HashSet<Integer>(setA);
        interseccion.retainAll(setB);
        Set<Integer> complementoA = new HashSet<Integer>(setB);
        complementoA.removeAll(setA);
        Set<Integer> complementoB = new HashSet<Integer>(setA);
        complementoB.removeAll(setB);
        Set<Integer> diferenciaAB = new HashSet<Integer>(setA);
        diferenciaAB.removeAll(setB);
        Set<Integer> diferenciaBA = new HashSet<Integer>(setB);
        diferenciaBA.removeAll(setA);
        JOptionPane.showMessageDialog(this, "Teoría de Conjuntos");
        JOptionPane.showMessageDialog(this, "Unión: " + union);
        JOptionPane.showMessageDialog(this, "Intersección: " + interseccion);
        JOptionPane.showMessageDialog(this, "Complemento de A en B: " + complementoA);
        JOptionPane.showMessageDialog(this, "Complemento de B en A: " + complementoB);
        JOptionPane.showMessageDialog(this, "Diferencia A - B: " + diferenciaAB);
        JOptionPane.showMessageDialog(this, "Diferencia B - A: " + diferenciaBA);
        input.close();
    }
    public void calcularRelacionesYFunciones() {
        JOptionPane.showMessageDialog(this, "Relaciones y Funciones seleccionado.");
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el número de pares: "));
        int[][] relacion = new int[n][2];
        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el par " + (i+1) + " (x): "));
            int y = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el par " + (i+1) + " (y): "));
            relacion[i][0] = x;
            relacion[i][1] = y;
        }
        int minDomain = relacion[0][0];
        int maxDomain = relacion[0][0];
        int minRange = relacion[0][1];
        int maxRange = relacion[0][1];
        for(int i = 0; i < relacion.length; i++) {
            if(relacion[i][0] < minDomain) {
                minDomain = relacion[i][0];
            }
            if(relacion[i][0] > maxDomain) {
                maxDomain = relacion[i][0];
            }
            if(relacion[i][1] < minRange) {
                minRange = relacion[i][1];
            }
            if(relacion[i][1] > maxRange) {
                maxRange = relacion[i][1];
            }
        }
        JOptionPane.showMessageDialog(this, "Dominio: [" + minDomain + ", " + maxDomain + "]");
        JOptionPane.showMessageDialog(this, "Rango: [" + minRange + ", " + maxRange + "]");
        boolean injective = true;
        for(int i = 0; i < relacion.length; i++) {
            int[] currPair = relacion[i];
            for(int j = i+1; j < relacion.length; j++) {
                int[] nextPair = relacion[j];
                if(currPair[0] == nextPair[0] && currPair[1] != nextPair[1]) {
                    injective = false;
                    break;
                }
            }
            if(!injective) {
                break;
            }
        }
        JOptionPane.showMessageDialog(this, "Inyectiva: " + (injective ? "yes" : "no"));
        boolean surjective = true;
        for(int i = minRange; i <= maxRange; i++) {
            boolean found = false;
            for(int j = 0; j < relacion.length; j++) {
                if(relacion[j][1] == i) {
                    found = true;
                    break;
                }
            }
            if(!found) {
                surjective = false;
                break;
            }
        }
        JOptionPane.showMessageDialog(this, "Sobreyectiva: " + (surjective ? "yes" : "no"));
        JOptionPane.showMessageDialog(this, "Biyectividad: " + (injective && surjective ? "yes" : "no"));
    }
    public void  calcularPropiedadesDeLogicaProposicional(){
        JOptionPane.showMessageDialog(this, "Propiedades De Logica Proposicional seleccionado.");
        Scanner input = new Scanner(System.in);
        String formula = JOptionPane.showInputDialog(this, "Ingrese una fórmula lógica en notación polaca inversa (por ejemplo, A B &&): ");
        formula = formula.replaceAll("[^\\w\\s]", "");
        String[] simbolos = formula.split("\\s+");
        Stack<Boolean> stack = new Stack<>();
        for (String simbolo : simbolos) {
            if (simbolo.matches("[A-Z]")) {
                boolean valor = Boolean.parseBoolean(JOptionPane.showInputDialog(this, "Ingrese el valor de la variable " + simbolo + ": "));
                stack.push(valor);
            } else {
                boolean valor2 = stack.pop();
                boolean valor1 = stack.pop();
                boolean resultado = false;
                switch (simbolo) {
                    case "&&":
                        resultado = valor1 && valor2; // && = AND
                        break;
                    case "||":
                        resultado = valor1 || valor2; // || = OR
                        break;
                    case "->":
                        resultado = !valor1 || valor2; // -> = IMPLICA
                        break;
                    case "<->":
                        resultado = valor1 == valor2;   // <-> = EQUIVALENCIA
                        break;
                    case "!":
                        resultado = !valor1; // ! = NEGACIÓN
                        break;
                }
                stack.push(resultado);
            }
        }
        JOptionPane.showMessageDialog(this, "Resultado: " + stack.pop());
        input.close();
    }
    public void expresión_booleanaTABLA(){
        boolean isCallSuccessful = License.iConfirmNonCommercialUse("John Doe");
        boolean isConfirmed = License.checkIfUseTypeConfirmed();
        String message = License.getUseTypeConfirmationMessage();
        JOptionPane.showMessageDialog(this, "Expresión Booleana en Tabla seleccionado.");
        String expression = String.valueOf(JOptionPane.showInputDialog(this, "Ingrese la expresión booleana (* es AND, + es OR, - es XOR, ' es NOT, -> es IMPLICA, <-> es EQUIVALENTE) "));
        List<String> variables = getVariables(expression);
        int numVariables = variables.size();
        int numRows = (int) Math.pow(2, numVariables);
        boolean[][] truthTable = new boolean[numRows][numVariables];
        for (int i = 0; i < numRows; i++) {
            String binary = String.format("%" + numVariables + "s", Integer.toBinaryString(i)).replace(' ', '0');
            for (int j = 0; j < numVariables; j++) {
                truthTable[i][j] = binary.charAt(j) != '0';
            }
        }
        StringBuilder tableBuilder = new StringBuilder();
        tableBuilder.append(expression).append("\n");
        for (String variable : variables) {
            tableBuilder.append(variable).append("   ");
        }
        tableBuilder.append("Resultado\n");
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numVariables; j++) {
                tableBuilder.append(truthTable[i][j]).append("   ");
            }
            boolean result = evaluateExpression(expression, variables, truthTable[i]);
            tableBuilder.append(result).append("\n");
        }
        JOptionPane.showMessageDialog(this, tableBuilder.toString());
    }
    private static List<String> getVariables(String expression) {
        List<String> variables = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (Character.isLetter(c)) {
                String variable = Character.toString(c);
                if (!variables.contains(variable)) {
                    variables.add(variable);
                }
            }
        }
        return variables;
    }
    private static boolean evaluateExpression(String expression, List<String> variables, boolean[] values) {
        for (int i = 0; i < variables.size(); i++) {
            String variable = variables.get(i);
            String regex = "(?<![a-zA-Z])" + variable + "(?![a-zA-Z])";
            String value = Boolean.toString(values[i]);
            expression = expression.replaceAll(regex, value);
        }
        return new Expression(expression).calculate() == 1;
    }
}