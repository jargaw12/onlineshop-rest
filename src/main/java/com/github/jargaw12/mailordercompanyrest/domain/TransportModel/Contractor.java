package com.github.jargaw12.mailordercompanyrest.domain.TransportModel;

public class Contractor {
    int contractorId;

    public Contractor(int contractorId) {
        this.contractorId = contractorId;
    }

    public int getContractorId() {
        return contractorId;
    }

    public Contractor setContractorId(int contractorId) {
        this.contractorId = contractorId;
        return this;
    }
}
