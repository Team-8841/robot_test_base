package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SerialComms extends SubsystemBase{

    private SerialPort arduino;

    private int timer = 0;

    public SerialComms() 
    {
        try 
        {
            arduino = new SerialPort(9600, SerialPort.Port.kUSB);
            System.out.println("Connected on kUSB");
        } catch (Exception e) 
        {
            System.out.println("Failed to connect on kUSB");
        }

        try 
        {
            arduino = new SerialPort(9600, SerialPort.Port.kUSB1);
            System.out.println("Connected on kUSB1");
        } catch (Exception e) 
        {
            System.out.println("Failed to connect on kUSB1");
        }

        try 
        {
            arduino = new SerialPort(9600, SerialPort.Port.kUSB2);
            System.out.println("Connected on kUSB2");
        } catch (Exception e) 
        {
            System.out.println("Failed to connect on kUSB2");
        }
    }

    @Override
    public void periodic() {

        if(arduino != null) {
            if (timer < 30) {
                timer++;
            }else if(timer >= 30){
                timer = 0;
                System.out.println("Wrote to arduino");
                arduino.write(new byte[] {0x12}, 1);
            }

            if (arduino.getBytesReceived() > 0)
            {
                System.out.println(arduino.readString());
            }
        }
    }
  
    @Override
    public void simulationPeriodic() {
      // This method will be called once per scheduler run during simulation
    }
    
}
