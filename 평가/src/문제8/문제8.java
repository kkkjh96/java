package ����8;

interface Parseable {
	public abstract void parse(String fileName);
}

class ParserManager {

	public static Parseable getParser(String type) {
		if(type.equals("XML")) {
			return new XMLParser();
		} else {
			Parseable p = new HTMLParser();
			return p;
			//return new HTMLParser();
		}
	}
}

class XMLParser implements Parseable {
	public void parse(String fileName) {
		System.out.println(fileName + " - XML parsing completed.");
	}
}

class HTMLParser implements Parseable {
	public void parse(String fileName) {
		System.out.println(fileName + " - HTML parsing completed.");
	}
}
public class ����8 {

	public static void main(String[] args) {
		Parseable parser = ParserManager.getParser("XML");
		parser.parse("documet.xml");
		parser = ParserManager.getParser("HTML");
		parser.parse("documet2.html");
	}
}
