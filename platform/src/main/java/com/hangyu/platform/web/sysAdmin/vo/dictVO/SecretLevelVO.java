package com.hangyu.platform.web.sysAdmin.vo.dictVO;

import com.hangyu.platform.web.sysAdmin.dto.Secretlevel;
import com.hangyu.platform.web.sysAdmin.vo.Page;

import java.util.List;

public class SecretLevelVO extends Page {

    private List<Secretlevel> secretlevelList;

    public List<Secretlevel> getSecretlevelList() {
        return secretlevelList;
    }

    public void setSecretlevelList(List<Secretlevel> secretlevelList) {
        this.secretlevelList = secretlevelList;
    }
}
