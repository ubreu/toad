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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TASK_LIST")
@NamedQuery(name="tasklist.findAll", query="select t from TaskList t order by t.id asc")
public class TaskList {

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@OneToMany(mappedBy="taskList")
	private List<Task> tasks;
	
	@Column(name="CREATED_BY")
	private String createdBy;

	@Column(name="CREATED_AT")
	private Date createdAt;

	@Column(name="MODIFIED_BY")
	private String modifiedBy;

	@Column(name="MODIFIED_AT")
	private Date modifiedAt;


	public TaskList() {
	}

	public TaskList(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
    public List<Task> getTasks() {
		return tasks;  
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
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
