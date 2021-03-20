package com.nighthawk.csa.algorithm;

/* MVC code that shows defining a simple Model, calling View, and this file serving as Controller
 * Web Content with Spring MVCSpring Example: https://spring.io/guides/gs/serving-web-con
 */

import com.nighthawk.csa.algorithm.fibonacciModel.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class AlgoController {

    // GET request,, parameters are passed with URL
    @GetMapping("/fib")
    public String fib(@RequestParam(name="fibseq", required=false,  defaultValue="2") String fibseq, Model model) {
        //nth is fibonacci request
        int nth = Integer.parseInt(fibseq);

        //fibonacci methods
        _Fibonacci fibfor = new FibFor(nth);
        _Fibonacci fibrecurse = new FibRecurse(nth);
        _Fibonacci fibstream = new FibStream(nth);
        _Fibonacci fibwhile = new FibWhile(nth);

        //MODEL attributes are passed back html
        model.addAttribute("fib", fibstream.getNth());
        model.addAttribute("fibseq", fibstream.getList());
        model.addAttribute("fibfortime", fibfor.getTimeElapsed());
        model.addAttribute("fibrecursetime", fibrecurse.getTimeElapsed());
        model.addAttribute("fibstreamtime", fibstream.getTimeElapsed());
        model.addAttribute("fibwhiletime", fibwhile.getTimeElapsed());

        //render fibonacci results
        return "algorithm/fib";
    }
}