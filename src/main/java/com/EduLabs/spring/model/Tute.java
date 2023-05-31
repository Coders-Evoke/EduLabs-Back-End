package com.EduLabs.spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "tutes")
public class Tute {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "ClassID")
  private String ClassID;

  @Column(name = "title")
  private String title;

  @Column(name = "totalCount")
  private int totalCount;

  @Column(name = "remainingCount")
  private int remainingCount;

  public Tute() {

  }

  public Tute(String ClassID, String title, int totalCount, int remainingCount) {
    this.ClassID = ClassID;
    this.title = title;
    this.totalCount = totalCount;
    this.remainingCount = remainingCount;
  }

  public long getId() {
    return id;
  }

  public String getClassID() {
    return ClassID;
  }

  public void setClassID(String ClassID) {
    this.ClassID = ClassID;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(int totalCount) {
    this.totalCount = totalCount;
  }

  public int getRemainingCount() {
    return remainingCount;
  }

  public void setRemainingCount(int remainingCount) {
    this.remainingCount = remainingCount;
  }

  @Override
  public String toString() {
    return "Tutorial [id=" + id + ", ClassID=" + ClassID + ", title=" + title + ", totalCount=" + totalCount + ", remainingCount=" + remainingCount + "]";
  }

}
