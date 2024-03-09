package com.example.async.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AsyncService {

	private final EmailService emailService;

	// 빈에 등록된 emailService proxy 를 사용하기 때문에 비동기로 동작한다.
	public void asyncCall_1() {
		System.out.println("[asyncCall_1] :: " + Thread.currentThread().getName());
		emailService.sendMail();
		emailService.sendMailWithCustomThreadPool();
	}

	// 직접 인스턴스를 만들었기 때문에 등록된 빈을 사용하지 않아 비동기로 동작하지 않는다.
	public void asyncCall_2() {
		System.out.println("[asyncCall_2] :: " + Thread.currentThread().getName());
		EmailService emailService = new EmailService();
		emailService.sendMail();
		emailService.sendMailWithCustomThreadPool();
	}

	// 이미 AsyncService빈을 받아와서 내부 메서드를 불러다가 사용하게 되면  비동기로 동작하지 않는다.
	// @Transactional 사용시에 @Transactional이 붙은 내부 메서드를 호출할 때 일어나는 문제와 같다.
	public void asyncCall_3() {
		System.out.println("[asyncCall_3] :: " + Thread.currentThread().getName());
		sendMail();
	}

	@Async
	public void sendMail() {
		System.out.println("[sendMail] :: " + Thread.currentThread().getName());
	}
}
