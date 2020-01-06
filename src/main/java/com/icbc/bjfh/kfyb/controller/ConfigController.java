package com.icbc.bjfh.kfyb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icbc.bjfh.config.KfybConfig;

@RestController
public class ConfigController {

	@Autowired
	private KfybConfig kfybConfig;

	@GetMapping("/config")
	public String getConfig() {
		return kfybConfig.toString();
	}

}
