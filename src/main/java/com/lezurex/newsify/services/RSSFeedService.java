package com.lezurex.newsify.services;

import com.lezurex.newsify.database.IRSSFeedRepo;
import com.lezurex.newsify.entities.RSSFeed;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RSSFeedService implements IRSSFeedService {
	private IRSSFeedRepo rssFeedRepo;

	public RSSFeedService(IRSSFeedRepo rssFeedRepo) {
		this.rssFeedRepo = rssFeedRepo;
	}

	@Override
	public List<RSSFeed> getRSSFeeds() {
		return rssFeedRepo.findAll();
	}
}
