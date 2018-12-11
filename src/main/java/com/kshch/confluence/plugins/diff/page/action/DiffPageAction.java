package com.kshch.confluence.plugins.diff.page.action;

import com.atlassian.confluence.core.ConfluenceActionSupport;
import com.atlassian.confluence.diff.Differ;
import com.atlassian.confluence.pages.AbstractPage;
import com.atlassian.confluence.pages.Page;
import com.atlassian.confluence.pages.PageManager;
import com.atlassian.confluence.pages.actions.PageAware;
import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;

@Scanned
public class DiffPageAction extends ConfluenceActionSupport implements PageAware {
    private Long sourcePageId;
    private Long destinationPageId;
    private String spaceKey;
    private String destinationPageName;

    private String sourcePageTitle;
    private String destinationPageTitle;

    private String diff;

    private Page sourcePage;

    private Differ differ;

    private final PageManager pageManager;

    public DiffPageAction(@ComponentImport PageManager pageManager) {
        this.pageManager = pageManager;
    }

    @Override
    public String execute() throws Exception {

        if (this.sourcePageId != null && this.spaceKey != null && this.destinationPageName != null) {
            this.sourcePage = this.pageManager.getPage(this.sourcePageId);
            Page destinationPage = this.pageManager.getPage(this.spaceKey, this.destinationPageName);

            if (this.sourcePage != null && destinationPage != null) {
                this.destinationPageId = destinationPage.getId();
                this.sourcePageTitle = this.sourcePage.getTitle();
                this.destinationPageTitle = destinationPage.getTitle();
                this.diff = this.differ.diff(this.sourcePage, destinationPage);
            }
        }

        return super.execute();
    }

    @Override
    public AbstractPage getPage() {
        return this.sourcePage;
    }

    @Override
    public void setPage(AbstractPage abstractPage) {

    }

    @Override
    public boolean isPageRequired() {
        return false;
    }

    @Override
    public boolean isLatestVersionRequired() {
        return false;
    }

    @Override
    public boolean isViewPermissionRequired() {
        return false;
    }

    @Override
    public boolean isEditPermissionRequired() {
        return false;
    }

    public void setHtmlDiffer(Differ differ) {
        this.differ = differ;
    }

    public void setSourcePageId(long sourcePageId) {
        this.sourcePageId = sourcePageId;
    }

    public void setSpaceKey(String spaceKey) {
        this.spaceKey = spaceKey;
    }

    public void setDestinationPageName(String destinationPageName) {
        this.destinationPageName = destinationPageName;
    }

    public long getSourcePageId() {
        return sourcePageId;
    }

    public String getSourcePageTitle() {
        return sourcePageTitle;
    }

    public String getDestinationPageTitle() {
        return destinationPageTitle;
    }

    public String getDiff() {
        return diff;
    }

    public Long getDestinationPageId() {
        return destinationPageId;
    }
}
