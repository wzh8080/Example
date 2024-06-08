package com.example.pattern.behavioral.duty.decider;

import com.example.pattern.behavioral.duty.Approver;
import com.example.pattern.behavioral.duty.PurchaseRequest;

/**
 * @Author 56465
 * @Create 2024/6/6 9:36
 */
public class PresidentApprover extends Approver {

    public PresidentApprover(String Name) {
        super(Name + " PresidentApprove");

    }

    @Override
    public void processRequest(PurchaseRequest request) {
        System.out.println("最终决策者，总理处理: **This request " + request.GetID()
                + " will be handled by " + this.Name + " **，request.GetSum()="+request.GetSum());

    }

}