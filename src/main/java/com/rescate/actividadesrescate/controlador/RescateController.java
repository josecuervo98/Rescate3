
package com.rescate.actividadesrescate.controlador;

import com.rescate.actividadesrescate.modelo.BrigadaRescate;
import com.rescate.actividadesrescate.modelo.Categoria;
import com.rescate.actividadesrescate.modelo.EnumRescate;
import com.rescate.actividadesrescate.modelo.Rescate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
public class RescateController {

    @GetMapping("/")
    public String inicio(Model model) {


        Rescate r1 = crearRescate("Carlos", "Parque Arví", "Laura", 10);
        Rescate r2 = crearRescate("María", "Estación Industriales", "Pedro", 20);
        Rescate r3 = crearRescate("Andrés", "Cerro El Volador", "Ana", 30);
        Rescate r4 = crearRescate("Sofía", "Pueblito Paisa", "Luis", 40);
        Rescate r5 = crearRescate("Daniel", "Laureles", "Camila", 50);


        Stack<Rescate> pilaRescates = new Stack<>();
        pilaRescates.push(r1);
        pilaRescates.push(r2);
        pilaRescates.push(r3);
        pilaRescates.push(r4);
        pilaRescates.push(r5);


        List<Rescate> recorridoPila = new ArrayList<>();
        ListIterator<Rescate> listIterator = pilaRescates.listIterator();

        while (listIterator.hasNext()) {
            recorridoPila.add(listIterator.next());
        }


        Deque<Rescate> dequeConvertido = new ArrayDeque<>(pilaRescates);


        BrigadaRescate brigada = new BrigadaRescate(
                "Brigada Principal",
                "Medellín",
                EnumRescate.ACCIDENTE,
                Categoria.BOMBEROS
        );


        for (Rescate rescate : dequeConvertido) {
            brigada.agregarRescate(rescate);
        }


        List<Rescate> recorridoDeque = new ArrayList<>();
        Iterator<Rescate> iterator = brigada.getRescates().iterator();

        while (iterator.hasNext()) {
            recorridoDeque.add(iterator.next());
        }



        List<Rescate> filtrados = brigada.getRescates().stream()
                .filter(rescate ->
                        rescate.getTipoRescate() == EnumRescate.ACCIDENTE)
                .collect(Collectors.toList());


        Function<Rescate, Integer> sumarConteo =
                rescate -> rescate.getConteo()
                        .stream()
                        .mapToInt(Integer::intValue)
                        .sum();


        List<Integer> totalesApply = new ArrayList<>();

        for (Rescate rescate : pilaRescates) {
            totalesApply.add(sumarConteo.apply(rescate));
        }


        List<Integer> totales = new ArrayList<>();

        for (Rescate rescate : pilaRescates) {
            totales.add(rescate.verTotales(sumarConteo));
        }

        // Enviar los datos a la vista HTML
        model.addAttribute("brigada", brigada);
        model.addAttribute("pilaRescates", recorridoPila);
        model.addAttribute("recorridoDeque", recorridoDeque);
        model.addAttribute("filtrados", filtrados);
        model.addAttribute("totalesApply", totalesApply);
        model.addAttribute("totales", totales);

        return "rescates";
    }


    private Rescate crearRescate(
            String nombre,
            String ubicacion,
            String responsable,
            int numero) {

        Rescate rescate = new Rescate(
                nombre,
                ubicacion,
                responsable,
                EnumRescate.ACCIDENTE,
                Categoria.BOMBEROS
        );

        rescate.agregarConteo(numero);
        rescate.agregarConteo(numero + 1);
        rescate.agregarConteo(numero + 2);

        return rescate;
    }
}
