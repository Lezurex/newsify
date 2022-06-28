package com.lezurex.newsify.services;

import com.lezurex.newsify.entities.Article;
import com.lezurex.newsify.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class CliService implements CommandLineRunner {
	@Autowired
	private ConfigurableApplicationContext context;
	private ICategoryService categoryService;
	private IRSSFetcherService fetcherService;
	private Scanner scanner;

	public CliService(ICategoryService categoryService, IRSSFetcherService fetcherService) {
		this.categoryService = categoryService;
		this.fetcherService = fetcherService;
		this.scanner = new Scanner(System.in);
	}

	@Override
	public void run(String... args) {
		fetcherService.fetchAll();
		List<Category> categories = categoryService.getCategories();
		if (categories.size() <= 0) {
			System.out.println("Sorry, there are no categories! There's nothing to view.");
		} else {
			while (true) {
				System.out.println("Which Category do you want to view? Enter the corresponding number.");
				for (int i = 0; i < categories.size(); i++) {
					System.out.println("[" + i + 1 + "]: " + categories.get(i).getName());
				}
				System.out.println("[0]: Exit");
				fetcherService.fetchAll();
				String number = scanner.nextLine();
				int chosenCategoryIndex = Integer.parseInt(number) - 1;
				if (chosenCategoryIndex == -1) {
					System.exit(SpringApplication.exit(context));
				}
				Category chosenCategory = categories.get(chosenCategoryIndex);
				List<Article> articles = chosenCategory.getArticles();
				if (articles.size() <= 0) {
					System.out.println("Sorry, there are no articles in this category!");
				} else {
					for (Article article : chosenCategory.getArticles()) {
						System.out.println(article.getTitle());
						System.out.println(article.getDescription());
						System.out.println(article.getLink());
						System.out.println(article.getPubDate());
					}
				}
			}
		}
	}
}
