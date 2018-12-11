package com.kshch.confluence.plugins.diff.page.action;

import com.atlassian.confluence.core.ConfluenceActionSupport;

public class DiffPagePopupAction extends ConfluenceActionSupport {

    private String spaceKey;

    private Long sourcePageId;

    public String getSpaceKey() {
        return spaceKey;
    }

    public void setSpaceKey(String spaceKey) {
        this.spaceKey = spaceKey;
    }

    public long getSourcePageId() {
        return sourcePageId;
    }

    public void setSourcePageId(long sourcePageId) {
        this.sourcePageId = sourcePageId;
    }
}
