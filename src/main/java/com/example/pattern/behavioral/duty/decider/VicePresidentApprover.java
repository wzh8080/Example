package com.example.pattern.behavioral.duty.decider;

import com.example.pattern.behavioral.duty.Approver;
import com.example.pattern.behavioral.duty.PurchaseRequest;

/**
 * @Author 56465
 * @Create 2024/6/6 9:36
 */
public class VicePresidentApprover extends Approver {

    public VicePresidentApprover(String Name) {
        super(Name + " VicePresidentApprove");

    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if ((10000 <= request.GetSum()) && (request.GetSum() < 15000)) {
            System.out.println("副总理处理：**This request " + request.GetID()
                    + " will be handled by " + this.Name + " **");
        } else {
            System.out.println("副总理处理不了，request.GetSum()="+request.GetSum());
            successor.processRequest(request);
        }

    }

}