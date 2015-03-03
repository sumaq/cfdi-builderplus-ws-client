package com.aje.cfdi.test;

import com.aje.cfdi.WSBuilderPlusClient;

public class BuilderClientTest {

	public static void main(String[] args) {
		WSBuilderPlusClient client = new WSBuilderPlusClient();
		String[] params = { "0030", "6D2BA454-6508-4F8C-AE41-C8233AAFF92B" };
		client.main(params);
	}
}
