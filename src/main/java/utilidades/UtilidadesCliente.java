package utilidades;

import modelos.Cliente;

public class UtilidadesCliente {


    /**
     * En la clase UtilidadesCliente hay que crear el siguiente método:
     * a. public boolean esDniValido(Cliente cliente).
     * El método devuelve true si el dni del cliente que se le pasa,
     * tiene 9 caracteres y de los cuáles los 8 primeros son números
     * y el último una letra, y devuelve false en caso contrario.
     */

    public boolean esDniValido(Cliente cliente){

        //9 elementos
        //8--> numeros
        //9--> letra

        String dni = cliente.getDni();

        boolean tiene9caracteres =  dni.length() == 9 ;
        boolean tiene8primerosNumeros = dni.substring(0, 7).matches("[0-9]");
        boolean tieneUltimoElementoLetra = dni.substring(8).matches("[A-Za-z]");


        return  tiene9caracteres && tiene8primerosNumeros && tieneUltimoElementoLetra;

    }

    public boolean esDniValido2Forma(Cliente cliente){
        String dni = cliente.getDni();

        int contador = 0;

        for(Character caracter : dni.toCharArray()){

            if(contador != 8 && !Character.isDigit(caracter)){
                return false;
            } else if (contador ==8  && !Character.isLetter(caracter)) {
                return false;
            }
            contador++;
        }

        return contador == 8;

    }

}
