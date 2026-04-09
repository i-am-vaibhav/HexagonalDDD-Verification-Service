package com.hex.ddd.verification.infrastructure.adapters.in.dto;

import lombok.Getter;

@Getter
public class VerificationRequest {
    private String userId;
    private String documentNumber;
}