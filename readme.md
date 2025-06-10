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

[Casos de Uso](https://www.plantuml.com/plantuml/png/XL9RZk8m4FptAVfp-O03h10YMX3yB8l2Ni3OJQObnuxiTiISQuum5vi6aXaUGNmbBbULgzoU9zQHS-qK4pk47IN6MeD5M65Y-lpmf__bqUIaat9uOE00aQet1aiH3LFmIcd38SAoRXng6xfbYGOR8_jYgZjibnkCBQKGYuWzkCA8dh4ir-iE-RFyrtjwesCbfWiye21AzQV0U3o3Nzk8ISGwTY57wX6wC2yBCC4peKVu6vZQ0E_mdvemKkecRYTfjSjNrhVfXpbNPOO9qcruuxxgC4lT8nTQqJWIkRIouJooCycS9ZXw8jd6O31zeyze2tHO2QWT9AeodTe1zbcVgJQ1wN1EL6BAZeKAkdyXelgvXY9ROk597C_YG-7gZcGejAS8lPtfd-GcOwkx8w5eOjXhAnM6fZ-Pl9m-_8RfbBnnsU9izbX9B5vSHEU1HqPlXos6kzxAvlB9jVi2)



UML 

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

