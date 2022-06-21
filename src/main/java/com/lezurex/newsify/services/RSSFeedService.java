package com.lezurex.newsify.services;

import com.lezurex.newsify.database.IRSSFeedRepo;
import com.lezurex.newsify.entities.RSSFeed;

import java.util.List;

public class RSSFeedService implements IRSSFeedService{
	IRSSFeedRepo rsaFeedRepo;

	public RSSFeedService(IRSSFeedRepo rssFeedRepo) {
		this.rsaFeedRepo = rssFeedRepo;
	}

	@Override
	public List<RSSFeed> getRSSFeeds() {
		return rsaFeedRepo.findAll();
	}
}
