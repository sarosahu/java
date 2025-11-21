package com.example.behavioral.visitor.one;

public class PrintVisitor implements Visitor{
    public PrintVisitor() {}


    @Override
    public void visit(Programmer programmer) {
        String msg = programmer.getName() + " is a " + programmer.getSkill() + " programmer";
        System.out.println(msg);
    }

    @Override
    public void visit(ProjectLead lead) {
        String msg = lead.getName() + " is a project lead with " +
                lead.getDirectReports().size() + " programmers reporting";
        System.out.println(msg);
    }

    @Override
    public void visit(Manager manager) {
        String msg = manager.getName() + " is a Manager with " +
                manager.getDirectReports().size() + " leads reporting.";
        System.out.println(msg);
    }

    @Override
    public void visit(VicePresident vp) {
        String msg = vp.getName() + " is a Vice President with " +
                vp.getDirectReports().size() + " managers reporting.";
        System.out.println(msg);
    }
}
