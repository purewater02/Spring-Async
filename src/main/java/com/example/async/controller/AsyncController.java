package com.example.async.controller;

import com.example.async.service.AsyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AsyncController {
	private final AsyncService asyncService;

	@GetMapping("/1")
	public String asyncCall_1() {
		asyncService.asyncCall_1();
	  return "asyncCall_1 success";
	}

	@GetMapping("/2")
	public String asyncCall_2() {
		asyncService.asyncCall_2();
		return "asyncCall_2 success";
	}

	@GetMapping("/3")
	public String asyncCall_3() {
		asyncService.asyncCall_3();
		return "asyncCall_3 success";
	}
}
