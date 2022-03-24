import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * IMPORTANTE: Usar jdk 1.8.0_231
 */
public class Main {

    //HashMap de personas que participarán en el sorteo
    static HashMap<Integer, Persona> personas = new HashMap<>();
    static HashMap<Integer, Persona> personas2 = new HashMap<>();

    //ArrayList definitivo con la información de las personas que van a regalar y a quien
    static List<Persona> resul = new ArrayList<>();

    //El número máximo de personas es n-1 (En este caso, al haber 4 personas, el máximo es 3)
    static int max = 2;
    static int min = 0;

    public static void main(String[] args) {
        Persona p = new Persona((byte) 0, (byte) 0, "Email1", "Nombre1");
        Persona p1 = new Persona((byte) 0, (byte) 0, "Email2", "Nombre2");
        Persona p2 = new Persona((byte) 0, (byte) 0, "Email3", "Nombre3");
     //   Persona p3 = new Persona((byte) 0, (byte) 0, "Email4", "Nombre4");

        personas.put(0, p);
        personas.put(1, p1);
        personas.put(2, p2);
      //  personas.put(3, p3);

        personas2.put(0, p);
        personas2.put(1, p1);
        personas2.put(2, p2);
       // personas2.put(3, p3);

        int rnd;
        //Se recorre el mapa de personas
        for (Map.Entry<Integer, Persona> principal : personas.entrySet()) {

            /**El do while generará numeros aleatorios hasta que encuentre a una persona (principal) con una clave distinta al numero random
             * para que a principal se le asigne una persona distinta a principal
             *  o esa persona random no esté elegido por otra para regalar
            **/
            do {
                rnd = (int) (Math.random() * (max - min + 1) + min);//Genera números aleatorios entre el minimo y el maximo (0 y 3)
            } while (rnd == principal.getKey() || personas2.get(rnd).getElegido() == 1);

            //Persona principal elegida
            Persona person = principal.getValue();

            //Cambio el estado de cogido a 1 para que esta persona no pueda escoger a mas personas
            person.setCogido((byte) 1);

            //Se almacena la clave de principal
            int key = principal.getKey();

            //Se elimina la posición key del mapa de personas2 para actualizar sus valores
            //La persona del mapa personas y la persona que se elimina del mapa personas2 son las mismas
            personas2.remove(key);
            personas2.put(key, person);

            //Se almacena la persona random del mapa personas2
            Persona person2 = personas2.get(rnd);

            //Cambio el estado de elegido a 1 para que esta persona no pueda ser elegida por otra persona
            person2.setElegido((byte) 1);

            //Elimino la persona de la lista para actualizar sus valores
            personas2.remove(rnd);
            personas2.put(rnd, person2);

            Persona persona = new Persona();
            //Añado el correo de principal y el nombre de la persona a la que va a regalar
            persona.setCorreo(principal.getValue().getCorreo());
            persona.setNombre(personas2.get(rnd).getNombre());
            resul.add(persona);

          /*  System.out.println("PRINCIPAL");
            for (Map.Entry<Integer, Persona> principal3 : personas.entrySet()) {
                Persona person22 = principal3.getValue();

                System.out.println(person22.toString());



            }

            System.out.println("PRINCIPAL2");

            for (Map.Entry<Integer, Persona> principal4 : personas2.entrySet()) {
                Persona person22 = principal4.getValue();

                System.out.println(person22.toString());



            }*/

        }


        //mosrtamos el resultado
        for (Persona persona : resul) {
            System.out.println(persona.getCorreo() + " " + persona.getNombre());
            CorreoElectronico cr = new CorreoElectronico(persona.getCorreo(), "Amigo invisible", persona.getNombre());
            cr.enviarConGMail();
           System.out.println("Correo enviado a " + persona.getCorreo());

        }


    }

}

