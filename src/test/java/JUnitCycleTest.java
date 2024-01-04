import org.junit.jupiter.api.*;
public class JUnitCycleTest {

    //전체 테스트를 실행하기전에 한번만 실행
    @BeforeAll
    static void beforeAll(){
        System.out.println("@BeforeAll");
    }
    // 각 테스트를 실행하기전에 매번 실행
    @BeforeEach
    public void beforeEach(){
        System.out.println("@BeforeEach");
    }

    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

    @Test
    public void test3(){
        System.out.println("test3");
    }

    @AfterAll
    static public void afterAll(){
        System.out.println("@AfterAll");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("@AfterEach");
    }
}
