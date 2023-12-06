package ru.spbstu.j24.module2.api;

import ru.spbstu.j24.module1.api.Service;

public class ServiceImpl implements Service {

	@Override
	public void action(String data) {
		System.out.println(data);
	}
	
}
