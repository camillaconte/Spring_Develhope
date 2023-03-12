# Headers

### Lezione Carlo 09.03.23
Partendo dall'esercizio Sprint **"Primi passi - First API - 04"**, 
che chiede di:

* scrivere una Spring Boot Application con un HeaderController:
  *  mappato su /headers
  *  in grado di ritornare host e host port usando gli headers della request

Carlo ci ha spiegato mostrato due modi di risolverlo, con i relativi commenti.

### _First way - più "azzardata" - usando HttpServletRequest_

        @GetMapping("/headers")
        public String getHostInfo(HttpServletRequest request){
            return ("The host is: " + request.getHeader("Host").split(":")[0]
                    + " and the port is: " + request.getHeader("Host").split(":")[1]);
        }

_**Commento:**_
In questo caso Java non è "consapevole" dell'oggetto host. Non sa che è di tipo InetSocketAddress (**vedi Second Way**)
Non sa che ha dei metodi e infatti non ce li suggerisce.

**getHeader**: metodo che appartiene a una famiglia di metodi che prendono un valore da un oggetto...
...oggetto Headers: contiene tanti campi (Host, Agent, Keep-ALive)...solo che Java questi campi non li conosce!
Non posso fare request.getHeader.getHost!
Devo accedere quindi a quel campo attraverso il suo nome!
SOlo che "Host" potrebbe anche non esistere o potrei sbagliare a scriverlo...un po' un azzardo!

**split:** uso il metodo split con la regex (":") perché so che "Host" in realtà è una stringa formata 
dal nome dell'host (e.g. localhost) + il numero della porta, separati dai due punti ("localhost:8080)...
quindi per vederli separatamente devo dividerlo nelle sue due parti. 

Anche in questo esercizio vediamo un esempio di **Dependency Injection**: non abbiamo il controllo di questo metodo,
non abbiamo creato nessun oggetto di tipo HeaderController...ma qualcuno lo crea!
E qualcuno chiama il metodo e lo controlla pure! Chi lo fa? Spring, ovviamente!
Spring dice:
"Mi è arrivata una richiesta, arrivata all'indirizzo /headers.
Il programmatore mi ha detto che se arriva una richiesta a questo indirizzo devo chiamare questo metodo.
Il metodo richiede un param in ingresso di tipo HttpServletRequest.
Io ce l'ho in questo contesto un oggetto di questo tipo? Yes! é la richiesta stessa!"

_La richiesta Http stessa è un OGGETTO! E Spring lo prende e lo mette nel metodo!_

Perché creiamo il parametro "request"? : non serve per creare la richiesta (la richiesta c'è)...
...serve per darle un nome e poterla quindi usare (request.getHeader...).


### _Second - MUCH BETTER - way (migliore) - usando @RequestHeader HttpHeaders_

        @GetMapping("/headers2")
        public String getHostInfo2(@RequestHeader HttpHeaders headers){
        //prendo oggetto Host
            InetSocketAddress host = headers.getHost();
            return ("The host is: " + host.getHostName()
                + " and the port is: " + host.getPort());
        }

_**Commento:**_
qui Java "conosce l'oggetto" che ho chiamato host, è di tipo InetSocketAddress 
(che è ciò che mi restituisce headers.getHost()). Quindi mi suggerisce anche i relativi metodi.
Questa strada è più sicura perché non rischio di scrivere termini scorretti (tipo "Host")

### Guides
The following guides illustrate how to use some features concretely:

* [How to Read HTTP Headers in Spring REST Controllers](https://www.baeldung.com/spring-rest-http-headers/)

