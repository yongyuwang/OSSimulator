package edu.uw.tcss422.components;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class SystemTimer {
	
	private boolean debugFlag = false;

	/**
	 * 
	 * @param min The minimum delay time in milliseconds to be randomly generated.
	 * @param max The maximum delay time in milliseconds to be randomly generated.
	 * @param debugFlag Will print debug info to console if set to true.
	 */
	public SystemTimer(int min, int max, boolean debugFlag) {
		
		this.debugFlag = debugFlag;
		
		Random random = new Random();
		long delay = random.nextInt((max - min) + 1) + min;
		
		Timer timer = new Timer();
		timer.schedule(new GenerateInterrupts(), Long.valueOf(delay));
		
		if(debugFlag) {
			System.out.println("System timer delay set to " + delay + " milliseconds.");
		}

	}
	
	/**
	 * Inner class that will be called to run when triggered by the Timer.
	 * @author yongyuwang
	 *
	 */
	class GenerateInterrupts extends TimerTask {
		public void run() {
			// calls interrupt method in CPU
			if(debugFlag) {
				System.out.println("Timer has triggered a CPU interrupt.");
			}
		}
	}
}
