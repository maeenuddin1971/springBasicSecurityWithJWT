package com.example.Nabiabad_high_school.entity.system;


import com.example.Nabiabad_high_school.entity.system.baseEnitiy.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="SYSTEM_MENU")
public class SystemMenu  extends BaseEntity {


    @Column(unique = true)
    String code;
    String description;

    String name;
    String url;
    String requestUrl;
    String customUrl;
    Integer sequence;
    Boolean hasChild;
    Boolean visibleToAll;
    String chkAuthorization;
    String chkAuthorizationChar;
    Boolean leftSideMenu;
    Boolean dashboardMenu;
    Boolean mainHeaderMenu;
    String urlCustom;
    String entityName;


    Boolean isChild;
    Boolean isOpenNewTab;
    Boolean isActive;

    // for ngx-admin template
    private String title;
    private String icon;
    private String link;
    private String home;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_menu_id", referencedColumnName = "id")
    @JsonIgnore
    SystemMenu parentMenu;

    @OneToMany(mappedBy ="parentMenu")
    public List<SystemMenu> children = new ArrayList<>();

    String parentMenuCode;

    Boolean superAdminAccessOnly;
    Boolean adminAccessOnly=false;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getCustomUrl() {
        return customUrl;
    }

    public void setCustomUrl(String customUrl) {
        this.customUrl = customUrl;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Boolean getHasChild() {
        return hasChild;
    }

    public void setHasChild(Boolean hasChild) {
        this.hasChild = hasChild;
    }

    public Boolean getVisibleToAll() {
        return visibleToAll;
    }

    public void setVisibleToAll(Boolean visibleToAll) {
        this.visibleToAll = visibleToAll;
    }

    public String getChkAuthorization() {
        return chkAuthorization;
    }

    public void setChkAuthorization(String chkAuthorization) {
        this.chkAuthorization = chkAuthorization;
    }

    public String getChkAuthorizationChar() {
        return chkAuthorizationChar;
    }

    public void setChkAuthorizationChar(String chkAuthorizationChar) {
        this.chkAuthorizationChar = chkAuthorizationChar;
    }

    public Boolean getLeftSideMenu() {
        return leftSideMenu;
    }

    public void setLeftSideMenu(Boolean leftSideMenu) {
        this.leftSideMenu = leftSideMenu;
    }

    public Boolean getDashboardMenu() {
        return dashboardMenu;
    }

    public void setDashboardMenu(Boolean dashboardMenu) {
        this.dashboardMenu = dashboardMenu;
    }

    public Boolean getMainHeaderMenu() {
        return mainHeaderMenu;
    }

    public void setMainHeaderMenu(Boolean mainHeaderMenu) {
        this.mainHeaderMenu = mainHeaderMenu;
    }

    public String getUrlCustom() {
        return urlCustom;
    }

    public void setUrlCustom(String urlCustom) {
        this.urlCustom = urlCustom;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Boolean getChild() {
        return isChild;
    }

    public void setChild(Boolean child) {
        isChild = child;
    }

    public Boolean getOpenNewTab() {
        return isOpenNewTab;
    }

    public void setOpenNewTab(Boolean openNewTab) {
        isOpenNewTab = openNewTab;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public SystemMenu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(SystemMenu parentMenu) {
        this.parentMenu = parentMenu;
    }

    public List<SystemMenu> getChildren() {
        return children;
    }

    public void setChildren(List<SystemMenu> children) {
        this.children = children;
    }

    public String getParentMenuCode() {
        return parentMenuCode;
    }

    public void setParentMenuCode(String parentMenuCode) {
        this.parentMenuCode = parentMenuCode;
    }

    public Boolean getSuperAdminAccessOnly() {
        return superAdminAccessOnly;
    }

    public void setSuperAdminAccessOnly(Boolean superAdminAccessOnly) {
        this.superAdminAccessOnly = superAdminAccessOnly;
    }

    public Boolean getAdminAccessOnly() {
        return adminAccessOnly;
    }

    public void setAdminAccessOnly(Boolean adminAccessOnly) {
        this.adminAccessOnly = adminAccessOnly;
    }

    public SystemMenu(String code, String description, String openUrl, String iconHtml, Boolean isActive,
                      Integer sequence, Boolean adminAccessOnly, String link, String title, String home) {
        this.code = code;
        this.description = description;
        this.url = openUrl;
        this.icon = iconHtml;
        this.isActive = isActive;
        this.sequence = sequence;
        this.adminAccessOnly=adminAccessOnly;
        this.link=link;
        this.title=title;
        this.home=home;

//        this.parentMenu = parentMenu;
    }
}
