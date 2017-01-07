import java.util.Scanner;
public class AnswerQuestion{
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int age;
		String height;
		double weight;
		System.out.println("How old are you?");
		age = keyboard.nextInt();
		System.out.println("how tall are you");
		height = keyboard.next();
		System.out.println("how much do you weight");
		weight = keyboard.nextDouble();
		System.out.println("So you are"+age+"old,"+height+" tall, and " +weight +" weight");
	}
}