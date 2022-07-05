package com.lezurex.newsify.services;

import com.lezurex.newsify.database.IArticleRepo;
import com.lezurex.newsify.database.IRSSFeedRepo;
import com.lezurex.newsify.entities.Article;
import com.lezurex.newsify.entities.RSSFeed;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@Service
public class RSSFetcherService implements IRSSFetcherService {

	private final IRSSFeedRepo feedRepo;
	private final IArticleRepo articleRepo;

	public RSSFetcherService(IRSSFeedRepo feedRepo, IArticleRepo articleRepo) {
		this.feedRepo = feedRepo;
		this.articleRepo = articleRepo;
	}

	@Override
	public void fetchAll() {
		List<RSSFeed> feeds = feedRepo.findAll();
		feeds.forEach(this::fetchFeed);
	}

	@Override
	public void fetchFeed(RSSFeed rssFeed) {
		SyndFeedInput input = new SyndFeedInput();
		try {
			SyndFeed feed = input.build(new XmlReader(new URL(rssFeed.getUrl())));
			var entries = feed.getEntries();
			var iterator = entries.iterator();
			while (iterator.hasNext()) {
				var entry = iterator.next();
				if (!articleRepo.existsById(entry.getUri())) {
					Article article = new Article(entry.getUri(), entry.getTitle(),
							entry.getDescription() != null ? entry.getDescription().getValue() : "",
							entry.getPublishedDate(), entry.getLink(), rssFeed.getCategory(), rssFeed);
					articleRepo.save(article);
				}
			}
		} catch (IllegalArgumentException | FeedException | IOException e) {
			e.printStackTrace();
		}
	}
}
