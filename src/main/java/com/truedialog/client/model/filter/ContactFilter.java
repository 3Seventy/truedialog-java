package com.truedialog.client.model.filter;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.truedialog.client.enums.FilterType;
import com.truedialog.client.enums.Operand;
import com.truedialog.client.enums.OperationType;
import com.truedialog.client.model.base.Base;

import static com.truedialog.client.enums.OperationType.*;
import static com.truedialog.client.enums.OperationType.ALL_BITS;

public class ContactFilter extends Base{

    /**
     * The ID of account that this filter belongs to.
     */
    @JsonProperty("AccountId")
    private int accountId;

    /**
     * The group ID this filter falls under
     */
    @JsonProperty("GroupId")
    private int groupId;

    /**
     * The type that we're filtering against.
     */
    @JsonProperty("FilterTypeId")
    private int filterTypeId;

    /**
     * Specific column to filter against.
     */
    @JsonProperty("OperandId")
    private int operandId;

    /**
     * The operator this filter applies to the Operand and the value.
     */
    @JsonProperty("Operation")
    private String operation;

    /**
     * A function that can be run on an operand.
     * <remarks>
     * The function will have to run on SQL, and will only be able to accept
     * just one parameter.  If null, we perform no additional operation
     * on the column.
     * </remarks>
     */
    @JsonProperty("OperandFunction")
    private String operandFunction;

    /**
     * The target value the operation works on.
     */
    @JsonProperty("Value")
    private String value;

    /**
     * A scripted value for the above.
     * <example>DateAdd(Today(), 0, 0, -1, 0, 0, 0)</example>
     */
    @JsonProperty("DynamicValue")
    private String dynamicValue;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getFilterTypeId() {
        return filterTypeId;
    }

    public void setFilterTypeId(int filterTypeId) {
        this.filterTypeId = filterTypeId;
    }

    public int getOperandId() {
        return operandId;
    }

    public void setOperandId(int operandId) {
        this.operandId = operandId;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperandFunction() {
        return operandFunction;
    }

    public void setOperandFunction(String operandFunction) {
        this.operandFunction = operandFunction;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDynamicValue() {
        return dynamicValue;
    }

    public void setDynamicValue(String dynamicValue) {
        this.dynamicValue = dynamicValue;
    }

    public FilterType getFilterType() {
        return FilterType.filterType(filterTypeId);
    }

    public void setFilterType(FilterType filterType) {
        this.filterTypeId = filterType.getValue();
    }

    public Operand getOperand() {
        return Operand.operand(operandId);
    }

    public void setOperand(Operand operand) {
        operandId = operand.getValue();
    }

    private String OperationEnumToValue(OperationType operationType) {
        switch (operationType) {
            case ALL_BITS:
                return "allbits";
            case ANY_BITS:
                return "anybits";
            case BEGINS_WITH:
                return "^";
            case ENDS_WITH:
                return "$";
            case EQUAL:
                return "=";
            case GREATER_THAN_OR_EQUAL:
                return ">=";
            case GREATER_THAN:
                return ">";
            case LESS_THEN:
                return "<";
            case LESS_THAN_OR_EQUAL:
                return "<=";
            case LIKE:
                return "LIKE";
            case NO_BITS:
                return "nobits";
            case NOT_EQUAL:
                return "<>";
            default:
                return "";
        }
    }

    private OperationType OperationValueToEnum(String operation) {
        switch (operation) {
            case "allbits":
                return ALL_BITS;
            case "anybits":
                return ANY_BITS;
            case "^":
                return BEGINS_WITH;
            case "$":
                return ENDS_WITH;
            case "=":
                return EQUAL;
            case ">=":
                return GREATER_THAN_OR_EQUAL;
            case ">":
                return GREATER_THAN;
            case "<":
                return LESS_THEN;
            case "<=":
                return LESS_THAN_OR_EQUAL;
            case "LIKE":
                return LIKE;
            case "nobits":
                return NO_BITS;
            case "<>":
                return NOT_EQUAL;
            default:
                return NONE;
        }
    }
}
