package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		// TODO - start

		// create a client object and use it to

		// - connect to the broker - user "sensor" as the user name
		// - publish the temperature(s)
		// - disconnect from the broker

		Client client = new Client("sensor", Common.BROKERHOST, Common.BROKERPORT);
		client.connect();
		for (int i = 0; i < COUNT; i++) {
			int temp = sn.read();
			client.publish(Common.TEMPTOPIC, Integer.toString(temp));
		}
		client.disconnect();
		System.out.println("Temperature device stopping ... ");

		// TODO - end
	}
}
