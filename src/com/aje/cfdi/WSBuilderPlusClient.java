package com.aje.cfdi;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import com.aje.cfdi.WSBuilderPlusStub.CancelarCFDI;
import com.aje.cfdi.WSBuilderPlusStub.CancelarCFDIResponse;

public class WSBuilderPlusClient {

	public static void main(String[] args) {
		String compania = new String(args[0]);
		String UUID = new String(args[1]);

		try {
			WSBuilderPlusStub stub = new WSBuilderPlusStub();
			CancelarCFDI cancelarCFDI = new CancelarCFDI();

			cancelarCFDI.setCompania(compania);
			cancelarCFDI.setUUID(UUID);

			CancelarCFDIResponse response = stub.cancelarCFDI(cancelarCFDI);

			System.out
					.println("Respuesta: " + response.get_return().toString());

		} catch (AxisFault e) {
			System.out.println("Axis Client Error: " + e.getMessage());
			e.printStackTrace();
		} catch (RemoteException e) {
			System.out.println("Remote Error : " + e.getMessage());
			e.printStackTrace();
		}

	}

}
