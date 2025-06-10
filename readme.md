# Sistema de Gestión Excusas S.R.L.

Este proyecto intenta ser un sistema para evaluar y procesar excusas laborales de empleados, utilizando diferentes patrones de diseño y no compilando para lograrlo.

## El Sistema implementa los siguientes patrones de diseño:

-**Chain of Responsibility**: para la delegación de tareas entre los diferentes encargados.

-**Strategy**: para aplicar distintos modos de evaluación del encargado (ModoNormal, ModoProductivo, ModoVago)

-**Observer**: los CEOs son notificados automáticamente cuando se crea un nuevo prontuario.

-**Singleton**: "AdministradorDeProntuarios" centraliza el registro de excusas procesadas, evitando que se instancie más de una vez.

## Actores

-**Empleado**: Genera excusas.

-**Encargados**: procesan las excusas según su tipo y nivel jerárquico.

-**Rechazador**: última instancia que rechaza la excusa si naide más la procesó.

-**AdministradorDeProntuarios**: No es un actor como tal, pero guarda los registros de las excusas aceptadas.

-**CEOs**: observers del sistema, notificando ante nuevos prontuarios.

## Casos De Uso

[Casos de Uso](//www.plantuml.com/plantuml/png/XL9HRkem4FptAVRpyG47U4A8w3q4FwKez0B6NjAL73korn4zLu_GYtKfYPg88BuIpyvCPh9U9zQHS-qK4pk48oN6MeD5s69Y-lhqr_VDnUIaat9uPk00aQft1aiH3LFmIcd38SAcRXng6xfZYGOR8tCnrHrsp0t6bbA8HSGUt694prYMkrs7_DkyAgLwFvZFL_3d4349JSSkpapTGpVcxG0cU2Rq22-1gGtm0M_KX9bIes2TfDKk3wp7EQSvWzZJ16anFL1g3FN1YyQHqL42IscBS2EPwnfc3oI760ocWVSqxJywh0JK3X9LcQx10RtHiT8sF5Bj0zFv9r69AJiMAkX-pQBwRLXaIomyYUDPV2WCwfTew4GHUZlJtwjznbPtduIYYU6ahLIOMknYyNIny1UMI_B6POkhrLqbiNZs8peFl31wEsqntNKiMyiZr-uR)



## Diagrama de Clases

```mermaid
classDiagram
direction TB

    class SupervisorArea {
    }

    class Recepcionista {
    }

    class GerenteRRHH {
    }

    class CEO {
    }
    
    class ModoNormal {
    }

    class ModoProductivo {
    }

    class ModoVago {
    }

    class Prontuario {
    }

    class Observer {
    }

    class ExcusaModerada {
    }

    class ExcusaLuz {
    }

    class ExcusaFamilia {
    }

    class ExcusaTrivial {
    }

    class ExcusaInverosimil {
    }

    class ExcusaCompleja {
    }

    class IProntuario {
	    +Encargado: encargado
	    +Empleado: empleado
	    +Excusa: excusa
	    -getEmpleado()
	    -getEncargado()
	    -getExcusa()
    }

    class AdministradorDeProntuario {
	    List : prontuarios
	    +agregarProntuario(Prontuario prontuario)
	    +eliminarProntuario(Prontario prontuario)
    }

    class IExcusa {
	    +procesar(IEncargado encargado)
	    getEmpleado() Empleado
    }

    class TipoExcusa {
	    +actuar(Encargado encargado, Excusa excusa)
	    +puedeSerManejadaPor(ManejadorExcusa manejadorExcusa) boolean
    }

    class EmailSender {
	    +enviarEmail(origen, destino, asunto, cuerpo)
    }

    class Excusa {
	    ManejadorExcusa: manejadorExcusa
	    TipoExcusa: tipo
	    Motivo: String
	    Empleado: empleado
	    +getEmpleado()
	    +getMotivo()
	    +evaluar(Encargado encargado)
	    +puedeSerManejadaPor(ManejadorExcusa manejadorExcusa)
    }

    class IEmpleado {
	    +generarExcusa(String motivo, TipoExcusa tipoExcusa) Excusa
	    +getNombre() String
	    +getEmail() String
	    +getLegajo() int
    }

    class IEncargado {
	    -getModoEvaluacion() ModoEvaluacion
	    -modoNormal()
	    -modoProductivo()
	    -modoVago()
    }

    class ModoEvaluacion {
	    +evaluar(IEncargado encargado, IExcusa excusa)
    }

    class Encargado {
	    +ModoEvaluacion: modoEvaluacion
	    +ManejadorExcusa: siguiente
	    -getModoEvaluacion() ModoEvaluacion
	    -setSiguiente(ManejadorExcusa siguiente))
	    -getSiguiente() ManejadorExcusa
	    -realizarAccion(Excusa excusa)
	    -puedeManejarExcusa(Excusa excusa) boolean
	    -evaluarExcusa(Excusa excusa)
	    -manejarExcusa(Excusa excusa)
	    -modoNormal()
	    -modoProductivo()
	    -modoVago()
    }

    class ManejadorExcusa {
	    evaluarExcusa(Excusa excusa)
	    manejarExcusa(Excusa excusa)
	    pasarExcusa(Excusa excusa)
	    realizarAccion(Excusa excusa)
	    setSiguiente(ManejadorExcusa siguiente)
	    setSiguiente() ManejadorExcusa
	    puedenManejar(Excusa excusa) boolean
	    soyGerenteRRHH() boolean
	    soyRecepcionista() boolean
	    soySupervisorArea() boolean
	    soyCEO() boolean
	    soyEncargadoPorDefecto() boolean
    }

    class Rechazador {
	    +evaluarExcusa(Excusa excusa)
	    +manejarExcusa(Excusa excusa)
	    +pasarExcusa(Excusa excusa)
	    +realizarAccion(Excusa excusa)
	    +setSiguiente(ManejadorExcusa siguiente)
	    +soyGerenteRRHH() boolean
	    +soyRecepcionista() boolean
	    +soySupervisorArea() boolean
	    +soyCEO() boolean
	    +soyEncargadoPorDefecto() boolean
	    +getSiguiente() ManejadorExcusa
    }

    class Empleado {
	    +nombre: String
	    +legajo: int
	    +email: String
	    +getNombre() String
	    +getEmail() String
	    +getLegajo() int
	    +generarExcusa(String motivo, TipoExcusa tipoExcusa) Excusa
    }

    IEmpleado <|.. Empleado
    Empleado <|-- Encargado
    ManejadorExcusa <|.. Encargado
    ManejadorExcusa <|.. Rechazador
    IEncargado <|.. Encargado
    Encargado <|-- SupervisorArea
    Encargado <|-- GerenteRRHH
    Encargado <|-- Recepcionista
    Encargado <|-- CEO
    IExcusa <|.. Excusa
    Excusa <|-- TipoExcusa
    TipoExcusa <|-- ExcusaModerada
    TipoExcusa <|-- ExcusaCompleja
    TipoExcusa <|-- ExcusaInverosimil
    TipoExcusa <|-- ExcusaTrivial
    ExcusaModerada <|-- ExcusaLuz
    ExcusaModerada <|-- ExcusaFamilia
    ModoEvaluacion <|-- ModoNormal
    ModoEvaluacion <|-- ModoProductivo
    ModoEvaluacion <|-- ModoVago
    Prontuario <|-- AdministradorDeProntuario
    IProntuario <|.. Prontuario
    CEO ..|> Observer
    Observer --> Prontuario
    AdministradorDeProntuario <|-- AdministradorDeProntuario
    Encargado <|.. EmailSender
   
    ```

