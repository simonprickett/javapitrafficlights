import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class TrafficLights {
  private static GpioController gpio = null; 
  private static GpioPinDigitalOutput red = null;
  private static GpioPinDigitalOutput yellow = null;
  private static GpioPinDigitalOutput green = null;

  public static void main(final String[] args) throws InterruptedException {
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        if (gpio != null) {
          red.low();
          yellow.low();
          green.low();
          gpio.shutdown();
        }
      }
    });

    gpio = GpioFactory.getInstance();

    red = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_13, "Red", PinState.LOW);
    yellow = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_12, "Red", PinState.LOW);
    green = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_14, "Red", PinState.LOW);

    while (true) {
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
    }
  }
}