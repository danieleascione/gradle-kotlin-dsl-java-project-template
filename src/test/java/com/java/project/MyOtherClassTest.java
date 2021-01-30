package com.java.project;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MyOtherClassTest {

    @Nested
    class ExecuteTest {

        private MyClass myClassMock;
        private MyOtherClass sut;

        @BeforeEach
        public void beforeEach() {
            myClassMock = mock(MyClass.class);
            sut = new MyOtherClass(myClassMock);
        }

        @AfterEach
        public void afterEach() {
            reset(myClassMock);
        }

        @Test
        public void executeShouldReturnPlusOne() {
            when(myClassMock.sum()).thenReturn(0);

            int actual = sut.execute();

            verify(myClassMock, times(1)).sum();
            assertThat(actual).isEqualTo(1);
        }
    }
}
