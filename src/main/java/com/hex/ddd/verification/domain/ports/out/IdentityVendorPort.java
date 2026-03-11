package com.hex.ddd.verification.domain.ports.out;

public interface IdentityVendorPort {
    boolean isValid(String documentNumber);
}