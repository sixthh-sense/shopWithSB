package demo.mall.shopWithSB;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "/test")
    public UserDto test() {

        UserDto userDto = new UserDto();
        userDto.setAge(20);
        userDto.setName("sung");

        return userDto;
    }

    @GetMapping(value = "/test2")
    public String test2() {
        return "12345";
    }
}
