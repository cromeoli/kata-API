package syntaxt3rr0r.apikata;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Test 'sanity check' que comprueba que la clase main existe y funciona.
 */

@SpringBootTest
class ApiKataApplicationTests {

    @Autowired
    private ApiKataApplication application;
    @Test
    void contextLoads() throws Exception {
        assertThat(application).isNotNull();
    }

}
