package com.mycom.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FeedBack {
	public static final String TABLE_NAME = "interviewfeedback";
	public static final String REASON_COLUMN = "reason";
	public static final String FEEDBACKSTATE_COLUMN = "feedbackState";
	public static final String IDINTERVIEWER_COLUMN = "idInterviewer";
	public static final String IDINTERVIEW_COLUMN = "idInterview";
	public static final String ID_COLUMN = "id";
	
	private Long id;
	@Size(min=1)
	private String reason;
	private String feedbackState;
	private long idInterviewer;
	private long idInterview;
	private String interviewname;
	private String interviewername;
	
	
	

	public String getInterviewname() {
		return interviewname;
	}

	public void setInterviewname(String interviewname) {
		this.interviewname = interviewname;
	}

	public String getInterviewername() {
		return interviewername;
	}

	public void setInterviewername(String interviewername) {
		this.interviewername = interviewername;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFeedbackState() {
		return feedbackState;
	}

	public void setFeedbackState(String feedbackState) {
		this.feedbackState = feedbackState;
	}

	public long getIdInterviewer() {
		return idInterviewer;
	}

	public void setIdInterviewer(long idInterviewer) {
		this.idInterviewer = idInterviewer;
	}

	public long getIdInterview() {
		return idInterview;
	}

	public void setIdInterview(long idInterview) {
		this.idInterview = idInterview;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
