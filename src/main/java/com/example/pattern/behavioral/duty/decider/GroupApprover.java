package com.example.pattern.behavioral.duty.decider;

import com.example.pattern.behavioral.duty.Approver;
import com.example.pattern.behavioral.duty.PurchaseRequest;

/**
 * 组长
 * @Author 56465
 * @Create 2024/6/6 9:32
 */
public class GroupApprover extends Approver {

    public GroupApprover(String Name) {
        super(Name + " GroupLeader");
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.GetSum() < 5000) {
            System.out.println("组长处理：**This request " + request.GetID() + " will be handled by " + this.Name + " **");
        } else {
            System.out.println("组长处理不了，request.GetSum()="+request.GetSum());
            successor.processRequest(request);
        }
    }

}