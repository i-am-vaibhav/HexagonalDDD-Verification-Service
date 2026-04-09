package com.hex.ddd.verification.infrastructure.adapters.in.web;

import com.hex.ddd.verification.domain.ports.in.StartVerificationUseCase;
import com.hex.ddd.verification.infrastructure.adapters.in.dto.VerificationRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/verifications")
public class VerificationController {

    private final StartVerificationUseCase startVerificationUseCase;

    public VerificationController(StartVerificationUseCase startVerificationUseCase) {
        this.startVerificationUseCase = startVerificationUseCase;
    }

    @PostMapping
    public void startVerification(@RequestBody VerificationRequest request) {
        startVerificationUseCase.handle(request.getUserId(), request.getDocumentNumber());
    }
}

