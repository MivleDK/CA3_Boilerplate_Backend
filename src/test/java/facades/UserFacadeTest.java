package facades;

import entities.Role;
import utils.EMF_Creator;
import entities.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import security.errorhandling.AuthenticationException;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class UserFacadeTest {

    private static EntityManagerFactory emf;
    //private static FacadeExample facade;
    private static UserFacade facade;
    private User u1, u2;
    private Role r1, r2;

    public UserFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = UserFacade.getUserFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the code below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("User.deleteAllRows").executeUpdate();
            em.createNamedQuery("Role.deleteAllRows").executeUpdate();
            r1 = new Role("user");
            r2 = new Role("admin");
            u1 = new User("testmand1", "storFedAgurk");
            u2 = new User("testmand2", "lilleFedTomat");

            u1.addRole(r1);
            u2.addRole(r2);

            em.persist(r1);
            em.persist(r2);
            em.persist(u1);
            em.persist(u2);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    @Test
    public void testAFacadeMethod() {
        assertEquals(2, facade.getUserCount(), "Expects two rows in the database");
    }

    @Test
    public void testGetVeryfiedUser() throws AuthenticationException {
        String pass = u1.getUserPass();

        assertEquals(u1.getUserName(), "testmand1");
        assertEquals(u1.getUserPass(), pass);
        assertThat(u1.getUserName(), is(not("pollemand")));
        assertThat(u1.getUserPass(), is(not("lilleGrimTomat")));
    }

    @Test
    public void testGetRoleList() {
        assertEquals(u1.getRolesAsStrings().get(0), r1.getRoleName());
    }
}
