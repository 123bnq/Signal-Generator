package Server;

public abstract class SignalGen {
	protected String name;
	protected int[] signal;
	protected int w;
	protected int h;
	protected int SamplingRate = 8000;
	
	public int[] getSignal() {
		return signal;
	}

	public String getName() {
		return name;
	}
}
