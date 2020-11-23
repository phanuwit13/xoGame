import java.util.ArrayList;
import java.util.Scanner;

public class xoGame {

	public static String[][] game = { { "[7]", "[8]", "[9]" }, { "[4]", "[5]", "[6]" }, { "[1]", "[2]", "[3]" } };

	static void show() {
		for (int j = 0; j < game.length; j++) {
			for (int k = 0; k < game[j].length; k++) {
				System.out.print(game[j][k] + " ");
			}
			System.out.println("\n");
		}
	}

	static void createXO(int key, int play) {
		String symbol = "";
		if (play == 1) {
			symbol = "[X]";
		} else {
			symbol = "[O]";
		}

		switch (key) {
		case 1:
			game[2][0] = symbol;
			show();
			break;
		case 2:
			game[2][1] = symbol;
			show();
			break;
		case 3:
			game[2][2] = symbol;
			show();
			break;
		case 4:
			game[1][0] = symbol;
			show();
			break;
		case 5:
			game[1][1] = symbol;
			show();
			break;
		case 6:
			game[1][2] = symbol;
			show();
			break;
		case 7:
			game[0][0] = symbol;
			show();
			break;
		case 8:
			game[0][1] = symbol;
			show();
			break;
		case 9:
			game[0][2] = symbol;
			show();
			break;
		default:
		}
	}

	public static void main(String[] args) {
		int[][] win = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 }, { 1, 5, 9 },
				{ 3, 5, 7 } };
		int[] use = new int[9];
		int[] x = new int[9];
		int[] o = new int[9];

		int success = 0;
		int checkInput = 0;
		System.out.println("--XO Game--");
		for (int j = 0; j < game.length; j++) {
			for (int k = 0; k < game[j].length; k++) {
				System.out.print(game[j][k] + " ");
			}
			System.out.println("\n");
		}
		System.out.println("Please select the number above");
		Scanner sc = new Scanner(System.in);
		int i = 0;
		while (true) {

			int check = 0;
			while (checkInput == 0) {
				int p;
				try {
					System.out.print("Player 1 select : ");
					x[i] = sc.nextInt();
					for (p = 0; p < use.length; p++) {
						if (use[p] == x[i]) {
							System.out.println("Repeat value");
							x[i] = 0;
							break;
						}

					}
					if (p == use.length) {
						use[i] = x[i];
						createXO(x[i], 1);
						break;
					}
				} catch (Exception e) {
					System.out.println("incorrect value !!!!");
					java.lang.System.exit(0);
				}

			}

			for (int j = 0; j < win.length; j++) {
				for (int k = 0; k < win[j].length; k++) {
					for (int n = 0; n < x.length; n++) {
						if (x[n] == win[j][k]) {
							success++;
						}
					}

				}
				if (success != 3) {
					success = 0;
				} else {
					System.out.println("Player 1 win");
					java.lang.System.exit(0);
				}
			}

			while (checkInput == 0) {
				int p;
				try {
					System.out.print("Player 2 select : ");
					o[i] = sc.nextInt();

					for (p = 0; p < use.length; p++) {
						if (use[p] == o[i]) {
							System.out.println("Repeat value");
							o[i] = 0;
							break;
						}

					}

					if (p == use.length) {
						use[i] = o[i];
						createXO(o[i], 2);
						break;
					}
				} catch (Exception e) {
					System.out.println("incorrect value !!!!");
					java.lang.System.exit(0);
				}

			}

			for (int j = 0; j < win.length; j++) {
				for (int k = 0; k < win[j].length; k++) {
					for (int n = 0; n < o.length; n++) {
						if (o[n] == win[j][k]) {
							success++;
						}
					}

				}
				if (success != 3) {
					success = 0;
				} else {
					System.out.println("Player 2 win");
					java.lang.System.exit(0);
				}
			}
			if (check == 1) {
				break;
			}
			i++;
		}

	}

}
