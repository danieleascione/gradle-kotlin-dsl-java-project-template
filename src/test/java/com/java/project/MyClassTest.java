package com.java.project;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MyClassTest {

    @Nested
    class SumTest {

        @Test
        public void onePlusTwoShouldReturnThree() {
            MyClass a = new MyClass(1, 2);

            int actual = a.sum();

            assertThat(actual).isEqualTo(3);
        }
    }
}
