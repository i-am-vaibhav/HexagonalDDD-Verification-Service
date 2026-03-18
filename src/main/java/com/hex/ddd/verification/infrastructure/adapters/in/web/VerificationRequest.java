package com.hex.ddd.verification.infrastructure.adapters.in.web;

import lombok.Getter;

@Getter
public class VerificationRequest {
    private String userId;
    private String documentNumber;
}