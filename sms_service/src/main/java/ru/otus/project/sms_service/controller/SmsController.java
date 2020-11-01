package ru.otus.project.sms_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.project.sms_service.domain.SmsCode;
import ru.otus.project.sms_service.dto.PhoneDto;
import ru.otus.project.sms_service.dto.SmsCodeDto;
import ru.otus.project.sms_service.dto.SmsCodeStatus;
import ru.otus.project.sms_service.service.SmcCodeProvider;
import ru.otus.project.sms_service.service.code_generation.service.SmsCodeService;

@RestController
@RequiredArgsConstructor
public class SmsController {
    private final SmcCodeProvider provider;
    private final SmsCodeService service;

    @PostMapping("code/generate")
    public ResponseEntity<?> generate(@RequestBody PhoneDto phone) {
        var codeGenerationAvailability = provider.run(phone.getNumber());

        return
            codeGenerationAvailability.isAvailable()
                ? ResponseEntity.ok().build()
                : ResponseEntity.badRequest().body(codeGenerationAvailability.getMessage())
            ;
    }

    @PostMapping("code/check")
    public ResponseEntity<SmsCodeStatus> checkCode(@RequestBody SmsCodeDto smsCode) {
        return ResponseEntity.ok(service.checkCode(new SmsCode(smsCode.getPhone(), smsCode.getCode())));
    }
}
