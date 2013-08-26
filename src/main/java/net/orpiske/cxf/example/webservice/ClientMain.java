package net.orpiske.cxf.example.webservice;

import java.net.URL;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import net.orpiske.examples.cxf.webservice.TimeService;


public class ClientMain {
	private static String ip = "localhost";
	private static String port = "80";

	public static void callService() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

		/*
		 * Setup logging goods
		 */
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());

		/*
		 * Sets the service class
		 */
		factory.setServiceClass(TimeService.class);

		/*
		 * Target URL
		 */

		factory.setAddress("http://" + ip + ":" + port + "/TimeService");

		TimeService port = (TimeService) factory.create();


		/*
		 * Sets the WSDL URL location
		 */
		factory.setWsdlURL("classpath:/wsdl/timeservice/TimeService.wsdl");
		factory.setServiceName(new QName("http://www.orpiske.net/examples/cxf/webservice",
				"TimeService"));

		/*
		 * Call the service and handle the response
		 */
		XMLGregorianCalendar ret = port.timeService("12");

		if (ret != null) {
			System.out.println("Ret = " + ret.toGregorianCalendar().toString());
		}
		else {
			System.out.println("No response from the server");
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 1) {
			ip = args[0];
		}
		else {
			if (args.length >= 2) {
				ip = args[0];
				port = args[1];
			}
		}

		callService();
	}

}
