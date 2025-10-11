// package com.example;

// import static org.junit.jupiter.api.Assertions.assertTrue;

// import org.junit.jupiter.api.Test;

// /**
//  * Unit test for simple App.
//  */
// public class AppTest {

//     /**
//      * Rigorous Test :-)
//      */
//     @Test
//     public void shouldAnswerWithTrue() {
//         assertTrue(true);
//     }
// }
package com.example;

import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testGreet() {
           // Call the main method directly
        App.main(new String[]{});
    }
}

