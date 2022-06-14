package com.code.issuestracker.util;

 public class IssueNotFoundException extends RuntimeException{
    public IssueNotFoundException(Long id) {
        super("Could not find issue " + id);
    }
}
