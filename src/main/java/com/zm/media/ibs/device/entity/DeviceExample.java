package com.zm.media.ibs.device.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andDeviceIdIsNull() {
            addCriterion("deviceId is null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIsNotNull() {
            addCriterion("deviceId is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceIdEqualTo(Long value) {
            addCriterion("deviceId =", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotEqualTo(Long value) {
            addCriterion("deviceId <>", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThan(Long value) {
            addCriterion("deviceId >", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("deviceId >=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThan(Long value) {
            addCriterion("deviceId <", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdLessThanOrEqualTo(Long value) {
            addCriterion("deviceId <=", value, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdIn(List<Long> values) {
            addCriterion("deviceId in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotIn(List<Long> values) {
            addCriterion("deviceId not in", values, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdBetween(Long value1, Long value2) {
            addCriterion("deviceId between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceIdNotBetween(Long value1, Long value2) {
            addCriterion("deviceId not between", value1, value2, "deviceId");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeIsNull() {
            addCriterion("deviceCode is null");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeIsNotNull() {
            addCriterion("deviceCode is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeEqualTo(String value) {
            addCriterion("deviceCode =", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeNotEqualTo(String value) {
            addCriterion("deviceCode <>", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeGreaterThan(String value) {
            addCriterion("deviceCode >", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("deviceCode >=", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeLessThan(String value) {
            addCriterion("deviceCode <", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeLessThanOrEqualTo(String value) {
            addCriterion("deviceCode <=", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeLike(String value) {
            addCriterion("deviceCode like", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeNotLike(String value) {
            addCriterion("deviceCode not like", value, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeIn(List<String> values) {
            addCriterion("deviceCode in", values, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeNotIn(List<String> values) {
            addCriterion("deviceCode not in", values, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeBetween(String value1, String value2) {
            addCriterion("deviceCode between", value1, value2, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andDeviceCodeNotBetween(String value1, String value2) {
            addCriterion("deviceCode not between", value1, value2, "deviceCode");
            return (Criteria) this;
        }

        public Criteria andNetTypeIsNull() {
            addCriterion("netType is null");
            return (Criteria) this;
        }

        public Criteria andNetTypeIsNotNull() {
            addCriterion("netType is not null");
            return (Criteria) this;
        }

        public Criteria andNetTypeEqualTo(Integer value) {
            addCriterion("netType =", value, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeNotEqualTo(Integer value) {
            addCriterion("netType <>", value, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeGreaterThan(Integer value) {
            addCriterion("netType >", value, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("netType >=", value, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeLessThan(Integer value) {
            addCriterion("netType <", value, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeLessThanOrEqualTo(Integer value) {
            addCriterion("netType <=", value, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeIn(List<Integer> values) {
            addCriterion("netType in", values, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeNotIn(List<Integer> values) {
            addCriterion("netType not in", values, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeBetween(Integer value1, Integer value2) {
            addCriterion("netType between", value1, value2, "netType");
            return (Criteria) this;
        }

        public Criteria andNetTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("netType not between", value1, value2, "netType");
            return (Criteria) this;
        }

        public Criteria andNetIPIsNull() {
            addCriterion("netIP is null");
            return (Criteria) this;
        }

        public Criteria andNetIPIsNotNull() {
            addCriterion("netIP is not null");
            return (Criteria) this;
        }

        public Criteria andNetIPEqualTo(String value) {
            addCriterion("netIP =", value, "netIP");
            return (Criteria) this;
        }

        public Criteria andNetIPNotEqualTo(String value) {
            addCriterion("netIP <>", value, "netIP");
            return (Criteria) this;
        }

        public Criteria andNetIPGreaterThan(String value) {
            addCriterion("netIP >", value, "netIP");
            return (Criteria) this;
        }

        public Criteria andNetIPGreaterThanOrEqualTo(String value) {
            addCriterion("netIP >=", value, "netIP");
            return (Criteria) this;
        }

        public Criteria andNetIPLessThan(String value) {
            addCriterion("netIP <", value, "netIP");
            return (Criteria) this;
        }

        public Criteria andNetIPLessThanOrEqualTo(String value) {
            addCriterion("netIP <=", value, "netIP");
            return (Criteria) this;
        }

        public Criteria andNetIPLike(String value) {
            addCriterion("netIP like", value, "netIP");
            return (Criteria) this;
        }

        public Criteria andNetIPNotLike(String value) {
            addCriterion("netIP not like", value, "netIP");
            return (Criteria) this;
        }

        public Criteria andNetIPIn(List<String> values) {
            addCriterion("netIP in", values, "netIP");
            return (Criteria) this;
        }

        public Criteria andNetIPNotIn(List<String> values) {
            addCriterion("netIP not in", values, "netIP");
            return (Criteria) this;
        }

        public Criteria andNetIPBetween(String value1, String value2) {
            addCriterion("netIP between", value1, value2, "netIP");
            return (Criteria) this;
        }

        public Criteria andNetIPNotBetween(String value1, String value2) {
            addCriterion("netIP not between", value1, value2, "netIP");
            return (Criteria) this;
        }

        public Criteria andNetMacIsNull() {
            addCriterion("netMac is null");
            return (Criteria) this;
        }

        public Criteria andNetMacIsNotNull() {
            addCriterion("netMac is not null");
            return (Criteria) this;
        }

        public Criteria andNetMacEqualTo(String value) {
            addCriterion("netMac =", value, "netMac");
            return (Criteria) this;
        }

        public Criteria andNetMacNotEqualTo(String value) {
            addCriterion("netMac <>", value, "netMac");
            return (Criteria) this;
        }

        public Criteria andNetMacGreaterThan(String value) {
            addCriterion("netMac >", value, "netMac");
            return (Criteria) this;
        }

        public Criteria andNetMacGreaterThanOrEqualTo(String value) {
            addCriterion("netMac >=", value, "netMac");
            return (Criteria) this;
        }

        public Criteria andNetMacLessThan(String value) {
            addCriterion("netMac <", value, "netMac");
            return (Criteria) this;
        }

        public Criteria andNetMacLessThanOrEqualTo(String value) {
            addCriterion("netMac <=", value, "netMac");
            return (Criteria) this;
        }

        public Criteria andNetMacLike(String value) {
            addCriterion("netMac like", value, "netMac");
            return (Criteria) this;
        }

        public Criteria andNetMacNotLike(String value) {
            addCriterion("netMac not like", value, "netMac");
            return (Criteria) this;
        }

        public Criteria andNetMacIn(List<String> values) {
            addCriterion("netMac in", values, "netMac");
            return (Criteria) this;
        }

        public Criteria andNetMacNotIn(List<String> values) {
            addCriterion("netMac not in", values, "netMac");
            return (Criteria) this;
        }

        public Criteria andNetMacBetween(String value1, String value2) {
            addCriterion("netMac between", value1, value2, "netMac");
            return (Criteria) this;
        }

        public Criteria andNetMacNotBetween(String value1, String value2) {
            addCriterion("netMac not between", value1, value2, "netMac");
            return (Criteria) this;
        }

        public Criteria andResolutionIsNull() {
            addCriterion("resolution is null");
            return (Criteria) this;
        }

        public Criteria andResolutionIsNotNull() {
            addCriterion("resolution is not null");
            return (Criteria) this;
        }

        public Criteria andResolutionEqualTo(String value) {
            addCriterion("resolution =", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionNotEqualTo(String value) {
            addCriterion("resolution <>", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionGreaterThan(String value) {
            addCriterion("resolution >", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionGreaterThanOrEqualTo(String value) {
            addCriterion("resolution >=", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionLessThan(String value) {
            addCriterion("resolution <", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionLessThanOrEqualTo(String value) {
            addCriterion("resolution <=", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionLike(String value) {
            addCriterion("resolution like", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionNotLike(String value) {
            addCriterion("resolution not like", value, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionIn(List<String> values) {
            addCriterion("resolution in", values, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionNotIn(List<String> values) {
            addCriterion("resolution not in", values, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionBetween(String value1, String value2) {
            addCriterion("resolution between", value1, value2, "resolution");
            return (Criteria) this;
        }

        public Criteria andResolutionNotBetween(String value1, String value2) {
            addCriterion("resolution not between", value1, value2, "resolution");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("createTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}