package com.example.async.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

	// Async를 사용하기 위해서는 접근 제어자를 private으로 하면 안된다. public처리 해야 한다.
	@Async("defaultTaskExecutor")
	public void sendMail() {
		System.out.println("[sendMail] :: " + Thread.currentThread().getName());
	}

	@Async("messagingTaskExecutor")
	public void sendMailWithCustomThreadPool() {
		System.out.println("[sendMail2] :: " + Thread.currentThread().getName());
	}
}
