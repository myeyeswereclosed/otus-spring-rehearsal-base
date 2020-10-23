package ru.otus.project.prep.service.sms;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.project.prep.domain.sms.SmsCode;
import ru.otus.project.prep.repository.sms.SmsCodeRepository;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class SmsCodeGenerator {
    private final SmsCodeRepository repository;

    @Transactional
    public SmsCode generate(String phone) {
        repository.invalidateActualFor(phone);

        return
            repository.save(
                new SmsCode(
                    phone,
                    String.valueOf(new Random().nextInt(8999) + 1000)
                )
            );
    }
}