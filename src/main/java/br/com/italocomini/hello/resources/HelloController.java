package br.com.italocomini.hello.resources;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = "/api/hello/{name}", produces = "application/vnd.hello.api.v1+json")
    public
    @ResponseBody
    String index1(@PathVariable("name") String name) {
        return String.format("Hello %s !!!!(v1)", name);
    }

    @GetMapping(value = "/api/hello/{name}", produces = "application/vnd.hello.api.v2+json")
    public
    @ResponseBody
    String index2(@PathVariable("name") String name) {
        return String.format("Hello %s !!!!(v2)", name);
    }
}
