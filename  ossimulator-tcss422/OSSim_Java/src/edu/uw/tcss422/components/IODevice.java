/**
 * IODevice.java
 * An IODevice that generates interrupts to the CPU at random time intervals.
 * 
 * @author yongyuwang
 * @version NonSandbox 1-1
 */
package edu.uw.tcss422.components;

import java.util.Random;

public class IODevice implements Runnable {
	
	/**
	 * Reference to the CPU object to call interrupts to.
	 */
	private CPU currentCPU;
	
	/**
	 * Identifies what IODevice this is.
	 */
	private String deviceType;
	
	/**
	 * The maximum and minimum values to generate the random delay time in milliseconds from.
	 */
	private int max, min;
	
	/**
	 * Displays debugging information when set.
	 */
	private boolean debugFlag = false;
	
	/**
	 * Constructor for each IODevice
	 * @param currentCPU	A reference to the CPU to call interrupts to.
	 * @param deviceType	Identifier to what device this is
	 * @param max	The maximum time delay in milliseconds to randomly generate interrupts.
	 * @param min	The minimum time delay in milliseconds to randomly generate interrupts.
	 */
	public IODevice(CPU currentCPU, String deviceType, int min, int max) {
		this.currentCPU = currentCPU;
		this.deviceType = deviceType;
		this.max = max;
		this.min = min;
	}
	
	/**
	 * Sets debug flag to enable diagnostic messages.
	 * @param value True/False for debug mode.
	 */
	public void setDebugFlag(boolean value) {
		debugFlag = value;
	}

	/**
	 * Run method to be executed in a thread.
	 */
	@Override
	public void run() {
		Random random = new Random();
		while(true) {
			int delayPeriod = random.nextInt((max - min) + 1) + min;
			try {
				Thread.sleep(Long.valueOf(delayPeriod));
			} catch (InterruptedException e) {
				System.out.println("IODevices thread interrupted! This is not supposed to happen.");
				e.printStackTrace();
			}
			
			//TODO: call interrupt method in CPU.
			
			if(debugFlag = true) {
				System.out.println("IODevice generated an interrupt. Delay time = " + delayPeriod +
						" milliseconds");
			}
		}
	}
	
	/**
	 * For testing purposes.
	 * @param args
	 */
	public static void main(String[] args) {
		IODevice main = new IODevice(new CPU(null, null, null), "Disk", 1000, 5000);
		main.setDebugFlag(true);
		new Thread(main).start();
	}
	
}