package org.toadally.model;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class TaskTest {

	@Test
	public void test() {
		Task parent = new Task();
		
		Task child = new Task();
		child.setParentTask(parent);
		
		assertThat(child.getParentTask(), is(parent));
	}

}
