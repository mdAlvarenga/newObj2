# Objetos2
Repositorio del TP final de Objetos 2-Oferta Hotelera

#Oferta Hotelera 
 
#####Introducción ......................................................................................................... 1
#####Hoteles .................................................................................................................. 2
#####Habitaciones ......................................................................................................... 2
#####Mecanismo para realizar una reserva ................................................................ 3 
#####Buscar alternativas .............................................................................................. 3 
#####Concretar una reserva ......................................................................................... 5 
#####Administrar reservas ........................................................................................... 5 
#####Administración para Pasajeros ........................................................................... 6 
#####Administración para Hoteleros ........................................................................... 6 
#####Esto no es todo .................................................................................................... 6

####Introducción 
Pequeños hoteles de diferentes países y regiones deciden unirse en un mismo portal para poder ofrecer sus servicios a turistas que realicen turismo económico. La idea del portal es poder ofrecer las diferentes alternativas de alojamiento, en diferentes días y que los mismos clientes puedan gestionar las reservas y el pago de las mismas. El sistema debe permitirle a los dueños de los hoteles publicar sus ofertas y gestionar las reservas realizadas y, a los futuros clientes de los hoteles poder buscar y realizar las reservas en los hoteles seleccionados.  

El sistema de alojamiento debe ser utilizado tanto por los dueños de los hoteles, como por los futuros pasajeros.  Los primeros necesitan poder cargar y gestionar las alternativas de alojamiento que publicitan. Por su parte, los pasajeros, desean poder encontrar la oferta que mejor les convenga y poder realizar la reserva correspondiente.  

Los hoteleros ofertan habitaciones que se encuentren dentro de un hotel. Es claro que en un hotel puede haber varias habitaciones o alternativas de alojamiento.   

####Hoteles 
Los hoteles son uno de los conceptos principales en este sistema en conjunto con los productos que ofertan. La información que se requiere de un hotel es la siguiente: 
    
    * Nombre 
    
    * País 
    * Ciudad 
    
    * Dirección 
    
    * Teléfono y correo electrónico de contacto. 
    
    * Categoría: Medida en estrellas de 1 a 5. Aunque el sistema este pensado para hoteles económicos, debe 
      permitir este tipo de calificaciones. 
    
    * Servicios: Los servicios con los que cuenta el hotel, por ejemplo wifi, Sauna, Gimnasio, cochera, etc. 
      Cada hotel tiene una serie de servicios los cuales deben seleccionarse de una lista común para todos 
      los hoteles. De los servicios es importante tener el nombre, una breve descripción y el precio.  
    
    * Horario de check-in y check-out. El horario de check in indica a partir de qué momento del día es 
      posible hacer uso de la reserva. Por su parte, el horario de check-out indica el tiempo límite para 
      dejar una habitación el último día del pasajero en el hotel. 
    
    * Formas de pago aceptadas. Éstas pueden ser efectivo, tarjeta de débito y tarjeta de crédito. 
      Para las dos últimas deben indicarse con cuáles trabaja el hotel, por ejemplo Visa y Mastercard
    

####Habitaciones
Los elementos que pueden adquirir los pasajeros se denominan habitaciones.  De las habitaciones interesan los siguientes conceptos: 
* Capacidad máxima. 
* Si es para dos personas saber si es con una cama grande o dos chicas. 
* Servicios que incluye 

      ** Baño privado / Compartido 

      ** Wi-fi o Otros: se pueden detallar tantos como se tenga en cada habitación. 
      
      ** Disponibilidad. 
      
      ** Precio para una estadía. 
      
En nuestro sistema, las habitaciones poseen el mismo valor sin importar la cantidad de pasajeros que las ocupen, siempre y cuando no superen la cantidad máxima. Los hoteleros deben indicar para las habitaciones el precio por noche de cada una de ellas. Este precio puede variar y depende del hotelero. Por ejemplo, una habitación puede salir $100 la noche del 1ro de Enero y $200 la noche del 2 de Enero. Si una persona reserva la habitación para más de una noche consecutiva, entonces deberá pagar la suma total de cada noche. 

####Mecanismo para realizar una reserva  
Diferentes estudios sobre el comportamiento de los pasajeros que utilizan este tipo de sistemas mostraron que la mayoría de los pasajeros 
realiza en primer lugar una búsqueda de las alternativas y luego selecciona y realiza la reserva de las habitaciones. 
En este sentido, el sistema debe contener todas estas alternativas, es decir: posibilidades para realizar búsquedas y realizar 
la reserva propiamente 

####Buscar alternativas  
La forma básica de buscar habitaciones se realiza indicando la ciudad de Destino, la fecha de entrada, la fecha de salida y 
la cantidad de huéspedes mediante un formulario similar al que muestra la Figura 1.  

El resultado de realizar la búsqueda debe ser un listado de hoteles que incluyen dentro de sus ofertas opciones que satisfagan la búsqueda. 
Esto significa que si un hotel posee disponible una habitación dentro de los parámetros de la búsqueda realizada, el hotel 
debe aparecer en la lista de resultados. De forma similar, deberán aparecer aquellos hoteles que tengan más de una alternativa que 
satisfaga la búsqueda ingresada.  

* ACA VA LA IMAGEN DEL BUSCADOR QUE NO SE COMO SUBIRLA; PERO ENTIENDEN!
 
Una vez que el pasajero posee el listado de hoteles que satisfacen la búsqueda puede elegir en cada uno de ellos la habitación para 
realizar la reserva. Es importante destacar que las alternativas que aparecen luego de realizar la búsqueda siempre son acordes a 
los valores de la búsqueda señalada. Si por alguna razón, el pasajero desea modificar los parámetros de la búsqueda, deberá realizar una nueva. 
Cuando el pasajero selecciona una alternativa de las listadas anteriormente, en esta alternativa puede haber más de una opción de 
habitaciones disponibles en ese hotel que satisfagan la búsqueda. Por ejemplo, dos habitaciones con diferentes comodidades una más 
cara que la otra. Cuando el pasajero decide por reservar una habitación particular pasa a concretar la 

####Concretar una reserva 
Luego de los pasos anteriores, las reservas se realizan para una habitación particular, de un hotel particular, entre dos fechas específicas.  Realizar una reserva implica para el hotelero el compromiso de no ocupar la habitación en el periodo particular y para un pasajero hacerse cargo del costo. La ayuda que brinda el sistema en este punto es poner en contacto a las partes y comprometerlos en sus obligaciones. El pago efectivo y cumplimiento de las obligaciones queda por fuera de esta parte del sistema. 

Cuando un pasajero realiza una reserva, el sistema solicita su información personal, los datos de la tarjeta de crédito y la dirección de email. Una vez que se hace efectiva la reserva el sistema envía un email al pasajero con los datos de la reserva, un email al hotel con la misma información y actualiza en el sistema la disponibilidad de la habitación reservada. 
Como en el sistema pueden acceder varios usuarios al mismo tiempo, es posible que entre el periodo de disponibilidad de la habitación y de tramitar la reserva otro usuario haya realizado la misma reserva con anterioridad. 
Estos casos, deben ser controlados por el sistema y no debe permitir dos reservas sobre la misma habitación en fechas simultáneas. 

Además, el sistema debe permitir a los hoteleros controlar las reservas que fueron realizadas para poder administrarlas. La información que necesitan los hoteleros es poder conocer para cada uno de sus hoteles qué reservas realizadas hay, que disponibilidad tienen, etc. 

Para los pasajeros que se hayan registrado en el sistema, debe ser posible visualizar sus reservas (Ver Administrar reservas).

####Administrar reservas 
La administración de las reservas depende del usuario que está utilizando el sistema, ya que la información no es la misma para los dueños de los hoteles que para los pasajeros. A continuación se muestra la información y actividades que correspondan a los diferentes tipos de usuarios. 

####Administración para Pasajeros 
Cuando un pasajero registrado ingresa al sistema, debe poder acceder a la información correspondiente a las reservas que realizó. Un pasajero debe poder acceder a todas sus reservas de las siguientes formas: 
          
          * Todas las reservas. 
          
          * Las reservas futuras: muestra aquellas reservas con fecha de ingreso posterior a la fecha 
            actual.
          
          * Reservas de una ciudad en particular. 
          
          * Ver las ciudades en las que tiene reservas. Por cada reserva, el pasajero debe poder 
            cancelarlas o realizar una modificación. La modificación no puede incluir ni la fecha de 
            ingreso, ni la fecha de salida ni la cantidad de personas. 

Debe ser posible enviar por email cualquiera de las reservas realizadas.

####Administración para Hoteleros 
Los hoteleros necesitan tener control de las reservas realizadas para su mejor administración. Un hotelero necesita poder acceder a la información de: 
        
        * Sus reservas actuales: aquellas reservas donde los pasajeros están en el hotel actualmente. 
        
        * Reservas futuras: aquellas que la fecha de ingreso sea posterior a la fecha actual. 
        
        * Reservas con inicio en los N futuros días: aquellas reservas que la fecha de entrada sea dentro 
          de los próximos N días venideros. 
          
####Esto no es todo 
La aplicación cuenta con más funcionalidades que se basan en lo que se describe en este documento. Estas funcionalidades restantes serán detallas próximamente. Mientras tanto, la información de este documento es válida para comenzar a realizar los diseños preliminares de la aplicación. 
