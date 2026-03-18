package com.hex.ddd.verification.domain.ports.out;

import com.hex.ddd.verification.domain.model.DocumentNumber;

public interface IdentityVendorPort {
    boolean isValid(DocumentNumber documentNumber);
}