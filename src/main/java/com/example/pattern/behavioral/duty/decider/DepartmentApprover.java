package com.example.pattern.behavioral.duty.decider;

import com.example.pattern.behavioral.duty.Approver;
import com.example.pattern.behavioral.duty.PurchaseRequest;

/**
 * @Author 56465
 * @Create 2024/6/6 9:36
 */
public class DepartmentApprover extends Approver {

    public DepartmentApprover(String Name) {
        super(Name + " DepartmentLeader");

    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if ((5000 <= request.GetSum()) && (request.GetSum() < 10000)) {
            System.out.println("部长处理：**This request " + request.GetID()
                    + " will be handled by " + this.Name + " **");
        } else {
            System.out.println("部长处理不了，request.GetSum()="+request.GetSum());
            successor.processRequest(request);
        }

    }

}