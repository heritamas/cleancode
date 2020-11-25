package ch09.unittests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class ServiceUserTest {

    ServiceProvider spMock;
    Service svMock;

    ServiceUser su;

    @BeforeEach
    public void before() {
        spMock = mock(ServiceProvider.class);
        svMock = mock(Service.class);
        when(spMock.getService(anyString())).thenReturn(svMock);
        su = new ServiceUser(spMock);
//        su = new ServiceUser(new ServiceProvider());
    }

    @Test
    public void testDo3This2That() {
        su.do3This2That();

        verify(svMock, times(3)).doThis();
        verify(svMock, times(2)).doThat();
    }
    
    @Test
    public void testDay(){
        su.whatDayIsIt();
        verify(svMock).doSomethingWithArgument(eq(Service.days.TUESDAY));
        verify(svMock, times(0)).doSomethingWithArgument(eq(Service.days.SUNDAY));
    }

}