package com.niit.backend.model;

import java.util.UUID;

public class JobOportunities {
private String jobOportunities_id;
private String title;
private String description;
private String createdAt;
public String getJobOportunities_id() {
	return jobOportunities_id;
}
public void setJobOportunities_id(String jobOportunities_id) {
	this.jobOportunities_id = jobOportunities_id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(String createdAt) {
	this.createdAt = createdAt;
}
public JobOportunities(){
	this.jobOportunities_id="JOB"+UUID.randomUUID().toString().substring(30).toUpperCase();
}
}