package praktikum;

import org.junit.Before;
import org.mockito.Mockito;

public class BaseTest {

    protected Burger burger;
    protected Bun bun;

    @Before
    public void setUp () {
        burger = new Burger();
        bun = Mockito.mock(Bun.class);
        burger.setBuns(bun);

    }


}
