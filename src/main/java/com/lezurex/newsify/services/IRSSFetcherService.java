package com.lezurex.newsify.services;

import com.lezurex.newsify.entities.RSSFeed;

public interface IRSSFetcherService {
	public void fetchAll();
	public void fetchFeed(RSSFeed rssFeed);
}
