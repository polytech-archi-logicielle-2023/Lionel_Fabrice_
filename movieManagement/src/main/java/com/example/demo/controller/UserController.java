import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.*;

@RequestMapping("/users")
@RestController
public class UserController {

    @GetMapping("")
    public ResponseEntity<List<String>> getAllUsers() {
        return ResponseEntity.ok(new ArrayList<>());
    }

}