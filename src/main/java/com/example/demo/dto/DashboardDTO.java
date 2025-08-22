package com.example.demo.dto;

public class DashboardDTO {
    private long totalInternships;
    private long totalApplications;
    private long pendingApprovals;
    private long selectedStudents;
    
    public DashboardDTO() {}
    
    public DashboardDTO(long totalInternships, long totalApplications, long pendingApprovals, long selectedStudents) {
        this.totalInternships = totalInternships;
        this.totalApplications = totalApplications;
        this.pendingApprovals = pendingApprovals;
        this.selectedStudents = selectedStudents;
    }
    
    public long getTotalInternships() { return totalInternships; }
    public void setTotalInternships(long totalInternships) { this.totalInternships = totalInternships; }
    
    public long getTotalApplications() { return totalApplications; }
    public void setTotalApplications(long totalApplications) { this.totalApplications = totalApplications; }
    
    public long getPendingApprovals() { return pendingApprovals; }
    public void setPendingApprovals(long pendingApprovals) { this.pendingApprovals = pendingApprovals; }
    
    public long getSelectedStudents() { return selectedStudents; }
    public void setSelectedStudents(long selectedStudents) { this.selectedStudents = selectedStudents; }
}