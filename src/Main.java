import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * IMPORTANTE: Usar jdk 1.8.0_231
 */
public class Main {
    static HashMap<Integer, Persona> personas = new HashMap<>();
    static HashMap<Integer, Persona> personas2 = new HashMap<>();
    static List<Persona> resul = new ArrayList<>();

    static int max = 3;
    static int min = 0;

    public static void main(String[] args) {
        Persona p = new Persona((byte) 0, (byte) 0, "alonsocinco@gmail.com", "Alonso");
        Persona p1 = new Persona((byte) 0, (byte) 0, "alonsocl2001@gmail.com", "Hector");
        Persona p2 = new Persona((byte) 0, (byte) 0, "alonsikocasca@gmail.com", "Ruben");
        Persona p3 = new Persona((byte) 0, (byte) 0, "alonsocinco@gmail.com", "Sandra");

        personas.put(0, p);
        personas.put(1, p1);
        personas.put(2, p2);
        personas.put(3, p3);

        personas2.put(0, p);
        personas2.put(1, p1);
        personas2.put(2, p2);
        personas2.put(3, p3);
        int cont = 0;

        int rnd;
        // do {
        for (Map.Entry<Integer, Persona> entry : personas.entrySet()) {

            do {
                rnd = (int) (Math.random() * (max - min + 1) + min);
            } while (rnd == entry.getKey() || personas2.get(rnd).getElegido() == 1);

            Persona person = entry.getValue();//persona elegida
            // if (person.getElegido() == 0) {
            person.setCogido((byte) 1);//cambio el estado de cogido a 1
            // person.setElegido((byte) 1);//cambio el estado de elegido a 1

            int key = entry.getKey();
            // personas.remove(key);//elimino la persona de la lista
            personas2.remove(key);


            personas2.put(key, person);//reemplazo la persona

            Persona person2 = personas2.get(rnd);
            person2.setElegido((byte) 1);
            personas2.remove(rnd);//elimino la persona de la lista
            personas2.put(rnd, person2);//reemplazo la persona

            Persona persona = new Persona();
            persona.setCorreo(entry.getValue().getCorreo());
            persona.setNombre(personas2.get(rnd).getNombre());
            resul.add(persona);

            //break;//Porque no puedo iterar sobre un hash que estoy modificando java.util.ConcurrentModificationException
        }
        //}
        cont++;
        //}
        // while (cont < personas.size() - 1);

        //mosrtamos el resultado
        for (Persona persona : resul) {
            System.out.println(persona.getCorreo() + " " + persona.getNombre());
            CorreoElectronico cr = new CorreoElectronico(persona.getCorreo(), "Amigo invisible", persona.getNombre());
            cr.enviarConGMail();
            System.out.println("Correo enviado a " + persona.getCorreo());

        }

        /*//recorremos personas
        for (Map.Entry<Integer, Persona> entry : personas.entrySet()) {
            Persona persona = entry.getValue();
            System.out.println(persona.getCorreo() + " " + persona.getNombre());

        }*/


    }

}

