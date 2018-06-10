package m2i.demo.controller;


import m2i.demo.model.Personne;
import m2i.demo.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonneController {

    @Autowired
    private PersonneRepository repository;

    @RequestMapping("/hello")
    public String Hello(){
        return "Hello";
    }

    @RequestMapping("/add")
    @ResponseBody
    public Personne add(){
        Personne p = new Personne();
        p.setNom("Ncedleg");
        p.setPrenom("Pcedleg");
        p.setAge(34);
        repository.save(p);
        return p;
    }

    /* POST WHIT PARAMETER */
    @RequestMapping("/add2")
    @ResponseBody
    public Personne add(@RequestParam("nom") String nom){
        Personne p = new Personne();
        p.setNom(nom);
        p.setPrenom("Pcedleg");
        p.setAge(34);
        repository.save(p);
        return p;
    }

    /* POST WHIT BODY */
    @RequestMapping(value = "/add3", method = RequestMethod.POST)
    @ResponseBody
    public Personne add(@RequestBody Personne p){
        return repository.save(p);
    }
}
