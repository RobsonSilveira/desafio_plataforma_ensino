package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Quantas aulas tem o curso? ");
		int numOfLessons = sc.nextInt();

		List<Lesson> list = new ArrayList<>();

		for (int i = 1; i <= numOfLessons; i++) {
			list.add(createLesson(sc, i));
		}

		int courseDuration = 0;

		for (Lesson lesson : list) {
			courseDuration += lesson.duration();
		}
		System.out.println("\nDURAÇÃO TOTAL DO CURSO = " + courseDuration + " segundos");

	}

	public static Lesson createLesson(Scanner sc, int position) {
		String title;
		System.out.println("\nDados da " + position + "a aula:");
		System.out.print("Conteúdo ou tarefa (c/t)? ");
		char productType = sc.next().charAt(0);
		sc.nextLine();
		System.out.print("Título: ");
		title = sc.nextLine();

		if (productType == 'c') {
			System.out.print("URL do vídeo: ");
			String url = sc.nextLine();
			System.out.print("Duração em segundos: ");
			int seconds = sc.nextInt();
			return new Video(title, url, seconds);
		} else {
			System.out.print("Descrição: ");
			String description = sc.nextLine();
			System.out.print("Quantidade de questões: ");
			int questionCount = sc.nextInt();
			return new Task(title, description, questionCount);
		}
	}

}
