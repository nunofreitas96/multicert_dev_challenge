import com.challenge.model.Client;
import com.challenge.rest.WebServiceController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.checkerframework.checker.units.qual.A;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(WebServiceController.class)
public class WebServiceControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    Client clientRepository;

    Client RECORD_1 = new Client("a", 987654321, "d", 968574123);
    Client RECORD_2 = new Client("b", 123456789, "e", 987654321);
    Client RECORD_3 = new Client("c", 456789132, "f", 956874123);
    

}
