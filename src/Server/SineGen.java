package Server;

public class SineGen extends SignalGen {
	private int freq;
	private int amp;

	public SineGen(int numberOfSample, int freq, int amp) {
		this.numberOfSample = numberOfSample;
		this.freq = freq;
		this.amp = amp;
		this.signal = null;
		this.signal = new int[this.numberOfSample];
		name = "sine";
	}
	
	public void generate() {
		double y;
		for (int x = 0; x < numberOfSample; x++) {
			y = amp * Math.sin(Math.PI * (float) (2 * freq * x / (double)SamplingRate));
			signal[x] = (int) y;
		}
	}
}
