package com.hackaton.covid19.showpandebuddies.application;

import com.hackaton.covid19.shared.application.outbound_ports.PandeBuddyDocument;

import java.util.List;

public class PandeBuddiesDocument {
    private List<PandeBuddyDocument> pandeBuddyDocuments;

    public PandeBuddiesDocument(List<PandeBuddyDocument> pandeBuddyDocuments) {
        this.pandeBuddyDocuments = pandeBuddyDocuments;
    }

    public List<PandeBuddyDocument> getPandeBuddyDocuments() {
        return pandeBuddyDocuments;
    }
}
