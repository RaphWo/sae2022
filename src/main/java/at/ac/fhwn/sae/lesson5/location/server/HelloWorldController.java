package at.ac.fhwn.sae.lesson5.location.server;//package at.ac.fhwn.sae.lesson5.location.server;
//
//import at.ac.fhwn.sae.lesson3.AnimalFarm.Cow;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Hashtable;
//
//@RestController
//public class HelloWorldController {
//
//    CowService cowService;
//
//    public HelloWorldController(CowService cowService){
//        this.cowService = cowService;
//    }
//
//    @GetMapping("/")
//    public String root(){
//        return "Hello World";
//    }
//
//    @GetMapping("/cow")
//    public Cow cow(
//            @RequestParam("index")int index){
//        Cow cow = new Cow("Loisi");
//        cowService.helloWorld(cow, index);
//        return cow;
//    }
//
//    @GetMapping("/cows")
//    public Hashtable cows(){
//        return cowService.getCows();
//    }
//
//
//}
