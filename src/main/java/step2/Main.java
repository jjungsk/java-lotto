package step2;

public class Main {
	public static void main(String[] args) {
		Print.inputAmount();
		Game.start(Integer.parseInt(InputView.input()));
	}
}