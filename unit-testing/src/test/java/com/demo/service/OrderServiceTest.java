package com.demo.service;

import com.demo.domain.Order;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class OrderServiceTest {

    @Mock
    private EmailService emailService;

    @InjectMocks
    private OrderService orderService;

    @Before  // Use JUnit 4's @Before instead of @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPlaceOrderWithoutCc_ShouldThrowExceptionAndNotNotifyCustomer() {
        Order order = new Order(1, "something", 100.0);

        // Fix: Ensure correct method stubbing for exception
        when(emailService.sendEmail(any(Order.class), any(String.class)))
                .thenThrow(new RuntimeException("An Exception Occurred"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> orderService.placeOrder(order, null));

        assertEquals("An Exception Occurred", exception.getMessage());
        assertFalse(order.isCustomerNotified());
    }

    @Test
    public void testPlaceOrderWithCc_ShouldReturnTrueAndNotifyCustomer() {
        Order order = new Order(1, "something", 100.0);

        // Fix: Use `any(Order.class)` instead of direct object match
        when(emailService.sendEmail(any(Order.class), eq("samriddhi@gmail.com"))).thenReturn(true);

        boolean isNotified = orderService.placeOrder(order, "samriddhi@gmail.com");

        assertTrue(isNotified);
        verify(emailService).sendEmail(any(Order.class), eq("samriddhi@gmail.com"));
        assertEquals(240.0, order.getPriceWithTax(), 0.001);
        assertTrue(order.isCustomerNotified());
    }
}
