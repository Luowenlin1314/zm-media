package com.zm.media.ibs.program.entity;

import java.util.ArrayList;
import java.util.List;

public class ElementExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ElementExample() {
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

        public Criteria andElementIdIsNull() {
            addCriterion("elementId is null");
            return (Criteria) this;
        }

        public Criteria andElementIdIsNotNull() {
            addCriterion("elementId is not null");
            return (Criteria) this;
        }

        public Criteria andElementIdEqualTo(Long value) {
            addCriterion("elementId =", value, "elementId");
            return (Criteria) this;
        }

        public Criteria andElementIdNotEqualTo(Long value) {
            addCriterion("elementId <>", value, "elementId");
            return (Criteria) this;
        }

        public Criteria andElementIdGreaterThan(Long value) {
            addCriterion("elementId >", value, "elementId");
            return (Criteria) this;
        }

        public Criteria andElementIdGreaterThanOrEqualTo(Long value) {
            addCriterion("elementId >=", value, "elementId");
            return (Criteria) this;
        }

        public Criteria andElementIdLessThan(Long value) {
            addCriterion("elementId <", value, "elementId");
            return (Criteria) this;
        }

        public Criteria andElementIdLessThanOrEqualTo(Long value) {
            addCriterion("elementId <=", value, "elementId");
            return (Criteria) this;
        }

        public Criteria andElementIdIn(List<Long> values) {
            addCriterion("elementId in", values, "elementId");
            return (Criteria) this;
        }

        public Criteria andElementIdNotIn(List<Long> values) {
            addCriterion("elementId not in", values, "elementId");
            return (Criteria) this;
        }

        public Criteria andElementIdBetween(Long value1, Long value2) {
            addCriterion("elementId between", value1, value2, "elementId");
            return (Criteria) this;
        }

        public Criteria andElementIdNotBetween(Long value1, Long value2) {
            addCriterion("elementId not between", value1, value2, "elementId");
            return (Criteria) this;
        }

        public Criteria andProgramIdIsNull() {
            addCriterion("programId is null");
            return (Criteria) this;
        }

        public Criteria andProgramIdIsNotNull() {
            addCriterion("programId is not null");
            return (Criteria) this;
        }

        public Criteria andProgramIdEqualTo(Long value) {
            addCriterion("programId =", value, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdNotEqualTo(Long value) {
            addCriterion("programId <>", value, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdGreaterThan(Long value) {
            addCriterion("programId >", value, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdGreaterThanOrEqualTo(Long value) {
            addCriterion("programId >=", value, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdLessThan(Long value) {
            addCriterion("programId <", value, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdLessThanOrEqualTo(Long value) {
            addCriterion("programId <=", value, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdIn(List<Long> values) {
            addCriterion("programId in", values, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdNotIn(List<Long> values) {
            addCriterion("programId not in", values, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdBetween(Long value1, Long value2) {
            addCriterion("programId between", value1, value2, "programId");
            return (Criteria) this;
        }

        public Criteria andProgramIdNotBetween(Long value1, Long value2) {
            addCriterion("programId not between", value1, value2, "programId");
            return (Criteria) this;
        }

        public Criteria andElementNameIsNull() {
            addCriterion("elementName is null");
            return (Criteria) this;
        }

        public Criteria andElementNameIsNotNull() {
            addCriterion("elementName is not null");
            return (Criteria) this;
        }

        public Criteria andElementNameEqualTo(String value) {
            addCriterion("elementName =", value, "elementName");
            return (Criteria) this;
        }

        public Criteria andElementNameNotEqualTo(String value) {
            addCriterion("elementName <>", value, "elementName");
            return (Criteria) this;
        }

        public Criteria andElementNameGreaterThan(String value) {
            addCriterion("elementName >", value, "elementName");
            return (Criteria) this;
        }

        public Criteria andElementNameGreaterThanOrEqualTo(String value) {
            addCriterion("elementName >=", value, "elementName");
            return (Criteria) this;
        }

        public Criteria andElementNameLessThan(String value) {
            addCriterion("elementName <", value, "elementName");
            return (Criteria) this;
        }

        public Criteria andElementNameLessThanOrEqualTo(String value) {
            addCriterion("elementName <=", value, "elementName");
            return (Criteria) this;
        }

        public Criteria andElementNameLike(String value) {
            addCriterion("elementName like", value, "elementName");
            return (Criteria) this;
        }

        public Criteria andElementNameNotLike(String value) {
            addCriterion("elementName not like", value, "elementName");
            return (Criteria) this;
        }

        public Criteria andElementNameIn(List<String> values) {
            addCriterion("elementName in", values, "elementName");
            return (Criteria) this;
        }

        public Criteria andElementNameNotIn(List<String> values) {
            addCriterion("elementName not in", values, "elementName");
            return (Criteria) this;
        }

        public Criteria andElementNameBetween(String value1, String value2) {
            addCriterion("elementName between", value1, value2, "elementName");
            return (Criteria) this;
        }

        public Criteria andElementNameNotBetween(String value1, String value2) {
            addCriterion("elementName not between", value1, value2, "elementName");
            return (Criteria) this;
        }

        public Criteria andEtypeIsNull() {
            addCriterion("etype is null");
            return (Criteria) this;
        }

        public Criteria andEtypeIsNotNull() {
            addCriterion("etype is not null");
            return (Criteria) this;
        }

        public Criteria andEtypeEqualTo(Integer value) {
            addCriterion("etype =", value, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeNotEqualTo(Integer value) {
            addCriterion("etype <>", value, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeGreaterThan(Integer value) {
            addCriterion("etype >", value, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("etype >=", value, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeLessThan(Integer value) {
            addCriterion("etype <", value, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeLessThanOrEqualTo(Integer value) {
            addCriterion("etype <=", value, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeIn(List<Integer> values) {
            addCriterion("etype in", values, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeNotIn(List<Integer> values) {
            addCriterion("etype not in", values, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeBetween(Integer value1, Integer value2) {
            addCriterion("etype between", value1, value2, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("etype not between", value1, value2, "etype");
            return (Criteria) this;
        }

        public Criteria andBackgroundIsNull() {
            addCriterion("background is null");
            return (Criteria) this;
        }

        public Criteria andBackgroundIsNotNull() {
            addCriterion("background is not null");
            return (Criteria) this;
        }

        public Criteria andBackgroundEqualTo(String value) {
            addCriterion("background =", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundNotEqualTo(String value) {
            addCriterion("background <>", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundGreaterThan(String value) {
            addCriterion("background >", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundGreaterThanOrEqualTo(String value) {
            addCriterion("background >=", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundLessThan(String value) {
            addCriterion("background <", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundLessThanOrEqualTo(String value) {
            addCriterion("background <=", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundLike(String value) {
            addCriterion("background like", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundNotLike(String value) {
            addCriterion("background not like", value, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundIn(List<String> values) {
            addCriterion("background in", values, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundNotIn(List<String> values) {
            addCriterion("background not in", values, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundBetween(String value1, String value2) {
            addCriterion("background between", value1, value2, "background");
            return (Criteria) this;
        }

        public Criteria andBackgroundNotBetween(String value1, String value2) {
            addCriterion("background not between", value1, value2, "background");
            return (Criteria) this;
        }

        public Criteria andEleftIsNull() {
            addCriterion("eleft is null");
            return (Criteria) this;
        }

        public Criteria andEleftIsNotNull() {
            addCriterion("eleft is not null");
            return (Criteria) this;
        }

        public Criteria andEleftEqualTo(Integer value) {
            addCriterion("eleft =", value, "eleft");
            return (Criteria) this;
        }

        public Criteria andEleftNotEqualTo(Integer value) {
            addCriterion("eleft <>", value, "eleft");
            return (Criteria) this;
        }

        public Criteria andEleftGreaterThan(Integer value) {
            addCriterion("eleft >", value, "eleft");
            return (Criteria) this;
        }

        public Criteria andEleftGreaterThanOrEqualTo(Integer value) {
            addCriterion("eleft >=", value, "eleft");
            return (Criteria) this;
        }

        public Criteria andEleftLessThan(Integer value) {
            addCriterion("eleft <", value, "eleft");
            return (Criteria) this;
        }

        public Criteria andEleftLessThanOrEqualTo(Integer value) {
            addCriterion("eleft <=", value, "eleft");
            return (Criteria) this;
        }

        public Criteria andEleftIn(List<Integer> values) {
            addCriterion("eleft in", values, "eleft");
            return (Criteria) this;
        }

        public Criteria andEleftNotIn(List<Integer> values) {
            addCriterion("eleft not in", values, "eleft");
            return (Criteria) this;
        }

        public Criteria andEleftBetween(Integer value1, Integer value2) {
            addCriterion("eleft between", value1, value2, "eleft");
            return (Criteria) this;
        }

        public Criteria andEleftNotBetween(Integer value1, Integer value2) {
            addCriterion("eleft not between", value1, value2, "eleft");
            return (Criteria) this;
        }

        public Criteria andEtopIsNull() {
            addCriterion("etop is null");
            return (Criteria) this;
        }

        public Criteria andEtopIsNotNull() {
            addCriterion("etop is not null");
            return (Criteria) this;
        }

        public Criteria andEtopEqualTo(Integer value) {
            addCriterion("etop =", value, "etop");
            return (Criteria) this;
        }

        public Criteria andEtopNotEqualTo(Integer value) {
            addCriterion("etop <>", value, "etop");
            return (Criteria) this;
        }

        public Criteria andEtopGreaterThan(Integer value) {
            addCriterion("etop >", value, "etop");
            return (Criteria) this;
        }

        public Criteria andEtopGreaterThanOrEqualTo(Integer value) {
            addCriterion("etop >=", value, "etop");
            return (Criteria) this;
        }

        public Criteria andEtopLessThan(Integer value) {
            addCriterion("etop <", value, "etop");
            return (Criteria) this;
        }

        public Criteria andEtopLessThanOrEqualTo(Integer value) {
            addCriterion("etop <=", value, "etop");
            return (Criteria) this;
        }

        public Criteria andEtopIn(List<Integer> values) {
            addCriterion("etop in", values, "etop");
            return (Criteria) this;
        }

        public Criteria andEtopNotIn(List<Integer> values) {
            addCriterion("etop not in", values, "etop");
            return (Criteria) this;
        }

        public Criteria andEtopBetween(Integer value1, Integer value2) {
            addCriterion("etop between", value1, value2, "etop");
            return (Criteria) this;
        }

        public Criteria andEtopNotBetween(Integer value1, Integer value2) {
            addCriterion("etop not between", value1, value2, "etop");
            return (Criteria) this;
        }

        public Criteria andEwidthIsNull() {
            addCriterion("ewidth is null");
            return (Criteria) this;
        }

        public Criteria andEwidthIsNotNull() {
            addCriterion("ewidth is not null");
            return (Criteria) this;
        }

        public Criteria andEwidthEqualTo(Integer value) {
            addCriterion("ewidth =", value, "ewidth");
            return (Criteria) this;
        }

        public Criteria andEwidthNotEqualTo(Integer value) {
            addCriterion("ewidth <>", value, "ewidth");
            return (Criteria) this;
        }

        public Criteria andEwidthGreaterThan(Integer value) {
            addCriterion("ewidth >", value, "ewidth");
            return (Criteria) this;
        }

        public Criteria andEwidthGreaterThanOrEqualTo(Integer value) {
            addCriterion("ewidth >=", value, "ewidth");
            return (Criteria) this;
        }

        public Criteria andEwidthLessThan(Integer value) {
            addCriterion("ewidth <", value, "ewidth");
            return (Criteria) this;
        }

        public Criteria andEwidthLessThanOrEqualTo(Integer value) {
            addCriterion("ewidth <=", value, "ewidth");
            return (Criteria) this;
        }

        public Criteria andEwidthIn(List<Integer> values) {
            addCriterion("ewidth in", values, "ewidth");
            return (Criteria) this;
        }

        public Criteria andEwidthNotIn(List<Integer> values) {
            addCriterion("ewidth not in", values, "ewidth");
            return (Criteria) this;
        }

        public Criteria andEwidthBetween(Integer value1, Integer value2) {
            addCriterion("ewidth between", value1, value2, "ewidth");
            return (Criteria) this;
        }

        public Criteria andEwidthNotBetween(Integer value1, Integer value2) {
            addCriterion("ewidth not between", value1, value2, "ewidth");
            return (Criteria) this;
        }

        public Criteria andEheightIsNull() {
            addCriterion("eheight is null");
            return (Criteria) this;
        }

        public Criteria andEheightIsNotNull() {
            addCriterion("eheight is not null");
            return (Criteria) this;
        }

        public Criteria andEheightEqualTo(Integer value) {
            addCriterion("eheight =", value, "eheight");
            return (Criteria) this;
        }

        public Criteria andEheightNotEqualTo(Integer value) {
            addCriterion("eheight <>", value, "eheight");
            return (Criteria) this;
        }

        public Criteria andEheightGreaterThan(Integer value) {
            addCriterion("eheight >", value, "eheight");
            return (Criteria) this;
        }

        public Criteria andEheightGreaterThanOrEqualTo(Integer value) {
            addCriterion("eheight >=", value, "eheight");
            return (Criteria) this;
        }

        public Criteria andEheightLessThan(Integer value) {
            addCriterion("eheight <", value, "eheight");
            return (Criteria) this;
        }

        public Criteria andEheightLessThanOrEqualTo(Integer value) {
            addCriterion("eheight <=", value, "eheight");
            return (Criteria) this;
        }

        public Criteria andEheightIn(List<Integer> values) {
            addCriterion("eheight in", values, "eheight");
            return (Criteria) this;
        }

        public Criteria andEheightNotIn(List<Integer> values) {
            addCriterion("eheight not in", values, "eheight");
            return (Criteria) this;
        }

        public Criteria andEheightBetween(Integer value1, Integer value2) {
            addCriterion("eheight between", value1, value2, "eheight");
            return (Criteria) this;
        }

        public Criteria andEheightNotBetween(Integer value1, Integer value2) {
            addCriterion("eheight not between", value1, value2, "eheight");
            return (Criteria) this;
        }

        public Criteria andEindexIsNull() {
            addCriterion("eindex is null");
            return (Criteria) this;
        }

        public Criteria andEindexIsNotNull() {
            addCriterion("eindex is not null");
            return (Criteria) this;
        }

        public Criteria andEindexEqualTo(Integer value) {
            addCriterion("eindex =", value, "eindex");
            return (Criteria) this;
        }

        public Criteria andEindexNotEqualTo(Integer value) {
            addCriterion("eindex <>", value, "eindex");
            return (Criteria) this;
        }

        public Criteria andEindexGreaterThan(Integer value) {
            addCriterion("eindex >", value, "eindex");
            return (Criteria) this;
        }

        public Criteria andEindexGreaterThanOrEqualTo(Integer value) {
            addCriterion("eindex >=", value, "eindex");
            return (Criteria) this;
        }

        public Criteria andEindexLessThan(Integer value) {
            addCriterion("eindex <", value, "eindex");
            return (Criteria) this;
        }

        public Criteria andEindexLessThanOrEqualTo(Integer value) {
            addCriterion("eindex <=", value, "eindex");
            return (Criteria) this;
        }

        public Criteria andEindexIn(List<Integer> values) {
            addCriterion("eindex in", values, "eindex");
            return (Criteria) this;
        }

        public Criteria andEindexNotIn(List<Integer> values) {
            addCriterion("eindex not in", values, "eindex");
            return (Criteria) this;
        }

        public Criteria andEindexBetween(Integer value1, Integer value2) {
            addCriterion("eindex between", value1, value2, "eindex");
            return (Criteria) this;
        }

        public Criteria andEindexNotBetween(Integer value1, Integer value2) {
            addCriterion("eindex not between", value1, value2, "eindex");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(Integer value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(Integer value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(Integer value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(Integer value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(Integer value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<Integer> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<Integer> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(Integer value1, Integer value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andEffectIsNull() {
            addCriterion("effect is null");
            return (Criteria) this;
        }

        public Criteria andEffectIsNotNull() {
            addCriterion("effect is not null");
            return (Criteria) this;
        }

        public Criteria andEffectEqualTo(Integer value) {
            addCriterion("effect =", value, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectNotEqualTo(Integer value) {
            addCriterion("effect <>", value, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectGreaterThan(Integer value) {
            addCriterion("effect >", value, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectGreaterThanOrEqualTo(Integer value) {
            addCriterion("effect >=", value, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectLessThan(Integer value) {
            addCriterion("effect <", value, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectLessThanOrEqualTo(Integer value) {
            addCriterion("effect <=", value, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectIn(List<Integer> values) {
            addCriterion("effect in", values, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectNotIn(List<Integer> values) {
            addCriterion("effect not in", values, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectBetween(Integer value1, Integer value2) {
            addCriterion("effect between", value1, value2, "effect");
            return (Criteria) this;
        }

        public Criteria andEffectNotBetween(Integer value1, Integer value2) {
            addCriterion("effect not between", value1, value2, "effect");
            return (Criteria) this;
        }

        public Criteria andEmodeIsNull() {
            addCriterion("emode is null");
            return (Criteria) this;
        }

        public Criteria andEmodeIsNotNull() {
            addCriterion("emode is not null");
            return (Criteria) this;
        }

        public Criteria andEmodeEqualTo(Integer value) {
            addCriterion("emode =", value, "emode");
            return (Criteria) this;
        }

        public Criteria andEmodeNotEqualTo(Integer value) {
            addCriterion("emode <>", value, "emode");
            return (Criteria) this;
        }

        public Criteria andEmodeGreaterThan(Integer value) {
            addCriterion("emode >", value, "emode");
            return (Criteria) this;
        }

        public Criteria andEmodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("emode >=", value, "emode");
            return (Criteria) this;
        }

        public Criteria andEmodeLessThan(Integer value) {
            addCriterion("emode <", value, "emode");
            return (Criteria) this;
        }

        public Criteria andEmodeLessThanOrEqualTo(Integer value) {
            addCriterion("emode <=", value, "emode");
            return (Criteria) this;
        }

        public Criteria andEmodeIn(List<Integer> values) {
            addCriterion("emode in", values, "emode");
            return (Criteria) this;
        }

        public Criteria andEmodeNotIn(List<Integer> values) {
            addCriterion("emode not in", values, "emode");
            return (Criteria) this;
        }

        public Criteria andEmodeBetween(Integer value1, Integer value2) {
            addCriterion("emode between", value1, value2, "emode");
            return (Criteria) this;
        }

        public Criteria andEmodeNotBetween(Integer value1, Integer value2) {
            addCriterion("emode not between", value1, value2, "emode");
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