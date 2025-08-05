package com.portfolio.portfolio_backend.Contrloller;
import com.portfolio.portfolio_backend.model.Person;
import com.portfolio.portfolio_backend.Repository.PersonRepository;
import com.portfolio.portfolio_backend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private EmailService emailService;

    @PostMapping("/submit")
    public Person submitPerson(@RequestBody Person person) {
        // Save into MySQL
        Person savedPerson = personRepository.save(person);

        // Send email to admin
        emailService.sendNotificationToAdmin(person.getName(), person.getEmail(), person.getMessage());

        // Auto–reply to user
        emailService.sendAutoReplyToUser(person.getName(), person.getEmail());

        return savedPerson;
    }
}
