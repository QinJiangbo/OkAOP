import com.qinjiangbo.test.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @date: 12/01/2017 1:42 PM
 * @author: qinjiangbo@github.io
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-aop.xml"})
public class BookAspectTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testSearch() {
        bookService.searchBook(17783l);
    }
}
