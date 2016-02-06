import java.util.Scanner;

public class CaesarCipher {

	// Метод, проверяващ дали въведената стойност е от тип int
	public static int tryCatch(String s, int i) {
		try {
			// Конвертиране от String към тип int
			i = Integer.parseInt(s.trim());
		} catch (NumberFormatException nfe) {
			System.out.println("NumberFormatException: " + nfe.getMessage());
		}
		return i;
	}

	// Метод за шифроване
	public static void encryption(String text, int step) {
		text = text.trim();
		char[] array = text.toCharArray();
		int length = array.length;
		String encryption = "";
		for (int i = 0; i < length; i++) {
			int ch = (int) array[i];
			if (ch >= 65 && ch <= 90) {
				while (ch + step > 90) {
					ch -= 26;
				}
				ch = ch + step;

			}
			if (ch >= 97 && ch <= 122) {
				while (ch + step > 122) {
					ch -= 26;
				}
				ch = ch + step;

			}
			array[i] = (char) ch;
		}

		for (int i = 0; i < length; i++) {
			encryption = encryption + array[i];
		}
		System.out.println("The encrypted text is: " + encryption);
	}

	// Метод за дешифроване
	public static void decryption(String text, int step) {
		text = text.trim();
		char[] array = text.toCharArray();
		int length = array.length;
		String decryption = "";
		for (int i = 0; i < length; i++) {
			int ch = (int) array[i];
			if (ch >= 65 && ch <= 90) {
				while (ch - step < 65) {
					ch += 26;
				}
				ch = ch - step;

			}
			if (ch >= 97 && ch <= 122) {
				while (ch - step < 97) {
					ch += 26;
				}
				ch = ch - step;

			}
			array[i] = (char) ch;
		}

		for (int i = 0; i < length; i++) {
			decryption = decryption + array[i];
		}
		System.out.println("The decrypted text is: " + decryption);
	}

	// Главно меню
	public static void menu() {
		Scanner input = new Scanner(System.in);
		System.out.println("       CEASAR CIPHER      ");
		System.out.println("--------------------------");
		System.out.println("Please, select an action:");
		System.out.println("1.Encryption");
		System.out.println("2.Decryption");
		String s = input.nextLine();
		int choice = 0;
		String text = "";
		int step = 0;

		choice = tryCatch(s, choice);

		while (choice != 1 && choice != 2) {
			System.out.println("Error! There is no such option. Try again!");
			s = input.nextLine();
			choice = tryCatch(s, choice);

		}
		;

		switch (choice) {
		case 1:
			Scanner input1 = new Scanner(System.in);
			System.out.println("You chose encryption.");
			System.out.println("Please, enter text to encrypt");
			text = input1.nextLine();
			while (text.equals("")) {
				System.out.println("Error,you should enter text. Try again!");
				text = input1.nextLine();
			}
			System.out.println("Please, choose step different from 0");
			s = input1.nextLine();
			step = tryCatch(s, step);
			while (step == 0) {
				System.out.println("Error! Try again.");
				s = input1.nextLine();
				step = tryCatch(s, step);
			}
			encryption(text, step);

			break;
		case 2:
			Scanner input2 = new Scanner(System.in);
			System.out.println("You chose decryption.");
			System.out.println("Please, enter text to decrypt");
			text = input2.nextLine();
			while (text.equals("")) {
				System.out.println("Error,you should enter text. Try again!");
				text = input2.nextLine();
			}
			System.out.println("Please, choose step different from 0");
			s = input2.nextLine();
			step = tryCatch(s, step);
			while (step == 0) {
				System.out.println("Error! Try again.");
				s = input2.nextLine();
				step = tryCatch(s, step);
			}
			decryption(text, step);

			break;
		default:
			System.out.println("Error! There is no such option.");
			break;
		}
	}

	public static void main(String[] args) {

		menu();

	}

}
