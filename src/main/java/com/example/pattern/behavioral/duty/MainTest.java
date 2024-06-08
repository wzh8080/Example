package com.example.pattern.behavioral.duty;

import com.example.pattern.behavioral.duty.decider.DepartmentApprover;
import com.example.pattern.behavioral.duty.decider.GroupApprover;
import com.example.pattern.behavioral.duty.decider.PresidentApprover;
import com.example.pattern.behavioral.duty.decider.VicePresidentApprover;

/**
 * 责任链模式
 * @Author 56465
 * @Create 2024/6/6 9:36
 */
public class MainTest {
    public static void main(String[] args) {
        Client mClient = new Client();
        Approver GroupLeader = new GroupApprover("Tom");
        Approver DepartmentLeader = new DepartmentApprover("Jerry");
        Approver VicePresident = new VicePresidentApprover("Kate");
        Approver President = new PresidentApprover("Bush");

        GroupLeader.setSuccessor(DepartmentLeader);
        DepartmentLeader.setSuccessor(VicePresident);
        VicePresident.setSuccessor(President);

        GroupLeader.processRequest(mClient.sendRequest(1, 11000, 1));

    }
}
