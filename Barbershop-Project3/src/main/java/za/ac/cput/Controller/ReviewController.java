//package za.ac.cput.Controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import za.ac.cput.domain.Review;
//import za.ac.cput.factory.PaymentFactory;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//
//
//@Controller
//@RequestMapping("/review")
//public class ReviewController {
//    @GetMapping
//    String getReview(Model model){
//        model.addAttribute("heading","Reviews");
//        model.addAttribute("review1", Arrays.asList(
//                new Review("Isa Hassan","The barber named John Blade gave me the best mullet. I was scared because i always gotten bad mullets but John Blade blessed me with a fresh cut")
//        ));
//        model.addAttribute("review2", Arrays.asList(
//                new Review("Ameer Marlie","I got the best fade and beard trim  from Mostache barbershop. I recommend everyone to visit this barbershop.")
//        ));
//        model.addAttribute("review3", Arrays.asList(
//                new Review("John Doe","I came to this barbershop on Friday and asked for a trim with 2 on the sides and 3 at the back, My barber was John Blade. He didn’t listen to my request and instead gave me a 1 on both sides.")
//        ));
//        return "review";
//    }
//
//}