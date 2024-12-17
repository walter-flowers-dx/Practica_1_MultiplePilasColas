package Ejercicio_5;
public class Principal {
    public static void main(String[] args) {
        ColaSimpleTareas colaTareas = new ColaSimpleTareas();
        PilaCoCirRecursos pilaRecursosInforme = new PilaCoCirRecursos();
        ColaCircularRecursos recursosInforme = new ColaCircularRecursos();
        recursosInforme.adi(new Recursos("desarrollador", "humano", 2));
        recursosInforme.adi(new Recursos("computadora", "material", 2));
        pilaRecursosInforme.adi(recursosInforme);

        PilaCoCirRecursos pilaRecursosActualizar = new PilaCoCirRecursos();
        ColaCircularRecursos recursosActualizar = new ColaCircularRecursos();
        recursosActualizar.adi(new Recursos("analista", "humano", 2));
        recursosActualizar.adi(new Recursos("análisis", "material", 1));
        pilaRecursosActualizar.adi(recursosActualizar);

        PilaCoCirRecursos pilaRecursosSprint = new PilaCoCirRecursos();
        ColaCircularRecursos recursosSprint = new ColaCircularRecursos();
        recursosSprint.adi(new Recursos("Pizarra", "material", 1));
        recursosSprint.adi(new Recursos("Documentación", "material", 1));
        pilaRecursosSprint.adi(recursosSprint);

        Tareas tarea1 = new Tareas("Informe Errores", "5", "Analizar sistema", pilaRecursosInforme);
        Tareas tarea2 = new Tareas("Actualizar sistema", "8", "Hacer modificaciones", pilaRecursosActualizar);
        Tareas tarea3 = new Tareas("Planificar Sprint", "9", "Organizar equipo", pilaRecursosSprint);

        colaTareas.adi(tarea1);
        colaTareas.adi(tarea2);
        colaTareas.adi(tarea3);

        colaTareas.mostrar();

        System.out.println("a) Verificar si en la tarea con nombre X se usa un recurso de tipo “humano”.");
        verificarRecursoHumano(colaTareas, "Actualizar sistema");

        System.out.println("c) Determinar la tarea con mayor prioridad y cuántos recursos \"materiales\" tiene.");
        tareaMayorPrioridadRecursosMateriales(colaTareas);
    }
    // c)
    public static void tareaMayorPrioridadRecursosMateriales(ColaSimpleTareas colaTareas) {
        ColaSimpleTareas aux = new ColaSimpleTareas();
        Tareas tareaMayorPrioridad = null;
        int maxPrioridad = -1; 

        // Encontrar la tarea de mayor prioridad
        while (!colaTareas.esVacia()) {
            Tareas tarea = colaTareas.eli();  
            int prioridadActual = Integer.parseInt(tarea.getPrioridad());
           
            if (prioridadActual > maxPrioridad) {
                tareaMayorPrioridad = tarea;
                maxPrioridad = prioridadActual;
            }

            aux.adi(tarea);  // Almacenar la tarea en la cola auxiliar
        }

        // Restaurar la cola original
        while (!aux.esVacia()) {
            colaTareas.adi(aux.eli());
        }

        // Si hay una tarea con mayor prioridad
        if (tareaMayorPrioridad != null) {
            PilaCoCirRecursos pilaRecursos = tareaMayorPrioridad.getPilaRecursos();
            int recursosMateriales = 0;

            // Contar los recursos materiales
            PilaCoCirRecursos auxPila = new PilaCoCirRecursos();
            while (!pilaRecursos.esVacia()) {
                ColaCircularRecursos recursos = pilaRecursos.eli();
                ColaCircularRecursos auxRecursos = new ColaCircularRecursos();

                // Contar recursos de tipo material
                while (!recursos.esVacia()) {
                    Recursos recurso = recursos.eli(); 
                    auxRecursos.adi(recurso);  // Almacenar el recurso

                    if (recurso.getTipo().equals("material")) {
                        recursosMateriales++;
                    }
                }

                // Restaurar los recursos a la cola
                while (!auxRecursos.esVacia()) {
                    recursos.adi(auxRecursos.eli());
                }
                pilaRecursos.adi(recursos);
            }

            // Imprimir resultados
            System.out.println("La tarea con mayor prioridad es '" + tareaMayorPrioridad.getNombre() + "' con prioridad " + tareaMayorPrioridad.getPrioridad() + ".");
            System.out.println("Esta tarea tiene " + recursosMateriales + " recursos de tipo material.");
        } else {
            System.out.println("No se encontraron tareas.");
        }
    }


    
    // a)
    public static void verificarRecursoHumano(ColaSimpleTareas colaTareas, String nombreTarea) {
        ColaSimpleTareas aux = new ColaSimpleTareas();
        boolean tareaEncontrada = false;

        while (!colaTareas.esVacia()) {
            Tareas tarea = colaTareas.eli();  

            if (tarea.getNombre().equals(nombreTarea)) {
                tareaEncontrada = true;
                PilaCoCirRecursos pilaRecursos = tarea.getPilaRecursos();
                boolean recursoHumanoEncontrado = false;
                PilaCoCirRecursos auxPila = new PilaCoCirRecursos();
                while (!pilaRecursos.esVacia()) {
                    ColaCircularRecursos recursos = pilaRecursos.eli();
                    ColaCircularRecursos auxRecursos = new ColaCircularRecursos();
                    
                    while (!recursos.esVacia()) {
                        Recursos recurso = recursos.eli();
                        if (recurso.getTipo().equals("humano")) {
                            recursoHumanoEncontrado = true;
                            break;
                        }
                        auxRecursos.adi(recurso);
                    }

                    pilaRecursos.adi(auxRecursos);
                    if (recursoHumanoEncontrado) {
                        System.out.println("La tarea '" + nombreTarea + "' tiene un recurso de tipo humano.");
                        break;
                    }
                    auxPila.adi(recursos);  
                }

                pilaRecursos.vaciar(auxPila);  
                if (!recursoHumanoEncontrado) {
                    System.out.println("La tarea '" + nombreTarea + "' no tiene recursos de tipo humano.");
                }
            }

            aux.adi(tarea); 
        }

        if (!tareaEncontrada) {
            System.out.println("La tarea con nombre '" + nombreTarea + "' no fue encontrada.");
        }

        colaTareas.vaciar(aux);  // Restaurar las tareas en la cola original
    }


    
}

