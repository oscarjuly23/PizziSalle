##Pràctica 1 - PizziSalle (Patrons)
####Metodología del Software 2021-22

######@author: Oscar Julian Ponte (oscar.julian)
######@date: 09 de Gener 2022

###EXECUCIÓ:
- Tenir connexió a la Base de Dades en MySQL proporcionada.
- Fer 'Run' del Main del mateix projecte Java.
- El programa demana primerament les dades del client.
- Després demana la comanda amb els camps requerits per l'enunciat.
- Un cop tots els camps omplerts es realitza la inserció a la base de dades.
- Aquí s'acaba el programa, si es vol demanar una altre pizza s'ha de tornar a executar el codi.
######Aclarir que els camps que hem de introduir han de ser estrictament correctes amb els proporcionats a la base de dades, en cas contrari no es realitzarà correctament la inserció a la BBDD.

###PATRONS APLICATS:
- **MVC**: Com es pot veure, tot el projecte està estructurat amb el patró de disseny model-vista-controlador. He separat les dades de manera en que en la View tenim tot lo relacionat amb la interface de l'usuari, en la Model tinc estructurada tota la informació i els accessos (com la BBDD i també els objectes que requereix la pràctica)
i finalment en el Controller que és l'intermediari entre la vista i la model.
- **Singleton**: He usat aquest patró d'instància única per a restringir la creació d'objectes que pertanyen a una classe i també el valor d'un tipus a un únic objecte, m'ha resultat molt útil per la part de la BBDD.
- **Builder**: He utilitzat aquest patró per a contruir l'objecte 'Pizza' de cada pizza que demana l'usuari per comanda. Finalment només ha calgut tenir una AbstractClass la qual tindrà un sol ConcreteBuilder ja que només amb un he pogut contruir qualsevol tipus de pizza.
- **Decorator**: Ha sigut útil aquest patró estructural per a tenir en compte els ingredients extras. Com al final han de ser com un ingredient de la pizza ademés dels que ja té apriori, amb aquest patró hem pogut modificar l'objecte de pizza original sense modificar la base de la reste d'objectes del mateix tipus.