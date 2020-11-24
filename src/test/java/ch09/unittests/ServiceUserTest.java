package ch09.unittests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class ServiceUserTest {

    ServiceProvider spMock;
    Service svMock;

    ServiceUser su;

    @BeforeEach
    public void before() {
        // ?????

        su = new ServiceUser(spMock);
    }

    @Test
    public void testDo3This2That() {
        su.do3This2That();

        // ????
    }

}