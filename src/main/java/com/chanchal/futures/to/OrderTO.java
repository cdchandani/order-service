package com.chanchal.futures.to;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

///home/hp/dev/work/FinancialData/orders_data/daywise_order_book_2023-01-19.csv
@Getter
@ToString
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OrderTO {

    private String prc;
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
    private String tickSize;
    private String prcType;
    private String status;
    private String minQty;
    private String orderCriteria;
    private String sym;
    private String multiplier;
    private String exseg;
    private String exchOrdID;
    private String exchConfrmtime;
    private String syomOrderId;
    private String pCode;
    private String dscQty;
    private String exchange;
    private String ordValdate;
    private String accountId;
    private String exchangeUserInfo;
    private String avgPrc;
    private String trgPrc;
    private String tranType;
    private String bQty;
    private String fillShares;
    private String trsym;
    private String algoCategory;
    private String strikePrice;
    private String sipIndicator;
    private String algoID;
    private String reportType;
    private String noMktPro;
    private String brokerClient;
    private String orderUserMessage;
    private String decprec;
    private String expDate;
    private String cOPercentage;
    private String marketProtectionPercentage;
    private String expSsbDate;
    private String nstOrdNo;
    private String orderedTime;
    private String modifiedBy;
    private String rejReason;
    private String scripName;
    private String stat;
    private String orderenTryTime;
    private String priceDenomenator;
    private String panNo;
    private String refLmtPrice;
    private String priceNumerator;
    private String orderSource;
    private String token;
    private String generalDenomenator;
    private String validity;
    private String series;
    private String instName;
    private String generalNumerator;
    private String users;
    private String remarks;
    private String iSinceBOE;
}
