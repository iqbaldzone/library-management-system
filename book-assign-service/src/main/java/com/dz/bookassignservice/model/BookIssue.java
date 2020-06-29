package com.dz.bookassignservice.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
@Entity
@Table(name = "bookIssueDetails")
@Data
public class BookIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_id")
    private Long bookId;

    private Timestamp issueTime;

    private Timestamp returnTime;

    private Timestamp deletedTime;

    private boolean deleted;

    @Column(name = "issue_by")
    private Long issuedBy;

    @Column(name = "issue_to")
    private Long issueTo;

    private double amount;

    private int quantity;

    @Column(name = "is_returned")
    private boolean returned;

    @Column(name = "is_sold")
    private boolean sold;

    private double penalty = 0.0;
}
