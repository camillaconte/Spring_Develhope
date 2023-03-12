package co.develhope.FirstAPI.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetSocketAddress;

@RestController
public class HeaderController {

    /**
     * a HeaderController that:
     * is mapped on headers
     * returns the host name and the host port using the headers of the request
     *
     * VEDI FILE Headers.md di questo progetto per la lezione di Carlo Casiglia relativa
     * a questo esercizio (con considerazioni generali sulla Dep Inj)
     */


    @GetMapping("/headers")
    public String getHostInfo(HttpServletRequest request){
            return ("The host is: " + request.getHeader("Host").split(":")[0]
                    + " and the port is: " + request.getHeader("Host").split(":")[1]);
    }

    //Best! Conosce l'oggetto!
    @GetMapping("/headers2")
    public String getHostInfo2(@RequestHeader HttpHeaders headers){
        //prendo oggetto Host
        InetSocketAddress host = headers.getHost();
        return ("The host is: " + host.getHostName()
                + " and the port is: " + host.getPort());
    }

}
