package com.hazelcast.simulator.tests.map.domain;



import java.math.BigDecimal;
import java.time.LocalDateTime;


public class MarketDataHazelcastEntity {

    public static final String FIELD_NAME_ID = "id";
    public static final String FIELD_NAME_INCREMENT_ID = "increment_id";
    public static final String FIELD_NAME_ASK = "ask";
    public static final String FIELD_NAME_BASE_PRICE = "base_price";
    public static final String FIELD_NAME_BID = "bid";
    public static final String FIELD_NAME_DATA_VENDOR_CODE = "data_vendor_code";
    public static final String FIELD_NAME_EXCHANGE_CODE = "exchange_code";
    public static final String FIELD_NAME_HIGH = "high";
    public static final String FIELD_NAME_LAST = "last";
    public static final String FIELD_NAME_LIMIT_DOWN = "limit_down";
    public static final String FIELD_NAME_LIMIT_UP = "limit_up";
    public static final String FIELD_NAME_LOW = "low";
    public static final String FIELD_NAME_PREV_DAY_CLOSE = "prev_day_close";
    public static final String FIELD_NAME_PRICE_STEP = "price_step";
    public static final String FIELD_NAME_PROCESSED_TIME = "processed_time";
    public static final String FIELD_NAME_QUANTITY = "quantity";
    public static final String FIELD_NAME_SYMBOL = "symbol";
    public static final String FIELD_NAME_SYMBOL_DATA_VENDOR = "symbol_data_vendor";
    public static final String FIELD_NAME_TICKER = "ticker";
    public static final String FIELD_NAME_UPDATE_TIME = "update_time";
    public static final String FIELD_NAME_DELETE_TIME = "delete_time";
    public static final String FIELD_NAME_VOLUME = "volume";
    public static final String FIELD_NAME_REFERENCE = "reference";
    public static final String FIELD_NAME_DB_UPDATE_TIME = "db_update_time";

    private String id;
    private Long incrementId;
    private String ticker;
    private String symbol;
    private String symbolDataVendor;
    private BigDecimal bid;
    private BigDecimal ask;
    private BigDecimal low;
    private BigDecimal high;
    private BigDecimal last;
    private BigDecimal prevDayClose;
    private BigDecimal quantity;
    private BigDecimal volume;
    private BigDecimal limitUp;
    private BigDecimal limitDown;
    private BigDecimal priceStep;
    private BigDecimal basePrice;
    private LocalDateTime updateTime;
    private LocalDateTime deleteTime;
    private String dataVendorCode;
    private LocalDateTime processedTime;
    private String exchangeCode;
    private String reference;
    private LocalDateTime dbUpdateTime;


    public MarketDataHazelcastEntity(String id, Long incrementId, String ticker, String symbol, String symbolDataVendor, BigDecimal bid, BigDecimal ask, BigDecimal low, BigDecimal high, BigDecimal last, BigDecimal prevDayClose, BigDecimal quantity, BigDecimal volume, BigDecimal limitUp, BigDecimal limitDown, BigDecimal priceStep, BigDecimal basePrice, LocalDateTime updateTime, LocalDateTime deleteTime, String dataVendorCode, LocalDateTime processedTime, String exchangeCode, String reference, LocalDateTime dbUpdateTime) {
        this.id = id;
        this.incrementId = incrementId;
        this.ticker = ticker;
        this.symbol = symbol;
        this.symbolDataVendor = symbolDataVendor;
        this.bid = bid;
        this.ask = ask;
        this.low = low;
        this.high = high;
        this.last = last;
        this.prevDayClose = prevDayClose;
        this.quantity = quantity;
        this.volume = volume;
        this.limitUp = limitUp;
        this.limitDown = limitDown;
        this.priceStep = priceStep;
        this.basePrice = basePrice;
        this.updateTime = updateTime;
        this.deleteTime = deleteTime;
        this.dataVendorCode = dataVendorCode;
        this.processedTime = processedTime;
        this.exchangeCode = exchangeCode;
        this.reference = reference;
        this.dbUpdateTime = dbUpdateTime;
    }


    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getIncrementId() {
        return this.incrementId;
    }

    public void setIncrementId(Long incrementId) {
        this.incrementId = incrementId;
    }

    public String getTicker() {
        return this.ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbolDataVendor() {
        return this.symbolDataVendor;
    }

    public void setSymbolDataVendor(String symbolDataVendor) {
        this.symbolDataVendor = symbolDataVendor;
    }

    public BigDecimal getBid() {
        return this.bid;
    }

    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

    public BigDecimal getAsk() {
        return this.ask;
    }

    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }

    public BigDecimal getLow() {
        return this.low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getHigh() {
        return this.high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLast() {
        return this.last;
    }

    public void setLast(BigDecimal last) {
        this.last = last;
    }

    public BigDecimal getPrevDayClose() {
        return this.prevDayClose;
    }

    public void setPrevDayClose(BigDecimal prevDayClose) {
        this.prevDayClose = prevDayClose;
    }

    public BigDecimal getQuantity() {
        return this.quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getVolume() {
        return this.volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getLimitUp() {
        return this.limitUp;
    }

    public void setLimitUp(BigDecimal limitUp) {
        this.limitUp = limitUp;
    }

    public BigDecimal getLimitDown() {
        return this.limitDown;
    }

    public void setLimitDown(BigDecimal limitDown) {
        this.limitDown = limitDown;
    }

    public BigDecimal getPriceStep() {
        return this.priceStep;
    }

    public void setPriceStep(BigDecimal priceStep) {
        this.priceStep = priceStep;
    }

    public BigDecimal getBasePrice() {
        return this.basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public LocalDateTime getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDateTime getDeleteTime() {
        return this.deleteTime;
    }

    public void setDeleteTime(LocalDateTime deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getDataVendorCode() {
        return this.dataVendorCode;
    }

    public void setDataVendorCode(String dataVendorCode) {
        this.dataVendorCode = dataVendorCode;
    }

    public LocalDateTime getProcessedTime() {
        return this.processedTime;
    }

    public void setProcessedTime(LocalDateTime processedTime) {
        this.processedTime = processedTime;
    }

    public String getExchangeCode() {
        return this.exchangeCode;
    }

    public void setExchangeCode(String exchangeCode) {
        this.exchangeCode = exchangeCode;
    }

    public String getReference() {
        return this.reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public LocalDateTime getDbUpdateTime() {
        return this.dbUpdateTime;
    }

    public void setDbUpdateTime(LocalDateTime dbUpdateTime) {
        this.dbUpdateTime = dbUpdateTime;
    }

    



} 