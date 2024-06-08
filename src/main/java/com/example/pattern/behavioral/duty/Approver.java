package com.example.pattern.behavioral.duty;

/**
 * @Author 56465
 * @Create 2024/6/6 9:31
 */
public abstract class Approver {
    protected Approver successor;
    protected String Name;
    public Approver(String Name){
        this.Name=Name;
    }
    public abstract void processRequest(PurchaseRequest request);

    /**
     * 设置下一个处理者
     * @param successor
     */
    public void setSuccessor(Approver successor) {
        this.successor=successor;
    }
}