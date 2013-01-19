/*
 * Copyright 2011, 2012 open knowledge GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.toadally.boot;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.toadally.model.Task;
import org.toadally.model.TaskDetail;
import org.toadally.model.TaskList;
import org.toadally.tx.Transactional;

public class DemoDataLoader {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void init() {
		System.out.println("Starting the unstartable...");
		TaskList taskList = new TaskList("My Fürst List");

		Task task = new Task("Task 1", 1, taskList);
		task = new Task("Subtask 1.1", 5, task);
		task = new Task("Subtask 1.1.1", 5, task);
		task = new Task("Task 2", 2, taskList);
		task = new Task("Task 3", 3, taskList);
		task = new Task("Task 4", 4, taskList);
		task = new Task("Task 5", 5, taskList);
		Task subtask = new Task("Subtask 5.1", 5, task);
		task = new Task("Subtask 5.1.1", 5, subtask);
		task = new Task("Subtask 5.1.2", 5, subtask);

		new TaskDetail(false, new Date(), "My first description", task);

		em.persist(taskList);
	}
}
