package Server;

public class SineGen extends SignalGen {
	private int freq;
	private int amp;

	public SineGen(int w, int h, int freq, int amp) {
		this.w = w;
		this.h = h;
		this.freq = freq;
		this.amp = amp;
		this.signal = null;
		this.signal = new int[this.w];
		name = "sine";
	}
	
	public void generate() {
		double y;
		for (int x = 0; x < w; x++) {
			y = amp * Math.sin(Math.PI * (float) (2 * freq * x / (double)SamplingRate));
			signal[x] = (int) y;
		}
	}
}
