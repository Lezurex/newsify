package com.lezurex.newsify.services;

import com.lezurex.newsify.database.IRSSFeedRepo;
import com.lezurex.newsify.entities.RSSFeed;

import java.util.List;

public class RSSFetcherService implements IRSSFetcherService {
	IRSSFeedRepo feedRepo;

	public RSSFetcherService(IRSSFeedRepo feedRepo) {
		this.feedRepo = feedRepo;
	}

	@Override
	public void fetchAll() {
		List<RSSFeed> feeds = feedRepo.findAll();
		feeds.forEach(this::fetchFeed);
	}

	@Override
	public void fetchFeed(RSSFeed rssFeed) {

	}
}