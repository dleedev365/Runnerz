package dleedev365.runnerz.user;

import org.springframework.web.service.annotation.GetExchange;
import java.util.List;

public interface UserHttpClient {
    @GetExchange("/users")
    List<User> findAll();

    @GetExchange("/users/{id}")
    User findById(Integer id);
}
