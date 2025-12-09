package M2_Act5;

public abstract class Program {
	
	private String name;
	private boolean isRunning = false;
	
	public Program() {
		
	}
	
	public Program(String name) {
		this.name = name;
	}
	
	abstract void run();
	abstract void stop();
   
   //get n set
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getIsRunning() {
		return isRunning;
	}
	public void setIsRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}	
}
