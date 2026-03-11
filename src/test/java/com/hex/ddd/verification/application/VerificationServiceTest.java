package com.hex.ddd.verification.application;

import com.hex.ddd.verification.domain.ports.out.EventPublisherPort;
import com.hex.ddd.verification.domain.ports.out.IdentityVendorPort;
import com.hex.ddd.verification.domain.ports.out.VerificationRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class VerificationServiceTest {
    // Mock the Output Ports
    private final VerificationRepository repository = mock(VerificationRepository.class);
    private final IdentityVendorPort vendorPort = mock(IdentityVendorPort.class);
    private final EventPublisherPort eventPublisher = mock(EventPublisherPort.class);

    private final VerificationService service = new VerificationService(repository, vendorPort, eventPublisher);

    @Test
    void should_complete_verification_when_vendor_is_successful() {
        // Arrange
        when(vendorPort.isValid("ABC123")).thenReturn(true);

        // Act
        service.handle("user-1", "ABC123");

        // Assert
        verify(repository).save(any());
        verify(eventPublisher).publishStatusChanged("user-1", "SUCCESS");
    }
}