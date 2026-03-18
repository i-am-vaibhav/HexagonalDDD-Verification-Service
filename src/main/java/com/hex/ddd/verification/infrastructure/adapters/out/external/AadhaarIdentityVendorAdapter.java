package com.hex.ddd.verification.infrastructure.adapters.out.external;

import com.hex.ddd.verification.domain.model.DocumentNumber;
import com.hex.ddd.verification.domain.ports.out.IdentityVendorPort;
import org.springframework.stereotype.Component;

@Component
public class AadhaarIdentityVendorAdapter implements IdentityVendorPort {

    @Override
    public boolean isValid(DocumentNumber documentNumber) {
        System.out.println("Calling external KYC vendor for AADHAAR number: " + documentNumber);
        return documentNumber != null && documentNumber.getDocumentNumber().length() == 12;
    }

}