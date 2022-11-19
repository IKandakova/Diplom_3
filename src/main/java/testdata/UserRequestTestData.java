package testdata;

import org.apache.commons.lang3.RandomStringUtils;
import pojo.UserRequest;

public class UserRequestTestData {
    public static UserRequest getUserRequestWithCorrectData(){
        String name = RandomStringUtils.randomAlphabetic(11);
        String email = "ikandakov2@ya.ru";
        String password = RandomStringUtils.randomAlphabetic(6);

        return new UserRequest(name, email, password);
    }

    public static UserRequest getUserRequestWithIncorrectPassword(){
        String name = RandomStringUtils.randomAlphabetic(11);
        String email = RandomStringUtils.randomAlphabetic(11) + "@ya.ru";
        String password = RandomStringUtils.randomAlphabetic(5);

        return new UserRequest(name, email, password);
    }

}