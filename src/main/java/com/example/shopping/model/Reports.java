package com.example.shopping.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reports")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reports_ID")
    private Long id;
    @Column(name = "report_name")
    private String reportName;
    @Column(name = "report_date")
    private String reportDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "acc_id")
    private Accounts accounts;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "logs_id")
    private Logs logs;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trans_id")
    private Transactions transactions;

}
