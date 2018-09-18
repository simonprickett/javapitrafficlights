import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class TrafficLights {
	private static GpioController gpio; 

	private static void allLightsOff() {
	}

	public static void main(String[] args) throws InterruptedException {
		gpio = GpioFactory.getInstance();

		final GpioPinDigitalOutput red = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_13, "Red", PinState.LOW);
		final GpioPinDigitalOutput yellow = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_12, "Red", PinState.LOW);
		final GpioPinDigitalOutput green = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_14, "Red", PinState.LOW);

		red.high();

		Thread.sleep(3000);

		yellow.high();

		Thread.sleep(1000);

		red.low();
		yellow.low();
		green.high();

		Thread.sleep(5000);

		green.low();
		yellow.high();

		Thread.sleep(2000);

		yellow.low();

		gpio.shutdown();
	}
}
