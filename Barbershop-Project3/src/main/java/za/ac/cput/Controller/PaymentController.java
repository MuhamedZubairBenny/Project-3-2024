package za.ac.cput.Controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import za.ac.cput.domain.Payment;
import za.ac.cput.factory.PaymentFactory;

import java.time.LocalDate;
import java.util.Arrays;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @GetMapping
    String getPayment(Model model){
        model.addAttribute("heading","Payment");
       model.addAttribute("payment", Arrays.asList(
                PaymentFactory.buildPayment("A1","MF", LocalDate.of(2024, 11, 30),110),
               PaymentFactory.buildPayment("A2","HTS", LocalDate.of(2024, 11, 12),80),
               PaymentFactory.buildPayment("A3","CSF", LocalDate.of(2024, 11, 2),200),
               PaymentFactory.buildPayment("A4","CST", LocalDate.of(2024, 11, 4),120),
               PaymentFactory.buildPayment("A5","HTS", LocalDate.of(2024, 11, 1),80),
               PaymentFactory.buildPayment("B1","CSH", LocalDate.of(2024, 11, 8),150),
               PaymentFactory.buildPayment("B2","MF", LocalDate.of(2024, 11, 22),110),
               PaymentFactory.buildPayment("B3","HTS", LocalDate.of(2024, 11, 19),80),
               PaymentFactory.buildPayment("B4","CSF", LocalDate.of(2024, 11, 27),200),
               PaymentFactory.buildPayment("B5","MF", LocalDate.of(2024, 11, 7),110),
               PaymentFactory.buildPayment("C1","CSF", LocalDate.of(2024, 11, 11),200),
               PaymentFactory.buildPayment("C2","MF", LocalDate.of(2024, 11, 25),110)
       ));
        return "payment";

    }
}
