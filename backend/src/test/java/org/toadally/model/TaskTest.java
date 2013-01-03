package org.toadally.model;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TaskTest {

	Logger LOGGER = LoggerFactory.getLogger(TaskTest.class.getName());
	
	@Test
	public void test() {
		LOGGER.debug("starting test");
		Task parent = new Task();
		Task child = new Task();
		child.setParentTask(parent);
		
		assertThat(child.getParentTask(), is(parent));
	}

}
