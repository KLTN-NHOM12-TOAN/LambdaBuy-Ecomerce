package com.example.kltn.SpringAPILambdaBuy.common.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.kltn.SpringAPILambdaBuy.common.request.authen.RegisterDto;

public class ConstantGlobal {
	public static List<RegisterDto> listAdmin = Arrays.asList(
			new RegisterDto("Toan", "Le", "lvtoan.it2000@gmail.com", "lvtoan", "123123", "123123"),
			new RegisterDto("Admin", "account", "admin@gmail.com", "admin", "123123", "123123")
		);
}
