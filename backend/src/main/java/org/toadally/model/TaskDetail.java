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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="TASK_DETAIL")
public class TaskDetail {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Task task;
	
	@Column(name="CHECKED")
	private boolean checked;

	@Column(name="DUE_DATE")
	private Date dueDate;

	@Column(name="DESCRIPTION")
	private String description;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Column(name="CREATED_AT")
	private Date createdAt;

	@Column(name="MODIFIED_BY")
	private String modifiedBy;

	@Column(name="MODIFIED_AT")
	private Date modifiedAt;

	public TaskDetail() {
	}

	public TaskDetail(boolean checked, Date dueDate, String description, Task task) {
		this.checked = checked;
		this.dueDate = dueDate;
		this.description = description;
		this.setTask(task);
	}

	public int getId() {
		return id;
	}

	public Task getTask() {
		return task;
	}
	
	public void setTask(Task task) {
		this.task = task;
	}
	
	public boolean getChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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

	/*  

  public void updateAuditInformation(CrmUser aCrmUser) {
    if (id > 0) {
      modifiedAt = new Date();
      modifiedBy = aCrmUser.getLogin();
    } else {
      createdAt = new Date();
      modifiedAt = createdAt;
      createdBy = aCrmUser.getLogin();
      modifiedBy = createdBy;
    }  
  }
	 */    
}
