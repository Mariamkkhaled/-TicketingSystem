package mariam;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<String> issues;

    public Category(String name) {
        this.name = name;
        this.issues = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getIssues() {
        return issues;
    }

    public void addIssue(String issue) {
        issues.add(issue);
    }
}

