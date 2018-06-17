package Server;

public class SawtoothGen extends SignalGen {
	private int freq;

	public SawtoothGen(int numberOfSample, int freq) {
		this.freq = freq;
		this.signal = null;
		this.numberOfSample = numberOfSample;
		this.signal = new int[this.numberOfSample];
		name = "sawtooth";
	}

	public void generate(int amp) {
		double y = 0.0;
		for (int i = 0; i < numberOfSample; i++) {
			y = -2 * amp / Math.PI * Math.atan(1 / Math.tan(Math.PI * i * (double) freq / (double) SamplingRate));
			signal[i] = (int) Math.round(y);
		}

	}

}
