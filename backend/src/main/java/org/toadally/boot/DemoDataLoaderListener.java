package org.toadally.boot;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DemoDataLoaderListener implements ServletContextListener {

	@Inject
	private DemoDataLoader loader;

	public void contextInitialized(ServletContextEvent sce) {
		loader.init();
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}
}
