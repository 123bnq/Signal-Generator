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
//		double y = 0;
//		double sin;
//		for (int x = 0; x < numberOfSample; x++) {
//			y = 0;
//			for (int j = 1; j < n; j++) {
//				sin = -(double) (amp / (double) j) * Math.pow(-1, j)
//						* Math.sin(2 * Math.PI * (double) j * (freq * (double) x / (double) SamplingRate));
//				y = y + sin;
//			}
//			signal[x] = (int) y;
//		}
		double y = 0.0;
		for (int i = 0; i < numberOfSample; i++) {
			y = -2 * amp / Math.PI * Math.atan(1 / Math.tan(Math.PI * i * (double) freq / (double) SamplingRate));
			signal[i] = (int) Math.round(y);
		}

	}

}
