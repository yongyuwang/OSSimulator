package edu.uw.tcss422.types;

import java.util.Random;

public abstract class GenericProcess {
  
  /**
   * The maximum number of instructions.
   */
  public static final int MAX_INSTRUCTIONS = 10000;
  
  /**
   * The minimum number of instructions.
   */
  public static final int MIN_INSTRUCTIONS = 1000;
  
  /**
   * The process type.
   */
  private ProcessType processType;
  
  /**
   * The number of instructions of this process.
   */
  private int numOfInstructions;
  
  /**
   * Trigger point. The address where the actual service call is made.
   */
  protected int[] triggerPoints;
  
  /**
   * Single arg constructor.
   */
  public GenericProcess(ProcessType processType) {
    //Set the process type
    this.processType = processType;
    Random r = new Random();
    // Generate a number between 1000 to 10000 inclusively.
    numOfInstructions = r.nextInt(MAX_INSTRUCTIONS - MIN_INSTRUCTIONS + 1) + MIN_INSTRUCTIONS; 
  }
  
  /**
   * Returns process's trigger point.
   * @return The process's trigger point.
   */
  public int[] getTriggerPoints() {
    return triggerPoints;
  }
  
  /**
   * Returns process's process type.
   * @return The process's process type.
   */
  public ProcessType getProcessType() {
    return processType;
  }
  
  public int getNumOfInstructions() {
	  return numOfInstructions;
  }
}
