package com.xiejuqi.groovy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("SalesOrder")
public class OrderVo implements Serializable{

	private static final long serialVersionUID = 4641734224138716314L;
	
	private Integer buid;
	
	@XStreamAlias("source_system")
	private String sourceSystem;
	
	@XStreamAlias("order_num")
	private String orderNum;
	
	@XStreamAlias("business_type")
	private String businessType;
	
	@XStreamAlias("asn_num")
	private String asnNum;
	
	@XStreamAlias("lsp_code")
	private String lspCode;
	
	@XStreamAlias("line_haul")
	private String lineHaul;
	
	@XStreamAlias("order_date")
	private Date orderDate;
	
	@XStreamAlias("related_id")
	private String relatedId;
	
	@XStreamAlias("current_status")
	private String currentStatus;
	
	@XStreamAlias("current_status_date")
	private Date currentStatusDate;
	
	@XStreamAlias("total_box")
	private Integer totalBox;
	
	@XStreamAlias("total_weight")
	private Double totalWeight;
	
	@XStreamAlias("total_volume")
	private Double totalVolume;
	
	@XStreamAlias("ship_type")
	private String shipType;
	
	@XStreamAlias("mas_loc")
	private String masLoc;
	
	@XStreamAlias("sorting_center")
	private String sortingCenter;
	
	@XStreamAlias("ex_date")
	private Date exDate;
	
	@XStreamAlias("insurance_fee")
	private Double insuranceFee;
	
	@XStreamAlias("to_priovince_code")
	private String toPriovinceCode;
	
	@XStreamAlias("to_province")
	private String toProvince;
	
	@XStreamAlias("to_city_code")
	private String toCityCode;
	
	@XStreamAlias("to_city")
	private String toCity;
	
	@XStreamAlias("to_division_code")
	private String toDivisionCode;
	
	@XStreamAlias("to_division")
	private String toDivision;
	
	@XStreamAlias("to_state_code")
	private String toStateCode;
	
	@XStreamAlias("to_state")
	private String toState;
	
	@XStreamAlias("to_linkman")
	private String toZipCode;
	
	@XStreamAlias("to_linkman")
	private String toLinkman;
	
	@XStreamAlias("to_company_name")
	private String toCompanyName;
	
	@XStreamAlias("to_address")
	private String toAddress;
	
	@XStreamAlias("to_phone")
	private String toPhone;
	
	@XStreamAlias("delivery_weekend_flag")
	private String deliveryWeekendFlag;
	
	@XStreamAlias("delivery_timeslot")
	private String deliveryTimeslot;
	
	@XStreamAlias("fdd_flag")
	private String fddFlag;
	
	@XStreamAlias("fdd_date")
	private Date fddDate;
	
	@XStreamAlias("payment_code")
	private String paymentCode;
	
	@XStreamAlias("total_due_amount")
	private Double totalDueAmount;
	
	@XStreamAlias("total_paid_amount")
	private Double totalPaidAmount;
	
	@XStreamAlias("selling_price")
	private Double sellingPrice;
	
	@XStreamAlias("identifying_code")
	private String identifyingCode;
	
	@XStreamAlias("cod_term")
	private String codTerm;
	
	@XStreamAlias("need_phone_confirm")
	private String needPhoneConfirm;
	
	@XStreamAlias("used_flag")
	private String usedFlag;
	
	@XStreamAlias("self_pickup_flag")
	private String selfPickupFlag;
	
	@XStreamAlias("order_type")
	private String orderType;
	
	@XStreamAlias("order_type_desc")
	private String orderTypeDesc;
	
	@XStreamAlias("original_order_num")
	private String originalOrderNum ;
	
	private String remark;
	
	@XStreamAlias("delivery_num")
	private String deliveryNum;
	
	@XStreamAlias("from_address")
	private String fromAddress;
	
	@XStreamAlias("from_province")
	private String fromProvince;
	
	@XStreamAlias("from_city")
	private String fromCity;
	
	@XStreamAlias("from_company_name")
	private String fromCompanyName;
	
	@XStreamAlias("from_linkman")
	private String fromLinkman;
	
	@XStreamAlias("from_zip_code")
	private String fromZipCode;
	
//	@XStreamAlias("detail")
//	List<OrderDetailVo> details = new ArrayList<OrderDetailVo>();

	public Integer getBuid() {
		return buid;
	}

	public void setBuid(Integer buid) {
		this.buid = buid;
	}

	public String getSourceSystem() {
		return sourceSystem;
	}

	public void setSourceSystem(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getAsnNum() {
		return asnNum;
	}

	public void setAsnNum(String asnNum) {
		this.asnNum = asnNum;
	}

	public String getLspCode() {
		return lspCode;
	}

	public void setLspCode(String lspCode) {
		this.lspCode = lspCode;
	}

	public String getLineHaul() {
		return lineHaul;
	}

	public void setLineHaul(String lineHaul) {
		this.lineHaul = lineHaul;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getRelatedId() {
		return relatedId;
	}

	public void setRelatedId(String relatedId) {
		this.relatedId = relatedId;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public Date getCurrentStatusDate() {
		return currentStatusDate;
	}

	public void setCurrentStatusDate(Date currentStatusDate) {
		this.currentStatusDate = currentStatusDate;
	}

	public Integer getTotalBox() {
		return totalBox;
	}

	public void setTotalBox(Integer totalBox) {
		this.totalBox = totalBox;
	}

	public Double getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(Double totalWeight) {
		this.totalWeight = totalWeight;
	}

	public Double getTotalVolume() {
		return totalVolume;
	}

	public void setTotalVolume(Double totalVolume) {
		this.totalVolume = totalVolume;
	}

	public String getShipType() {
		return shipType;
	}

	public void setShipType(String shipType) {
		this.shipType = shipType;
	}

	public String getMasLoc() {
		return masLoc;
	}

	public void setMasLoc(String masLoc) {
		this.masLoc = masLoc;
	}

	public String getSortingCenter() {
		return sortingCenter;
	}

	public void setSortingCenter(String sortingCenter) {
		this.sortingCenter = sortingCenter;
	}

	public Date getExDate() {
		return exDate;
	}

	public void setExDate(Date exDate) {
		this.exDate = exDate;
	}

	public Double getInsuranceFee() {
		return insuranceFee;
	}

	public void setInsuranceFee(Double insuranceFee) {
		this.insuranceFee = insuranceFee;
	}

	public String getToPriovinceCode() {
		return toPriovinceCode;
	}

	public void setToPriovinceCode(String toPriovinceCode) {
		this.toPriovinceCode = toPriovinceCode;
	}

	public String getToProvince() {
		return toProvince;
	}

	public void setToProvince(String toProvince) {
		this.toProvince = toProvince;
	}

	public String getToCityCode() {
		return toCityCode;
	}

	public void setToCityCode(String toCityCode) {
		this.toCityCode = toCityCode;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public String getToDivisionCode() {
		return toDivisionCode;
	}

	public void setToDivisionCode(String toDivisionCode) {
		this.toDivisionCode = toDivisionCode;
	}

	public String getToDivision() {
		return toDivision;
	}

	public void setToDivision(String toDivision) {
		this.toDivision = toDivision;
	}

	public String getToStateCode() {
		return toStateCode;
	}

	public void setToStateCode(String toStateCode) {
		this.toStateCode = toStateCode;
	}

	public String getToState() {
		return toState;
	}

	public void setToState(String toState) {
		this.toState = toState;
	}

	public String getToZipCode() {
		return toZipCode;
	}

	public void setToZipCode(String toZipCode) {
		this.toZipCode = toZipCode;
	}

	public String getToLinkman() {
		return toLinkman;
	}

	public void setToLinkman(String toLinkman) {
		this.toLinkman = toLinkman;
	}

	public String getToCompanyName() {
		return toCompanyName;
	}

	public void setToCompanyName(String toCompanyName) {
		this.toCompanyName = toCompanyName;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getToPhone() {
		return toPhone;
	}

	public void setToPhone(String toPhone) {
		this.toPhone = toPhone;
	}

	public String getDeliveryWeekendFlag() {
		return deliveryWeekendFlag;
	}

	public void setDeliveryWeekendFlag(String deliveryWeekendFlag) {
		this.deliveryWeekendFlag = deliveryWeekendFlag;
	}

	public String getDeliveryTimeslot() {
		return deliveryTimeslot;
	}

	public void setDeliveryTimeslot(String deliveryTimeslot) {
		this.deliveryTimeslot = deliveryTimeslot;
	}

	public String getFddFlag() {
		return fddFlag;
	}

	public void setFddFlag(String fddFlag) {
		this.fddFlag = fddFlag;
	}

	public Date getFddDate() {
		return fddDate;
	}

	public void setFddDate(Date fddDate) {
		this.fddDate = fddDate;
	}

	public String getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}

	public Double getTotalDueAmount() {
		return totalDueAmount;
	}

	public void setTotalDueAmount(Double totalDueAmount) {
		this.totalDueAmount = totalDueAmount;
	}

	public Double getTotalPaidAmount() {
		return totalPaidAmount;
	}

	public void setTotalPaidAmount(Double totalPaidAmount) {
		this.totalPaidAmount = totalPaidAmount;
	}

	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public String getIdentifyingCode() {
		return identifyingCode;
	}

	public void setIdentifyingCode(String identifyingCode) {
		this.identifyingCode = identifyingCode;
	}

	public String getCodTerm() {
		return codTerm;
	}

	public void setCodTerm(String codTerm) {
		this.codTerm = codTerm;
	}

	public String getNeedPhoneConfirm() {
		return needPhoneConfirm;
	}

	public void setNeedPhoneConfirm(String needPhoneConfirm) {
		this.needPhoneConfirm = needPhoneConfirm;
	}

	public String getUsedFlag() {
		return usedFlag;
	}

	public void setUsedFlag(String usedFlag) {
		this.usedFlag = usedFlag;
	}

	public String getSelfPickupFlag() {
		return selfPickupFlag;
	}

	public void setSelfPickupFlag(String selfPickupFlag) {
		this.selfPickupFlag = selfPickupFlag;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderTypeDesc() {
		return orderTypeDesc;
	}

	public void setOrderTypeDesc(String orderTypeDesc) {
		this.orderTypeDesc = orderTypeDesc;
	}

	public String getOriginalOrderNum() {
		return originalOrderNum;
	}

	public void setOriginalOrderNum(String originalOrderNum) {
		this.originalOrderNum = originalOrderNum;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDeliveryNum() {
		return deliveryNum;
	}

	public void setDeliveryNum(String deliveryNum) {
		this.deliveryNum = deliveryNum;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getFromProvince() {
		return fromProvince;
	}

	public void setFromProvince(String fromProvince) {
		this.fromProvince = fromProvince;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getFromCompanyName() {
		return fromCompanyName;
	}

	public void setFromCompanyName(String fromCompanyName) {
		this.fromCompanyName = fromCompanyName;
	}

	public String getFromLinkman() {
		return fromLinkman;
	}

	public void setFromLinkman(String fromLinkman) {
		this.fromLinkman = fromLinkman;
	}

	public String getFromZipCode() {
		return fromZipCode;
	}

	public void setFromZipCode(String fromZipCode) {
		this.fromZipCode = fromZipCode;
	}

//	public List<OrderDetailVo> getDetails() {
//		return details;
//	}
//
//	public void setDetails(List<OrderDetailVo> details) {
//		this.details = details;
//	}
	
}
