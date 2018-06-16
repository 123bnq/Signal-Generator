package Server;

public class SawtoothGen extends SignalGen {
	private int freq;

	public SawtoothGen(int w, int h, int freq) {
		this.w = w;
		this.h = h;
		this.freq = freq;
		this.signal = null;
		this.signal = new int[w];
		name = "sawtooth";
	}

	public void generate(int n, int amp) {
		double y = 0;
		double sin;
		for (int x = 0; x < w; x++) {
			y = 0;
			for (int j = 1; j < n; j++) {
				sin = -(double) (amp / (double) j) * Math.pow(-1, j)
						* Math.sin(2 * Math.PI * (double) j * (freq * (double) x / (double) SamplingRate));
				y = y + sin;
			}
			signal[x] = (int) y;
		}
	}

}
