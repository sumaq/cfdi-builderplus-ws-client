/* Clase    : Connection
 * Autor    : Wilmer Reyes Alfaro
 * Revision : 22/06/2013 12:45
 * Funcion  : Permite obtener la cadena de conexi�n hacia la base de datos APM. 
 * 			  Se obtiene a partir del archivo config.xml de la carpeta conf del proyecto.
 * */
package com.aje.cfdi;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.aje.cfdi.common.OperatingSystem;
import com.aje.cfdi.common.ResourcePath;

public class WSBuilderPlusConfig extends DefaultHandler {
	String xmlFileName;
	String tmpValue;
	String WSName;
	String WSUrlServiceCancelarCFDI;
	String WSUser;
	String WSPassword;
	OperatingSystem OS = new OperatingSystem();
	Boolean fName;
	Boolean fUrlServiceCancelarCFDI;
	Boolean fUser;
	Boolean fPassword;

	public WSBuilderPlusConfig() {

		ResourcePath resource = new ResourcePath(this);

		this.xmlFileName = resource.getWEBINFpath() + OS.getOSPathDelimiter()
				+ "conf" + OS.getOSPathDelimiter() + "WSBuilderPlusConfig.xml";
		parseDocument();
	}

	private void parseDocument() {
		// parse
		SAXParserFactory factory = SAXParserFactory.newInstance();
		fName = false;
		fUrlServiceCancelarCFDI = false;
		fUser = false;
		fPassword = false;

		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(this.xmlFileName, this);
		} catch (ParserConfigurationException e) {
			System.out.println("ParserConfig error: " + e.getMessage());
			e.printStackTrace();
		} catch (SAXException e) {
			System.out.println("SAXException : xml not well formed | "
					+ e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void startElement(String s, String s1, String elementName,
			Attributes attributes) throws SAXException {

		if (elementName.equalsIgnoreCase("name")) {
			fName = true;
		}
		if (elementName.equalsIgnoreCase("urlServiceCancelarCFDI")) {
			fUrlServiceCancelarCFDI = true;
		}
		if (elementName.equalsIgnoreCase("user")) {
			fUser = true;
		}
		if (elementName.equalsIgnoreCase("password")) {
			fPassword = true;
		}

	}

	@Override
	public void endElement(String s, String s1, String element)
			throws SAXException {
		// if end of book element add to list

	}

	@Override
	public void characters(char[] ac, int i, int j) throws SAXException {
		if (fName) {
			this.WSName = (new String(ac, i, j));
			fName = false;
		}
		if (fUrlServiceCancelarCFDI) {
			this.WSUrlServiceCancelarCFDI = (new String(ac, i, j));
			fUrlServiceCancelarCFDI = false;
		}
		if (fUser) {
			this.WSUser = (new String(ac, i, j));
			fUser = false;
		}
		if (fPassword) {
			this.WSPassword = (new String(ac, i, j));
			fPassword = false;
		}
	}

	public String getWSName() {
		return WSName;
	}

	public void setWSName(String wSName) {
		WSName = wSName;
	}

	public String getWSUrlServiceCancelarCFDI() {
		return WSUrlServiceCancelarCFDI;
	}

	public void setWSUrlServiceCancelarCFDI(String wSUrlServiceCancelarCFDI) {
		WSUrlServiceCancelarCFDI = wSUrlServiceCancelarCFDI;
	}

	public String getWSUser() {
		return WSUser;
	}

	public void setWSUser(String wSUser) {
		WSUser = wSUser;
	}

	public String getWSPassword() {
		return WSPassword;
	}

	public void setWSPassword(String wSPassword) {
		WSPassword = wSPassword;
	}

}
