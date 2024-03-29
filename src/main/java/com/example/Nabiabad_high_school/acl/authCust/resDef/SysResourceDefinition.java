package com.example.Nabiabad_high_school.acl.authCust.resDef;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "ACL_SYSTEM_RESOURCE_DEF")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SysResourceDefinition {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @Column(unique = true, nullable = false)
    String clientReqUrl;            // Client Request URL // Menu URL
    @Column(unique = true, nullable = false)
    String backendUrl;              // Backend API + Normal URL
    String resourceType;            /* 1. entity 2. menu 3. process 4. job scheduler 5. entity + menu, 6. Others */
    String resourceCode;            // EMP_REF_PROFILE --> Employee Reference Profile
    String resourceTitle;           // ResCode Elaboration
    String resourceElement;

    String entityName;              // no space allow : Domain Class (Ex: SystemMenu)
    String entityDescription;       // (Ex: System Menu)
    String openUrl;

    // Auth properties
    String chkAuthorization;        // [Yes, No] default yes
    String chkAuthorizationChar;    // [C, R, U, D, Q, A, S]
    Boolean adminAccessOnly;
    Boolean superAdminAccessOnly;

    Integer sequence;
    Boolean active;

    // System log fields
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "CREATION_DATETIME")
    Date creationDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientReqUrl() {
        return clientReqUrl;
    }

    public void setClientReqUrl(String clientReqUrl) {
        this.clientReqUrl = clientReqUrl;
    }

    public String getBackendUrl() {
        return backendUrl;
    }

    public void setBackendUrl(String backendUrl) {
        this.backendUrl = backendUrl;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    public String getResourceTitle() {
        return resourceTitle;
    }

    public void setResourceTitle(String resourceTitle) {
        this.resourceTitle = resourceTitle;
    }

    public String getResourceElement() {
        return resourceElement;
    }

    public void setResourceElement(String resourceElement) {
        this.resourceElement = resourceElement;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityDescription() {
        return entityDescription;
    }

    public void setEntityDescription(String entityDescription) {
        this.entityDescription = entityDescription;
    }

    public String getOpenUrl() {
        return openUrl;
    }

    public void setOpenUrl(String openUrl) {
        this.openUrl = openUrl;
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

    public Boolean getAdminAccessOnly() {
        return adminAccessOnly;
    }

    public void setAdminAccessOnly(Boolean adminAccessOnly) {
        this.adminAccessOnly = adminAccessOnly;
    }

    public Boolean getSuperAdminAccessOnly() {
        return superAdminAccessOnly;
    }

    public void setSuperAdminAccessOnly(Boolean superAdminAccessOnly) {
        this.superAdminAccessOnly = superAdminAccessOnly;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(Date creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public String getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    public Date getLastUpdateDateTime() {
        return lastUpdateDateTime;
    }

    public void setLastUpdateDateTime(Date lastUpdateDateTime) {
        this.lastUpdateDateTime = lastUpdateDateTime;
    }

    public String getLastUpdateUser() {
        return lastUpdateUser;
    }

    public void setLastUpdateUser(String lastUpdateUser) {
        this.lastUpdateUser = lastUpdateUser;
    }

    @Column(name = "CREATION_USER")
    String creationUser;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "LAST_UPDATE_DATETIME")
    Date lastUpdateDateTime;
    @Column(name = "LAST_UPDATE_USER")
    String lastUpdateUser;
}
