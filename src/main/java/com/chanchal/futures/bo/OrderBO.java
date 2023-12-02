package com.chanchal.futures.bo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

///home/hp/dev/work/FinancialData/orders_data/daywise_order_book_2023-01-19.csv
@Entity
@Table(name = "tbl_order", schema = "futures")
@ToString
@Getter
@Setter
public class OrderBO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String prc;
    @Column(name = "request_id")
    private String requestId;
    private String cancelQty;
    private String discQtyPerc;
    private String customText;
    private String mktpro;
    private String defMktProval;
    private String optionType;
    private String usecs;
    private String mpro;
    private String qty;
    private String orderGenerationType;
    private String unFilledSize;
    private String orderAuthStatus;
    private String userComments;
    private String prcType;
    private String status;
    private String minQty;
    private String orderCriteria;
    private String sym;
    private String exchOrdID;
    private String exchConfrmtime;
    private String dscQty;
    private String exchange;
    private String ordValdate;
    private String accountId;
    private String avgPrc;
    private String tranType;
    private String bQty;
    private String fillShares;
    private String algoCategory;
    private String strikePrice;
    private String reportType;
    private String brokerClient;
    private String orderUserMessage;
    private String expDate;
    private String orderedTime;
    private String modifiedBy;
    private String rejReason;
    private String panNo;
    private String orderSource;
    private String instName;
    private String remarks;
    @CreationTimestamp
    private Timestamp createdDt;
    @CreationTimestamp
    private Timestamp modifiedDt;


}
