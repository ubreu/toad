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

package org.toadally.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TASK")
@NamedQuery(name = "task.findAll", query = "select t from Task t order by t.id asc")
public class Task {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "SORT_NO")
	private int sortNo;

	@OneToOne(mappedBy="task", cascade = CascadeType.ALL)
	private TaskDetail taskDetail;

	@ManyToOne
	@JoinColumn(name = "TASK_LIST_ID")
	private TaskList taskList;

	@ManyToOne
	@JoinColumn(name = "TASK_ID")
	private Task parentTask;

	@OneToMany
	@JoinColumn(name = "TASK_ID")
	private List<Task> subTasks;
	
	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "CREATED_AT")
	private Date createdAt;

	@Column(name = "MODIFIED_BY")
	private String modifiedBy;

	@Column(name = "MODIFIED_AT")
	private Date modifiedAt;


	public Task() {
	}

	private Task(String title, int sortNo) {
		this.title = title;
		this.sortNo = sortNo;
	}

	public Task(String title, int sortNo, TaskList taskList) {
		this(title, sortNo);
		this.taskList = taskList;
	}

	public Task(String title, int sortNo, Task parentTask) {
		this(title, sortNo);
		this.setParentTask(parentTask);
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSortNo() {
		return sortNo;
	}

	public void setSortNo(int sortNo) {
		this.sortNo = sortNo;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public TaskDetail getTaskDetail() {
		return taskDetail;
	}

	public TaskList getTaskList() {
		return taskList;
	}

	public void setTaskList(TaskList taskList) {
		this.taskList = taskList;
	}

	public Task getParentTask() {
		return parentTask;
	}

	public void setParentTask(Task parentTask) {
		this.parentTask = parentTask;
	}

	public List<Task> getSubTasks() {
		return subTasks;
	}

	public void setSubTasks(List<Task> subTasks) {
		this.subTasks = subTasks;
	}

	/*
	 * 
	 * public void updateAuditInformation(CrmUser aCrmUser) { if (id > 0) {
	 * modifiedAt = new Date(); modifiedBy = aCrmUser.getLogin(); } else {
	 * createdAt = new Date(); modifiedAt = createdAt; createdBy =
	 * aCrmUser.getLogin(); modifiedBy = createdBy; } }
	 */
}
