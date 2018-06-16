package Server;

public class SquareGen extends SignalGen {
	private int PWM;

	public SquareGen(int w, int h, int PWM) {
		this.w = w;
		this.h = h;
		this.PWM = PWM;
		this.signal = null;
		this.signal = new int[this.w];
		name = "square";
	}

	public void generate(int n, int freq, int amp) {
		double y;
		double duty = PWM / 100.0;
		double tau = duty / (double) freq;
		double sin;
		double cos;
		for (int i = 0; i < w; i++) { // w samples
			y = duty;
			for (int j = 1; j < n; j++) {
				sin = Math.sin(Math.PI * (double) j * freq * tau);
				cos = Math.cos(2 * Math.PI * j * freq * ((double) i / (double)SamplingRate - (tau / 2.0)));
				y += 2.0 / ((double) j * Math.PI) * sin * cos;
			}
			y = y * amp;
			signal[i] = (int) y;
		}
	}
}
