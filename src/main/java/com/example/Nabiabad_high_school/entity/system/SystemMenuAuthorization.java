package com.example.Nabiabad_high_school.entity.system;

import com.example.Nabiabad_high_school.entity.system.baseEnitiy.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name="SYSTEM_MENU_AUTHORIZATION")
public class SystemMenuAuthorization extends BaseEntity {

    String menuCode;
    String parentMenuCode;
    String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "system_menu_id", nullable = false)
    SystemMenu systemMenu;

    Boolean canSee;
    Integer sequence;
    private String authCreate="N"; // create for C
    private String authRead="N"; // read for R
    private String authUpdate="N"; // update for U
    private String authDelete="N"; // delete for D
    private String authQuery="N";  // query for Q
    private String authSingle="N"; // single For S
    private String authCustom="N";


    public SystemMenuAuthorization(String menuCode, String parentMenuCode, String username, SystemMenu systemMenu, Boolean canSee, Integer sequence) {
        this.menuCode = menuCode;
        this.parentMenuCode = parentMenuCode;
        this.username = username;
        this.systemMenu = systemMenu;
        this.canSee = canSee;
        this.sequence = sequence;

    }
}

